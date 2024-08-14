package backend.backend.service;

import backend.backend.exception.TwitException;
import backend.backend.exception.UserException;
import backend.backend.model.Like;
import backend.backend.model.User;

import java.util.List;

public interface LikeService {

  public Like likeTwit(Long twitId, User user) throws UserException, TwitException;

  public List<Like> getAllLikes(Long twitId) throws TwitException;
}
