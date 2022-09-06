package app.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

	// http://localhost:8080/hello
//	@RequestMapping(method = RequestMethod.GET, path = "/hello")

	// http://localhost:8080/api/hello
	@GetMapping("/hello")
	public String hello(@RequestParam String user) {
		return "Hello and welcome " + user;
	}

	// http://localhost:8080/api/sum?a=35&b=200
	@GetMapping("/sum")
	public int sum(@RequestParam int a, @RequestParam int b) {
		return a + b;
	}

	@GetMapping("/find/{word}")
	public String getDefinition(@PathVariable String word) {
		return "the defintion for " + word + " is...";
	}

}
