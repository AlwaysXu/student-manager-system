package com.nd.subject.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nd.common.PageUtil;
import com.nd.common.Status;
import com.nd.common.StringUtil;
import com.nd.subject.dao.SubjectDao;
import com.nd.subject.dao.SubjectDaoImpl;
import com.nd.subject.po.SubjectVo;

/**
 * Servlet implementation class SubjectServlet
 */
public class SubjectServlet extends HttpServlet {
	//m默认当前页数为第一页
	int currentPage=1;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if("subjectList".equals(method)) {
			subjectList(request,response);
		}
		else if("subjectAdd".equals(method)) {
			subjectAdd(request,response);
		}
		else if("preSubjectAdd".equals(method)) {
			preSubjectAdd(request,response);
		}
		else if("updateSubjectStatus".equals(method))
		{
			updateSubjectStatus(request,response);
		}
		else if("subjectDelete".equals(method))
		{
			subjectDelete(request,response);
		}
	}
	
	public void subjectDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		int newId=Integer.parseInt(id);
		String pageNo=request.getParameter("pageNo");
		SubjectDao dao=new SubjectDaoImpl();
		
		boolean reusult=dao.subjectDelete(newId);
		request.getRequestDispatcher("subject?method=subjectList").forward(request, response);
	}
	public void updateSubjectStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		int newId=Integer.parseInt(id);
		String status=request.getParameter("status");
		String pageNo=request.getParameter("pageNo");
		/*
		 * if(!StringUtil.empty(pageNo)) { currentPage=Integer.parseInt(pageNo); }
		 */
		SubjectDao dao=new SubjectDaoImpl();
		int i=dao.updateSubjectStatus(newId,status);
		request.setAttribute("pageNo", pageNo);
		request.getRequestDispatcher("subject?method=subjectList").forward(request, response);
		
	
	}
	public void preSubjectAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SubjectDao dao=new SubjectDaoImpl();
		List<Status> statuss=dao.getStatus();
		request.setAttribute("statuss", statuss);
		request.getRequestDispatcher("subjectAdd.jsp").forward(request, response);
		
	
	}
	
	public void subjectAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectName=request.getParameter("subjectName");
		String id=request.getParameter("id");
		int newId=Integer.parseInt(id);
		String ifValid=request.getParameter("status");
		
		SubjectDao dao=new SubjectDaoImpl();
		boolean res=dao.subjectAdd(subjectName, newId,ifValid);
		if(res) {
			request.getRequestDispatcher("subject?method=subjectList").forward(request, response);
		}
		
		
	
	}
	public void subjectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//支持模糊查询
		String subjectName=request.getParameter("subjectName");
		Map filter=new HashMap();
		filter.put("subjectName",subjectName);
		
		
		
		
		PageUtil page=new PageUtil();
		//默认展现第一页
		
		//获取当前页号
		String pageNo=request.getParameter("pageNo");
		
		if(!StringUtil.empty(pageNo)) {
			currentPage=Integer.parseInt(pageNo);
		}
		
		SubjectDao dao=new SubjectDaoImpl();
		
		//设置分页参数
		page.setTotalSize(dao.getAllCount(filter));
		page.setCurrentPage(currentPage);
		page.setPageSize(4);//设置每页显示4行
		page.setTotalPage(dao.getAllCount(filter));
		
		
		//从数据库中获取课程
		List<SubjectVo> svs=dao.getAll(page,filter);
		
		
		
		request.setAttribute("pageUtil", page);
		request.setAttribute("subjectVos", svs);
		request.getRequestDispatcher("subjectList.jsp").forward(request, response);
	
	}

	
}
