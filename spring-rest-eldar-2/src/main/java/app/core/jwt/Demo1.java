package app.core.jwt;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo1 {

	public static void main(String[] args) {
		
		String secretKey = "aaaaaaaaa1aaaaaaaaa2aaaaaaaaa3aaaaaaaaa4aaa";
		byte[] bytes = secretKey.getBytes();
		byte[] bytesDecoded = Base64.getDecoder().decode(bytes);
		
		// choose alg
		String alg = SignatureAlgorithm.HS256.getJcaName();
		
		// create a signature key
		Key key = new SecretKeySpec(bytesDecoded, alg);
		
		Instant now = Instant.now();
		Instant exp = now.plus(30, ChronoUnit.SECONDS);
		
		// create a token
		String token = Jwts.builder()
				.signWith(key)
				.setSubject("aaa@mail")
				.setIssuedAt(Date.from(now))
				.setExpiration(Date.from(exp))
				.claim("name", "Eldar")
				.claim("address", "Jerusalem, Israel")
				.compact();
		System.out.println(token);
		
		//////////////////////////
		String jws = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYWFAbWFpbCIsImlhdCI6MTY2MjQ1MzU2NCwiZXhwIjoxNjYyNDUzNTk0LCJuYW1lIjoiRWxkYXIiLCJhZGRyZXNzIjoiSmVydXNhbGVtLCBJc3JhZWwifQ.JX_at4MJPuLDoXHPBp8LkX3KQ9nQakjfoAPelW4_uo0";
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		Jws<Claims> jwt = jwtParser.parseClaimsJws(jws);
		
		System.out.println("=======================");
		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody());
		System.out.println(jwt.getSignature());

	}

}
