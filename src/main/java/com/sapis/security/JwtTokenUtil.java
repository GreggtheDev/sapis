import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Utility class for handling JWT tokens.
 * It includes methods for generating, validating, and extracting information from JWT tokens.
 */
@Component
public class JwtTokenUtil {

    // Secret key used for signing JWT tokens (should be stored securely in production)
    private final String secretKey = "your-secret-key";

    /**
     * Generates a JWT token based on the username.
     * The token has an expiration time of 10 hours.
     *
     * @param username the username for which the token is being generated
     * @return the generated JWT token as a String
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // Sets the subject (username)
                .setIssuedAt(new Date())  // Sets the issue time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // Token expires after 10 hours
                .signWith(SignatureAlgorithm.HS256, secretKey)  // Signs the token using HS256 algorithm and the secret key
                .compact();
    }

    /**
     * Validates the JWT token by checking the username and expiration date.
     *
     * @param token the JWT token to be validated
     * @param username the username to be compared with the token's subject
     * @return true if the token is valid and matches the username, false otherwise
     */
    public boolean validateToken(String token, String username) {
        return getUsernameFromToken(token).equals(username) && !isTokenExpired(token);
    }

    /**
     * Extracts the username from the JWT token.
     *
     * @param token the JWT token
     * @return the username extracted from the token
     */
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)  // Parses the token with the secret key
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();  // Returns the subject (username)
    }

    /**
     * Checks if the JWT token has expired.
     *
     * @param token the JWT token
     * @return true if the token is expired, false otherwise
     */
    private boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }

    /**
     * Retrieves the expiration date from the JWT token.
     *
     * @param token the JWT token
     * @return the expiration date of the token
     */
    private Date getExpirationDateFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration();
    }
}

