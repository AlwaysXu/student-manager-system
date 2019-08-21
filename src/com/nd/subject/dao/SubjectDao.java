package com.nd.subject.dao;

import java.util.List;
import java.util.Map;

import com.nd.common.PageUtil;
import com.nd.common.Status;
import com.nd.subject.po.SubjectVo;

public interface SubjectDao {
	public List<SubjectVo> getAll(PageUtil page,Map map);
	
	public List<Status> getStatus();
	public boolean subjectAdd(String subjectName, int createPersonId, String ifValid);
	public int  getAllCount(Map map);
	public int updateSubjectStatus(int id,String status);
	public boolean subjectDelete(int id);
	

}
