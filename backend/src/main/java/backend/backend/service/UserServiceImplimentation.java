package backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backend.config.JwtProvider;
import backend.backend.exception.UserException;
import backend.backend.model.User;
import backend.backend.repository.UserRepository;

@Service
public class UserServiceImplimentation implements UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private JwtProvider jwtProvider;

  @Override
  public User findUserById(Long userId) throws UserException {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new UserException("user not found with id " + userId));

    return user;
  }

  @Override
  public User findUserProfileByJwt(String jwt) throws UserException {
    String email = jwtProvider.getEmailFormToken(jwt);
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new UserException("user not found with email " + email);
    }
    return user;
  }

  @Override
  public User updateUser(Long userId, User req) throws UserException {
    User user = findUserById(userId);
    if (req.getFullName() != null) {
      user.setFullName(req.getFullName());
    }
    if (req.getImage() != null) {
      user.setImage(req.getImage());
    }
    if (req.getBackgroundImage() != null) {
      user.setBackgroundImage(req.getBackgroundImage());
    }
    if (req.getBirthDate() != null) {
      user.setBirthDate(req.getBirthDate());
    }
    if (req.getLocation() != null) {
      user.setLocation(req.getLocation());
    }
    if (req.getBio() != null) {
      user.setBio(req.getBio());
    }
    if (req.getWebsite() != null) {
      user.setWebsite(req.getWebsite());
    }

    return userRepository.save(user);
  }

  @Override
  public User followUser(Long userId, User user) throws UserException {
    User followToUser = findUserById(userId);
    if (user.getFollowing().contains(followToUser) && followToUser.getFollower().contains(user)) {
      user.getFollowing().remove(followToUser);
      followToUser.getFollower().remove(user);
    } else {
      user.getFollowing().add(followToUser);
      followToUser.getFollower().add(user);
    }

    userRepository.save(followToUser);
    userRepository.save(user);

    return followToUser;
  }

  @Override
  public List<User> searchUser(String query) {
    return userRepository.searchUser(query);
  }

}
