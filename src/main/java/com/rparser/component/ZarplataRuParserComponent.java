package com.rparser.component;

import com.rparser.hibernate.entities.Resume;
import com.rparser.hibernate.entities.SyncInfo;
import com.rparser.service.ResumeService;
import com.rparser.service.SyncInfoService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@Service
public class ZarplataRuParserComponent implements ResumeParserComponent {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private SyncInfoService syncInfoService;

    private static final String BASE_URL = "https://ekb.zarplata.ru/resume";
    private static final String YESTERDAY = "вчера";

    @Override
    public void parse() {
        Document doc = null;
        try {
            doc = Jsoup.connect(BASE_URL).get();
            Elements elements = doc.select("div.resume-item");
            for (Element element : elements) {
                Resume resume = new Resume();
                resume.setId(Integer.valueOf(element.getElementsByAttribute("name").get(0).attr("name")));
                Elements previewInfo = element.select("div.eleven").get(0).children();
                resume.setJobInterestIn(previewInfo.get(0).text());
                praseNameAndAge(previewInfo.get(1).text(), resume);
                resume.setPublishDate(parsePublishDate(previewInfo.get(2).child(0).child(0).text()));
                Elements salaryExpInfo = element.select("div.five").get(0).child(0).children();
                String rawSalary = salaryExpInfo.get(0).text();

                Integer salary = 0;
                if (Character.isDigit(rawSalary.charAt(0))) {
                    salary = Integer.valueOf(rawSalary.substring(0, rawSalary.lastIndexOf(" ")).replace(" ", ""));
                }
                resume.setSalaryReq(salary);
                resume.setExperience(salaryExpInfo.get(1).text());
                resume.setEducation(salaryExpInfo.get(2).text());
                resumeService.save(resume);
            }
            syncInfoService.save(new SyncInfo("RESUME", new Date()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void praseNameAndAge(String nativeNameAge, Resume resume){
        String nameAge[] = nativeNameAge.split(", ");
        resume.setFullname(nameAge[0]);
        char emptySign = 160;
        resume.setAge(Integer.valueOf(nameAge[1].trim().substring(0, nameAge[1].indexOf(emptySign))));
    }

    private Date parsePublishDate(String rawString){
        Calendar cal = Calendar.getInstance();
        String[] dayTime = rawString.split(" ");

        if (YESTERDAY.equals(dayTime[0])) {
            cal.add(Calendar.DATE, -1);
        }
        String[] hourMinute = dayTime[2].split(":");
        cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hourMinute[0]));
        cal.set(Calendar.MINUTE, Integer.valueOf(hourMinute[1]));
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }
}
