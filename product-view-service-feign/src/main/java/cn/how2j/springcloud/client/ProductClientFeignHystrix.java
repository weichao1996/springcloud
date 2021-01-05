package cn.how2j.springcloud.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;

@Component
public class ProductClientFeignHystrix implements ProductClientFeign{

	@Override
	public List<Product> listProdcuts(Page page) {
		// TODO Auto-generated method stub
		List<Product> a=new ArrayList<Product>();
		a.add(new Product(0,"数据微服务不可用",0));
		return a;
	}

	@Override
	public void deleteproduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getproduct(Product product) {
		// TODO Auto-generated method stub
		Product product1 = new Product(0,"数据微服务不可用",0);
		return product1;
	}

	@Override
	public void updateproduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addproduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void creatOrder(Product product) {
		// TODO Auto-generated method stub
		
	}

}
