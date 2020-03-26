package cn.kris.api;

import cn.kris.entity.SAdmin;
import cn.kris.service.SAdminService;
import cn.kris.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
@CrossOrigin //所有域名均可访问该类下所有接口
public class SAdminApi {

    @Autowired
    private SAdminService sAdminService;
    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping(method = RequestMethod.GET)
    public Object a() {
        redisUtil.set("mobile1","15566889551",10L, TimeUnit.MINUTES);
        redisUtil.set("mobile2","15566889552",10L, TimeUnit.MINUTES);
        redisUtil.set("mobile3","15566889553",10L, TimeUnit.MINUTES);
        redisUtil.set("mobile4","15566889554",10L, TimeUnit.MINUTES);
        redisUtil.set("mobile5","15566889555",10L, TimeUnit.MINUTES);
        return redisUtil.get("mobile1");
    }


    @ApiOperation("会员登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Object login(@RequestBody Map<String, Object> param) {
        String username = param.get("username").toString();
        String password = param.get("password").toString();

        QueryWrapper<SAdmin> sAdminWrapper = new QueryWrapper<>();
        sAdminWrapper.eq("username", username);
        sAdminWrapper.eq("password", password);
        return sAdminService.getOne(sAdminWrapper);
    }

    @ApiOperation("会员注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public Object register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        SAdmin sAdmin = new SAdmin();
        sAdmin.setUsername(username);
        sAdmin.setPassword(password);
        return sAdminService.save(sAdmin);
    }


}
