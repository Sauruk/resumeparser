package com.rparser.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Resume",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Resume implements Serializable{

    private Integer id;
    private String fullname;
    private Integer age;
    private Date publishDate;
    private String jobInterestIn;
    private Integer salaryReq;
    private String experience;
    private String education;

    public Resume() {
    }

    public Resume(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "FULL_NAME")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Column(name = "AGE")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "PUBLISH_DATE")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Column(name = "JOB_INTEREST_IN")
    public String getJobInterestIn() {
        return jobInterestIn;
    }

    public void setJobInterestIn(String jobInterestIn) {
        this.jobInterestIn = jobInterestIn;
    }

    @Column(name = "SALARY_REQ")
    public Integer getSalaryReq() {
        return salaryReq;
    }

    public void setSalaryReq(Integer salaryReq) {
        this.salaryReq = salaryReq;
    }

    @Column(name = "EXPERIENCE")
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Column(name = "EDUCATION")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
