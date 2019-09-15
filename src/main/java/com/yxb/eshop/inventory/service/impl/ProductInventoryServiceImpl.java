package com.yxb.eshop.inventory.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yxb.eshop.inventory.common.ProductInventoryRequest;
import com.yxb.eshop.inventory.mapper.ProductInventoryMapper;
import com.yxb.eshop.inventory.model.ProductInventory;
import com.yxb.eshop.inventory.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

	@Autowired
	private ProductInventoryMapper productInventoryMapper;
	@Autowired
	private JedisPool jedisPool;
	
	public void add(ProductInventoryRequest request) {
		productInventoryMapper.add(request);
		Jedis jedis = jedisPool.getResource();
		jedis.set("product_inventory_" + request.getProductId(), JSONObject.toJSONString(request));
	}

	public void update(ProductInventoryRequest request) {
		productInventoryMapper.update(request);
		Jedis jedis = jedisPool.getResource();
		jedis.set("product_inventory_" + request.getProductId(), JSONObject.toJSONString(request));
	}

	public void delete(Long id) {
		ProductInventory productInventory = findById(id);
		productInventoryMapper.delete(id);
		Jedis jedis = jedisPool.getResource();
		jedis.del("product_inventory_" + productInventory.getProductId());
	}

	public ProductInventory findById(Long id) {
		return productInventoryMapper.findById(id);
	}

}
