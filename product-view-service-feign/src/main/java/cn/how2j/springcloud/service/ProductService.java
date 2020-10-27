package cn.how2j.springcloud.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.how2j.springcloud.client.ProductClientFeign;
import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;
 
@Service
public class ProductService {
    @Autowired ProductClientFeign productClientFeign;
    public List<Product> listProducts(Page page){
        return productClientFeign.listProdcuts(page);
 
    }
	public void deleteproduct(Product product) {
		// TODO Auto-generated method stub
		productClientFeign.deleteproduct(product);
	}
	public Product getproduct(Product product) {
		// TODO Auto-generated method stub
		return productClientFeign.getproduct(product);
	}
	public void updateproduct(Product product) {
		// TODO Auto-generated method stub
		productClientFeign.updateproduct(product);
	}
	public void addproduct(Product product) {
		// TODO Auto-generated method stub
		productClientFeign.addproduct(product);
	}
	public int total() {
		// TODO Auto-generated method stub
		return productClientFeign.total();
	}

}
