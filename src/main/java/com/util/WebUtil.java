package com.util;

import com.common.Constant;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: 
 * @date: 2023-04-12
 */
public abstract class WebUtil {

    /**
     *  获取HttpServletRequest 对象
     * @return
     */
    public static HttpServletRequest getReuqest(){
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        return servletRequestAttributes.getRequest();
    }


    /**
     *  获取session
     * @return
     */
    public static HttpSession getSession(){
        return getReuqest().getSession();
    }

    /**
     *  获取ServletContext
     * @return
     */
    public static ServletContext getContext(){
        return ContextLoader.getCurrentWebApplicationContext().getServletContext();
    }

    /**
     * 将当前用户存到session 中
     * @param user
     * @param <T>
     */
    public static <T> void saveUser(T user){

        getSession().setAttribute(Constant.CURRENT_USER,user);
    }

    /**
     *  获取session中的用户
     * @param <T>
     * @return
     */
    public static <T> T  getUser(){
        Object o = getSession().getAttribute(Constant.CURRENT_USER);
        if (o == null){
            return null;
        }
        return (T) o;
    }


    /**
     * 将验证码存入session
     * @param code
     * @param <T>
     */
    public static <T> void saveCode(String code){
        getSession().setAttribute(Constant.CURRENT_CODE,code);
    }

    /**
     *  获取session中的验证码
     * @param
     * @return
     */
    public static String  getCode(){
        Object o = getSession().getAttribute(Constant.CURRENT_CODE);
        if (o == null){
            return "";
        }
        return o.toString();
    }



}
