package com.rparser.dao;

import com.rparser.acceptor.ResumeAcceptor;
import com.rparser.hibernate.entities.Resume;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Repository
public class ResumeDaoImpl implements ResumeDao {

    private final static String COLUMN_FULL_NAME = "FULL_NAME";
    private final static String COLUMN_AGE = "AGE";
    private final static String COLUMN_JOB_INTEREST_IN = "JOB_INTEREST_IN";
    private final static String COLUMN_SALARY_REQ = "SALARY_REQ";
    private final static String COLUMN_EXPERIENCE = "EXPERIENCE";
    private final static String COLUMN_EDUCATION = "EDUCATION";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Resume object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public List<Resume> list(ResumeAcceptor acceptor) {
        StringBuilder builder = new StringBuilder("select * from RESUME ");
        Boolean whereFlag = false;
        Map<String, Object> paramVal = new HashMap<>();
        if (acceptor.getAge() != null) {
            addWhereOrAdd(builder, whereFlag, COLUMN_AGE);
            paramVal.put(COLUMN_AGE, acceptor.getAge());
            whereFlag = true;
        }
        if (acceptor.getFullname() != null) {
            addWhereOrAdd(builder, whereFlag, COLUMN_FULL_NAME);
            paramVal.put(COLUMN_FULL_NAME, acceptor.getFullname());
            whereFlag = true;
        }
        if (acceptor.getEducation() != null) {
            addWhereOrAdd(builder, whereFlag, COLUMN_EDUCATION);
            paramVal.put(COLUMN_EDUCATION, acceptor.getEducation());
            whereFlag = true;
        }
        if (acceptor.getJobInterestIn() != null) {
            addWhereOrAdd(builder, whereFlag, COLUMN_JOB_INTEREST_IN);
            paramVal.put(COLUMN_JOB_INTEREST_IN, acceptor.getJobInterestIn());
            whereFlag = true;
        }
        if (acceptor.getSalaryReq() != null) {
            addWhereOrAdd(builder, whereFlag, COLUMN_SALARY_REQ);
            paramVal.put(COLUMN_SALARY_REQ, acceptor.getSalaryReq());
            whereFlag = true;
        }
        if (acceptor.getExperience() != null) {
            addWhereOrAdd(builder, whereFlag, COLUMN_EXPERIENCE);
            paramVal.put(COLUMN_EXPERIENCE, acceptor.getExperience());
        }
        NativeQuery<Resume> queue = sessionFactory.getCurrentSession().createNativeQuery(builder.toString(), Resume.class);
        queue.setProperties(paramVal);
        return queue.list();
    }

    @Override
    public Resume get(ResumeAcceptor acceptor) {
        return null;
    }

    private void asseptorToQuery(ResumeAcceptor acceptor){

    }

    private StringBuilder addWhereOrAdd(StringBuilder builder, Boolean whereFlag, String columnName){
        if (whereFlag) {
            builder.append(" and ");
        } else {
            builder.append(" where ");
        }
        builder.append(columnName).append(" = :").append(columnName);
        return builder;
    }

}
