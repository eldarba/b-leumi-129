package app.core.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.jwt.JwtUtil.ClientDetails;
import app.core.jwt.JwtUtil.ClientDetails.ClientType;

// @Component
public class Demo2 implements CommandLineRunner {
	@Autowired
	private JwtUtil util;

	@Override
	public void run(String... args) throws Exception {
		String token = util.generateToken(new ClientDetails("aaa@mail", ClientType.ADMIN));
		System.out.println(token);
		
		ClientDetails client = util.extractClient(token);
		System.out.println(client);
		
	}

}
