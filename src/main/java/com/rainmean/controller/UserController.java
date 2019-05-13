package com.rainmean.controller;/**
 * Created by Administrator on 2019/4/17.
 */

import com.rainmean.entity.User;
import com.rainmean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 用户Controller
 *
 * @author Rainmean.Li
 * @create 2019-04-17 17:38
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public String list(ModelMap map){
        List<User> users = userService.findUsers();
        map.addAttribute("users",users);
        return "user_list";
    }

    @GetMapping("/userEdit")
    public String edit(Long id, ModelMap map){
        User user = null;
        if(id==null){
            user = new User();
        }else{
            user = userService.findUserById(id);
        }
        map.addAttribute("user",user);
        return "user_edit";
    }

    @PostMapping("/userSave")
    public String save(User user, RedirectAttributes redirectAttributes){
        int row = 0;
        if(user.getId()==null){
            userService.addUser(user);
            redirectAttributes.addFlashAttribute("message","创建用户成功！");
        }else{
            userService.update(user);
            redirectAttributes.addFlashAttribute("message","更新用户成功！");
        }
        return "redirect:userList";
    }

    @GetMapping("/userDelete")
    public String delete(Long id, RedirectAttributes redirectAttributes){
        int row = userService.delete(id);
        if(row>0){
            redirectAttributes.addFlashAttribute("message","删除用户成功！");
        }else{
            redirectAttributes.addFlashAttribute("error","删除用户失败！");
        }
        return "redirect:userList";
    }
}
