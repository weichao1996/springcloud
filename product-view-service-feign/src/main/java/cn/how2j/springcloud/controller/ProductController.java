package cn.how2j.springcloud.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;
import cn.how2j.springcloud.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
  
@Api(tags = "商品API") // 类文档显示内容
@Controller
public class ProductController {
  
    @Autowired ProductService productService;
    @Value("${version}")
    String version;
    @Value("${server.port}")
    String port;
     
    @ApiOperation(value = "获取商品list") // 接口文档显示内容
    @GetMapping("/products")
    public Object products(Page page,Model m) {
    	int total = productService.total();
        page.caculateLast(total);
        List<Product> ps = productService.listProducts(page);
        m.addAttribute("version", version); 
        m.addAttribute("ps", ps);
        m.addAttribute("port", port);
        return "products";
 
    }
    
    @ApiOperation(value = "删除商品") // 接口文档显示内容
    @GetMapping("/deleteproduct")
    public Object deleteproduct(Product product) throws Exception{
        productService.deleteproduct(product);
        return "redirect:products";
    }
    
    @ApiOperation(value = "获取商品") // 接口文档显示内容
    @GetMapping("/getproduct")
    public ModelAndView getproduct(Product product) throws Exception{
        Product product1 = productService.getproduct(product);
//        m.addAttribute("product",product1);
//        return "editproduct";
        ModelAndView mav = new ModelAndView("editproduct");
		mav.addObject("product",product1);
		return mav;
    }
    
    @ApiOperation(value = "更新商品") // 接口文档显示内容
    @PostMapping("/updateproduct")
    public Object updateproduct(Product product) throws Exception{
        productService.updateproduct(product);
        return "redirect:products";
    }
    
    @ApiOperation(value = "添加商品") // 接口文档显示内容
    @PostMapping("/addproduct")
    public Object addproduct(Product product) throws Exception{
        productService.addproduct(product);
        return "redirect:products";
    }
    
    @ApiOperation(value = "创建订单") // 接口文档显示内容
    @GetMapping("creatOrder") 
    public Object creatOrder(Product product) throws Exception{
    	productService.creatOrder(product);
    	 return "redirect:products";
    }
    
    
}