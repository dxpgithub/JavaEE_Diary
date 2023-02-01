/*
 *用户登录校验
 */
function CheckLogin() {
	var userName=$("#username").val();
	var userPassword=$("#userpassword").val();
	if (userName == null || userName.trim() == "") {
		$("#loginmsg").html("登录用户名不能为空！");
		$("#username").focus();
		return false;
	}
	if (userPassword == null || userPassword == "") {
		$("#loginmsg").html("密码不能为空！");
		$("#userpassword").focus();
		return false;
	}
	else {
		document.getElementById("#LoginForm").submit();
		return true;
	}
	
}
/*
*用户注册校验
*/
function CheckRegister(){
	var registname=$("#registname").val();
	var registpwd=$("#registpwd").val();
	var registphone=$("#registphone").val();
	var registsex=$('input:radio[name="registsex"]:checked').val();
	if (registname == null || registname.trim() == "") {
		$("#msg").html("用户名不能为空！");
		$("#registname").focus();
		return false;
	}
	if (registpwd == null || registpwd.trim() == "") {
		$("#msg").html("密码不能为空！");
		$("#registpwd").focus();
		return false;
	}
	if(registphone==null || registphone.trim()=="" ||registphone.trim().length!=11){
		$("#msg").html("请输入正确格式的手机号！");
		$("#registphone").focus();
		return false;
	}
	if (registsex == null || registsex == "") {
		$("#msg").html("请选择性别！");
		$("#registsex").focus();
		return false;
	}
	else{
		document.getElementById("#RegisterForm").submit();
		return true;
	}
	
}


