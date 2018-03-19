package com.rparser.dao;

import com.rparser.acceptor.SyncInfoAcceptor;
import com.rparser.hibernate.entities.SyncInfo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SyncInfoDaoImp implements SyncInfoDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void save(SyncInfo syncInfo) {
      sessionFactory.getCurrentSession().saveOrUpdate(syncInfo);
      sessionFactory.getCurrentSession().flush();
   }

   @Override
   public List<SyncInfo> list(SyncInfoAcceptor acceptor) {
      SyncInfo result = get(acceptor);
      return result == null ? new ArrayList<>() : Arrays.asList();
   }

   @Override
   public SyncInfo get(SyncInfoAcceptor acceptor) {
      return sessionFactory.getCurrentSession().get(SyncInfo.class, acceptor.getId());
   }
}
