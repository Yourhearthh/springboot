package com.hunau.springboot.controller;

import com.hunau.springboot.domain.Humiture;
import com.hunau.springboot.service.IHumitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * @author cx
 * @Time 2020/6/28 10:22
 * @Description 页面信息展示 控制层
 */
@Controller
public class IndexController {

    @Autowired
    private IHumitureService iHumitureService;

    @GetMapping("/")
    public String hello(ModelMap modelMap)
    {
        List<Humiture> list = iHumitureService.listHumiture();
        modelMap.addAttribute("message",list);
        return "index";
    }

    @GetMapping("/humiture")
    public String humiture(ModelMap modelMap)
    {
        List<Humiture> list = iHumitureService.listHumiture();
        modelMap.addAttribute("value",list);
        return "humiture";
    }
}
