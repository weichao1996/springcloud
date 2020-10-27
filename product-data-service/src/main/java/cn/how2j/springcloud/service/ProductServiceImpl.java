package cn.how2j.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.how2j.springcloud.mapper.ProductMapper;
import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;

@Component
public class ProductServiceImpl implements ProductService{

	@Autowired
    ProductMapper productMapper;
	
	@Override
	public List<Product> listProducts(Page page) {
		// TODO Auto-generated method stub
		return productMapper.listProducts(page);
	}

	@Override
	public void deleteproduct(Product product) {
		// TODO Auto-generated method stub
		productMapper.deleteproduct(product);
	}

	@Override
	public Product getproduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.getproduct(product);
	}

	@Override
	public void updateproduct(Product product) {
		// TODO Auto-generated method stub
		productMapper.updateproduct(product);
	}

	@Override
	public void addproduct(Product product) {
		// TODO Auto-generated method stub
		productMapper.addproduct(product);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return productMapper.total();
	}

}
