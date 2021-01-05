package cn.how2j.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.how2j.springcloud.mapper.ProductMapper;
import cn.how2j.springcloud.pojo.ErpOrder;
import cn.how2j.springcloud.pojo.Order;
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

	@Override
	@Transactional(rollbackFor = Exception.class) // 实现事务(抛出异常即回滚)
	public void creatOrder(Product product) throws Exception {
		// TODO Auto-generated method stub
		
		
		Product pro=productMapper.getproduct(product);
		if (product.getCount() > pro.getCount()) {
			// 非受检查异常抛出时，会回滚
			throw new Exception();
		}
		pro.setCount(pro.getCount()-product.getCount());
		productMapper.updateproduct(pro);
		
		
		
		Order order=new Order();
		order.setCount(product.getCount());
		order.setProductID(product.getId());
		productMapper.insertOrder(order);
		
		// 数据源2插入数据
//		ErpOrder erpOrder = new ErpOrder();
//		erpOrder.setCount(order.getCount());
//		erpOrder.setProductID(order.getProductID());
//		erpOrder.setOutId(order.getId());
//		erpOrderMapper.insertOrder(erpOrder);
	}



	
}
