package com.xiao.programmer.controller.common;

import com.xiao.programmer.entity.*;
import com.xiao.programmer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Henery
 * @date 2019/12/19 - 23:45
 */
@RequestMapping(value = "/SelfInformation")
@Controller
public class SelfInformationController {

    @Autowired
    private BranchService branchService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private LeaderService leaderService;

    @Autowired
    private CourseLeaderService courseLeaderService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    /**
     * 根据不同角色跳转至不同角色的个人信息页面
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/introduce", method = RequestMethod.GET)
    public ModelAndView introduce(ModelAndView model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Integer type = user.getType();
        if (type == 2 || type == 3) {
            Leader userWithType = (Leader) request.getSession().getAttribute("userWithType");
            String branchName = "null";
            if (userWithType.getBranchid() != null) {
                Branch branch = branchService.findById(userWithType.getBranchid());
                branchName = branch.getName();
            }
            request.getSession().setAttribute("branchName", branchName);
            model.setViewName("leader/selfInformation");
        }
        ;
        if (type == 4) {
            CourseLeader userWithType = (CourseLeader) request.getSession().getAttribute("userWithType");
            String teacherName = "null";
            String courseName = "null";
            if (userWithType.getTid() != null) {
                Teacher teacher = teacherService.findById(userWithType.getTid());
                teacherName = teacher.getName();
            }
            if (userWithType.getCourseid() != null) {
                Course course = courseService.findById(userWithType.getCourseid());
                courseName = course.getName();
            }
            request.getSession().setAttribute("teacherName", teacherName);
            request.getSession().setAttribute("courseName", courseName);
            model.setViewName("courseLeader/selfInformation");
        }
        if (type == 5) {
            Teacher userWithType = (Teacher) request.getSession().getAttribute("userWithType");
            String branchName = "null";
            model.setViewName("teacher/selfInformation");
        }
        if (type == 6) {
            Student userWithType = (Student) request.getSession().getAttribute("userWithType");
            String branchName = "null";
            if (userWithType.getBranchid() != null) {
                Branch branch = branchService.findById(userWithType.getBranchid());
                branchName = branch.getName();
            }
            request.getSession().setAttribute("branchName", branchName);
            model.setViewName("student/selfInformation");
        }

        return model;
    }

    // 跳转修改密码页面
    @RequestMapping("/jumpModiPw")
    public ModelAndView jumpModiPw(ModelAndView model) {
        model.setViewName("common/modityPw");
        return model;
    }

    // 修改密码（不同角色类型不同跳转页面）
    @RequestMapping("/modityPw")
    public ModelAndView modityPw(@RequestParam("password") String password, ModelAndView model, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        Integer type = user.getType();
        //修改密码
        user.setPassword(password);
        if (type == 2 || type == 3) {
            if (userService.edit(user) > 0) {
                model.setViewName("leader/selfInformation");
            } else {
                model.setViewName("fail");
                return model;
            }
        }
        if (type == 4) {
            if (userService.edit(user) > 0) {
                model.setViewName("courseLeader/selfInformation");
            } else {
                model.setViewName("fail");
                return model;
            }
        }
        if (type == 5) {
            if (userService.edit(user) > 0) {
                model.setViewName("teacher/selfInformation");
            } else {
                model.setViewName("fail");
                return model;
            }
        }
        if (type == 6) {
            if (userService.edit(user) > 0) {
                model.setViewName("student/selfInformation");
            } else {
                model.setViewName("fail");
                return model;
            }
        }


        //更新session中的数据
        request.getSession().setAttribute("user", user);
        return model;
    }

    // 跳转修改邮箱页面
    @RequestMapping("/jumpModiEamil")
    public ModelAndView jumpModiEamil(ModelAndView model) {
        model.setViewName("common/modityEmail");
        return model;
    }

    // 修改邮箱（不同角色类型不同修改方式）
    @RequestMapping("/ModiEmail")
    public ModelAndView ModiEmail(@RequestParam("email") String email, ModelAndView model, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        Integer type = user.getType();
        if (type == 2 || type == 3) {
            Leader userWithType = (Leader) request.getSession().getAttribute("userWithType");
            userWithType.setEmail(email);
            //修改邮箱
            if (leaderService.edit(userWithType) > 0) {
                model.setViewName("leader/selfInformation");
            } else {
                model.setViewName("fail");
                return model;
            }
            //更新session中的数据
            request.getSession().setAttribute("userWithType", userWithType);
        }
        if (type == 4) {
            CourseLeader userWithType = (CourseLeader) request.getSession().getAttribute("userWithType");
            userWithType.setEmail(email);
            //修改邮箱
            if (courseLeaderService.edit(userWithType) > 0) {
                model.setViewName("courseLeader/selfInformation");
            } else {
                model.setViewName("fail");
                return model;
            }
            //更新session中的数据
            request.getSession().setAttribute("userWithType", userWithType);
        }
        if (type == 6) {
            Student userWithType = (Student) request.getSession().getAttribute("userWithType");
            userWithType.setEmail(email);
            //修改邮箱
            if (studentService.edit(userWithType) > 0) {
                model.setViewName("student/selfInformation");
            } else {
                model.setViewName("fail");
                return model;
            }
            //更新session中的数据
            request.getSession().setAttribute("userWithType", userWithType);
        }


        return model;
    }

    // 跳转修改授课老师id页面
    @RequestMapping("/jumpModiTid")
    public ModelAndView jumpModiTid(ModelAndView model) {
        model.setViewName("courseLeader/modityTid");
        return model;
    }

    // 修改授课老师id
    @RequestMapping("/ModiTid")
    public ModelAndView ModiTid(@RequestParam("tid") String tid, ModelAndView model, HttpServletRequest request) {
        CourseLeader userWithType = (CourseLeader) request.getSession().getAttribute("userWithType");
        userWithType.setTid(tid);
        Teacher existTeacher = teacherService.findById(tid);
        //判断是否存在该老师id
        if (existTeacher == null) {
            model.setViewName("fail");
            return model;
        }
        //修改
        if (courseLeaderService.edit(userWithType) > 0) {
            String teacherName = "null";
            Teacher teacher = teacherService.findById(userWithType.getTid());
            teacherName = teacher.getName();
            request.getSession().setAttribute("teacherName", teacherName);
            model.setViewName("courseLeader/selfInformation");

        } else {
            model.setViewName("fail");
            return model;
        }
        //更新session中的数据
        request.getSession().setAttribute("userWithType", userWithType);
        return model;
    }

    // 跳转修改授课程id页面
    @RequestMapping("/jumpModiCourseid")
    public ModelAndView jumpModiCourseid(ModelAndView model) {
        model.setViewName("courseLeader/modityCourseid");
        return model;
    }

    // 修改授课课程id
    @RequestMapping("/ModiCourseid")
    public ModelAndView ModiCourseid(@RequestParam("courseid") String courseid, ModelAndView model, HttpServletRequest request) {
        CourseLeader userWithType = (CourseLeader) request.getSession().getAttribute("userWithType");
        userWithType.setCourseid(courseid);
        Course existCourse = courseService.findById(courseid);
        //判断是否存在该课程id
        if (existCourse == null) {
            model.setViewName("fail");
            return model;
        }
        //修改
        if (courseLeaderService.edit(userWithType) > 0) {
            String courseName = "null";
            Course course = courseService.findById(userWithType.getCourseid());
            courseName = course.getName();
            request.getSession().setAttribute("courseName", courseName);
            model.setViewName("courseLeader/selfInformation");

        } else {
            model.setViewName("fail");
            return model;
        }
        //更新session中的数据
        request.getSession().setAttribute("userWithType", userWithType);
        return model;
    }

    // 跳转修改课程介绍页面
    @RequestMapping("/jumpModiIntroduce")
    public ModelAndView jumpModiIntroduce(ModelAndView model) {
        model.setViewName("courseLeader/modityIntroduce");
        return model;
    }

    // 修改课程介绍
    @RequestMapping("/ModiIntroduce")
    public ModelAndView ModiIntroduce(@RequestParam("introduce") String introduce, ModelAndView model, HttpServletRequest request) {
        CourseLeader userWithType = (CourseLeader) request.getSession().getAttribute("userWithType");
        userWithType.setIntroduce(introduce);
        //修改
        if (courseLeaderService.edit(userWithType) > 0) {
            model.setViewName("courseLeader/selfInformation");

        } else {
            model.setViewName("fail");
            return model;
        }
        //更新session中的数据
        request.getSession().setAttribute("userWithType", userWithType);
        return model;
    }

}


