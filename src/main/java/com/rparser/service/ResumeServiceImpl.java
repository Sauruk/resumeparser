package com.rparser.service;

import com.rparser.dao.Dao;
import com.rparser.dao.ResumeDao;
import com.rparser.hibernate.entities.Resume;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ResumeServiceImpl extends AbstractService<Resume> implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public Dao getDao() {
        return resumeDao;
    }
}
