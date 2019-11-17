package vn.t3h.chapter3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bai2_TemplateController {

	@RequestMapping("chapter3/bai2-template.html")
	public String template() {
		return "chapter3.bai2.template";
	}
}
