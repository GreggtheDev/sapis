import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A simple REST controller with role-based access control using @PreAuthorize annotations.
 * It provides different endpoints for users with ADMIN and USER roles.
 */
@RestController
@RequestMapping("/api")
public class MyController {

    /**
     * Endpoint that can only be accessed by users with the ADMIN role.
     *
     * @return a String message for admin users
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Admin Access";  // Only ADMIN users can access this endpoint
    }

    /**
     * Endpoint that can only be accessed by users with the USER role.
     *
     * @return a String message for regular users
     */
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userEndpoint() {
        return "User Access";  // Only USER users can access this endpoint
    }
}

