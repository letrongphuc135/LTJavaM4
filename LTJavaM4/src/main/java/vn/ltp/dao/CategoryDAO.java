package vn.ltp.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import vn.ltp.dao.impl.AbstractDao;
import vn.ltp.domain.Category;

public class CategoryDAO extends AbstractDao<Serializable, Category>{
	
	
	public int insert(Category category) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			session.persist(category);
			tran.commit();
			return 1;
		} catch (Exception e) {
			if(tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Category> getParents(){
		//session
		Session session = HibernateUtils.getSessionFactory().openSession();
		Query query = session.createQuery("from Category where parentid = null");
		List<Category> list = query.getResultList();
		return list;
	}
}
