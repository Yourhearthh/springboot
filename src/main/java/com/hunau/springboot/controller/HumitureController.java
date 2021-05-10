package com.hunau.springboot.controller;

import com.hunau.springboot.domain.Humiture;
import com.hunau.springboot.service.IHumitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cx
 * @Time 2020/6/28 15:32
 * @Description 温湿度采集 控制层
 */
@Controller
public class HumitureController {
    @Autowired
    private IHumitureService iHumitureService;

    @GetMapping("/test")
    @ResponseBody
    public List<Humiture> list()
    {
        return iHumitureService.listHumiture();
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String,Object> selectAll()
    {
        Map<String,Object> map = new HashMap<>();
        List<Humiture> data = iHumitureService.listHumiture();
        map.put("code",0);
        map.put("msg","随便写点东西");
        map.put("count",10);
        map.put("data",data);
        return map;
    }
}
