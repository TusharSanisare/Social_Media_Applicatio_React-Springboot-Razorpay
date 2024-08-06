package backend.backend.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtProvider {

  SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

  public String generateToken(Authentication auth) {
    String jwt = Jwts.builder()
        .setIssuedAt(new Date())
        .setExpiration(new Date(new Date().getTime() + 86400000))
        .claim("email", auth.getName())
        .signWith(null, key) // .signWith(key)
        .compact();

    return jwt;
  }

  public String getEmailFormToken(String jwt) {
    jwt = jwt.substring(7);

    Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
    // Claims claims =
    // Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
    String email = String.valueOf(claims.get("email"));

    return email;
  }

}
