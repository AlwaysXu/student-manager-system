<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="user?method=addUser" method="post" enctype="multipart/form-data">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="userName">用户账号：</label>
                    <input type="text" name="userName" id="userName"/>
                    <span>*请输入用户账号，且不能重复</span>
                </div>
                <div>
                    <label for="realName">真实姓名：</label>
                    <input type="text" name="realName" id="realName"/>
                    <span >*请输入用真实姓名</span>
                </div>
                <div>
                    <label for="password">用户密码：</label>
                    <input type="text" name="password" id="password"/>
                    <span>*密码长度必须大于6位小于20位</span>

                </div>
                <div>
                    <label for="userRemi">确认密码：</label>
                    <input type="text" name="userRemi" id="userRemi"/>
                    <span>*请输入确认密码</span>
                </div>
                <div>
                    <label >用户性别：</label>

                    <select name="sex">
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                    <span></span>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" name="birthday" value="${user.birthday }" readonly="readonly" onClick="SelectDate(this,'yyyy年MM月dd日')"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="telephone">用户电话：</label>
                    <input type="text" name="telephone" id="telephone"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                    <input type="text" name="address" id="address"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="type" value="0"/>管理员
                    <input type="radio" name="type" value="1"/>教师
                    <input type="radio" name="type" value="2"/>学生

                </div>
                <div>
                    <label >上传头像：</label>
                    <input type="file" name="photo" />

                </div>
                
                
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存" />
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