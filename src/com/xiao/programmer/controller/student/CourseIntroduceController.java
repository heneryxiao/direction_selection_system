package com.xiao.programmer.controller.student;

import com.xiao.programmer.entity.origin.User;
import com.xiao.programmer.service.CourseLeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Henery
 * @date 2019/12/30 - 9:15
 */
@RequestMapping(value = "/CourseIntroduce")
@Controller
public class CourseIntroduceController {

    @Autowired
    private CourseLeaderService courseLeaderService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ModelAndView select(ModelAndView model) {
        model.setViewName("student/courseInformation");
        return model;
    }

    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(HttpServletRequest request) {
        Map<String, Object> ret = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        String uid = user.getUid();
        ret.put("rows", courseLeaderService.selectCourseListWithCourseAndTeacher());
        ret.put("total", 10);
        return ret;

    }
}
