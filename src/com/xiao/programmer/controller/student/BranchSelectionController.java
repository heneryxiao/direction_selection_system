package com.xiao.programmer.controller.student;

import com.xiao.programmer.entity.origin.Student;
import com.xiao.programmer.service.BranchService;
import com.xiao.programmer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Henery
 * @date 2019/12/3 - 0:15
 */
@RequestMapping(value = "/BranchSelection")
@Controller
public class BranchSelectionController {
    @Autowired
    private BranchService branchService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ModelAndView select(ModelAndView model) {
        model.setViewName("student/branchSelection");
        return model;
    }
    //@ResponseBody!!!!返回数据一要这个     （@ResponseBody：将ret转换成json字符串）
    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> get_list() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("rows", branchService.getList());
        ret.put("total", 10);
        return ret;

    }
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> submit(
            @RequestParam(value = "branchid", required = true) String branchid,
            HttpServletRequest request
    ) {
        Map<String, Object> ret = new HashMap<>();
        //判读是否勾选了课程
        if (branchid == null) {
            ret.put("type", "error");
            ret.put("msg", "未选择专业方向！");
            return ret;
        }
        //判断用户是否已选课程
        Student student = (Student) request.getSession().getAttribute("userWithType");
        if (student.getBranchid() == null) {
            Integer limited = branchService.getLimitedByBranchId(branchid);
            Integer selected = branchService.getSelectedByBranchId(branchid);
            if (selected >= limited) {
                ret.put("type", "error");
                ret.put("msg", "人数已满，请选择其他专业方向！");
                return ret;
            }
            //更新学生选报信息
            String sid = student.getSid();
            studentService.updateBranchIdBySid(sid, branchid);
            //更新session中的student数据
            student = studentService.findById(sid);
            request.getSession().setAttribute("userWithType", student);
            //已选人数加一
            branchService.updateByBranchId(branchid);
            ret.put("type", "success");
            ret.put("msg", "专业方向选择成功！");
            return ret;
        }else {
            ret.put("type", "error");
            ret.put("msg", "你已经选过专业方向了！");
            return ret;
        }
    }
}



