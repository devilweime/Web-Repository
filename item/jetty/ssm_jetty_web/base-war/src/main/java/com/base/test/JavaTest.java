package com.base.test;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class JavaTest {

	public static void main(String[] args) {

		Server server = new Server();
		server.setStopAtShutdown(true);

		ServerConnector connector = new ServerConnector(server);
		// 设置服务端口
		connector.setPort(8081);
		connector.setReuseAddress(false);
		server.setConnectors(new Connector[] { connector });

		WebAppContext webAppContext = new WebAppContext("src/main/webapp", "/");
		webAppContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		webAppContext.setResourceBase("src/main/webapp");
		/*webAppContext.setDisplayName("/");*/
		webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());
		webAppContext.setConfigurationDiscovered(true);
		webAppContext.setParentLoaderPriority(true);

		server.setHandler(webAppContext);
		System.out.println(webAppContext.getContextPath());
		System.out.println(webAppContext.getDescriptor());
		System.out.println(webAppContext.getResourceBase());
		System.out.println(webAppContext.getBaseResource());

		try {
            server.start();
            System.out.println("server is  start");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                server.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	
}