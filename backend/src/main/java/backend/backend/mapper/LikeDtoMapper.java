package backend.backend.mapper;

import java.util.List;
import java.util.ArrayList;

import backend.backend.dto.LikeDto;
import backend.backend.dto.TwitDto;
import backend.backend.dto.UserDto;
import backend.backend.model.Like;
import backend.backend.model.User;

public class LikeDtoMapper {

  public static LikeDto toLikeDto(Like like, User reqUser) {
    UserDto user = UserDtoMappre.toUserDto(like.getUser());
    UserDto reqUserDto = UserDtoMappre.toUserDto(reqUser);
    TwitDto twit = TwitDtoMapper.toTwitDto(like.getTwit(), reqUser);

    LikeDto likeDto = new LikeDto();
    likeDto.setId(like.getId());
    likeDto.setTwit(twit);
    likeDto.setUser(user);

    return likeDto;
  }

  public static List<LikeDto> toLikeDtos(List<Like> likes, User reqUser) {

    List<LikeDto> likeDtos = new ArrayList<>();
    for (Like like : likes) {
      UserDto user = UserDtoMappre.toUserDto(like.getUser());
      TwitDto twit = TwitDtoMapper.toTwitDto(like.getTwit(), reqUser);

      LikeDto likeDto = new LikeDto();
      likeDto.setId(like.getId());
      likeDto.setTwit(twit);
      likeDto.setUser(user);
      likeDtos.add(likeDto);
    }
    return likeDtos;
  }
}
