package com.yxb.eshop.inventory.mapper;

import com.yxb.eshop.inventory.common.ProductInventoryRequest;
import com.yxb.eshop.inventory.model.ProductInventory;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductInventoryMapper {
	
	@Insert("INSERT INTO product_inventory_new(value,product_id) VALUES(#{value},#{productId})")
	public void add(ProductInventoryRequest request);
	
	@Update("UPDATE product_inventory_new SET value=#{value},product_id=#{productId} WHERE id=#{id}")
	public void update(ProductInventoryRequest request);
	
	@Delete("DELETE FROM product_inventory WHERE id=#{id}")  
	public void delete(Long id);
	
	@Select("SELECT * FROM product_inventory_new WHERE id=#{id}")
	public ProductInventory findById(Long id);
	
}
