package com.peterwanghao.spring.cloud.oauth.authresource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.peterwanghao.spring.cloud.oauth.authresource.model.Person;

 /**
  * @description:个人信息
  * @author: clj
  * @date: 15:22 24/04/2019
  * @version : V1.0
  */
@RestController
public class PersonInfoController {

    @GetMapping("/person")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public @ResponseBody Person personInfo() {
        return new Person("peter", "Beijing", "China", 29, "Male");
    }   
}
