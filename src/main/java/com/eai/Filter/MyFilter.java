package com.eai.Filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 
 * @author xudong.li
 *
 */
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest resquest = (HttpServletRequest) servletRequest;
        System.out.println("this is myfilter,url:" + resquest.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("this is myfilter end");
    }

    @Override
    public void destroy() {

    }
}
