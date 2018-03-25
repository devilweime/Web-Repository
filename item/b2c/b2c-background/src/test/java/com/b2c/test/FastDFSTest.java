package com.b2c.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastDFSTest {

	@Test
	public void upload() throws FileNotFoundException, IOException, MyException {
		String path = this.getClass().getResource("/").getPath();
		System.out.println(path);
		String conf = "classpath:fastdfs\\fastdfs.properties";
		conf = conf.replaceAll("classpath:", path);
		System.out.println(conf);
		ClientGlobal.init(conf);
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageClient storageClient = new StorageClient(trackerServer, null);
		String[] strings = storageClient.upload_file("C:\\Users\\Wei\\Pictures\\heshang.jpg", "jpg", null);
		for (String str : strings) {
			System.out.println(str);
		}
	}
}
