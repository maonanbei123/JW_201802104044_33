//201802104044杨轲
package filter;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "Filter10_Session",urlPatterns = {"/*"})
public class Filter10_Session implements Filter {
    public void init(FilterConfig config) throws ServletException {}
    public void destroy() {}
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter 10 - Session begins");
        HttpServletRequest request = (HttpServletRequest)req;
        String path= request.getRequestURI();
        if (path.contains("/login") || path.contains("/mySchool")){
            System.out.println("不对该页面进行验证");
        }else {
            //创建JSON对象message，以便往前端响应信息
            JSONObject message = new JSONObject();
            //访问权限验证
            HttpSession session = request.getSession(false);
            if (session==null || session.getAttribute("currentUser")==null){
                message.put("message", "请登录或重新登录");
                //响应message到前端
                resp.getWriter().println(message);
                return;
            }
        }
        chain.doFilter(req, resp);
        System.out.println("Filter 10 - Session ends");
    }
}
