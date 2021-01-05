package cn.how2j.springcloud.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.how2j.springcloud.pojo.Order;
import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;

@Repository
public interface ProductMapper {
	public List<Product> listProducts(Page page);

	public void deleteproduct(Product product);

	public Product getproduct(Product product);

	public void updateproduct(Product product);

	public void addproduct(Product product);

	public int total();
	
	public void insertOrder(Order order);
}
