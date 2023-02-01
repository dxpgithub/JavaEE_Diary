<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-9">
				<div class="data_list">

					<div class="data_list_title" >
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list-stars" viewBox="0 0 16 16">
						  <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5z"/>
						  <path d="M2.242 2.194a.27.27 0 0 1 .516 0l.162.53c.035.115.14.194.258.194h.551c.259 0 .37.333.164.493l-.468.363a.277.277 0 0 0-.094.3l.173.569c.078.256-.213.462-.423.3l-.417-.324a.267.267 0 0 0-.328 0l-.417.323c-.21.163-.5-.043-.423-.299l.173-.57a.277.277 0 0 0-.094-.299l-.468-.363c-.206-.16-.095-.493.164-.493h.55a.271.271 0 0 0 .259-.194l.162-.53zm0 4a.27.27 0 0 1 .516 0l.162.53c.035.115.14.194.258.194h.551c.259 0 .37.333.164.493l-.468.363a.277.277 0 0 0-.094.3l.173.569c.078.255-.213.462-.423.3l-.417-.324a.267.267 0 0 0-.328 0l-.417.323c-.21.163-.5-.043-.423-.299l.173-.57a.277.277 0 0 0-.094-.299l-.468-.363c-.206-.16-.095-.493.164-.493h.55a.271.271 0 0 0 .259-.194l.162-.53zm0 4a.27.27 0 0 1 .516 0l.162.53c.035.115.14.194.258.194h.551c.259 0 .37.333.164.493l-.468.363a.277.277 0 0 0-.094.3l.173.569c.078.255-.213.462-.423.3l-.417-.324a.267.267 0 0 0-.328 0l-.417.323c-.21.163-.5-.043-.423-.299l.173-.57a.277.277 0 0 0-.094-.299l-.468-.363c-.206-.16-.095-.493.164-.493h.55a.271.271 0 0 0 .259-.194l.162-.53z"/>
						</svg>
						<span class="glyphicon glyphicon-edit" ></span>
							<b>日记列表</b>
							
					</div>
					<!-- 列表判空 -->
					<c:if test="${empty page }">
						<h3>暂未查询到日记记录</h3>
					</c:if>
					<c:if test="${!empty page }">
					<div class="note_datas">
						<ul class="list-unstyled" style="padding-left: 100px">
							<c:forEach items="${page.datalist }" var="item">
								<li >【${item.pubtime }】&nbsp; &nbsp;
									<a href="noteview.do?noteid=${item.noteid }">${item.title}</a>
								</li>
							</c:forEach>
							
							
						</ul>
					</div>

					<nav aria-label="Page navigation example" style="padding-left: 100px" >
					
					  <ul class="pagination">
					  <!-- 上一页标签 -->
					  <c:if test="${ page.pagenum>1}">
						    <li class="page-item">
						      <a class="page-link" href="notelist.do?pagenum=${page.prepage }" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
					    </c:if>
					    <c:forEach begin="${page.startnavpage }" end="${page.endnavpage }" var="p">
						    <li <c:if test="${page.pagenum==p}"> class="page-item active"</c:if>>
						    	<a class="page-link" href="notelist.do?pagenum=${p}">${p}</a>
						    </li>
					   </c:forEach>
					   <!-- 下一页标签 -->
					    <c:if test="${ page.pagenum<page.totalpage}">
					    <li class="page-item">
					      <a class="page-link" href="notelist.do?pagenum=${page.nextpage }" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					    </c:if>
					  </ul>
					</nav>
					</c:if>
				</div>
			</div>