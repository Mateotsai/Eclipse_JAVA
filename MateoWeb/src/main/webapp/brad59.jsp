<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			window.onload = function(){
				console.log("start: " + document.cookie);
				//解析 cookie
				
				let aryCookies = {};  //{account:brad, passwd:123, re:true}
				parseCookie();
				function parseCookie(){
					let cookie = document.cookie;
					let cookies = cookie.split(";");  //切割出cookies的陣列
					cookies.forEach(function(item,i){
						let data = item.split("=");
					if(data[0]){
						aryCookies[data[0].trim()] = data[1].trim();
					}
					});
				};
				
				if(aryCookies['account']){
					document.getElementById('account').value = aryCookies['account'];
				}
				if(aryCookies['passwd']){
					document.getElementById('passwd').value = aryCookies['passwd'];
				}
				if(aryCookies['remember']){
					document.getElementById('remember').checked = aryCookies['remember'];
				}		
				
			};	
		
			function beforeSubmit(){
				let account = document.getElementById('account').value;
				let passwd = document.getElementById('passwd').value;
				let isRemember = document.getElementById('remember').checked;
				
				if(isRemember){
					document.cookie = 'account = ' + account;
					document.cookie = 'passwd = ' + passwd;
					document.cookie = 'remember = ' + isRemember;
					
				}else{
					let cookies = document.cookie.split(";");
					for(let i = 0; i<cookies.length; i++){
						let key = cookies[i].split("=")[0];
						document.cookie = key + "= ; expires = Thu,01 Jan 1970 00:00:00 UTC";
					}
				}
				return false;
			};	
			
		</script>
		
		
	</head>
	<body>
	<form action="brad60.jsp" onsubmit="return beforeSubmit()">
	Account: <input name="account" id="account" /> <br>
	Password: <input name="passwd" id="passwd" /> <br>
	<input type="checkbox" id="remember" />Remember me <br />
	<input type="submit" value="Login" />
	
	</form>
	</body>
</html>