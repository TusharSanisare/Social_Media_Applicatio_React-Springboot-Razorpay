package backend.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import backend.backend.dto.TwitDto;
import backend.backend.dto.UserDto;
import backend.backend.model.Twit;
import backend.backend.model.User;
import backend.backend.util.TwitUtil;

public class TwitDtoMapper {

  public static TwitDto toTwitDto(Twit twit, User reqUser) {
    UserDto user = UserDtoMappre.toUserDto(twit.getUser());

    boolean isLiked = TwitUtil.isLikedByReqUser(reqUser, twit);
    boolean isRetwit = TwitUtil.isRetwitByReqUser(reqUser, twit);

    List<Long> retwitUserId = new ArrayList<>();

    for (User user1 : twit.getReTwitUser()) {
      retwitUserId.add(user1.getId());
    }

    TwitDto twitDto = new TwitDto();
    twitDto.setId(twit.getId());
    twitDto.setContent(twit.getContent());
    twitDto.setCreatedAt(twit.getCreatedAt());
    twitDto.setImage(twit.getImage());
    twitDto.setTotalLikes(twit.getReplyTwits().size());
    twitDto.setTotalRetweets(twit.getReTwitUser().size());
    twitDto.setUser(user);
    twitDto.setLiked(isLiked);
    twitDto.setRetwit(isRetwit);
    twitDto.setRetwitUserId(retwitUserId);
    twitDto.setReplyTwits(toTwitDtos(twit.getReplyTwits(), reqUser));
    twitDto.setVideo(twit.getVideo());

    return twitDto;
  }

  public static List<TwitDto> toTwitDtos(List<Twit> twits, User reqUser) {
    List<TwitDto> twitDtos = new ArrayList<>();

    for (Twit twit : twits) {
      TwitDto twitDto = toReplyTwitDto(twit, reqUser);
      twitDtos.add(twitDto);
    }

    return twitDtos;
  }

  private static TwitDto toReplyTwitDto(Twit twit, User reqUser) {

    UserDto user = UserDtoMappre.toUserDto(twit.getUser());

    boolean isLiked = TwitUtil.isLikedByReqUser(reqUser, twit);
    boolean isRetwit = TwitUtil.isRetwitByReqUser(reqUser, twit);

    List<Long> retwitUserId = new ArrayList<>();

    for (User user1 : twit.getReTwitUser()) {
      retwitUserId.add(user1.getId());
    }

    TwitDto twitDto = new TwitDto();
    twitDto.setId(twit.getId());
    twitDto.setContent(twit.getContent());
    twitDto.setCreatedAt(twit.getCreatedAt());
    twitDto.setImage(twit.getImage());
    twitDto.setTotalLikes(twit.getReplyTwits().size());
    twitDto.setTotalRetweets(twit.getReTwitUser().size());
    twitDto.setUser(user);
    twitDto.setLiked(isLiked);
    twitDto.setRetwit(isRetwit);
    twitDto.setRetwitUserId(retwitUserId);
    twitDto.setVideo(twit.getVideo());

    return twitDto;
  }
}
