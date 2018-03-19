package com.rparser.service;

import com.rparser.dao.SyncInfoDao;
import com.rparser.hibernate.entities.SyncInfo;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class SyncInfoServiceImp extends AbstractService<SyncInfo> implements SyncInfoService {

   @Autowired
   private SyncInfoDao syncInfoDao;

   @Override
   public SyncInfoDao getDao() {
      return syncInfoDao;
   }
}
