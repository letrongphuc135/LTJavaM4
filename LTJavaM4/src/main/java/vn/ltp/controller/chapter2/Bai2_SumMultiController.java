package vn.ltp.controller.chapter2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bai2_SumMultiController {
	
	@RequestMapping("summulti")
	public String index() {
		return "chapter2/summulti";
	}
	
	@RequestMapping(value = "summulti", method = RequestMethod.POST)
	public String index(Model model, @RequestParam("num") int[] list) {
		int s = 0;
		for(Integer num : list) {
			s+=num;
		}
		model.addAttribute("result", s);
		return "chapter2/summulti";
	}
}
