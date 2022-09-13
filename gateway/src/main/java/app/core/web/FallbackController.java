package app.core.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	// copy path from github
	@GetMapping("/fallback/serviceA")
	public String fallbackA() {
		return "Gateway fallback: cant access service A";
	}

	// copy path from github
	@GetMapping("/fallback/serviceB")
	public String fallbackB() {
		return "Gateway fallback: cant access service B";
	}

}
