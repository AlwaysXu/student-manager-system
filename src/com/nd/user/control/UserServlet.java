package com.nd.user.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nd.user.dao.UserDao;
import com.nd.user.dao.UserDaoImpl;
import com.nd.user.po.User;


/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if("login".equals(method)) {
			login(request,response);
		}
		else if("userList".equals(method)) {
			userList(request,response);
		}
		else if("updateStatus".equals(method)) {
			updateStatus(request,response);
		}
		else if("getUser".equals(method)) {
			getUser(request,response);
		}
		else if("preupdateUser".equals(method)) {
			preupdateUser(request,response);
		}
		else if("updateUser".equals(method)) {
				updateUser(request,response);
			}
		else if("addUser".equals(method)) {
			addUser(request,response);
		}
	}
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		User user=new User();
		
		//创建磁盘工厂
		DiskFileItemFactory df=new DiskFileItemFactory();
		//创建上传对象
		ServletFileUpload upload=new ServletFileUpload(df);
		
		try {
			List<FileItem> items=upload.parseRequest(request);
			for(FileItem its:items) {
				if(its.isFormField()) {
					//文本域
					String name=its.getFieldName();
					if("userName".equals(name)) {
						user.setUserName(its.getString("utf-8"));
					}
					
					if("password".equals(name)) {
						user.setPassWord(its.getString("utf-8"));
					}
					if("realName".equals(name)) {
						user.setRealName(its.getString("utf-8"));
					}
					if("sex".equals(name)) {
						user.setSex(its.getString("utf-8"));
					}
					if("telephone".equals(name)) {
						user.setTelephone(its.getString("utf-8"));
					}
					if("birthday".equals(name)) {
						user.setBirthday(its.getString("utf-8"));
					}
					if("address".equals(name)) {
						user.setAddress(its.getString("utf-8"));
					}
					if("type".equals(name)) {
						user.setType(its.getString("utf-8"));
					}
					
				}
				else {
					
					//文件域 
					String fileName=its.getName();
					//liu.jpg 
					String path=request.getRealPath("/fileupdload");
					File f=new File(path);
					if(!f.exists()) { 
						f.mkdir();
					//如果没有目录 就创建目录
					}
					//当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数 
					//保证文件名的唯一性 
					Long fileHead=System.currentTimeMillis(); 
					String fileTail=fileName.substring(fileName.indexOf(".")); 
					File file=new File(f,fileHead+fileTail);
					its.write(file);
					//String fileAddress=new String("D:\\javahome\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CourseforWEB\\fileupdload\\");
					user.setPhoto("fileupdload\\"+fileHead+fileTail);
					 
				}	
			}
			UserDao dao=new UserDaoImpl();
			boolean result=dao.addUser(user);
			if(result) {
				request.getRequestDispatcher("user?method=userList").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao dao=new UserDaoImpl();
		String id=request.getParameter("id");
		String realName=request.getParameter("realName");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String telephone=request.getParameter("telephone");
		String address=request.getParameter("address");
		String type=request.getParameter("type");
		
		int newId=Integer.parseInt(id);
		
		User user=new User();
		user.setId(newId);
		user.setRealName(realName);
		user.setSex(sex);
		user.setBirthday(birthday);
		user.setTelephone(telephone);
		user.setAddress(address);
		user.setTelephone(telephone);
		user.setType(type);

		boolean result=dao.updateUser(user);
		if(result) {
			request.getRequestDispatcher("user?method=userList").forward(request, response);
		}
			

	}
	public void preupdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao dao=new UserDaoImpl();
		String id=request.getParameter("id");
		int newId=Integer.parseInt(id);
		User user=dao.getUserById(newId);
		if(user!=null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
		}
	}
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao dao=new UserDaoImpl();
		String id=request.getParameter("id");
		int newId=Integer.parseInt(id);
		System.out.println(id);
		User user=dao.getUserById(newId);
		System.out.println(user.getUserName());
		if(user!=null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("userView.jsp").forward(request, response);
		}
		
	}
	
	
	
	public void updateStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao dao=new UserDaoImpl();
		String id=request.getParameter("id");
		int newId=Integer.parseInt(id);
		String status=request.getParameter("status");
		boolean result=dao.updateStatus(newId, status);
		if(result) {
			request.getRequestDispatcher("user?method=userList").forward(request, response);
		}
		
	}
	public void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao dao=new UserDaoImpl();
		List<User> users=dao.getALL();
		request.setAttribute("users", users);
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	
	}
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User();
		user.setUserName(name);
		user.setPassWord(password);
		UserDao dao=new UserDaoImpl();
		User u=dao.login(user);
		if(u!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			System.out.println("error!");
		}
	}
	
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
