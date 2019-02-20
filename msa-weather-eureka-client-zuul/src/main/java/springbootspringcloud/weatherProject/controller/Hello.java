package springbootspringcloud.weatherProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@GetMapping("/hello")
	public String name() {
		return "Hello World! Zuul";
	}
}
