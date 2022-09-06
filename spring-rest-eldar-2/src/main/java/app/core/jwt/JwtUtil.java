package app.core.jwt;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import app.core.jwt.JwtUtil.ClientDetails.ClientType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private String sinatureAlg = SignatureAlgorithm.HS256.getJcaName();
	@Value("${jwt.util.secret.key}")
	private String encodedSecretKey;
	private Key decodedSecretKey;
	@Value("${jwt.util.chrono.unit.number}")
	private int unitNumber;
	@Value("${jwt.util.chrono.unit}")
	private String chronoUnit;

	@PostConstruct
	public void init() {
		this.decodedSecretKey = new SecretKeySpec(Base64.getDecoder().decode(encodedSecretKey), this.sinatureAlg);
	}
	
	public String generateToken(ClientDetails clientDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("clientType", clientDetails.clientType);
		return createToken(claims, clientDetails.email);
	}
	
	private String createToken(Map<String, Object> claims, String subject) {
		Instant now = Instant.now();
		Instant exp = now.plus(this.unitNumber, ChronoUnit.valueOf(chronoUnit));
		return Jwts.builder()
		.setClaims(claims)
		.setSubject(subject)
		.setIssuedAt(Date.from(now))
		.setExpiration(Date.from(exp))
		.signWith(this.decodedSecretKey)
		.compact();
	}
	
	public ClientDetails extractClient(String token) {
		Claims claims = extractAllClaims(token);
		String email = claims.getSubject();
		ClientType type = ClientType.valueOf(claims.get("clientType", String.class));
		ClientDetails client = new  ClientDetails(email, type);
		return client;
	}
	
	private Claims extractAllClaims(String token) {
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(this.decodedSecretKey).build();
		return jwtParser.parseClaimsJws(token).getBody();
	}
	
	
	public static class ClientDetails{
		public String email;
		public ClientType clientType;
		
		public ClientDetails() {
		}
		
		public ClientDetails(String email, ClientType clientType) {
			super();
			this.email = email;
			this.clientType = clientType;
		}



		public enum ClientType{
			ADMIN, USER
		}
	}

}
