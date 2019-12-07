package vn.ltp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.ltp.dao.IProductDAO;
import vn.ltp.domain.Product;

public class ProductService implements IProductService {

	@Autowired
	private IProductDAO productDao;
	
	@Override
	public List<Product> findAll(Integer index, int size) {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		if(index == null) {
			index  = 1;
		}
		list = productDao.findByProperty(index, size);
		return list;
	}

	@Override
	public int getPage(int size) {
		// TODO Auto-generated method stub
		int page = (int) Math.ceil(productDao.count() / (float) size);
		return page;
	}

}
