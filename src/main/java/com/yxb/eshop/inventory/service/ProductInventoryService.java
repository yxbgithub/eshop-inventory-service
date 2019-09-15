package com.yxb.eshop.inventory.service;

import com.yxb.eshop.inventory.common.ProductInventoryRequest;
import com.yxb.eshop.inventory.model.ProductInventory;

public interface ProductInventoryService {
	
	public void add(ProductInventoryRequest request);
	
	public void update(ProductInventoryRequest request);
	
	public void delete(Long id);
	
	public ProductInventory findById(Long id);
	
}
