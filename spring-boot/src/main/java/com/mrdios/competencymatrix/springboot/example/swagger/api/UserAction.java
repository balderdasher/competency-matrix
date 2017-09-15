package com.mrdios.competencymatrix.springboot.example.swagger.api;

import com.mrdios.competencymatrix.springboot.example.swagger.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * Swagger生成优雅的restful api接口文档
 *
 * @author CodePorter
 * @date 2017-09-14
 */
@RestController
@RequestMapping(value = "/users")
public class UserAction {

    Map<String, User> userMap = Collections.synchronizedMap(new HashMap<String, User>());

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = new ArrayList<>(userMap.values());
        return users;
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体", required = true, dataType = "User")
    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        userMap.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        return userMap.get(id);
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体信息", required = true, dataType = "User")
    })
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public String putUser(@PathVariable String id, @RequestBody User user) {
        User user1 = userMap.get(id);
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        userMap.put(id, user1);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id) {
        userMap.remove(id);
        return "success";
    }

    @ApiIgnore
    @RequestMapping(value = {"/hi"}, method = RequestMethod.GET)
    public String jsonTest() {
        return "hello!";
    }
}
