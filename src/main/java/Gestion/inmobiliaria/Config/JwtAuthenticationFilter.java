package Gestion.inmobiliaria.Config;

import Gestion.inmobiliaria.Services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        // Solo procesa si el encabezado Authorization está presente y comienza con "Bearer "
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Elimina el prefijo "Bearer "

            try {
                // Extrae el DNI (o cualquier identificador) del token
                String dni = jwtService.extractDNI(token);

                // Valida el token
                if (jwtService.validateToken(token, dni)) {
                    // Si es válido, establece la autenticación en el contexto de seguridad
                    Authentication authentication = jwtService.getAuthentication(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    // Si el token no es válido, responde con 401 y detiene la cadena
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido o expirado");
                    return;
                }

            } catch (Exception e) {
                // Si ocurre un error al procesar el token, responde con 401
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error al procesar el token");
                return;
            }
        }

        // Continúa con la cadena de filtros (para rutas públicas o ya autenticadas)
        chain.doFilter(request, response);
    }
}
