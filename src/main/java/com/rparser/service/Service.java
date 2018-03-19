package com.rparser.service;

import com.rparser.acceptor.Acceptor;
import com.rparser.hibernate.entities.SyncInfo;

import java.util.List;

public interface Service<O> {
   void save(O object);
   O get(Acceptor acceptor);
   List<O> list(Acceptor acceptor);
}
