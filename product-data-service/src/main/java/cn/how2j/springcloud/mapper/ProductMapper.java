package cn.how2j.springcloud.mapper;

import java.util.List;

import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;

public interface ProductMapper {
	public List<Product> listProducts(Page page);

	public void deleteproduct(Product product);

	public Product getproduct(Product product);

	public void updateproduct(Product product);

	public void addproduct(Product product);

	public int total();
}
