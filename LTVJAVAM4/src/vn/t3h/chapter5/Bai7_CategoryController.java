package vn.t3h.chapter5;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.t3h.dao.CategoryRepository;
import vn.t3h.domain.Author;
import vn.t3h.domain.Category;

@Controller
@RequestMapping("chapter5/bai7-category")
public class Bai7_CategoryController {
	CategoryRepository repository = new CategoryRepository();

	@RequestMapping("list.html")
	public String list(Model model) {
		List<Category> list = repository.getCategories();
		model.addAttribute("list", list);

		return "chapter5.bai7.category.list";
	}

	@RequestMapping("add.html")
	public String add() {
		return "chapter5.bai8.category.list";
	}
	
	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public String add(Category obj) {
		repository.add(obj);
		return "redirect:/chapter5/bai7-category/list.html";
	}
}
