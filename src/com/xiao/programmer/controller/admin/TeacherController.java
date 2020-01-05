package com.xiao.programmer.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.xiao.programmer.entity.extend.Page;
import com.xiao.programmer.entity.origin.Course;
import com.xiao.programmer.entity.origin.CourseLeader;
import com.xiao.programmer.entity.origin.Teacher;
import com.xiao.programmer.entity.origin.User;
import com.xiao.programmer.service.CourseLeaderService;
import com.xiao.programmer.service.CourseService;
import com.xiao.programmer.service.TeacherService;
import com.xiao.programmer.service.UserService;
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

@RequestMapping("/teacher")
@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView model) {
		model.setViewName("admin/teacher_list");
		return model;
	}

	@RequestMapping(value = "/get_list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> get_list(
			@RequestParam(value = "tid", required = false, defaultValue = "") String tid,
			Page page,
			HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("tid", "%" + tid + "%");
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", teacherService.findList(queryMap));
		ret.put("total", teacherService.getTotal());
		return ret;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	// @ResponseBody 把返回的数据转换成json对象再返回
	public Map<String, String> add(Teacher teacher) {
		Map<String, String> ret = new HashMap<String, String>();
		if (teacher == null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系管理员");
			return ret;
		}
		if (StringUtil.isEmpty(teacher.getTid())) {
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(teacher.getName())) {
			ret.put("type", "error");
			ret.put("msg", "姓名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(teacher.getGender())) {
			ret.put("type", "error");
			ret.put("msg", "性别不能为空");
			return ret;
		}
		User existUser = userService.findById(teacher.getTid());
		if (existUser == null) {
			ret.put("type", "error");
			ret.put("msg", "该未找到该用户，无法添加");
			return ret;
		}
		if (existUser.getType() != 5) {
			ret.put("type", "error");
			ret.put("msg", "该用户不是老师，无法添加");
			return ret;
		}
		if (teacher.getName().length() > 10) {
			ret.put("type", "error");
			ret.put("msg", "姓名超过允许的范围");
			return ret;
		}
		if (!teacher.getGender().equals("男") && !teacher.getGender().equals("女")) {
			ret.put("type", "error");
			ret.put("msg", "请输入正确的性别");
			return ret;
		}
		//添加并判断
		if (teacherService.add(teacher) <= 0) {
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
			if (teacherService.delete(id) <= 0) {
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
	public Map<String, String> edit(Teacher teacher) {
		Map<String, String> ret = new HashMap<String, String>();
		if (teacher == null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系管理员");
			return ret;
		}
		if (StringUtil.isEmpty(teacher.getName())) {
			ret.put("type", "error");
			ret.put("msg", "姓名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(teacher.getGender())) {
			ret.put("type", "error");
			ret.put("msg", "性别不能为空");
			return ret;
		}
		if (teacher.getName().length() > 10) {
			ret.put("type", "error");
			ret.put("msg", "姓名超过允许的范围");
			return ret;
		}
		if (!teacher.getGender().equals("男") && !teacher.getGender().equals("女")) {
			ret.put("type", "error");
			ret.put("msg", "请输入正确的性别");
			return ret;
		}
		if (teacherService.editWithNull(teacher) <= 0) {
			ret.put("type", "error");
			ret.put("msg", "修改失败");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "修改成功");
		return ret;
	}

}