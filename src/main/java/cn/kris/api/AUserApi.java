package cn.kris.api;

import cn.kris.entity.AUser;
import cn.kris.service.AUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class AUserApi {

    @Autowired
    private AUserService aUserService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public Object login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        QueryWrapper<AUser> aUserWrapper = new QueryWrapper<AUser>();
        aUserWrapper.eq("username", username);
        aUserWrapper.eq("password", password);
        return aUserService.getOne(aUserWrapper);
    }


}
