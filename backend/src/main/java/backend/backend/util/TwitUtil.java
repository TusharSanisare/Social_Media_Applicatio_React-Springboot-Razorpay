package backend.backend.util;

import backend.backend.model.Like;
import backend.backend.model.Twit;
import backend.backend.model.User;

public class TwitUtil {

  public final static boolean isLikedByReqUser(User reqUser, Twit twit) {
    for (Like like : twit.getLikes()) {
      if (like.getUser().getId().equals(reqUser.getId())) {
        return true;
      }
    }
    return false;
  }

  public final static boolean isRetwitByReqUser(User reqUser, Twit twit) {
    for (User user : twit.getReTwitUser()) {
      if (user.getId().equals(reqUser.getId())) {
        return true;
      }
    }
    return false;
  }
}
