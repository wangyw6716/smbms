package top.wobs.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        System.out.println("user_name:"+req.getSession().getAttribute("user_name"));
        if(req.getSession().getAttribute("user_name") == null){
            resp.sendRedirect("/login.jsp");
        }
        System.out.println("走了登陆过滤");
        filterChain.doFilter(servletRequest, servletResponse);//让请求继续走,如果不写,程序到这里就没拦截停止了!
    }

    @Override
    public void destroy() {

    }
}
