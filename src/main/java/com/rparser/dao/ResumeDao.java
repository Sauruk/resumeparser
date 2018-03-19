package com.rparser.dao;

import com.rparser.acceptor.ResumeAcceptor;
import com.rparser.hibernate.entities.Resume;

public interface ResumeDao extends Dao<Resume, ResumeAcceptor> {
}
