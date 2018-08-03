
##jetty:run

```
然后直接运行：mvn jetty:run,就可以直接启动了。jetty会默认加载以下的配置：

resources in ${project.basedir}/src/main/webapp  
classes in ${project.build.outputDirectory}  
web.xml in ${project.basedir}/src/main/webapp/WEB-INF/

`去掉jetty-jsp的依赖，不然会报错`

##main方法运行

```
详情请看ServerRun.java

##jetty支持jsp

```
<!-- jetty支持jsp -->
<dependency>
	<groupId>org.eclipse.jetty</groupId>
	<artifactId>jetty-jsp</artifactId>
</dependency>


##RequestMapping多个链接，设置首页

```
@RequestMapping({"/", "/index"})

