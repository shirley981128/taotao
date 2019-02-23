一、配置项目名usermanage  
`<display-name>usermanage</display-name>`  
二、spring配置文件
```
<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:spring/applicationContext*.xml</param-value>
	</context-param>
```
配置spring的xml存放地址   
```
<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
```
配置spring监听器   
三、配置编码过滤器
```
<!-- 编码过滤器，以UTF8编码 -->
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF8</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```
四、配置servlet
```
	<!-- 配置SpringMVC框架入口 -->
	<servlet>
        <servlet-name>usermanage</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
        	<param-name>contextConfigLocation</param-name>
        	<param-value>classpath:usermanage-servlet.xml</param-value>
        </init-param>
        <!-- 0：off（false） 1：on（true） -->
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>usermanage</servlet-name>
        <url-pattern>/rest/*</url-pattern>
    </servlet-mapping>

    <!-- 首页 -->
    <welcome-file-list>
    	<welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
```
