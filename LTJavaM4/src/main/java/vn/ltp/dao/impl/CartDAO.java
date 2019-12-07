package vn.ltp.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import vn.ltp.dao.HibernateUtils;
import vn.ltp.domain.Cart;

public class CartDAO {
	public List<Cart> getCarts(String id){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Query query = session.createNativeQuery("CALL GetCarts(:id)");
		query.setParameter("id", id);
		List<Cart> list = query.getResultList();
		return list;
	}
	
	public int add(Cart obj) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createNativeQuery("INSERT INTO Cart (CartId, MemberId, ProductId, Quantity) VALUES (?, ?, ?, ?)" + 
					"ON DUPLICATE KEY UPDATE Quantity = Quantity + qty");
			query.setParameter(1, obj.getId());
			query.setParameter(1, obj.getMemberId());
			query.setParameter(1, obj.getProductId());
			query.setParameter(1, obj.getQuantity());
			transaction.commit();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
		
	}
}
