package backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.config.JwtProvider;
import backend.backend.exception.UserException;
import backend.backend.model.User;
import backend.backend.model.Varification;
import backend.backend.repository.UserRepository;
import backend.backend.response.AuthResponse;
import backend.backend.service.CustomUserDetailsServiceImplementation;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JwtProvider jwtProvider;
  @Autowired
  private CustomUserDetailsServiceImplementation customUserDetails;

  public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {

    String email = user.getEmail();
    String password = user.getPassword();
    String fullName = user.getFullName();
    String birthDate = user.getBirthDate();

    User isEmailExist = userRepository.findByEmail(email);

    if (isEmailExist != null) {
      throw new UserException("Email is already used with another account");
    }
    User createdUser = new User();
    createdUser.setEmail(email);
    createdUser.setFullName(fullName);
    createdUser.setPassword(password);
    createdUser.setBirthDate(birthDate);
    createdUser.setVerification(new Varification());

    User saveUser = userRepository.save(createdUser);

    Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = jwtProvider.generateToken(authentication);

    AuthResponse res = new AuthResponse(token, true);

    return new ResponseEntity<AuthResponse>(res, HttpStatus.CREATED);
  }
}
