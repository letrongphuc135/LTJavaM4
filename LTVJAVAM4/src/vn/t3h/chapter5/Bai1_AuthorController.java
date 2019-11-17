package vn.t3h.chapter5;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.t3h.dao.AuthorRepository;
import vn.t3h.domain.Author;

@Controller
@RequestMapping("admin/author")
public class Bai1_AuthorController {

	AuthorRepository repository = new AuthorRepository();

	@RequestMapping("index.html")
	public String index(Model model) {
		List<Author> list = repository.getAuthors();
		model.addAttribute("list", list);
		return "chapter5.bai1.author.list";
	}

	@RequestMapping("add.html")
	public String add() {
		return "chapter5.bai3.author.list";
	}

	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public String add(Author obj) {
		repository.add(obj);
		return "redirect:/admin/author/index.html";
	}

	@RequestMapping("edit.html/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("o", repository.getAuthor(id));
		return "chapter5.bai4.author.list";
	}

	@RequestMapping(value = "edit.html/{id}", method = RequestMethod.POST)
	public String edit(Model model, Author obj, @PathVariable("id") int id) {
		repository.edit(obj);
		return "redirect:/admin/author/index.html";
	}

	@RequestMapping("del.html/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.delete(id);
		return "redirect:/admin/author/index.html";
	}

	@RequestMapping(value = "dels.html", method = RequestMethod.POST)
	public String delete(@RequestParam("ids") List<Integer> list) {
		repository.delete(list);
		return "redirect:/admin/author/index.html";
	}
}
