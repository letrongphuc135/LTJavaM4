package vn.ltp.controller.chapter2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping("hello")
	public String view() {
		return "hello";
		
	}
}
