package com.xiao.programmer.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.xiao.programmer.entity.extend.Page;
import com.xiao.programmer.entity.origin.*;
import com.xiao.programmer.service.*;
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

@RequestMapping("/courseLeader")
@Controller
public class CourseLeaderController {

	@Autowired
	private CourseLeaderService courseLeaderService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView model) {
		model.setViewName("admin/courseLeader_list");
		return model;
	}

	@RequestMapping(value = "/get_list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> get_list(
			@RequestParam(value = "cid", required = false, defaultValue = "") String cid,
			Page page,
			HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("cid", "%" + cid + "%");
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", courseLeaderService.findList(queryMap));
		ret.put("total", courseLeaderService.getTotal());
		return ret;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	// @ResponseBody 把返回的数据转换成json对象再返回
	public Map<String, String> add(CourseLeader courseLeader) {
		Map<String, String> ret = new HashMap<String, String>();
		if (courseLeader == null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系管理员");
			return ret;
		}
		if (StringUtil.isEmpty(courseLeader.getCid())) {
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(courseLeader.getName())) {
			ret.put("type", "error");
			ret.put("msg", "姓名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(courseLeader.getGender())) {
			ret.put("type", "error");
			ret.put("msg", "性别不能为空");
			return ret;
		}
		User existUser = userService.findById(courseLeader.getCid());
		if (existUser == null) {
			ret.put("type", "error");
			ret.put("msg", "该未找到该用户，无法添加");
			return ret;
		}
		if (existUser.getType() != 4) {
			ret.put("type", "error");
			ret.put("msg", "该用户不是课程主任，无法添加");
			return ret;
		}
		if (courseLeader.getName().length() > 10) {
			ret.put("type", "error");
			ret.put("msg", "姓名超过允许的范围");
			return ret;
		}
		if (!courseLeader.getGender().equals("男") && !courseLeader.getGender().equals("女")) {
			ret.put("type", "error");
			ret.put("msg", "请输入正确的性别");
			return ret;
		}
		//如果未输入方向ID则调整为Null（未填写为“”，由于外键关联约束，改为null可添加成功）
		if(courseLeader.getCourseid().equals("")){
			courseLeader.setCourseid(null);
		}
		if(courseLeader.getTid().equals("")){
			courseLeader.setTid(null);
		}
		Teacher existTeacher = teacherService.findById(courseLeader.getTid());
		if (existTeacher == null && courseLeader.getTid() != null) {
			ret.put("type", "error");
			ret.put("msg", "授课老师不存在");
			return ret;
		}
		Course existCourse = courseService.findById(courseLeader.getCourseid());
		if (existCourse == null && courseLeader.getCourseid() != null) {
			ret.put("type", "error");
			ret.put("msg", "所授课程不存在");
			return ret;
		}
		//添加并判断
		if (courseLeaderService.add(courseLeader) <= 0) {
			ret.put("type", "error");
			ret.put("msg", "修改失败!");
			return ret;
		}

		ret.put("type", "success");
		ret.put("msg", "添加成功");
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
	// @ResponseBody 把返回的数据转换成json对象再返回
	public Map<String, String> delete(
			@RequestParam(value = "ids[]", required = true) String[] ids
	) {
		Map<String, String> ret = new HashMap<String, String>();
		if (ids == null) {
			ret.put("type", "error");
			ret.put("msg", "请选择要删除的数据");
			return ret;
		}

		for (String id : ids) {
			if (courseLeaderService.delete(id) <= 0) {
				ret.put("type", "error");
				ret.put("msg", "删除失败!");
				return ret;
			}
		}
		ret.put("type", "success");
		ret.put("msg", "删除成功");
		return ret;
	}

	/**
	 * 编辑用户操作
	 *
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	//@ResponseBody 把返回的数据转换成json对象再返回
	public Map<String, String> edit(CourseLeader courseLeader) {
		Map<String, String> ret = new HashMap<String, String>();
		if (courseLeader == null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系管理员");
			return ret;
		}
		if (StringUtil.isEmpty(courseLeader.getName())) {
			ret.put("type", "error");
			ret.put("msg", "姓名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(courseLeader.getGender())) {
			ret.put("type", "error");
			ret.put("msg", "性别不能为空");
			return ret;
		}
		if (courseLeader.getName().length() > 10) {
			ret.put("type", "error");
			ret.put("msg", "姓名超过允许的范围");
			return ret;
		}
		if (!courseLeader.getGender().equals("男") && !courseLeader.getGender().equals("女")) {
			ret.put("type", "error");
			ret.put("msg", "请输入正确的性别");
			return ret;
		}
		//如果未输入方向ID则调整为Null（未填写为“”，由于外键关联约束，改为null可添加成功）
		if(courseLeader.getCourseid().equals("")){
			courseLeader.setCourseid(null);
		}
		if(courseLeader.getTid().equals("")){
			courseLeader.setTid(null);
		}
		Teacher existTeacher = teacherService.findById(courseLeader.getTid());
		if (existTeacher == null && courseLeader.getTid() != null) {
			ret.put("type", "error");
			ret.put("msg", "授课老师不存在");
			return ret;
		}
		Course existCourse = courseService.findById(courseLeader.getCourseid());
		if (existCourse == null && courseLeader.getCourseid() != null) {
			ret.put("type", "error");
			ret.put("msg", "所授课程不存在");
			return ret;
		}

		if (courseLeaderService.editWithNull(courseLeader) <= 0) {
			ret.put("type", "error");
			ret.put("msg", "修改失败");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "修改成功");
		return ret;
	}

}