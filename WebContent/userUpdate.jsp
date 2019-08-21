<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="user?method=updateUser" method="post">
            <input type="hidden" name="id" value="${user.id }">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="realName">真实姓名：</label>
                    <input type="text" name="realName" id="realName" value="${user.realName }" />
                    <span >*</span>
                </div>

                <div>
                    <label >用户性别：</label>

                    <select name="sex">
                        <option value="1" 
                        <c:if test="${user.sex==1 }">selected="selected"</c:if>
                        >男</option>
                        <option value="2"
                        <c:if test="${user.sex==2 }">selected="selected"</c:if>
                        
                        >女</option>
                    </select>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" name="birthday" value="${user.birthday }" readonly="readonly" onClick="SelectDate(this,'yyyy年MM月dd日')"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="telephone">用户电话：</label>
                    <input type="text" name="telephone" id="telephone" value="${user.telephone }"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                    <input type="text" name="address" id="address" value="${user.address }"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="type" value="0"
                    <c:if test="${user.type==0 }">checked="checked"</c:if>/>管理员
                    <input type="radio" name="type" value="1"
                    <c:if test="${user.type==1 }">checked="checked"</c:if>/>老师
                    <input type="radio" name="type" value="2"
                    <c:if test="${user.type==2 }">checked="checked"</c:if>/>学生

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>