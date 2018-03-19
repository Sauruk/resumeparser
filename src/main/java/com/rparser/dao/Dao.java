package com.rparser.dao;

import com.rparser.acceptor.Acceptor;

import java.util.List;

public interface Dao<O, A extends Acceptor> {
   void save(O object);
   List<O> list(A acceptor);
   O get(A acceptor);
}
