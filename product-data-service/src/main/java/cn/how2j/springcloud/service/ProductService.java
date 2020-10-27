package cn.how2j.springcloud.service;
 
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;
 
//@Service
public interface ProductService {
//    @Value("${server.port}")
//    String port;
     
//    public List<Product> listProducts(){
//        List<Product> ps = new ArrayList<>();
//        ps.add(new Product(1,"product a from port:"+port, 50));
//        ps.add(new Product(2,"product b from port:"+port, 150));
//        ps.add(new Product(3,"product c from port:"+port, 250));
//        return ps;
//    }
    
    public List<Product> listProducts(Page page);

	public void deleteproduct(Product product);

	public Product getproduct(Product product);

	public void updateproduct(Product product);

	public void addproduct(Product product);

	public int total();
}