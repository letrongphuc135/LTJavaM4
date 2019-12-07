package vn.ltp.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import vn.ltp.dao.HibernateUtils;
import vn.ltp.dao.IProductDAO;
import vn.ltp.domain.Product;

@Component
public class ProductDAO extends AbstractDao<Serializable, Product> implements IProductDAO{
	
	public List<Product> findByProperty(int index, int size){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Query query = session.createQuery("from Product");
		query.setFirstResult((index - 1) * size);
		query.setMaxResults(size);
		List<Product> list = new ArrayList<Product>();
		list = query.getResultList();
		return list;
	}
}
