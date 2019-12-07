package vn.ltp.controller.chapter6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.ltp.dao.IProductDAO;
import vn.ltp.dao.impl.ProductDAO;
import vn.ltp.domain.Product;
import vn.ltp.service.IProductService;

@Controller
public class ProductController {
	
	private IProductDAO productDao = new ProductDAO();
	private static int size = 6;

	@RequestMapping(value = { "index", "index/{p}" })
	public String index(Model model, @PathVariable(value = "p", required = false) Integer p) {
		int page = (int) Math.ceil(productDao.count() / (float) size);
		if(p == null) {
			p =1;
		}
		model.addAttribute("page", page);
		model.addAttribute("list", productDao.findByProperty(p, size));
		return "home.index";
	}

	@RequestMapping("home/detail.html/{id}")
	public String detail(Model model, @PathVariable("id") int id) {
		Product product = productDao.findById(id);
		model.addAttribute("o", product);
		return "home.detail";
	}

	@RequestMapping("search.html")
	public String search(Model model, @RequestParam("s") String s,

			@PathVariable(value = "p", required = false) Integer p) {
		model.addAttribute("title", "Result for " + s);
		if (p == null) {
			p = 1;
		}
		List<Product> list = new ArrayList<Product>();
		list = productDao.search("title", s, p, size);
		model.addAttribute("list", list);
		return "home.search";
	}

}
