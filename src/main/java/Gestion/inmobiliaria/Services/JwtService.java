package Gestion.inmobiliaria.Services;

import Gestion.inmobiliaria.Persistance.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.Date;

@Service
public class JwtService {

    private final String secretKey = "pQ1MqycZ7bqZcO3Gx0HDVjNyrI8AmdWCuqPg8T8D+cM=";
    private final long expirationTime = 86400000; // 24 hours in milliseconds

    // Generar el token JWT
    public String generateToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getDni());  // Usamos el DNI como sujeto
        claims.put("role", user.getRole());  // Agregamos el role a los claims

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Extraer el DNI del token
    public String extractDNI(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extraer el role del token
    public String extractRole(String token) {
        return (String) extractAllClaims(token).get("role");
    }

    // Obtener todos los claims del token
    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new IllegalArgumentException("Token ha expirado");
        } catch (UnsupportedJwtException e) {
            throw new IllegalArgumentException("Token no soportado");
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al extraer los claims");
        }
    }

    // Método genérico para extraer un claim específico del token
    private <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.resolve(claims);
    }

    // Verificar si el token ha expirado
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String dni) {
        return (dni.equals(extractDNI(token)) && !isTokenExpired(token));
    }

    // Obtener la autenticación del token
    public Authentication getAuthentication(String token) {
        String dni = extractDNI(token);
        String role = extractRole(token);

        // Usamos el DNI como el principal y el role como autoridad
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                dni, "", Collections.singleton(new SimpleGrantedAuthority(role))
        );

        return new UsernamePasswordAuthenticationToken(userDetails, token, userDetails.getAuthorities());
    }

    // Interfaz funcional para resolver claims
    @FunctionalInterface
    interface ClaimsResolver<T> {
        T resolve(Claims claims);
    }
}
