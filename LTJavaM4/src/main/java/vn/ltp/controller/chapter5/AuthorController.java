package vn.ltp.controller.chapter5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.ltp.dao.AuthorRepository;

@Controller
@RequestMapping("admin/author")
public class AuthorController {

	AuthorRepository repository = new AuthorRepository();
	
	public String index(Model model) {
		model.addAttribute("list", repository.getAuthors());
		return "author";
	}
}
