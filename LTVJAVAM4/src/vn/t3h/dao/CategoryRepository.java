package vn.t3h.dao;

import java.util.List;

import vn.t3h.domain.Category;
import vn.t3h.mapper.CategoryMapper;

public class CategoryRepository extends Repository {

	public int add(Category obj) {
		return jdbc.update("INSERT INTO Category(CategoryId, CategoryName, ParentId) VALUES (?, ?, ?)", 
				obj.getId(), obj.getName(), obj.getParent());
	}

	public List<Category> getParents() {
		String sql = "SELECT * FROM Category WHERE parentId is null";
		return jdbc.query(sql, new CategoryMapper());
	}

	public List<Category> getCategories() {
		String sql = "SELECT * FROM Category";
		return jdbc.query(sql, new CategoryMapper());
	}
}
