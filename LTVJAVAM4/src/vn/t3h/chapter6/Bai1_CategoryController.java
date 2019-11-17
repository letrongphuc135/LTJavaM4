package vn.t3h.chapter6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.t3h.dao.CategoryRepository;
import vn.t3h.domain.Category;

@Controller
@RequestMapping("chapter6/bai1-category")
public class Bai1_CategoryController {

	CategoryRepository repository = new CategoryRepository();

	@RequestMapping("add.html")
	public String add(Model model) {
		List<Category> list = repository.getParents();
		model.addAttribute("list", list);

//		Map<Integer, String> map = new HashMap<>();
//		for (Category item : list) {
//			map.put(item.getId(), item.getName());
//		}
//		model.addAttribute("map", map);

		model.addAttribute("obj", new Category());
		return "chapter6.bai1.category.add";
	}

	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public String add(Model model, Category obj) {
		repository.add(obj);
		return "redirect:/chapter5/bai7-category/list.html";
	}
}
