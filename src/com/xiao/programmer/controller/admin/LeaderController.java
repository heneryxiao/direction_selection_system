package com.xiao.programmer.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.xiao.programmer.entity.extend.Page;
import com.xiao.programmer.entity.origin.Branch;
import com.xiao.programmer.entity.origin.Leader;
import com.xiao.programmer.entity.origin.User;
import com.xiao.programmer.service.BranchService;
import com.xiao.programmer.service.LeaderService;
import com.xiao.programmer.service.UserService;
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

@RequestMapping("/leader")
@Controller
public class LeaderController {

	@Autowired
	private LeaderService leaderService;

	@Autowired
	private UserService userService;

	@Autowired
	private BranchService branchService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView model) {
		model.setViewName("admin/leader_list");
		return model;
	}

	@RequestMapping(value = "/get_list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> get_list(
			@RequestParam(value = "lid", required = false, defaultValue = "") String lid,
			Page page,
			HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("lid", "%" + lid + "%");
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", leaderService.findList(queryMap));
		ret.put("total", leaderService.getTotal());
		return ret;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	// @ResponseBody 把返回的数据转换成json对象再返回
	public Map<String, String> add(Leader leader) {
		Map<String, String> ret = new HashMap<String, String>();
		if (leader == null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系管理员");
			return ret;
		}
		if (StringUtil.isEmpty(leader.getLid())) {
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(leader.getName())) {
			ret.put("type", "error");
			ret.put("msg", "姓名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(leader.getGender())) {
			ret.put("type", "error");
			ret.put("msg", "性别不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(leader.getProfession())) {
			ret.put("type", "error");
			ret.put("msg", "专业不能为空");
			return ret;
		}
		User existUser = userService.findById(leader.getLid());
		if (existUser == null) {
			ret.put("type", "error");
			ret.put("msg", "该未找到该用户，无法添加");
			return ret;
		}
		if (existUser.getType() != 2 && existUser.getType() != 3) {
			ret.put("type", "error");
			ret.put("msg", "该用户不是负责人，无法添加");
			return ret;
		}
		if (leader.getName().length() > 10) {
			ret.put("type", "error");
			ret.put("msg", "姓名超过允许的范围");
			return ret;
		}
		if (!leader.getGender().equals("男") && !leader.getGender().equals("女")) {
			ret.put("type", "error");
			ret.put("msg", "请输入正确的性别");
			return ret;
		}
		//如果未输入方向ID则调整为Null（未填写为“”，由于外键关联约束，改为null可添加成功）
		if(leader.getBranchid().equals("")){
			leader.setBranchid(null);
		}
		Branch existBranch = branchService.findById(leader.getBranchid());
		if (existBranch == null && leader.getBranchid() != null) {
			ret.put("type", "error");
			ret.put("msg", "所属方向不存在");
			return ret;
		}
		Leader existLeader = leaderService.findById(leader.getLid());
		if (existLeader != null) {
			ret.put("type", "error");
			ret.put("msg", "该用户名已存在");
			return ret;
		}
		//添加并判断
		if (leaderService.add(leader) <= 0) {
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
			System.out.println(id);
			if (leaderService.delete(id) <= 0) {
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
	public Map<String, String> edit(Leader leader) {
		Map<String, String> ret = new HashMap<String, String>();
		if (leader == null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系管理员");
			return ret;
		}
		if (StringUtil.isEmpty(leader.getName())) {
			ret.put("type", "error");
			ret.put("msg", "姓名不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(leader.getGender())) {
			ret.put("type", "error");
			ret.put("msg", "性别不能为空");
			return ret;
		}
		if (StringUtil.isEmpty(leader.getProfession())) {
			ret.put("type", "error");
			ret.put("msg", "专业不能为空");
			return ret;
		}
		if (leader.getName().length() > 10) {
			ret.put("type", "error");
			ret.put("msg", "姓名超过允许的范围");
			return ret;
		}
		if (!leader.getGender().equals("男") && !leader.getGender().equals("女")) {
			ret.put("type", "error");
			ret.put("msg", "请输入正确的性别");
			return ret;
		}
		//如果未输入方向ID则调整为Null（未填写为“”，由于外键关联约束，改为null可添加成功）
		if(leader.getBranchid().equals("")){
			leader.setBranchid(null);
			System.out.println(leader.toString());
		}
		Branch existBranch = branchService.findById(leader.getBranchid());
		if (existBranch == null && leader.getBranchid() != null) {
			ret.put("type", "error");
			ret.put("msg", "所属方向不存在");
			return ret;
		}
		if (leaderService.editWithNull(leader) <= 0) {
			ret.put("type", "error");
			ret.put("msg", "修改失败");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "修改成功");
		return ret;
	}

}