package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDao;

/**
 * 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	UserDao userdao= new UserDao();  
	ArrayList list = new ArrayList();
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");           //设置请求编码  
        response.setContentType("UTF-8");                //设置响应编码  
        
        HttpSession session=request.getSession();         // 先获得user对象，如果是第一次访问该Servlet，用户对象肯定为空，但如果是第  
        User user=(User) session.getAttribute("LoginUser");    // 二次甚至是第三次，就不应该再判断该用户的信息  
        if(user==null)
			try {
				user = userdao.getByUsernameAndPwd(request.getParameter("name"),request.getParameter("password"));
			} catch (Exception e) {
				e.printStackTrace();
			}  
        if(user!=null){                                      //如果登陆成功  
            session.setAttribute("LoginUser",user);              //将获取的对象保存在session中  
            //ArrayList al=loginDao.findMbInfo();           //获取留言板的内容，返回一个数组  
            //session.setAttribute("al", al);               //把数组保存起来  
            System.out.println("user"+user);
            response.sendRedirect("success.jsp");            //验证成功跳转到 main.jsp  
        }  
        else{                                             //验证失败跳转到 error.jsp  
            response.sendRedirect("error.jsp");  
        }  
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
