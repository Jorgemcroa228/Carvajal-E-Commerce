package com.carvajal.Carvajal_E_commerce.service;

import javax.crypto.SecretKey;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.carvajal.Carvajal_E_commerce.entity.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class JwtService {
  @Value("${security.jwt.secret-key}")
    private String secretKey;

    /**
     * Tiempo de expiracion de token en millisegundos
     */
    @Value("${security.jwt.token-expiration}")
    private Long expiration;

    /**
     * Genera la firma secreta apartir del secretKey en el yaml
     * 
     * @return firma secreta para firmar el jwt
     */
    private SecretKey getSigninKey() {
        byte[] keyByte = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyByte);
    }

    /**
     * Generar un token de Jwt
     * 
     * @param users
     * @return
     */
    public String generatedToken(UserEntity users) {
        Date now = new Date();
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);

        return Jwts.builder()
                .claims(Map.of("userId", users.getId_user(), "role", users.getRole().name()))
                .subject(users.getEmail())
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(getSigninKey())
                .compact();

    }

    /**
     * Metodo de validacion del token y que si es valido o ya expiro el token
     * 
     * @param token
     * @return
     */
    public Boolean validToken(String token) {
        try {
            Jwts.parser()
                .verifyWith(getSigninKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            log.error("token invalido: " + e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Error al validar el token: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metodo de extraer todo los claims payload
     * 
     * @param <T>
     * @param token
     * @param resolver
     * @return
     */
    public <T> T extractClaims(String token, Function<Claims, T> resolver) {
        final Claims claims = Jwts.parser()
                .verifyWith(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return resolver.apply(claims);
    }

    /**
     * Extraer el propietario del token
     * 
     * @param token
     * @return
     */
    public String extractEmail(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    /**
     * Metodo extraer el ID del usuario
     * 
     * @param token
     * @return
     */
    public Long extractUserId(String token) {
        return extractClaims(token, claims -> {
            Number id = claims.get("userId", Number.class);
            return id != null ? id.longValue() : null;
        });
    }

    /**
     * Metodo de estraer el rol
     * 
     * @param token
     * @return
     */
    public String extractRol(String token) {
        return extractClaims(token, claims -> claims.get("role", String.class));
    }

    /**
     * Metodo de refrescar el token da uno nuevo sobre el token original
     * 
     * @param token
     * @return
     * @throws Exception
     */
    public String refreshToken(String token) throws Exception {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .verifyWith(getSigninKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        } catch (JwtException e) {
            throw new Exception("El token no es valido: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Un error en servicio: " + e.getMessage());
        }

        UserEntity users = new UserEntity();
        users.setId_user(claims.get("userId", Number.class).longValue());
        users.setEmail(claims.getSubject());
        users.setRole(User.valueOf(claims.get("role", String.class)));

        return generatedToken(users);
    }
}
