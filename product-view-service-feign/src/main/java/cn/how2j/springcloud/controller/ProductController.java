package cn.how2j.springcloud.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;
import cn.how2j.springcloud.service.ProductService;
  
@Controller
public class ProductController {
  
    @Autowired ProductService productService;
    @Value("${version}")
    String version;
    @Value("${server.port}")
    String port;
     
    @RequestMapping("/products")
    public Object products(Page page,Model m) {
    	int total = productService.total();
        page.caculateLast(total);
        List<Product> ps = productService.listProducts(page);
        m.addAttribute("version", version); 
        m.addAttribute("ps", ps);
        m.addAttribute("port", port);
        return "products";
 
    }
    
    @RequestMapping("/deleteproduct")
    public Object deleteproduct(Product product) throws Exception{
        productService.deleteproduct(product);
        return "redirect:products";
    }
    
    @RequestMapping("/getproduct")
    public Object getproduct(Product product,Model m) throws Exception{
        Product product1 = productService.getproduct(product);
        m.addAttribute("product",product1);
        return "editproduct";
    }
    
    @RequestMapping("/updateproduct")
    public Object updateproduct(Product product) throws Exception{
        productService.updateproduct(product);
        return "redirect:products";
    }
    
    @RequestMapping("/addproduct")
    public Object addproduct(Product product) throws Exception{
        productService.addproduct(product);
        return "redirect:products";
    }
    
    
}