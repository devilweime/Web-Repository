package com.b2c.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.commons.pojo.Page;
import com.b2c.mapper.ProductMapper;
import com.b2c.model.Product;
import com.b2c.model.ProductExample;
import com.b2c.model.ProductExample.Criteria;
import com.b2c.service.ISearchService;
@Service
public class SearchServiceImpl implements ISearchService{
	@Autowired
	private ProductMapper productMapper;
	@Autowired
//	private HttpSolrServer solrServer;
	
	private CloudSolrServer solrServer;
	
	@Override
	public void synAllDate() {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andFlagEqualTo((byte)1);
		List<Product> list = productMapper.selectByExample(example);
		if (list!=null && !list.isEmpty()) {
			for (Product product : list) {
				SolrInputDocument document = new SolrInputDocument();
				document.setField("id", product.getId());
				document.setField("product_name", product.getName());
				document.setField("product_price", product.getPrice());
				document.setField("sale_point", product.getSalePoint());
				document.setField("images", product.getImages());
				try {
					solrServer.add(document);
				} catch (SolrServerException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				solrServer.commit();
			} catch (SolrServerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	//错误，solr索引存在数据，无须到数据库中再取
	/*@Override
	public List<Product> queryByMain(String mainSearch) {
		SolrQuery query = new SolrQuery();
		query.setQuery("product_name:"+mainSearch);
		//1.名称查询
		//1.1获得不同名称的list，allProduct
		List<Product> allProduct = new ArrayList<>();
		try {
			QueryResponse response = solrServer.query(query);
			SolrDocumentList list = response.getResults();
			for (SolrDocument solrDocument : list) {
				String product_name = (String) solrDocument.getFieldValue("product_name");
				ProductExample example = new ProductExample();
				Criteria criteria = example.createCriteria();
				criteria.andNameLike(product_name);
				List<Product> products = productMapper.selectByExample(example);
				if (products!=null && !products.isEmpty()) {
					allProduct.removeAll(products);
					allProduct.addAll(products);
					Collection<Product> nuCon = new Vector<>();
					nuCon.add(null); 
					allProduct.removeAll(nuCon);
					
				}
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		if (!allProduct.isEmpty()) {
			return allProduct;
		}else {
			return null;
		}
	}*/
	
	@Override
	public Page queryByMain(String mainSearch,Integer pageIndex,Integer rows){
		Page page = new Page();
		List<Product> allProduct = new ArrayList<>();
		SolrQuery query = new SolrQuery();
		if (StringUtils.isEmpty(mainSearch)) {
			query.setQuery("*:*");
		}else {
			query.setQuery("product_keywords:"+mainSearch);
		}
		//开始查询index
		query.setStart((pageIndex-1)*rows);
		//限制多少条
		query.setRows(rows);
		//总记录数
		long totalCount= 0;
		//设置高亮
		query.setHighlight(true);
		query.setHighlightSimplePre("<font color='red'>");
		/*记得设置高亮字段*/
		query.addHighlightField("product_name");
		query.addHighlightField("sale_point");
		query.setHighlightSimplePost("</font>");
		try {
			QueryResponse response = solrServer.query(query );
			SolrDocumentList documents = response.getResults();
			totalCount = documents.getNumFound();
			Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			if (documents!=null && !documents.isEmpty()) {
				for (SolrDocument document : documents) {
					Product product = new Product();
					product.setId(Integer.parseInt((String) document.getFieldValue("id")));
					//名字高亮
					Map<String, List<String>> map = highlighting.get(document.getFieldValue("id"));
					List<String> nameList = map.get("product_name");
					if (nameList!=null && !nameList.isEmpty()) {
						product.setName(nameList.get(0));
					}else {
						product.setName((String) document.getFieldValue("product_name"));
					}
					List<String> pointList = map.get("sale_point");
					if(pointList!=null && !pointList.isEmpty()){
						product.setSalePoint(pointList.get(0));
					}else {
						product.setSalePoint((String) document.getFieldValue("sale_point"));
					}
					product.setPrice((Integer) document.getFieldValue("product_price"));
					product.setImages((String) document.getFieldValue("images"));
					allProduct.add(product);
				}
			}
			
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		page.setCurrentPage(pageIndex);
		page.setList(allProduct);
		page.setRows(rows);
		page.setTotalCount((int) totalCount);
		page.setTotalPage((int) (totalCount%rows==0?totalCount/rows:totalCount/rows+1));
		page.setNavigatePages(5);
		return page;
	
	}

	@Override
	public void synDataByJson(Product product) {
		SolrInputDocument document = new SolrInputDocument();
		document.setField("id", product.getId());
		document.setField("product_name", product.getName());
		document.setField("product_price", product.getPrice());
		document.setField("sale_point", product.getSalePoint());
		document.setField("images", product.getImages());
		try {
			//solrServer注入
			solrServer.add(document);
			solrServer.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
