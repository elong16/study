package com.example._work.controller;

import com.example._work.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class MyController {

    Map<String,User> map=new HashMap<>();



    //POST接口
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(@RequestParam(value = "name") String name,
                           @RequestParam(value = "password") String password){
        if (map.containsKey(name)){
            return "用户已经存在";
        }else {
            User user = new User(name, password);
            map.put(name,user);
            return user.toString();
        }
    }

    //GET接口
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "password") String password){
        if (map.containsKey(name)){
            User user = map.get(name);
            return user.toString();
        }else {
            return "未查找到该用户";
        }
    }

   //DELETE接口
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String delUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "password") String password){
        if (map.containsKey(name)){
             map.remove("name");
            return "已删用户"+name;
        }else {
           return "该用户不存在";
        }
    }

    //PUT接口
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "password") String password){
        if (map.containsKey(name)){
            User user = map.get(name);
            User user1 = new User(name, password);
            map.put(name,user);
            return "修改前密码为"+user.getPassword()+"\n"+"修改后密码为"+user1.getPassword();
        }else {
           return"该用户不存在";
        }
    }



}
