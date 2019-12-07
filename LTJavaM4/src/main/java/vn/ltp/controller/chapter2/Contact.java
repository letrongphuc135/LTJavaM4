package vn.ltp.controller.chapter2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Contact {

	@RequestMapping("contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping(value = "contact", method = RequestMethod.POST)
	public String contact(Model model, Contact o) {
		model.addAttribute("o", o);
		return "contact";
	}
}
