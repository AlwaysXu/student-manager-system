<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>科目管理页面 >> 科目添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="subject?method=subjectAdd&id=${user.id }" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
               
                <div>
                    <label for="subjectName">科目名称：</label>
                    <input type="text" name="subjectName" id="subjectName"/>
                    <span >*请输入科目名称</span>
                </div>
                <div>
                    <label >科目状态：</label>
					
                    <select name="status">
                        <c:forEach items="${statuss }" var="stas">
                        <option value="${stas.id }">${stas.name }</option>
                        </c:forEach>
                    </select>
                    
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