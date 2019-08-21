package com.nd.subject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nd.common.DbUtil;
import com.nd.common.PageUtil;
import com.nd.common.Status;
import com.nd.subject.po.SubjectVo;

public class SubjectDaoImpl implements SubjectDao{
	@Override
	public boolean subjectDelete(int id) {
		// TODO Auto-generated method stub
		boolean result=false;

		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		//ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		
		sqlbuf.append("delete from t_subject ");
		sqlbuf.append("where id=? ");
		try {
			
			ps=conn.prepareStatement(sqlbuf.toString());

			ps.setInt(1, id);
			result=ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	
	}
	@Override
	public int updateSubjectStatus(int id, String status) {
		// TODO Auto-generated method stub
		int result=0;
		
		Connection conn=null;
		PreparedStatement ps=null;
		//ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		
		sqlbuf.append("update t_subject ");
		sqlbuf.append("set if_valid=? ");
		sqlbuf.append("where id=? ");
		try {
			
			ps=conn.prepareStatement(sqlbuf.toString());
			ps.setString(1, status);
			ps.setInt(2, id);
			result=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int getAllCount(Map map) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int count=0;
		//三接口一类
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		sqlbuf.append("select * ");//数据库语句不区分大小写
		sqlbuf.append("from t_subject t1,t_user t2 ");
		sqlbuf.append("where t1.createpersonid=t2.id ");
		//sqlbuf.append("where 1=1 ");
		
		if(map.get("subjectName")!=null&&!"".equals(map.get("subjectName"))) {
			sqlbuf.append(" and subjectName like ? ");
		}
		
		sqlbuf.append(" ");
		
		
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			int i=1;
			if(map.get("subjectName")!=null&&!"".equals(map.get("subjectName"))) {
				ps.setString(i++,"%"+map.get("subjectName").toString()+"%");
			}
			
			
			rs=ps.executeQuery();
			
			
			
			while(rs.next()) {
				count++;
			}
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.closeAll(conn, ps, rs);
		}
		
		return count;
	}
	
	@Override
	public List<Status> getStatus() {
		
		List<Status> statuss=new ArrayList<Status>();
		Status status=null;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		sqlbuf.append("select * from t_status");
		
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			rs=ps.executeQuery();
			while(rs.next()) {
				status=new Status();
				status.setId(rs.getInt(1));
				status.setName(rs.getString(2));
				statuss.add(status);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return statuss;
	
	}
	
	
	@Override
	public boolean subjectAdd(String subjectName,int createPersonId,String ifValid) {
		boolean result=false;
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		//ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		sqlbuf.append("insert t_subject ");
		sqlbuf.append("set subjectname=?,createpersonid=?,if_valid=?");
		
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			ps.setString(1, subjectName);
			ps.setInt(2, createPersonId);
			ps.setString(3, ifValid);
			int i=ps.executeUpdate();
			if(i!=0) {
				result=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public List<SubjectVo> getAll(PageUtil page,Map map) {
		

		// TODO Auto-generated method stub
		List<SubjectVo> subjectVos=new ArrayList<SubjectVo>();
		SubjectVo sv=null;
		//三接口一类
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		sqlbuf.append("select t1.*,t2.username ");//数据库语句不区分大小写
		sqlbuf.append("from t_subject t1,t_user t2 ");//数据库语句不区分大小写
		sqlbuf.append("where t1.createpersonid=t2.id ");
		if(map.get("subjectName")!=null&&!"".equals(map.get("subjectName"))) {
			sqlbuf.append("and subjectName like ? ");
		}
		sqlbuf.append("limit "); 
		sqlbuf.append(
		 (page.getCurrentPage()-1)*page.getPageSize() 
		 ); 
		sqlbuf.append(",");
		sqlbuf.append(page.getPageSize());
		
		 
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			
			int i=1; if(map.get("subjectName")!=null&&!"".equals(map.get("subjectName")))
			{ 
				ps.setString(i++,"%"+map.get("subjectName").toString()+"%"); 
			}
		
			
			
			rs=ps.executeQuery();
			while(rs.next()) {
				sv=new SubjectVo();
				sv.setId(rs.getInt(1));
				sv.setSubjectName(rs.getString(2));
				sv.setCreatePersonId(rs.getInt(3));
				sv.setIfValid(rs.getString(4));
				sv.setCreatePerson(rs.getString(5));
				subjectVos.add(sv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.closeAll(conn, ps, rs);
		}
		
		return subjectVos;
	}
}
