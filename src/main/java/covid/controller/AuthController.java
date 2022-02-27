package covid.controller;

import covid.entity.User;
import covid.repository.UserRepository;
import covid.request.LoginRequest;
import covid.request.LoginResponse;
import covid.security.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@PreAuthorize("permitAll()")
public class AuthController {
    private final JWTTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(JWTTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public ResponseEntity<User> profile(Principal principal) {
        return new ResponseEntity<>(userRepository.findByUsername(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new LoginResponse("Success", jwt));
    }
}
