package com.rparser.service;

import com.rparser.acceptor.Acceptor;
import com.rparser.dao.Dao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractService<O> implements Service<O> {

    @Transactional
    public void save(O object) {
        getDao().save(object);
    }

    @Transactional(readOnly = true)
    public List<O> list(Acceptor acceptor) {
        return getDao().list(acceptor);
    }

    @Override
    @Transactional(readOnly = true)
    public O get(Acceptor acceptor) {
        return (O) getDao().get(acceptor);
    }

    public abstract Dao getDao();
}
