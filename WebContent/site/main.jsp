<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
    <title>留言板界面</title>  
  </head> 
<body bgcolor="#ddd" >  
  <div style="margin-left:35%;margin-top:100px;font-family:Microsoft YaHei">  
   <h1 style="margin-left:5%">这里是留言板主界面</h1>  
   <form  action="leavemessage.jsp" method="post">  
        <table border="1">  
            <caption>所有留言信息</caption>  
            <tr><th>留言人姓名</th><th>留言时间</th>  
                <th>留言标题</th><th>留言内容</th></tr>  
        <%-- <%  
            ArrayList<MessBoar> al=new ArrayList<MessBoar>();  
            al= (ArrayList)session.getAttribute("al");  
            if(al!=null){  
                Iterator iter=al.iterator();  
                while(iter.hasNext()){  
                MessBoar mb=(MessBoar)iter.next();  
        %>  
                <tr><td><%=new UserDao().getName(mb.getId())%></td>  
                    <td><%= mb.getTime().toString() %></td>  
                    <td><%= mb.getTitle() %></td>  
                    <td><%= mb.getMessage() %></td></tr>  
        <%   
            }  
            }  
         %>  --%>
        </table>  
    </form>  
   <a style="margin-left:22%" href="leavemessage.jsp">留言</a>  
    </div>  
  </body>  
</html>