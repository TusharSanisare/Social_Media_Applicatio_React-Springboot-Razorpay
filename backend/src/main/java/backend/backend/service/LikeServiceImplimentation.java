package backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backend.exception.TwitException;
import backend.backend.exception.UserException;
import backend.backend.model.Like;
import backend.backend.model.Twit;
import backend.backend.model.User;
import backend.backend.repository.LikeRepository;
import backend.backend.repository.TwitRepository;

@Service
public class LikeServiceImplimentation implements LikeService {

  @Autowired
  private LikeRepository likeRepository;
  @Autowired
  private TwitService twitService;
  @Autowired
  private TwitRepository twitRepository;

  @Override
  public Like likeTwit(Long twitId, User user) throws UserException, TwitException {
    Like isLikeExist = likeRepository.isLikeExist(user.getId(), twitId);
    if (isLikeExist != null) {
      likeRepository.deleteById(isLikeExist.getId());
      return isLikeExist;
    }
    Twit twit = twitService.findById(twitId);
    Like like = new Like();
    like.setTwit(twit);
    like.setUser(user);

    Like savedLike = likeRepository.save(like);
    twit.getLikes().add(savedLike);
    twitRepository.save(twit);

    return savedLike;
  }

  @Override
  public List<Like> getAllLikes(Long twitId) throws TwitException {
    Twit twit = twitService.findById(twitId);

    List<Like> likes = likeRepository.findByTwitId(twitId);
    return likes;
  }

}
