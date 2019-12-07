package vn.ltp.dao.impl;

import java.util.List;

import vn.ltp.dao.Repository;
import vn.ltp.domain.Cart;
import vn.ltp.mapper.CartMapper;

public class CartRepository extends Repository {
	public List<Cart> getCarts(String id) {
		return jdbc.query("CALL GetCarts(?)", new CartMapper(), id);
	}

	public int add(Cart obj) {
		return jdbc.update("CALL AddCart(?, ?, ?, ?)", obj.getId(), obj.getMemberId(), obj.getProductId(),
				obj.getQuantity());
	}
}
