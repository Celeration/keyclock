
package com.mentoring.keycloak;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint accessible by anyone.";
    }

    @GetMapping("/protected")
    public String protectedEndpoint() {
        return "This is a protected endpoint accessible only by authenticated users.";
    }

    @GetMapping("/employee")
    @PreAuthorize("hasRole('employee')")
    public String employeeEndpoint() {
        return "You are employee";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('manager')")
    public String managerEndpoint() {
        return "You are manager";
    }


    @GetMapping("/director")
    @PreAuthorize("hasRole('director')")
    public String directorEndpoint() {
        return "You are director";
    }
}
