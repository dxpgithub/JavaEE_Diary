<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<div class="col-md-9">
			
			<div class="data_list">
				<div class="data_list_title">
					<span class="glyphicon glyphicon-list"></span>
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
									class="bi bi-bookmark-star-fill" viewBox="0 0 16 16">
									<path fill-rule="evenodd"
										d="M2 15.5V2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.74.439L8 13.069l-5.26 2.87A.5.5 0 0 1 2 15.5zM8.16 4.1a.178.178 0 0 0-.32 0l-.634 1.285a.178.178 0 0 1-.134.098l-1.42.206a.178.178 0 0 0-.098.303L6.58 6.993c.042.041.061.1.051.158L6.39 8.565a.178.178 0 0 0 .258.187l1.27-.668a.178.178 0 0 1 .165 0l1.27.668a.178.178 0 0 0 .257-.187L9.368 7.15a.178.178 0 0 1 .05-.158l1.028-1.001a.178.178 0 0 0-.098-.303l-1.42-.206a.178.178 0 0 1-.134-.098L8.16 4.1z" />
					</svg>
					<b>日记类别</b>
					<span class="noteType_add">
						<button type="button" class="btn btn-dark" id="addBtn" style="float:right;">添加类别</button>
					</span>
				</div>
				
				<div id="tablediv">
				<c:if test="${empty typelist}">
					<h3>未查询到类别信息</h3>
				</c:if>
				
				<c:if test="${!empty typelist}">
					<table class="table table-hover table-striped" id="myTable">
						<tbody>
							<tr>
								<th>编号</th>
								<th>类型</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${typelist }" var="item" varStatus="st">
								<tr id="tr_${st.count }">
									<td>${st.count }</td>
									<td>${item.typename }</td>
									<td>
										<button class="btn btn-warning" type="button" onclick="openUpdateDialog(&quot ${item.typename }&quot,'${item.typeid }','${st.count }')">修改</button>
										<button class="btn btn-danger del" type="button" onclick="deleteType('${item.typename}','${st.count }')" >删除</button>
									</td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</c:if>
				</div>
			</div>
		</div>
		

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <!--  
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" >&times;</button>
             -->   
                <h4 class="modal-title" id="myModalLabel">新增</h4>
                <input type="hidden" name="modalId" id="modalId" />
                <input type="hidden" name="modalId" id="modalCount" />
            </div>
            <div class="modal-body">
				<div class="form-group">
				<label for="typename">类型名称</label>
				
				<input type="text" name="modalname" id="modalname" class="form-control"/>
				</div>
			</div>
           <div class="modal-footer">
           	<span id="msg" style="font-size:12px;color:red"></span>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<span class="glyphicon glyphicon-remove" data-dismiss="modal" id="close">关闭</span>
				</button>
				<button type="button" id="btn_submit" class="btn btn-primary" >
					<span class="glyphicon glyphicon-floppy-disk" id="btn_submit">保存</span>
				</button>
			</div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


