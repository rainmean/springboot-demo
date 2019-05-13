package com.rainmean.controller;/**
 * Created by Administrator on 2019/4/17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rainmean.Li
 * @create 2019-04-17 17:04
 **/
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("hello", "你好");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
