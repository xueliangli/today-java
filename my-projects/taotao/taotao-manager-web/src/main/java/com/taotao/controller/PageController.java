package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 显示首页
     * */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    /**
     * 显示商品的查询
     * 来的请求是什么就返回相应的 jsp
     * */
    @RequestMapping("/{page}")
    public String showItemList(@PathVariable String page){
        return page;
    }
}
