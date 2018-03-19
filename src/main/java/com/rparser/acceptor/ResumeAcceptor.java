package com.rparser.acceptor;

import java.util.Date;

public class ResumeAcceptor implements Acceptor{

    private String fullname;
    private Integer age;
    private Date publishDate;
    private String jobInterestIn;
    private Integer salaryReq;
    private String experience;
    private String education;
    private Integer lastRecords;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getJobInterestIn() {
        return jobInterestIn;
    }

    public void setJobInterestIn(String jobInterestIn) {
        this.jobInterestIn = jobInterestIn;
    }

    public Integer getSalaryReq() {
        return salaryReq;
    }

    public void setSalaryReq(Integer salaryReq) {
        this.salaryReq = salaryReq;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public ResumeAcceptor withLastRecords(Integer lastRecords){
        this.lastRecords = lastRecords;
        return this;
    }

    public Integer getLastRecords() {
        return lastRecords;
    }
}
