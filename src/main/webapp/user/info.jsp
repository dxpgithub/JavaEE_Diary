<%@ page language="java" contentType="text/html; charset=UTF-8"	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	<div class="col-md-9">
				<div class="data_list">
				<div class="container-fluid">
						<div class="row" style="padding-top: 20px;">
							<div class="col-md-8">
				<form class="form-horizontal" action="userinfomodify.do" method="post"
									enctype="multipart/form-data" onsubmit="return checkUser();">
					<div class="data_list_title">
						<span class="glyphicon glyphicon-edit">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
									class="bi bi-person-fill" viewBox="0 0 16 16">
									<path
										d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
								</svg>
							<b>个人中心</b>
						<input class="form-control" type="text" name="uid" id="uid" value="${userid.userid }"  readonly="readonly" />
						</span>
					</div>
					
								
									<div class="form-group">
									
									<br/>
										<label for="nick" class="col-sm-2 control-label">用户名:</label>
										<div class="col-sm-3">
											<input class="form-control" name="nick" id="nick" placeholder="用户名"
												value="${userid.username }" />
										</div>
										
										<label for="password" class="col-sm-2 control-label">密码:</label>
										<div class="col-sm-5">
											<input  class="form-control" type="password" id="password" name="password" placeholder="密码"  value="${userid.userpassword }"/>
										</div>
										<label for="phone" class="col-sm-2 control-label">电话:</label>
										<div class="col-sm-5">
											<input  class="form-control" type="text" id="phone" name="phone" placeholder="电话"  value="${userid.userphone }"/>
										</div>
										<label for="password" class="col-sm-2 control-label">性别:</label>
										<div class="col-sm-5">
											<input type="radio" name="sex"  value="男" <c:if test="${userid.usersex=='男'}">checked="checked"</c:if>/>男
											<input type="radio" name="sex"value="女" <c:if test="${userid.usersex=='女'}">checked="checked"</c:if>/>女
										</div>
										<label for="headimg" class="col-sm-2 control-label">头像:</label>
										<div class="col-sm-5">
											<input type="file" id="headimg" name="headimg" />
										</div>
									</div>
									<div class="form-group">
										<label for="mood" class="col-sm-2 control-label">留言:</label>
										<div class="col-sm-10">
											<textarea class="form-control" name="mood" id="mood"
												rows="3">${userid.usermood}</textarea>
										</div>
									</div>
									<br/>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" id="btn" class="btn btn-dark" onclick="UpdateUser()">确认修改</button>
											&nbsp;&nbsp;
											<span style="color: red;" id="msg"></span>
										</div>
									</div>
								</form>
							</div>
							<div class="col-md-4"><img style="wdith:500px;height: 400px;" name="img" src="photoshow.do?Name=${userid.userid}"/></div>
						</div>
					</div>
				</div>
			</div>
<script>
	function UpdateUser() {
	var nickName = document.getElementById("#nick");
	if (nickName.length == 0) {
	document.getElementById("#msg").innerHTML = "昵称不能为空";
			return false;
	}
	return true;
	}
</script>