package com.b2c.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.mapper.ProductCategoryMapper;
import com.b2c.mapper.ProductDescMapper;
import com.b2c.mapper.ProductMapper;
import com.b2c.model.Product;
import com.b2c.model.ProductCategory;
import com.b2c.model.ProductCategoryExample;
import com.b2c.model.ProductDesc;
import com.b2c.model.ProductDescExample;
import com.b2c.model.ProductExample;
import com.b2c.model.ProductExample.Criteria;
import com.b2c.service.IProductService;
import com.google.gson.Gson;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	@Autowired
	private ProductDescMapper productDescMapper;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	public void addProduct(Product product) {
		product.setFlag((byte) 1);
		productMapper.insert(product);
		ProductDesc productDesc = new ProductDesc();
		productDesc.setProductDesc(product.getDesc());
		productDesc.setProductId(product.getId());
		productDescMapper.insert(productDesc);
		//将数据发送到队列
		Gson gson = new Gson();
		String json = gson.toJson(product);
		rabbitTemplate.convertAndSend(json);
	}

	@Override
	public List<Product> getProductList() {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andFlagEqualTo((byte) 1);
		List<Product> list = productMapper.selectByExample(example);
		return list;
	}

	@Override
	public void delBatch(String ids) {
		String[] idList = ids.split(",");
		Map<String, Object> map = new HashMap<>();
		map.put("flag", 0);
		map.put("ids",idList );
		productMapper.delBatch(map);
	}

	@Override
	public void deById(Integer id) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		Product product = new Product();
		product.setFlag((byte)0);
		productMapper.updateByExampleSelective(product , example);
		
	}

	@Override
	public Product getProductById(Integer id) {
		Product product = productMapper.selectByPrimaryKey(id);
		ProductDescExample example = new ProductDescExample();
		com.b2c.model.ProductDescExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(id);
		List<ProductDesc> list = productDescMapper.selectByExampleWithBLOBs(example);
		
		if(list!=null && !list.isEmpty()){
			ProductDesc desc= list.get(0);
			product.setDescId(desc.getId());
			product.setDesc(desc.getProductDesc());
		}
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(product.getId());
		productMapper.updateByExampleSelective(product, example);
		ProductDesc productDesc = new ProductDesc();
		productDesc.setId(product.getDescId());
		productDesc.setProductDesc(product.getDesc());
		productDesc.setProductId(product.getId());
		com.b2c.model.ProductDescExample example2 = new ProductDescExample();
		com.b2c.model.ProductDescExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andIdEqualTo(productDesc.getId());
		productDescMapper.updateByExampleSelective(productDesc, example2);
	}

}
