package backend.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import backend.backend.model.User;
import backend.backend.repository.UserRepository;

@Service
public class CustomUserDetailsServiceImplementation implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    // User user = userRepository.findByFullName(username); ye to mene kiya he bc
    User user = userRepository.findByEmail(email);

    if (user == null || user.isLogin_with_google()) {
      throw new UsernameNotFoundException("user name not found with email" + email);
    }

    List<GrantedAuthority> authorities = new ArrayList<>();
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
  }

}
