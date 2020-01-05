package com.xiao.programmer.controller.course;

import com.xiao.programmer.entity.origin.Branch;
import com.xiao.programmer.entity.origin.Course;
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
@RequestMapping(value = "/CourseList")
@Controller
public class CourseListController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private BranchService branchService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model) {
        model.setViewName("course/course_list");
        return model;
    }

    //@ResponseBody!!!!返回数据一要这个     （@ResponseBody：将ret转换成json字符串）
    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> get_list(HttpServletRequest request) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("rows", courseService.getList());
        ret.put("total", 10);
        return ret;

    }

    /**
     * 添加课程信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(Course course) {
        Map<String, String> ret = new HashMap<String, String>();


        if (StringUtils.isEmpty(course.getCourseid())) {
            ret.put("type", "error");
            ret.put("msg", "课程编号不能为空!");
            return ret;
        }
        if (StringUtils.isEmpty(course.getName())) {
            ret.put("type", "error");
            ret.put("msg", "课程名称不能为空!");
            return ret;
        }
        if (StringUtils.isEmpty(course.getBranchid())) {
            ret.put("type", "error");
            ret.put("msg", "所属方向ID不能为空!");
            return ret;
        }

        Course existCourse = courseService.findById(course.getCourseid());
        if (existCourse != null) {
            ret.put("type", "error");
            ret.put("msg", "该课程编号已存在");
            return ret;
        }

        existCourse = courseService.selectByName(course.getName());
        if (existCourse != null) {
            ret.put("type", "error");
            ret.put("msg", "该课程名称已存在");
            return ret;
        }

        Branch existBranch = branchService.findById(course.getBranchid());
        if (existBranch == null) {
            ret.put("type", "error");
            ret.put("msg", "所属方向不存在");
            return ret;
        }
        //添加并判断
        if (courseService.add(course) <= 0) {
            ret.put("type", "error");
            ret.put("msg", "修改失败!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "课程添加成功！");
        return ret;
    }

    /**
     * 编辑课程操作
     *
     * @param course
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(Course course) {
        Map<String, String> ret = new HashMap<String, String>();
        if (course == null) {
            ret.put("type", "error");
            ret.put("msg", "数据绑定出错，请联系开发作者!");
            return ret;
        }
        if (StringUtils.isEmpty(course.getName())) {
            ret.put("type", "error");
            ret.put("msg", "课程名称不能为空!");
            return ret;
        }

        Course existCourse = courseService.selectByName(course.getName());
        if (existCourse != null) {
            Course isNowCourse = courseService.findById(course.getCourseid());
            //排除修改的是当前方向
            if (!isNowCourse.getName().equals(course.getName())) {
                ret.put("type", "error");
                ret.put("msg", "该课程名称已重复!");
                return ret;
            }
        }

        Branch existBranch = branchService.findById(course.getBranchid());
        if (existBranch == null) {
            ret.put("type", "error");
            ret.put("msg", "所属方向不存在");
            return ret;
        }

        if (courseService.edit(course) <= 0) {
            ret.put("type", "error");
            ret.put("msg", "修改失败!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "修改成功!");
        return ret;
    }

    /**
     * 删除课程操作
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
            if (courseService.delete(id) <= 0) {
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
