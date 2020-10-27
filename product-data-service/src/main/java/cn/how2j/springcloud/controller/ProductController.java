package cn.how2j.springcloud.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;
import cn.how2j.springcloud.service.ProductService;
  
@RestController
public class ProductController {
  
    @Autowired ProductService productService;
     
    @RequestMapping("/products")
    public Object products(@RequestBody Page page) {
        List<Product> ps = productService.listProducts(page);
        return ps;
    }
    
    @GetMapping("/deleteproduct")
    public void deleteproduct(@RequestBody Product product) {
        productService.deleteproduct(product);
    }
    
    @GetMapping("/getproduct")
    public Product getproduct(@RequestBody Product product) {
        return productService.getproduct(product);
    }
    
    @GetMapping("/updateproduct")
    public void updateproduct(@RequestBody Product product) {
        productService.updateproduct(product);
    }
    
    @GetMapping("/addproduct")
    public void addproduct(@RequestBody Product product) {
        productService.addproduct(product);
    }
    
    @GetMapping("/total")
    public Object total() {
    	int total = productService.total();
        return total;
    }
}