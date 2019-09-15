package com.yxb.eshop.inventory.web.controller;

import com.yxb.eshop.inventory.common.ProductInventoryRequest;
import com.yxb.eshop.inventory.model.ProductInventory;
import com.yxb.eshop.inventory.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-inventory")
public class ProductInventoryController {

	@Autowired
	private ProductInventoryService productInventoryService;
	
	@PostMapping
	public String add(ProductInventoryRequest request) {
		try {
			productInventoryService.add(request);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@PutMapping
	public String update(ProductInventoryRequest request) {
		try {
			productInventoryService.update(request);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@DeleteMapping("/{productInventoryId}")
	public String delete(@PathVariable("productInventoryId") Long id) {
		try {
			productInventoryService.delete(id); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@GetMapping("/{productInventoryId}")
	public ProductInventory findById(@PathVariable("productInventoryId") Long id){
		try {
			return productInventoryService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new ProductInventory();
	}
	
}
