package com.xiao.programmer.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Henery
 * @date 2019/12/19 - 17:28
 */
@RequestMapping(value = "/BranchIntroduce")
@Controller
public class BranchIntroduceController {
    @RequestMapping(value = "/introduce", method = RequestMethod.GET)
    public ModelAndView introduce(ModelAndView model) {
//        model.setViewName("student/branchIntroduce");
        model.setViewName("student/branchIntroduce");
        return model;
    }
}
