<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../include/head.jsp"></jsp:include>

<body>
  <section id="container">

	<jsp:include page="../include/header.jsp"></jsp:include>
	<jsp:include page="../include/left.jsp"></jsp:include>
    
  
    <section id="main-content">
      <section class="wrapper site-min-height">
        <h1>系统主页</h1>
        <div class="row mt">
          <div class="col-lg-12">
            <p>欢迎使用OA管理系统</p>
          </div>
        </div>
      </section>
     
    </section>
  
    <jsp:include page="../include/footer.jsp"></jsp:include>
  </section>
 	<jsp:include page="../include/script.jsp"></jsp:include>

</body>

</html>
    