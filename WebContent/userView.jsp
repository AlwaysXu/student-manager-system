<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户账号：</strong><span>${user.userName }</span></p>
            <p><strong>真实姓名：</strong><span>${user.realName }</span></p>
            <p><strong>用户性别：</strong><span><c:if test="${user.sex=='1' }">男</c:if><c:if test="${user.sex=='2' }">女</c:if></span></p>
            <p><strong>出生日期：</strong><span>${user.birthday }</span></p>
            <p><strong>用户电话：</strong><span>${user.telephone }</span></p>
            <p><strong>用户地址：</strong><span>${user.address }</span></p>
            <p><strong>用户类别：</strong><span><c:if test="${user.type=='0' }">管理员</c:if><c:if test="${user.type=='1' }">老师</c:if><c:if test="${user.type=='2' }">学生</c:if></span></p>
			<p><strong>用户头像：</strong><img alt="" src="${user.photo }" width="150" height="150" ></p>
            <a href="user?method=userList">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>