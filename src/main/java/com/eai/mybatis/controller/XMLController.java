package com.eai.mybatis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eai.common.ExceptionHandle;
import com.eai.common.utils.ResultUtil;
import com.eai.compont.Result;
import com.eai.mybatis.domain.UserInfo;
import com.eai.mybatis.service.XMLService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xudong.li
 *
 */
@RestController
@RequestMapping("/xml")
public class XMLController {

    @Autowired
    private XMLService service;

    @Autowired
    private ExceptionHandle handle;

    /**
     * 更新用户信息
     * @param user_id 用户ID
     * @param nickName 昵称
     */
    @ApiOperation(value = "更新用户信息",notes = "更新用户昵称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "String"),
            @ApiImplicitParam(name = "nickName",value = "用户昵称",required = true,dataType = "String")
    })
    @PutMapping("/updateUser/{id}")
    public Result updateUser(@PathVariable("id") String userId, @RequestParam("name") String name){
        Result result = ResultUtil.success();
        try {
            service.updateUser(userId,name);
        }catch (Exception e){
//            result = handle.exceptionGet(e);
        }
        return result;
//        service.updateUser(user_id,nickName);
    }

    /**
     * 获取用户信息
     * @param id 用户Id
     * @return
     */
    @ApiOperation(value = "获取用户信息",notes = "返回用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/getUser/{id}")
    public Result getUser(@PathVariable("id")  Integer id){
        Result result = ResultUtil.success();
        try {
            result.setData(service.getUser(id));
        }catch (Exception e){
//            result = handle.exceptionGet(e);
        }
        return result;
//        return service.getUser(id);
    }

    /**
     * 删除用户
     * @param tel
     */
    @ApiOperation(value = "删除用户",notes = "根据用户id删除用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Integer")
    @DeleteMapping("/deleteUserByUserId/{tel}")
    public Result deleteUserByUserId(@PathVariable("id")  String id){
        Result result = ResultUtil.success();
        try {
            UserInfo user  = new UserInfo();
            service.deleteUserByUserId(user);
        }catch (Exception e){
//            result = handle.exceptionGet(e);
        }
        return result;
//        UserInfo user  = new UserInfo();
//        user.setTel(tel);
//        service.deleteUserByUserId(user);
    }

    /**
     * 使用@RequestBody获取参数，用map类型接收，再取出
     * @param reqMap
     */
    @ApiOperation(value = "创建用户V3版本",notes = "返回用户信息")
    @ApiImplicitParam(name = "Map",value = "map集合",required = true,dataType = "Map")
    @PostMapping("/createUserByMap")
    public Result createUserByMap(@RequestBody Map<String,Object> reqMap){
        Result result = ResultUtil.success();
        try {
            service.createUser(reqMap);
        }catch (Exception e){
//            result = handle.exceptionGet(e);
        }
        return result;
//        service.createUser(reqMap);
    }


}
