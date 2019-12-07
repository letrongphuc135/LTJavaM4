package vn.ltp.service;

import java.util.List;

import vn.ltp.domain.Product;

public interface IProductService {
	int getPage(int size);
	List<Product> findAll(Integer index, int size);
}
