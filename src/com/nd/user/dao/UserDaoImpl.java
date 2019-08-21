package com.nd.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nd.common.DbUtil;
import com.nd.user.po.User;

public class UserDaoImpl implements UserDao{
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		//三接口一类
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		
		sqlbuf.append("insert into t_user ");
		sqlbuf.append("(username,password,realname,sex,birthday,telephone,address,type,photo) ");
		sqlbuf.append("values(?,?,?,?,?,?,?,?,?)");
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			ps.setString(1,user.getUserName() );
			ps.setString(2,user.getPassWord() );
			ps.setString(3,user.getRealName() );
			ps.setString(4,user.getSex() );
			ps.setString(5,user.getBirthday());
			ps.setString(6,user.getTelephone() );
			ps.setString(7,user.getAddress() );
			ps.setString(8,user.getType() );
			ps.setString(9,user.getPhoto() );
			result=ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DbUtil.closeAll(conn, ps, rs);
		}
		return result;
	}
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		//三接口一类
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		//数据库语句不区分大小写
		sqlbuf.append("update t_user ");
		sqlbuf.append("set realname=?,sex=?,birthday=?,telephone=?,address=?,type=? ");
		sqlbuf.append("where id=? ");
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			ps.setString(1, user.getRealName());
			ps.setString(2,user.getSex());
			ps.setString(3,user.getBirthday());
			ps.setString(4,user.getTelephone());
			ps.setString(5,user.getAddress());
			ps.setString(6,user.getType());
			ps.setInt(7,user.getId());
		    
			int i=ps.executeUpdate();
		    if(i!=0)
		    	result=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DbUtil.closeAll(conn, ps, rs);
		}

		return result;
	}
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User u=null;
		//三接口一类
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		sqlbuf.append("select * from t_user ");
		sqlbuf.append("where id=?");//数据库语句不区分大小写
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassWord(rs.getString(3));
				u.setRealName(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setBirthday(rs.getString(6));
				u.setTelephone(rs.getString(7));
				u.setAddress(rs.getString(8));
				u.setType(rs.getString(9));
				u.setIfValid(rs.getString(10));
				u.setPhoto(rs.getString(11));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DbUtil.closeAll(conn, ps, rs);
		}
		
		return u;
	}
	
	
	
	@Override
	public boolean updateStatus(int id, String status) {
		boolean result=false;
		
		//三接口一类
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		//数据库语句不区分大小写
		sqlbuf.append("update t_user ");
		sqlbuf.append("set if_valid=? ");
		sqlbuf.append("where id=? ");
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			ps.setString(1, status);
			ps.setInt(2,id);
		    int i=ps.executeUpdate();
		    if(i!=0)
		    	result=true;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DbUtil.closeAll(conn, ps, rs);
		}

		return result;
	}
	
	@Override
	public List<User> getALL() {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<User>();
		User u=null;
		//三接口一类
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		sqlbuf.append("select * from t_user ");//数据库语句不区分大小写
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassWord(rs.getString(3));
				u.setRealName(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setBirthday(rs.getString(6));
				u.setTelephone(rs.getString(7));
				u.setAddress(rs.getString(8));
				u.setType(rs.getString(9));
				u.setIfValid(rs.getString(10));
				u.setPhoto(rs.getString(11));
				users.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.closeAll(conn, ps, rs);
		}
		
		return users;
		
	}
	
	
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User u=null;
		//三接口一类
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StringBuffer sqlbuf=new StringBuffer();
		
		conn=DbUtil.getConnection();
		sqlbuf.append("select * from t_user ");
		sqlbuf.append("where userName=? and passWord=? and if_valid=1");//数据库语句不区分大小写
		try {
			ps=conn.prepareStatement(sqlbuf.toString());
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassWord(rs.getString(3));
				u.setRealName(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setBirthday(rs.getString(6));
				u.setTelephone(rs.getString(7));
				u.setAddress(rs.getString(8));
				u.setType(rs.getString(9));
				u.setIfValid(rs.getString(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DbUtil.closeAll(conn, ps, rs);
		}
		
		return u;
	}

	

}
