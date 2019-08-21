<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="common/common.jsp" %>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <span>用户名：</span>
                <input type="text" placeholder="请输入用户名"/>
                <input type="button" value="查询"/>
                <a href="userAdd.jsp">添加用户</a>
            </div>
            <!--用户-->
            <form action="">
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户账号</th>
                    <th width="10%">真实姓名</th>
                    <th width="5%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="10%">状态</th>
                    <th width="15%">头像</th>>
                    <th width="30%">操作</th>
                </tr>
           		<c:forEach items="${users }" var="us">
                <tr>
					<td>${us.userName }</td>
                    <td>${us.realName }</td>
                    <td>
                    	<c:if test="${us.sex=='1' }">男</c:if>
	                    <c:if test="${us.sex=='2' }">女</c:if>
               		</td>
                    <td>${us.birthday }</td>
                    <td>${us.telephone }</td>
                    <td>
                    	<c:if test="${us.type=='0' }">管理员</c:if>
                    	<c:if test="${us.type=='1' }">教师</c:if>
                    	<c:if test="${us.type=='2' }">学生</c:if>
                    </td>
                   <td>
						<c:if test="${us.ifValid=='1' }">可用</c:if>
                    	<c:if test="${us.ifValid=='0' }">不可用</c:if>                   
                   </td>
                   <td>
						<img alt="" src="${us.photo }" width="80%">                   
                   </td>
                    <td>
                    	<c:if test="${us.ifValid=='1' }"><a onclick="return confirm('确定要操作吗？')" href="user?method=updateStatus&id=${us.id }&status=0">冻结</a></c:if>
                    	<c:if test="${us.ifValid=='0' }"><a onclick="return confirm('确定要操作吗？')" href="user?method=updateStatus&id=${us.id }&status=1">解冻</a></c:if>
                        <a href="user?method=getUser&id=${us.id }"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="user?method=preupdateUser&id=${us.id }"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="#" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
               </c:forEach>
                
				 
				<tr>
				<td colspan="7">
				  当前第1页，1条数据&nbsp;&nbsp;&nbsp;&nbsp;共2页
			         首页
			         尾页
			        上一页
			        下一页
				</td>
				</tr>
            </table>
            </form>

        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>