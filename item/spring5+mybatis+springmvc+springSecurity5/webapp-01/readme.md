本项目基于spring5.0.X,相关使用请看 [文档教程](https://github.com/lfvepclr/spring-5-framework-doc)

####webapp-01版本增加

1. 项目搭建

    1.1 引入spring-framework-bomspring解决内部间的版本依赖 [查看使用](https://www.cnblogs.com/YLsY/p/5711103.html)
    
    1.2 module工程只能在pom工程聚合
    
    1.3 webapp项目需要引入子模块module的依赖，才能tomcat启动时加载到他们的jar
    
2. 项目运行
    
    [maven的三种启动方式](https://www.cnblogs.com/lcs-java/p/8468023.html)
    
    [maven-两种tomcat插件的配置](https://blog.csdn.net/j080624/article/details/67639259/)
    
3. 日志查看

    3.1 spring5.0.x推荐使用slf4j(简单门面模式)
    
    3.2 log4j改变
    
    * 3.2.1 spring5.0x推荐使用log4j2，放弃使用Log4j 1.x
        
    * 3.2.2 servlet2.5需手动配置web的log4j的监听器和过滤器，servlet3.0默认引入，不需要再次配置  [官方说明](http://logging.apache.org/log4j/2.0/manual/webapp.html)
        
    * 3.2.3 [spring集成 log4j + slf4j](https://www.cnblogs.com/yinz/p/5695995.html)

4. 页面分离
    
    jsp解析器配置
    ```
    <!-- 视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/views/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
    ```
    可通过ModelAndView绕过视图解析器视图文件名配置,也可继承此配置
    ```
    //工程目录下需包含src\main\java\views1\index.jsp
    @RequestMapping(value = {"/","/index"})
    public void index(HttpServletRequest request , HttpServletResponse response, ModelAndView mav) throws IOException {
    
        mav.setViewName("/views1/index.jsp");
    }
    //与上面效果相同，使用视图解析器解析视图文件名
    //工程目录下需包含src\main\java\views\index.jsp
    public String index(HttpServletRequest request , HttpServletResponse response, ModelAndView mav) throws IOException {
        return "index";
    }
    ```
    
    