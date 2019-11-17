package vn.t3h.chapter1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/chapter1/hello.html")
	public String index() {
		return "chapter1/hello";
	}
}
