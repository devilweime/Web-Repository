package com.b2c.search.test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrTest {

	// 添加or修改
	@Test
	public void saveOrUpdate() throws SolrServerException, IOException {
		HttpSolrServer solrServer = new HttpSolrServer("http://192.168.48.128:8080/solr");
		SolrInputDocument document = new SolrInputDocument();
		document.setField("id","");
		document.setField("product_name", "小米7");
		document.setField("product_price", 299);
		document.setField("sale_point", "便宜又好吃");
		document.setField("images", "http://192.168.48.128\\group1/M00/00/00/wKgwgFlsFJiAe3oXAAAlxmJEiEw591.jpg");
		solrServer.add(document);
		solrServer.commit();
	}

	// 查询索引
	@Test
	public void query() throws SolrServerException, IOException {
		HttpSolrServer solrServer = new HttpSolrServer("http://192.168.48.128:8080/solr");
		SolrQuery query = new SolrQuery();
		query.setQuery("product_name:test");
		QueryResponse response = solrServer.query(query);
		SolrDocumentList list = response.getResults();
		for (SolrDocument solrDocument : list) {
			System.out.println("id:" + solrDocument.getFieldValue("id"));
			System.out.println("product_name:" + solrDocument.getFieldValue("product_name"));
			System.out.println();
		}
	}

	// 删除
	@Test
	public void delById() throws SolrServerException, IOException {
		HttpSolrServer solrServer = new HttpSolrServer("http://192.168.48.128:8080/solr");
		solrServer.deleteById("19");
		solrServer.commit();
	}
	
	@Test
	public void delByQuery() throws SolrServerException, IOException{
		HttpSolrServer solrServer = new HttpSolrServer("http://192.168.48.128:8080/solr");
		solrServer.deleteByQuery("product_name:小米");
		solrServer.commit();
	}
}
