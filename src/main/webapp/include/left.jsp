<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<aside>
			<div class="asidemain">
				<div class="asidemaintop">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
						class="bi bi-person-fill" viewBox="0 0 16 16">
						<path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
					</svg>
					<span><b>个人中心</b></span>
					<a href="logout.do" style="text-decoration:none; float:right" class="btn btn-dark  btn-sm">注销</a>
				</div>
				<img src="photoshow.do?Name=${userid.userid}" width="250px" height="250px" />
				<br/>
				<div id="UserMood">
					<span><b>${userid.usermood}</b></span>
				</div>


			</div>

			<div class="music">
				<h2 class="title">Music Name</h2>
				<div class="player">
					<audio src="" ></audio>
					<div class="btns">
						<div class="prev">
							<span class="material-icons">
								skip_previous
							</span>
						</div>
						<div class="playPause">
							<span class="material-icons">
								play_arrow
							</span>
						</div>
						<div class="next">
							<span class="material-icons">
								skip_next
							</span>

						</div>
					</div>
				</div>
			</div>
			
			
			<div class="asidebottom">
				<div class="bottom-left">
					<b>日期分类</b>
					<c:if test="${empty datelist}">
					<h6>未查询到类别信息</h6>
					</c:if>
					<c:if test="${!empty datelist}">
					
							<c:forEach items="${datelist }" var="item" varStatus="st">
									<ul class="nav nav-pills nav-stacked" >
									<li >
										<span id="sp_${st.count }">
										&nbsp;&nbsp;
										<a href="notebydate.do?pubtime=${item.pubtime}">
										<fmt:formatDate value="${item.pubtime }" pattern='yyyy-MM'/>
										
											&nbsp;&nbsp;&nbsp;&nbsp;
										</a>
										<span class="badge bg-secondary">${item.total }</span>
										
										</span>
									</li>
									</ul>
							</c:forEach>
							
					</c:if>	
				</div>
				<div class="bottom-right">
					<b>类别分类</b>
					<c:if test="${empty typelist}">
					<h6>未查询到类别信息</h6>
					</c:if>
					<c:if test="${!empty typelist}">
					
							<c:forEach items="${typelist }" var="item" varStatus="st">
									<ul class="nav nav-pills nav-stacked" style="padding-left: 25px;">
									<li >
										<span id="sp_${st.count }">
										${st.count }:&nbsp;&nbsp;
										<a href="notebytype.do?typename=${item.typeid }">
											${item.typename }
										</a>
										</span>
									</li>
									</ul>
							</c:forEach>
							
					</c:if>	
				</div>
			</div>
</aside>