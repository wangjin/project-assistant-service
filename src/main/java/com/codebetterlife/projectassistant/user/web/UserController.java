package com.codebetterlife.projectassistant.user.web;

import com.codebetterlife.projectassistant.base.domain.Response;
import com.codebetterlife.projectassistant.user.domain.User;
import com.codebetterlife.projectassistant.user.domain.UserCriteria;
import com.codebetterlife.projectassistant.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:24 下午
 */
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/page")
    public Response<Page<User>> page(UserCriteria criteria, Pageable pageable) {
        return Response.success(userService.findByPage(criteria, pageable));
    }

    @GetMapping(value = "/{id}")
    public Response<User> get(@PathVariable Long id) {
        return Response.success(userService.findById(id).orElse(null));
    }

    @PostMapping
    public Response<User> create(@RequestBody User user) {
        return Response.success(userService.save(user));
    }

    @PutMapping
    public Response<User> update(@RequestBody User user) {
        return Response.success(userService.update(user));
    }

    @DeleteMapping(value = "/{id}")
    public Response<Void> delete(@PathVariable Long id) {
        userService.deleteLogic(id);
        return Response.success();
    }
}
