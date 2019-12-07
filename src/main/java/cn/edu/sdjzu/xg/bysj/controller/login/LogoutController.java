//201802104044杨轲
package cn.edu.sdjzu.xg.bysj.controller.login;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session  = request.getSession();
        //创建JSON对象message，以便往前端响应信息
        JSONObject message = new JSONObject();
        if(session != null) {
            //使会话失效
            session.invalidate();
            message.put("message","退出成功");
            response.getWriter().println(message);
        }
   }
}