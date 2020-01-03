package com.xiao.programmer.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xiao.programmer.entity.extend.Page;
import com.xiao.programmer.entity.origin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.util.StringUtil;
import com.xiao.programmer.service.UserService;

/**
 * 用户（管理员）控制器
 * @author Administrator
 *
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 用户管理列表页
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView model) {
		model.setViewName("admin/user_list");
		return model;
	}

	/**
	 * 用于获取列表
	 *
	 * @param uid
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/get_list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> get_list(
			@RequestParam(value = "uid", required = false, defaultValue = "") String uid,
			Page page,
			HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("uid", "%" + uid + "%");
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", userService.findList(queryMap));
//        ret.put("total", userService.getList());
		ret.put("total", userService.getTotal());
		return ret;
	}

	/**
	 * 添加用户操作
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	// @ResponseBody 把返回的数据转换成json对象再返回
	public Map<String, String> add(User user) {
		Map<String, String> ret = new HashMap<String, String>();
		if (user == null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系管理员");
			return ret;
		}
		if (StringUtil.isEmpty(user.getUid())) {
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(user.getPassword())) {
			ret.put("type", "error");
			ret.put("msg", "密码不能为空");
			return ret;
		}
		User existUser = userService.findById(user.getUid());
		if (existUser != null) {
			ret.put("type", "error");
			ret.put("msg", "用户名已经存在");
			return ret;
		}
		if (user.getType().equals(null)) {
			ret.put("type", "error");
			ret.put("msg", "类型不能为空");
			return ret;
		}
		if (!(user.getType() instanceof Integer)) {
			ret.put("type", "error");
			ret.put("msg", "类型不为数字!");
			return ret;
		}

//		if(!(user.getType()==2||user.getType()==3)){
//			ret.put("type", "error");
//			ret.put("msg", "类型只能填写2或3");
//			return ret;
//		}
		if (userService.add(user) <= 0) {
			ret.put("type", "error");
			ret.put("msg", "添加失败");
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
			if (userService.delete(id) <= 0) {
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
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	//@ResponseBody 把返回的数据转换成json对象再返回
	public Map<String, String> edit(User user) {
		Map<String, String> ret = new HashMap<String, String>();
		if (user == null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系管理员");
			return ret;
		}
		if (user.getUid() == null) {
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空");
			return ret;
		}
		if (user.getPassword() == null) {
			ret.put("type", "error");
			ret.put("msg", "密码不能为空");
			return ret;
		}
		if (user.getType() == null) {
			ret.put("type", "error");
			ret.put("msg", "类型不能为空");
			return ret;
		}
		System.out.println(user.toString());
		if (userService.edit(user) <= 0) {
			ret.put("type", "error");
			ret.put("msg", "修改失败");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "修改成功");
		return ret;
	}

}