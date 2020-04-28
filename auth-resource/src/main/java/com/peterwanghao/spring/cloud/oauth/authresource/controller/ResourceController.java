package com.peterwanghao.spring.cloud.oauth.authresource.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 /**
  * @description:TODO
  * @author: clj
  * @date: 15:22 24/04/2019
  * @version : V1.0
  */
@RestController
public class ResourceController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
      return user;
    }

    @RequestMapping("/test")
    public  String test() {
        return "test";
    }

     @RequestMapping("/test2")
     public  String test2() {
         return "test.>>...";
     }
}