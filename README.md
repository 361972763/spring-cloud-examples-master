原始
1.验证服务器   http://127.0.0.1:8088/oauth/authorize?response_type=code&client_id=lvhaibao&redirect_uri=http://baidu.com&state=test&scope=app
2.获取token    http://127.0.0.1:8088/oauth/token?grant_type=authorization_code&client_id=lvhaibao&client_secret=123456&redirect_uri=http://baidu.com&code=7v27VQ&scope=app



1.访问客户端   http://localhost:8080/personInfo ，定位到输入用户名密码界面



直接访问受保护的资源服务，显示未认证 http://localhost:9000/person
访问客户端 http://localhost:8080/personInfo，重定向到身份认证页面 
输入用户名、密码（user/user），显示资源服务数据 


2.验证服务器   http://127.0.0.1:7070/authserver/oauth/authorize?response_type=code&client_id=second&redirect_uri=http://localhost:8080/&state=test&scope=read
3.获取token    http://127.0.0.1:7070/authserver/oauth/token?grant_type=authorization_code&client_id=second&client_secret=passwordforauthserver&redirect_uri=http://localhost:8080/&code=ytODY4&scope=read
               http://localhost:9000/user?access_token=		
