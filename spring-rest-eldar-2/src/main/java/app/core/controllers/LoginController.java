package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.jwt.JwtUtil;
import app.core.jwt.JwtUtil.ClientDetails;
import app.core.jwt.JwtUtil.ClientDetails.ClientType;

@RestController
public class LoginController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public String login(String user, String password) {
		if(user.equals("user") && password.equals("123")) {
			ClientDetails clientDetails = new ClientDetails(user+"@mail", ClientType.ADMIN);
			String token = jwtUtil.generateToken(clientDetails);
			return token;
		}else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "wrong credentials");
		}
	}

}
