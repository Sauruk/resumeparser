package com.rparser.config;

import com.rparser.component.ResumeParserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class RootConfig {

    private static final int DAY_LENGTH = 86400000 ;

    @Autowired
    private ResumeParserComponent parserComponent;

    @Bean(name="syncTableName")
    public String getSyncTable(){
        return "RESUME";
    }

    @Scheduled(fixedRate = DAY_LENGTH)
    public void parseResume() {
        parserComponent.parse();
    }

}
