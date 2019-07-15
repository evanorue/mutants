package com.meli.mutants.controller;

import com.meli.mutants.model.ADNBase;
import com.meli.mutants.service.ADNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MutantsController {
    @Autowired
    ADNService adnService = null;

    public void setAdnService(ADNService dnaService) {
        this.adnService = dnaService;
    }

    @RequestMapping(value="validate/", method = RequestMethod.POST)
    @ResponseBody
    public ADNBase validate(@RequestBody ADNBase adnBase){
        return adnService.processDna(adnBase);
    }

    @RequestMapping(value="status/", method = RequestMethod.POST)
    @ResponseBody
    public String status(@RequestBody ADNBase adnBase){

        return "OK";
    }
}
