<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp"></jsp:include>

<body <c:if test="${userid.usersex=='男'}">style="background-color: #0088CC; background-image: url(/diary/img/Y0.png);"</c:if>
 <c:if test="${userid.usersex=='女'}">style="background-color:#FB7B7A; background-image: url(/diary/img/Y0.png);"</c:if>>


	<jsp:include page="../include/header.jsp"></jsp:include>
	<jsp:include page="../include/left.jsp"></jsp:include>
    
  
    <section id="main-content">
      	
	     	<c:if test="${empty changePage }">
	     		<jsp:include page="../note/notelist.jsp"></jsp:include>
	     	</c:if>
	     	
	     	<c:if test="${!empty changePage }">
	     		<jsp:include page="${changePage}"></jsp:include>
	     	</c:if>
     	
    </section>
  
    <jsp:include page="../include/footer.jsp"></jsp:include>
 	<jsp:include page="../include/script.jsp"></jsp:include>

</body>
</html>