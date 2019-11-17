package vn.t3h.chapter6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.t3h.dao.ProductRepository;

@Controller
public class Bai3_ProductController {

	ProductRepository repository = new ProductRepository();
	private static int size = 6;

	@RequestMapping(value = { "chapter3/bai3-product-list.html", "chapter3/bai3-product-list.html/{p}" })
	public String index(Model model, @PathVariable(value = "p", required = false) Integer p) {
		model.addAttribute("title", "Mini Shop");
		model.addAttribute("n", (int) Math.ceil(repository.count() / (double) size));
		model.addAttribute("list", repository.getProducts(1, size));
		
		return "chapter3.bai3.product.list";
	}
}
