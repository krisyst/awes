package cn.kris.controller;

import cn.kris.entity.AUser;
import cn.kris.mapper.AUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private AUserMapper aUserMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        List<AUser> list = aUserMapper.selectList(null);
        return "index.html";
    }

}
