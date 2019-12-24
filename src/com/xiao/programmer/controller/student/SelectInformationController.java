package com.xiao.programmer.controller.student;

import com.xiao.programmer.entity.Student;
import com.xiao.programmer.entity.User;
import com.xiao.programmer.service.BranchService;
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
 * @date 2019/11/29 - 22:31
 */
@RequestMapping(value = "/selectInformation")
@Controller
public class SelectInformationController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private BranchService branchService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ModelAndView select(ModelAndView model) {
        model.setViewName("student/selectInformation");
        return model;
    }


    //@ResponseBody!!!!返回数据一要这个     （@ResponseBody：将ret转换成json字符串）
    //rows里面的一定是要集合！！！！单个对象也要放入集合中
    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(HttpServletRequest request) {
        Map<String, Object> ret = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        String uid = user.getUid();
        ret.put("rows", studentService.getListBySIdWithBranch(uid));
        ret.put("total", 10);
        return ret;

    }

    @RequestMapping(value = "/quit", method = RequestMethod.GET)
    public ModelAndView quit(ModelAndView model, HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute("userWithType");
        System.out.println(student);
        //获取学号置空选报信息
        String sid = student.getSid();
        //获取选报信息置用于已选人数减一
        String branchid = student.getBranchid();
        //置空
        studentService.quitBySid(sid);
        //退选(已选人数减一)
        branchService.quitByBranchId(branchid);
        //更新session中的student数据
        student = studentService.findById(sid);
        request.getSession().setAttribute("userWithType", student);
        model.setViewName("student/selectInformation");
        return model;
    }
}
