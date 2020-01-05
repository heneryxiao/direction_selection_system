package com.xiao.programmer.controller.teacher;

import com.xiao.programmer.entity.origin.Teacher;
import com.xiao.programmer.service.StudentService;
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
 * @date 2019/12/26 - 15:04
 */
@RequestMapping("/selectedStudentList")
@Controller
public class selectedStudentListController {

    @Autowired
    private StudentService studentService;

    //跳转授课学生列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model) {
        model.setViewName("teacher/selectedStudent_list");
        return model;
    }

    //获取并显示授课学生列表
    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> get_list(HttpServletRequest request) {
        Map<String, Object> ret = new HashMap<>();
        Teacher userWithType = (Teacher) request.getSession().getAttribute("userWithType");
        ret.put("rows", studentService.selectStudentListWithBranchByTid(userWithType.getTid()));
        ret.put("total", 10);
        return ret;
    }
}
