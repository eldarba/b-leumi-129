package app.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import app.core.jwt.JwtUtil;
import app.core.jwt.JwtUtil.ClientDetails;

//@Component
@Order(1)
public class LoginFilter implements Filter {
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getRequestURI();
		String method = req.getMethod();
		
		System.out.println("=== filter:");
		System.out.println("=== pathe: " + path);
		System.out.println("=== method: " + method);
		
		try {
			if(path.startsWith("/api/dictionary") ){
				
				String authHeader = req.getHeader("Authorization");
				if(authHeader==null) {
					throw new RuntimeException("request blocked - no token");
				}
				if(!authHeader.startsWith("Bearer")) {
					throw new RuntimeException("request blocked - wrong authentication schema");
				}
				String token = authHeader.replace("Bearer ", "");
				
				ClientDetails client = this.jwtUtil.extractClient(token);
				System.out.println(client);
				chain.doFilter(request, response);
				return;
			}
			chain.doFilter(request, response);
			
		} catch (Exception e) {
			resp.sendError(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
		}
		
		// pass the request to its end point
		
		
		
	}

}
