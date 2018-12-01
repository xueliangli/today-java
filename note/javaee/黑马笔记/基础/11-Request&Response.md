##HttpServletRequest  和 HttpServletResponse


###Servlet配置方式

* 1. 全路径匹配

> 以 / 开始   /a /aa/bb

> localhost:8080/项目名称/aa/bb 

* 2. 路径匹配 , 前半段匹配

> 以  / 开始 ， 但是以 * 结束  /a/* /*  

> * 其实是一个通配符，匹配任意文字

> localhost:8080/项目名称/aa/bb 

* 3. 以扩展名匹配

> 写法： 没有/  以 * 开始   *.扩展名    *.aa *.bb 


###ServletContext

> Servlet 上下文

> 每个web工程都只有一个ServletContext对象。 说白了也就是不管在哪个servlet里面，获取到的这个类的对象都是同一个。

###如何得到对象

	//1. 获取对象
		ServletContext context = getServletContext();

### 有什么作用

1. 获取全局配置参数
2. 获取web工程中的资源
3. 存取数据，servlet间共享数据  域对象

####.可以获取全局配置参数

![icon](img/request_01.png)


获取全局参数


![icon](img/request_02.png)


####. 可以获取Web应用中的资源

	1. 获取资源在tomcat里面的绝对路径

		先得到路径，然后自己new InpuStream
	
			context.getRealPath("") //这里得到的是项目在tomcat里面的根目录。
	
			D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\
		
		 	String path = context.getRealPath("file/config.properties");
	
			D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\file\config.properties


	2. getResourceAsStream 获取资源 流对象

		直接给相对的路径，然后获取流对象。

![icon](img/request_03.png)


### 通过classloader去获取web工程下的资源

![icon](img/request_04.png)


### 使用ServletContext存取数据。



1. 定义一个登陆的html页面， 定义一个form表单

![icon](img/request_06.png)

2. 定义一个Servlet，名为LoginServlet


![icon](img/request_07.png)

3. 针对成功或者失败，进行判断，然后跳转到不一样的网页

![icon](img/request_08.png)

###ServletContext存取值分析

![icon](img/request_09.png)


##细节：

		<!-- 	
		A路径： Servlet的路径
			http://localhost:8080/Demo4/login
		
		B路径： 当前这个html的路径：
			http://localhost:8080/Demo4/login.html -->
		
		
		<form action="login" method="get">
			账号:<input type="text" name="username"/><br>
			密码:<input type="text" name="password"/><br>
			<input type="submit" value="登录"/>
		</form>


###ServletContext 何时创建， 何时销毁?

服务器启动的时候，会为托管的每一个web应用程序，创建一个ServletContext对象

从服务器移除托管，或者是关闭服务器。 

* ServletContext 的作用范围

> 只要在这个项目里面，都可以取。 只要同一个项目。 A项目 存， 在B项目取，是取不到的？ ServletContext对象不同。


##HttpServletRequest

> 这个对象封装了客户端提交过来的一切数据。 

1. 可以获取客户端请求头信息

		//得到一个枚举集合  
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = (String) headerNames.nextElement();
			String value = request.getHeader(name);
			System.out.println(name+"="+value);
			
		}

2. 获取客户端提交过来的数据


		String name = request.getParameter("name");
		String address = request.getParameter("address");
		System.out.println("name="+name);
		System.out.println("address="+address);

		-------------------------------------------------

		//name=zhangsan&name=lisi&name=wangwu 一个key可以对应多个值。

		Map<String, String[]> map = request.getParameterMap();
		
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println("key="+key + "--的值总数有："+map.get(key).length);
			String value = map.get(key)[0];
			String value1 = map.get(key)[1];
			String value2 = map.get(key)[2];
			
			System.out.println(key+" ======= "+ value + "=" + value1 + "="+ value2);
		}

3. 获取中文数据

> 客户端提交数据给服务器端，如果数据中带有中文的话，有可能会出现乱码情况，那么可以参照以下方法解决。

* 如果是GET方式
	
	1. 代码转码
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			System.out.println("userName="+username+"==password="+password);
			
			//get请求过来的数据，在url地址栏上就已经经过编码了，所以我们取到的就是乱码，
			//tomcat收到了这批数据，getParameter 默认使用ISO-8859-1去解码
			
			//先让文字回到ISO-8859-1对应的字节数组 ， 然后再按utf-8组拼字符串
			username = new String(username.getBytes("ISO-8859-1") , "UTF-8");
			System.out.println("userName="+username+"==password="+password);
		
			直接在tomcat里面做配置，以后get请求过来的数据永远都是用UTF-8编码。 
	

	2. 可以在tomcat里面做设置处理 conf/server.xml 加上URIEncoding="utf-8"
 
		  <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>


* 如果是POST方式

		这个说的是设置请求体里面的文字编码。  get方式，用这行，有用吗？ ---> 没用
		request.setCharacterEncoding("UTF-8");
	
		这行设置一定要写在getParameter之前。


##HttpServletResponse

> 负责返回数据给客户端。 

* 输出数据到页面上


		//以字符流的方式写数据	
		//response.getWriter().write("<h1>hello response...</h1>");
		
		//以字节流的方式写数据 
		response.getOutputStream().write("hello response2222...".getBytes());


### 响应的数据中有中文，那么有可能出现中文乱码

* 以字符流输出

> response.getWriter()


		//1. 指定输出到客户端的时候，这些文字使用UTF-8编码
		response.setCharacterEncoding("UTF-8");
		
		//2. 直接规定浏览器看这份数据的时候，使用什么编码来看。
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		
		response.getWriter().write("我爱黑马训练营...");



* 以字节流输出 

> response.getOutputStream()


	
		
		//1. 指定浏览器看这份数据使用的码表
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		//2. 指定输出的中文用的码表
		response.getOutputStream().write("我爱深圳黑马训练营..".getBytes("UTF-8"));


		--------------------------------------------

###不管是字节流还是字符流，直接使用一行代码就可以了。

	response.setContentType("text/html;charset=UTF-8");

	然后在写数据即可。


###演练下载资源。

1. 直接以超链接的方式下载，不写任何代码。 也能够下载东西下来。 


	让tomcat的默认servlet去提供下载：<br>
	<a href="download/aa.jpg">aa.jpg</a><br>
	<a href="download/bb.txt">bb.txt</a><br>
	<a href="download/cc.rar">cc.rar</a><br>

> 原因是tomcat里面有一个默认的Servlet -- DefaultServlet 。这个DefaultServlet 专门用于处理放在tomcat服务器上的静态资源。

![icon](img/request_10.png)



##总结

1. Servlet注册方式 

2. ServletContext【重点】

		作用：
	
			1. 获取全局参数
		
			2. 获取工程里面的资源。
		
			3. 资源共享。  ServletContext 域对象
	
		有几个 一个 
	
		什么时候创建 ？ 什么时候销毁
	
		服务器启动的时候给每一个应用都创建一个ServletContext对象， 服务器关闭的时候销毁

	简单登录

3. HttpServletRequest【重点】

		1. 获取请求头
	
		2. 获取提交过来的数据

	
	

4. HttpServletResponse【重点】

		负责输出数据到客户端，其实就是对之前的请求作出响应

5. 中文乱码问题。【重点】

6. 下载


###作业：

	
	1. 完成注册 

	2. 完成登录

![icon](img/request_11.png)

---------------------------------------

V1.1 最好配合上数据库，完成注册和登录的功能。 
	

	
