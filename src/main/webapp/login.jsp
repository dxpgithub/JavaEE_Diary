<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    
    <link rel="shortcut icon" type="image/x-icon" href="./img/diary.ico"/>
	<title>个人日记</title>
    <link rel="stylesheet" href="./css/dmaku.css">
	<script src="js/jquery.min.js"></script>
	
	<style type="text/css">

body {
font-family: 'Montserrat', sans-serif;
    background-image:url("img/nameback.jpg");
	background-repeat: repeat-y;
	background-size:100%;
	height: auto;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
	margin: 0;

}

</style>
</head>

<body>
    <div class="dowebok" id="dowebok">
        <div class="form-container sign-up-container">
            <form id="RegisterForm" name="RegisterForm" method="post" action="register.do" >
                <h1>
					注册
				</h1>
				<!--  
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                -->
                <span>注册您的账号</span>
                <input type="text" placeholder="用户名称" id="registname" name="registname"/>
				<input type="text" placeholder="电话" id="registphone" name="registphone"/>
                <input type="password" placeholder="密码" id="registpwd" name="registpwd"/>
				<div id="CheckBox" >
					<div id="registsex">
						<input type="radio" name="registsex"  value="男"/>男
						<input type="radio" name="registsex"value="女"/>女
					</div>
					<span id="msg"></span><br />
				</div>
                <button  type="submit" class="signnew" onclick="return CheckRegister()">注册</button>
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form id="LoginForm" name="LoginForm" method="post" action="login.do">
                <h1>
					登录
				</h1>
				<!--  
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                -->
				<!--	useraction表示用户行为，在userServlet中判断用户操作-->
				<input type="hidden" name="useraction" value="login"/>
                <span>使用您的帐号</span>
        
                <input type="text" placeholder="用户名" id="username" name="username">
                <input type="password" placeholder="密码"id="userpassword" name="userpassword" >
				<div id="CheckBox">
				<input type="checkbox" value="1" name="remember"/><a href="#">记住我</a>
                <a href="tochangepwd.do" >忘记密码？</a>
				</div>
				<span id="loginmsg"></span>
                <button type="submit" onclick="return CheckLogin()">登录</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>已有帐号？</h1>
                    <p>请使用您的帐号进行登录</p>
                    <button class="ghost" id="signIn">立即登录</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>没有帐号？</h1>
                    <p>立即注册加入我们，拥有一个自己的空间吧</p>
                    <button class="ghost" id="signUp">现在注册</button>
                </div>
            </div>
        </div>
    </div>
	
	
	
	<script src="js/vue.js"></script>
    <script src="./js/dmaku.js"></script>
	<script src="./js/cs.js"></script>
</body>

</html>