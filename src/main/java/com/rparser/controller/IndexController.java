package com.rparser.controller;

import com.rparser.acceptor.ResumeAcceptor;
import com.rparser.acceptor.SyncInfoAcceptor;
import com.rparser.hibernate.entities.Resume;
import com.rparser.hibernate.entities.SyncInfo;
import com.rparser.service.ResumeService;
import com.rparser.service.SyncInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class IndexController {

   @Autowired
   private SyncInfoService syncInfoService;

   @Autowired
   private ResumeService resumeService;

   @Autowired
   @Qualifier("syncTableName")
   private String synTableName;

   private final static Integer MAX_RECORDS = 30;

   @RequestMapping(path={"/"},method= RequestMethod.GET)
   public String indexPage(Model model) {
      SyncInfo syncInfo = syncInfoService.get(new SyncInfoAcceptor(synTableName));
      if (syncInfo != null) {
         model.addAttribute("lastSyncDate", syncInfo.getLastSyncDate());
         model.addAttribute("resumeList", resumeService.list(new ResumeAcceptor().withLastRecords(MAX_RECORDS)));
      }
      return "index";
   }
}
