package vn.ltp.dao;

import java.io.Serializable;
import java.util.List;

import vn.ltp.domain.Product;

public interface IProductDAO extends GenericDAO<Serializable, Product> {
	List<Product> findByProperty(int index, int size);
}
