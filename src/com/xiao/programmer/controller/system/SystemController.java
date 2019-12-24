package com.xiao.programmer.controller.system;

import com.github.pagehelper.util.StringUtil;
import com.xiao.programmer.entity.*;
import com.xiao.programmer.service.*;
import com.xiao.programmer.util.CpachaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Henery
 * @date 2019/11/28 - 18:22
 */
@RequestMapping(value = "/system")
@Controller
public class SystemController {

    @Autowired
    private UserService userService;

    @Autowired
    private LeaderService leaderService;

    @Autowired
    private CourseLeaderService courseLeaderService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;




    /**
     * 项目启动首先跳转至此
     * 跳转登录页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model) {
        model.setViewName("system/login");
        return model;
    }

    /**
     * 显示验证码
     *
     * @param request
     * @param vl
     * @param w
     * @param h
     * @param response
     */
    @RequestMapping(value = "/get_cpacha", method = RequestMethod.GET)
    public void getCpacha(HttpServletRequest request,
                          @RequestParam(value = "vl", defaultValue = "4", required = false) Integer vl,
                          @RequestParam(value = "w", defaultValue = "98", required = false) Integer w,
                          @RequestParam(value = "h", defaultValue = "33", required = false) Integer h,
                          HttpServletResponse response) {
        CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute("loginCpacha", generatorVCode);
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录表单提交
     *
     * @return
     * @ResponseBody：将ret转换成json字符串
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(
            @RequestParam(value = "uid", required = true) String uid,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "vcode", required = true) String vcode,
            HttpServletRequest request
    ) {
        Map<String, String> ret = new HashMap<String, String>();

        if (StringUtil.isEmpty(uid)) {
            ret.put("type", "error");
            ret.put("msg", "账号不能为空！");
            return ret;
        } else if (StringUtil.isEmpty(password)) {
            ret.put("type", "error");
            ret.put("msg", "密码不能为空！");
            return ret;
        } else if (StringUtil.isEmpty(vcode)) {
            ret.put("type", "error");
            ret.put("msg", "验证码不能为空！");
            return ret;
        }
        //获取存入session的绘画的验证码，
        String loginCpacha = (String) request.getSession().getAttribute("loginCpacha");
        //session默认存在30分钟
        if (StringUtil.isEmpty(loginCpacha)) {
            ret.put("type", "error");
            ret.put("msg", "长时间未操作，会话已失效，请刷新后重试！");
            return ret;
        }
        //将绘画的验证码和输入的验证码同时转为大写字母后比较
        if (!vcode.toUpperCase().equals(loginCpacha.toUpperCase())) {
            ret.put("type", "error");
            ret.put("msg", "验证码错误！");
            return ret;
        }
        //从数据库中查找用户
        User user = userService.findById(uid);
        if (user == null) {
            ret.put("type", "error");
            ret.put("msg", "不存在该用户！");
            return ret;
        }
        if (!password.equals(user.getPassword())) {
            ret.put("type", "error");
            ret.put("msg", "密码错误！");
            return ret;
        }
        //存入学生信息，以便拦截或在其他页面显示需要的信息
        request.getSession().setAttribute("user", user);
        Integer type = user.getType();
        String id = user.getUid();
        //判断用户类型，然后根据用户类型查询对应表的数据存入session中
        if (type == 2 | type == 3){
            Leader userWithType = leaderService.findById(id);
            request.getSession().setAttribute("userWithType", userWithType);
        };

        if (type == 4){
            CourseLeader userWithType = courseLeaderService.findById(id);
            request.getSession().setAttribute("userWithType", userWithType);
        };
        if (type == 5){
            Teacher userWithType = teacherService.findById(id);
            request.getSession().setAttribute("userWithType", userWithType);
        };
        if (type == 6){
            Student userWithType = studentService.findById(id);
            request.getSession().setAttribute("userWithType", userWithType);
        };
        ret.put("type", "success");
        ret.put("msg", "登录成功！");
        return ret;
    }

    /**
     * 登录成功后跳转至首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model) {
        model.setViewName("system/index");
        return model;
    }

    /**
     * 注销登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/login_out",method=RequestMethod.GET)
    public String loginOut(HttpServletRequest request){
        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("userWithType", null);
        request.getSession().setAttribute("branchName", null);

        return "redirect:login";
    }
}
