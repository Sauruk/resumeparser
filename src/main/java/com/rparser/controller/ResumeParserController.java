package com.rparser.controller;

import com.rparser.acceptor.ResumeAcceptor;
import com.rparser.acceptor.SyncInfoAcceptor;
import com.rparser.component.ResumeParserComponent;
import com.rparser.component.ZarplataRuParserComponent;
import com.rparser.hibernate.entities.Resume;
import com.rparser.hibernate.entities.SyncInfo;
import com.rparser.service.ResumeService;
import com.rparser.service.Service;
import com.rparser.service.SyncInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ResumeParserController {

    @Autowired
    private ResumeParserComponent parserComponent;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    @Qualifier("syncTableName")
    private String synTableName;

    @RequestMapping(value={"forceUpdate"}, method = RequestMethod.GET)
    public String functionRestName(){
        parserComponent.parse();
        return "success";
    }

    @RequestMapping(path={"/filter"},method= RequestMethod.POST)
    @ResponseBody
    public Resume[] filter(ResumeAcceptor input) {
        return resumeService.list(input).toArray(new Resume[]{});
    }
}
