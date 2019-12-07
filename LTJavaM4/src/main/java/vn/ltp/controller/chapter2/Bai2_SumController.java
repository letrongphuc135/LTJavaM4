package vn.ltp.controller.chapter2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Bai2_SumController {
	
	@RequestMapping("sum")
	public String index() {
		return "chapter2/sum";
	}
	
	@RequestMapping(value = "sum", method = RequestMethod.POST)
	public String index(Model model, int a, int b) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("result", a + b);
		return "chapter2/sum";
	}
}
