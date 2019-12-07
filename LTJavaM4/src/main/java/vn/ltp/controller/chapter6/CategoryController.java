package vn.ltp.controller.chapter6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.ltp.dao.CategoryDAO;
import vn.ltp.domain.Category;

@Controller
public class CategoryController {
	
	private CategoryDAO categoryDAO = new CategoryDAO();
	
	@RequestMapping("category")
	public String index(Model model) {
		List<Category> list = categoryDAO.findAll();
		model.addAttribute("list", list);
		return "category";
	}
	
	@RequestMapping("category/add")
	public String add(Model model) {
		List<Category> list = categoryDAO.getParents();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Category item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map",map);
		model.addAttribute("obj", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "category/add", method = RequestMethod.POST)
	public String add(Model model, Category obj) {
		categoryDAO.insert(obj);
		return "redirect:/category/add";
	}
	
	@RequestMapping("category/edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		List<Category> listParent = categoryDAO.getParents();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Category item : listParent) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", categoryDAO.findById(id));
		return "editcategory";
	}
	
	@RequestMapping(value = "category/edit/{id}", method = RequestMethod.POST)
	public String edit(Model model, Category obj) {
		categoryDAO.update(obj);
		return "redirect:/category";
	}
}
