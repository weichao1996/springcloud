package cn.how2j.springcloud.client;
 
import java.util.List;
 
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.how2j.springcloud.pojo.Page;
import cn.how2j.springcloud.pojo.Product;
 
@FeignClient(value = "PRODUCT-DATA-SERVICE",fallback = ProductClientFeignHystrix.class)
public interface ProductClientFeign {
 
    @RequestMapping(value = "/products" ,method = RequestMethod.GET,consumes="application/json")
    public List<Product> listProdcuts(Page page);

    @RequestMapping(value = "/deleteproduct" ,method = RequestMethod.GET,consumes="application/json")
	public void deleteproduct(@RequestBody Product product);

    @RequestMapping(value = "/getproduct" ,method = RequestMethod.GET,consumes="application/json")
	public Product getproduct(Product product);

    @RequestMapping(value = "/updateproduct" ,method = RequestMethod.GET,consumes="application/json")
	public void updateproduct(Product product);

    @RequestMapping(value = "/addproduct" ,method = RequestMethod.GET,consumes="application/json")
	public void addproduct(Product product);

    @GetMapping("/total")
	public int total();
}