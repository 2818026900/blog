package com.lmy.blog.web.controller;

import com.lmy.blog.service.dto.vo.PersonalCenterInfoVO;
import com.lmy.blog.service.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

/**
 * @author lmy
 * @email 2818026900@qq.com
 */
@Api(tags = "个人中心")
@RestController
@RequestMapping(value = "/personInfo")
public class PersonInfoController {
    @Resource
    UsersService usersService = new UsersService();

    @ApiOperation(value = "获取个人中心信息")
    @GetMapping("/username={username}&labelsId={labelsId}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(paramType = "path", dataType = "String", name = "username", value = "用户名", required = true, example = "李鹏"),
                    @ApiImplicitParam(paramType = "path", dataType = "BigInteger", name = "labelsId", value = "标签号", required = true, example = "1")
            }
    )
    public PersonalCenterInfoVO getInfo(@PathVariable String username, @PathVariable BigInteger labelsId){
        return usersService.e2vo(username,labelsId);
    }

    @ApiOperation(value = "更新个人中心信息")
    @PutMapping("/personalCenterInfoVo=")
    public String putInfo(@RequestBody String jsonStr){
        String flag = usersService.jsonStr2e(jsonStr);
        if("success".equals(flag)){
            return "success";
        }
        return "failed";
    }
}
