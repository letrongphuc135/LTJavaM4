package vn.ltp.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ltp.dao.CategoryDAO;
import vn.ltp.domain.Category;

@RestController
public class CategoryApiController {
	private CategoryDAO categoryDao = new CategoryDAO();
	
	@GetMapping("/api/category")
	public List<Category> index(){
		return categoryDao.findAll();
	}
}
