package backend.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import backend.backend.dto.UserDto;
import backend.backend.model.User;

public class UserDtoMappre {

  public static UserDto toUserDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setEmail(user.getEmail());
    userDto.setImage(user.getImage());
    userDto.setFullName(user.getFullName());
    userDto.setBackgroundImage(user.getBackgroundImage());
    userDto.setBio(user.getBio());
    userDto.setBirthDate(user.getBirthDate());
    userDto.setFollower(toUserDeos(user.getFollower()));
    userDto.setFollowing(toUserDeos(user.getFollowing()));
    userDto.setLogin_with_google((user.isLogin_with_google()));
    userDto.setLocation(user.getLocation());
    // userDto.setVerified(false);

    return userDto;
  }

  private static List<UserDto> toUserDeos(List<User> follower) {
    List<UserDto> userDtos = new ArrayList<>();
    for (User user : follower) {
      UserDto userDto = new UserDto();
      userDto.setId(user.getId());
      userDto.setEmail(user.getEmail());
      userDto.setImage(user.getImage());
      userDto.setFullName(user.getFullName());

      userDtos.add(userDto);
    }
    return userDtos;
  }
}
