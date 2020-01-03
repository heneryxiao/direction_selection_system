package com.xiao.programmer.controller.student;

import com.xiao.programmer.entity.extend.Page;
import com.xiao.programmer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Henery
 * @date 2019/12/26 - 16:16
 */
@RequestMapping("/studentList")
@Controller
public class StudentListController {
    @Autowired
    private StudentService studentService;

    //跳转学生列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model) {
        model.setViewName("student/student_list");
        return model;
    }

    //获取并显示学生列表
    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> get_list(
            @RequestParam(value = "sid", required = false, defaultValue = "") String sid,
            Page page) {
        Map<String, Object> ret = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("sid", "%" + sid + "%");
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        ret.put("rows", studentService.findListWithBranch(queryMap));
        ret.put("total", studentService.getTotal());
        System.out.println(ret.toString() + "   " + queryMap.toString());
        return ret;
    }
}
