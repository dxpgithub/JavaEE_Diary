<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<div class="col-md-9">
	<div class="data_list">
		<div class="data_list_title">
			<span class="glyphicon glyphicon-cloud-upload">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
									class="bi bi-journal-bookmark" viewBox="0 0 16 16">
									<path fill-rule="evenodd"
										d="M6 8V1h1v6.117L8.743 6.07a.5.5 0 0 1 .514 0L11 7.117V1h1v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8z" />
									<path
										d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z" />
									<path
										d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z" />
								</svg>
			<b>发布日记</b>
			</span>
		</div>
		
		<div class="container-fluid">
			<div class="container-fluid">
				<div class="row" style="padding-top:20px;">
					<div class="col-md-12">
						<!--判断类型列表是否为空  -->
						<c:if test="${empty GetType }">
							<h3>暂未有可用类别，请添加类别</h3>
							<h5><a href="notetypelist.do"><button class="btn btn-outline-dark">添加类别</button> </a></h5>
						</c:if>
						
						<c:if test="${!empty GetType }">
						<form action="noteadd.do" method="post" class="form-horizontal">
							<div class="form-group">
								
								<div class="col-md-6" >
									<label for="typeid" class="col-sm-2 control-label" >类别</label> 
									<select id="typeid" class="form-control" name="typeid" >
										<c:forEach var="item" items="${GetType}">
											<option value="${item.typeid}">${item.typename }</option>
										
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<input type="hidden" >
								
								<div class="col-md-6">
									<label for="title" class="col-sm-2 control-label">标题</label>
									<input class="form-control" name="title" id="title" placeholder="日记标题" required="required">
								</div>
								
							</div>
							<div class="form-group">
								<h3>日记正文</h3>
								 <!-- <div id="editor"></div>				     -->
								
							       <textarea name="content" id="editor">
							           
							        </textarea>
			
							</div>
							<div class="form-group">
							<br/>
								<div class="col-sm-offset-4 col-sm-4">
									<input type="submit" class=" btn btn-dark" onclick="return checkForm()" value="保存" id="submit"/>
									<span id="msg" style="font-size: 12px ;color: red"></span>
								</div>
							</div>
						</form>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="./cke5/ckeditor.js"></script>
<script>
ClassicEditor
.create( document.querySelector( '#editor' ) )
.catch( error => {
    console.error( error );
} ); 

function checkForm() {
	var typeid=$("#typeid").val();
	var title=$("#title").val();
	var editorData = editor.getData();
	location.reload();
	if(isEmpty(typeid)){
		$("#msg").html("请选择日记类别");
		return false;
	}
	if(isEmpty(title)){
		$("#msg").html("请输入日记标题");
		return false;
	}
	if(isEmpty(editorData)){
		$("#msg").html("请输入日记内容");
		return false;
	}
	return true;
}
</script>
