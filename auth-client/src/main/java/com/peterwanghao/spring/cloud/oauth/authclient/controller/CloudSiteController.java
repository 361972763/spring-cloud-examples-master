package com.peterwanghao.spring.cloud.oauth.authclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.ModelAndView;

 /**
  * @description:TODO
  * @author: clj
  * @date: 15:19 24/04/2019 
  * @version : V1.0
  */
@RestController
public class CloudSiteController {

    @Autowired
    private RestOperations restOperations;

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello From Auth-Client!";
    }

    @GetMapping("/personInfo")
    public ModelAndView person() {
        ModelAndView mav = new ModelAndView("personinfo");
        //modify
        //String personResourceUrl = "http://localhost:9000/person";
        String personResourceUrl = "http://localhost:9000/user";
        mav.addObject("person", restOperations.getForObject(personResourceUrl, String.class));
        return mav;
    }

    /**
    * @author clj
    * @description //测试
    * @date 9:27 25/04/2019
    * @param []
    * @return java.lang.String
    **/
     @GetMapping("/test")
     public String  test() {
         //modify
         String personResourceUrl = "http://localhost:9000/test";
         return restOperations.getForObject(personResourceUrl, String.class);
     }
     /**
      * @author clj
      * @description //测试
      * @date 9:27 25/04/2019
      * @param []
      * @return java.lang.String
      **/
     @GetMapping("/test2")
     public String  test2() {
         //modify
         String personResourceUrl = "http://localhost:9000/test2";
         return restOperations.getForObject(personResourceUrl, String.class);
     }
}
