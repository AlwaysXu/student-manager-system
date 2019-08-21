<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>科目管理页面</span>
            </div>
            <form action="subject?method=subjectList" id="myForm" method="post">
            <div class="search">
                <span>科目名：</span>
                <input type="text" placeholder="请输入用户名" name="subjectName"/>
                <input type="submit" value="查询" />
                <a href="subject?method=preSubjectAdd">添加科目</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">科目编码</th>
                    <th width="20%">科目名称</th>
                    <th width="20%">创建人</th>
					<th width="20%">状态</th>
                    <th width="30%">操作</th>
                </tr>
                <c:forEach items="${subjectVos }" var="svs">
                <tr>
                    <td>${svs.id }</td>
                    <td>${svs.subjectName }</td>
                    <td>${svs.createPerson }</td>
					 <td>
					 <c:if test="${svs.ifValid==1 }">正常</c:if>
					 <c:if test="${svs.ifValid==0 }">失效</c:if>
					 </td>
                    <td>
                        <c:if test="${svs.ifValid==1 }">
                        	<a href="subject?method=updateSubjectStatus&id=${svs.id }&status=0">
                        		<input type="button"  value="冻结" name="freeze"/>
                        		</a>
                        </c:if>
                        <c:if test="${svs.ifValid==0 }">
                        	<a href="subject?method=updateSubjectStatus&id=${svs.id }&status=1">
                        		<input type="button"  value="恢复" name="unfreeze"/>
                        	</a>
                        </c:if>              
                        <a href="subject?method=subjectDelete&id=${svs.id }">
                        	<input type="button"  value="删除" name="deleteSubject"/>
                        </a>
                        
                        
                        <!-- <a href="#" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a> -->
                    </td>
                </tr>
                </c:forEach>
            </table>
			<script type="text/javascript">
				function nextPage(){
					document.getElementById("pageNo").value = parseInt(document.getElementById("pageNo").value)+1;
					document.getElementById("myForm").submit();
				}
				function lastPage(){
					document.getElementById("pageNo").value=parseInt(document.getElementById("pageNo").value)-1;
					document.getElementById("myForm").submit();
				}
				function firstPage(){
					document.getElementById("pageNo").value=1;
					document.getElementById("myForm").submit();
				}
				function finalPage(){
					document.getElementById("pageNo").value=parseInt(document.getElementById("pageTotal").value);
					document.getElementById("myForm").submit();
				}
				function toSubjectPage()
				{
					//alert($$("toPage"));
						
						document.getElementById("pageNo").value=document.getElementById("toPage").value;
						document.getElementById("myForm").submit();
					
					
					
					
					
				}
			
			
			
			
			</script>
			
			
			<table width="75%">
				<tr>
					<input type="hidden" value="${pageUtil.currentPage }" name="pageNo" id="pageNo"/>
					<input type="hidden" value="${pageUtil.totalPage }" name="pageTotal" id="pageTotal"/>
					<td>
					<input type="button" value="首页" onclick="firstPage()"/>
					<c:if test="${pageUtil.currentPage>1 }">
					<input type="button" value="上一页" onclick="lastPage()"/>
					</c:if>
					<c:if test="${pageUtil.currentPage<pageUtil.totalPage }">
					<input type="button" value="下一页" onclick="nextPage()"/>
					</c:if>
					<input type="button" value="尾页" onclick="finalPage()"/>
					总记录数${pageUtil.totalSize }条
					每页显示${pageUtil.pageSize }条
					共${pageUtil.totalPage }页
					当前第${pageUtil.currentPage }页
					
					跳转到
					<input type="text" name="toPage" id="toPage"/>
					<input type="button" value="Go" onclick="toSubjectPage()"/>
					
					
					
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