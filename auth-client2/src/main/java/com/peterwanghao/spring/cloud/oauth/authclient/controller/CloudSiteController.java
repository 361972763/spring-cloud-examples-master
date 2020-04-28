package com.peterwanghao.spring.cloud.oauth.authclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.ModelAndView;

 /**
  * @description:oauth客户端
  * @author: clj
  * @date: 15:21 24/04/2019 
  * @version : V1.0
  */
@RestController
public class CloudSiteController {

    @Autowired
    private RestOperations restOperations;

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello From Auth-Client2!";
    }
    /**
    * @author 获取用户信息
    * @description //TODO
    * @date 11:49 26/04/2019
    * @param []
    * @return org.springframework.web.servlet.ModelAndView
    **/
    @GetMapping("/personInfo")
    public ModelAndView person() {
        ModelAndView mav = new ModelAndView("personinfo");
        //modify
        //String personResourceUrl = "http://localhost:9000/person";
        String personResourceUrl = "http://localhost:9000/user";
        mav.addObject("person", restOperations.getForObject(personResourceUrl, String.class));
        return mav;
    }

}
