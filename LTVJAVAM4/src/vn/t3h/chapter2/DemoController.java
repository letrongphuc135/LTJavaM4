package vn.t3h.chapter2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.t3h.domain.Author;

@Controller
public class DemoController {

	@RequestMapping("chapter2/demo/path-variable.html/{name}")
	public String pathVariable(@PathVariable(name = "name") String name) {
		System.out.println("Hello " + name);
		return "chapter2/path_variable";
	}
	
	@RequestMapping("chapter2/demo/request-param1.html")
	public String requesParam1(@RequestParam("name") String name) {
		System.out.println("Hello " + name);
		return "chapter2/request_param1";
	}
	
	@RequestMapping("chapter2/demo/request-param2.html")
	public String requesParam2(@RequestParam("name") String name) {
		System.out.println("Hello " + name);
		return "chapter2/request_param2";
	}
	
	@RequestMapping("chapter2/demo/java-bean1.html")
	public String javaBean1(Author author) {
		System.out.println("ID = " + author.getId());
		System.out.println("Name = " + author.getName());
		return "chapter2/java_bean1";
	}
	
	@RequestMapping("chapter2/demo/java-bean2.html")
	public String javaBean2(Author author) {
		System.out.println("ID = " + author.getId());
		System.out.println("Name = " + author.getName());
		return "chapter2/java_bean2";
	}
}
