package com.xiao.programmer.controller.teacher;

import com.xiao.programmer.entity.extend.Page;
import com.xiao.programmer.service.TeacherService;
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
 * @date 2019/12/26 - 15:04
 */
@RequestMapping("/teacherList")
@Controller
public class TeacherListController {

    @Autowired
    private TeacherService teacherService;

    //跳转老师列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model) {
        model.setViewName("teacher/teacher_list");
        return model;
    }

    //获取并显示老师列表
    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> get_list(
            @RequestParam(value = "tid", required = false, defaultValue = "") String tid,
            Page page) {
        Map<String, Object> ret = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("tid", "%" + tid + "%");
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        ret.put("rows", teacherService.findList(queryMap));
        ret.put("total", teacherService.getTotal());
        return ret;
    }
}
