package cn.kris.api;

import cn.kris.entity.AUser;
import cn.kris.service.AUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
@CrossOrigin //所有域名均可访问该类下所有接口
public class AUserApi {

    @Autowired
    private AUserService aUserService;

    @ApiOperation("会员登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码" , required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Object login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        QueryWrapper<AUser> aUserWrapper = new QueryWrapper<>();
        aUserWrapper.eq("username", username);
        aUserWrapper.eq("password", password);
        return aUserService.getOne(aUserWrapper);
    }

    @ApiOperation("会员注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码" , required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public Object register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AUser aUser = new AUser();
        aUser.setUsername(username);
        aUser.setPassword(password);
        return aUserService.save(aUser);
    }


}
