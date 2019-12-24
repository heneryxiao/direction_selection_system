package com.xiao.programmer.interceptor;


import com.xiao.programmer.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录过滤拦截器
 * @author Henery
 * @date 2019/11/9 - 10:49
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        StringBuffer url = request.getRequestURL();
//        System.out.println("进入拦截器，url = " + url);
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
//            System.out.println("未登录或登录失效，url = " + url);
            response.sendRedirect(request.getContextPath() + "/system/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
