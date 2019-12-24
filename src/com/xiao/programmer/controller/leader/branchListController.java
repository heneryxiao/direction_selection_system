package com.xiao.programmer.controller.leader;

import com.xiao.programmer.entity.Branch;
import com.xiao.programmer.entity.Course;
import com.xiao.programmer.service.BranchService;
import com.xiao.programmer.service.CourseService;
import org.apache.commons.lang.StringUtils;
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
 * @date 2019/12/5 - 18:13
 */
@RequestMapping(value = "/BranchList")
@Controller
public class branchListController {
    @Autowired
    private BranchService branchService;

    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model) {
        model.setViewName("leader/branch_list");
        return model;
    }

    //@ResponseBody!!!!返回数据一要这个     （@ResponseBody：将ret转换成json字符串）
    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> get_list(HttpServletRequest request) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("rows", branchService.getList());
        ret.put("total", 10);
//        ret.put("code", 0);
//        ret.put("count", 10);
//        ret.put("data", branchService.getList());
        return ret;

    }

    /**
     * 添加方向信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(Branch branch) {
        Map<String, String> ret = new HashMap<String, String>();


        if (StringUtils.isEmpty(branch.getBranchid())) {
            ret.put("type", "error");
            ret.put("msg", "方向ID不能为空!");
            return ret;
        }
        if (StringUtils.isEmpty(branch.getName())) {
            ret.put("type", "error");
            ret.put("msg", "方向名称不能为空!");
            return ret;
        }
        if (StringUtils.isEmpty(branch.getCourseid())) {
            ret.put("type", "error");
            ret.put("msg", "涉及课程ID不能为空!");
            return ret;
        }
        Course existCourse = courseService.findById(branch.getCourseid());
        if (existCourse == null) {
            ret.put("type", "error");
            ret.put("msg", "所涉及的课程不存在");
            return ret;
        }
        Branch existBranch = branchService.findById(branch.getBranchid());
        if (existBranch != null) {
            ret.put("type", "error");
            ret.put("msg", "该方向ID已存在");
            return ret;
        }
        //添加并判断
        if (branchService.add(branch) <= 0) {
            ret.put("type", "error");
            ret.put("msg", "修改失败!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "学生添加成功！");
        return ret;
    }

    /**
     * 编辑用户操作
     *
     * @param branch
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(Branch branch) {
        Map<String, String> ret = new HashMap<String, String>();
        if (branch == null) {
            ret.put("type", "error");
            ret.put("msg", "数据绑定出错，请联系开发作者!");
            return ret;
        }
        if (StringUtils.isEmpty(branch.getName())) {
            ret.put("type", "error");
            ret.put("msg", "方向名称不能为空!");
            return ret;
        }
        if (StringUtils.isEmpty(branch.getCourseid())) {
            ret.put("type", "error");
            ret.put("msg", "涉及课程ID不能为空!");
            return ret;
        }
        if (branch.getLimited() <= 0) {
            ret.put("type", "error");
            ret.put("msg", "限制人人数不能小于等于0！");
            return ret;
        }
        Integer selected = branchService.getSelectedByBranchId(branch.getBranchid());
        if (branch.getLimited() < selected) {
            ret.put("type", "error");
            ret.put("msg", "限制人人数不能小于现已选人数！");
            return ret;
        }
        Course existCourse = courseService.findById(branch.getCourseid());
        if (existCourse == null) {
            ret.put("type", "error");
            ret.put("msg", "所涉及的课程不存在");
            return ret;
        }
        Branch existBranch = branchService.selectByName(branch.getName());
        if (existBranch != null) {
            Branch isNowBranch = branchService.findById(branch.getBranchid());
            //排除修改的是当前方向
            if (!isNowBranch.getName().equals(branch.getName())) {
                ret.put("type", "error");
                ret.put("msg", "该方向名称已重复!");
                return ret;
            }
        }
        if (branchService.edit(branch) <= 0) {
            ret.put("type", "error");
            ret.put("msg", "修改失败!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "修改成功!");
        return ret;
    }

    /**
     * 删除用户操作
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(
            @RequestParam(value = "ids[]", required = true) String[] ids
    ) {
        Map<String, String> ret = new HashMap<String, String>();
        if (ids == null) {
            ret.put("type", "error");
            ret.put("msg", "请选择要删除的数据!");
            return ret;
        }
        for (String id : ids) {
            if (branchService.delete(id) <= 0) {
                ret.put("type", "error");
                ret.put("msg", "删除失败!");
                return ret;
            }
        }
        ret.put("type", "success");
        ret.put("msg", "修改成功!");
        return ret;
    }
}
