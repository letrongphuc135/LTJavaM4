package vn.t3h.chapter3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class C3HomeController {

	@RequestMapping("/chapter3/index.html")
	public String index() {
		int a = 10;
		a = 20;
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");
		return "chapter3.index";
	}
}
