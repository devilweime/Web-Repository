package com.b2c.commons.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSUtils {

	private TrackerClient trackerClient;
	private TrackerServer trackerServer;
	private StorageClient storageClient;
	private StorageClient1 storageClient1;
	
	public FastDFSUtils(String conf) throws FileNotFoundException, IOException, MyException{
		String path = this.getClass().getResource("/").getPath();
		conf = conf.replaceAll("classpath:", path);
		ClientGlobal.init(conf);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageClient = new StorageClient(trackerServer, null);
		storageClient1 = new StorageClient1(trackerServer, null);
	}
	
	public String[] uploadFilesByPath(String path,String extName) throws IOException, MyException{
		return storageClient.upload_file(path, extName, null);
	}
	
	public String uploadFileByPath(String path,String extName) throws IOException, MyException{
		return storageClient1.upload_file1(path, extName, null);
	}
	
	public String uploadFileByBytes(byte[] bytes,String extName) throws IOException, MyException{
		return storageClient1.upload_file1(bytes, extName, null);
	}
}
