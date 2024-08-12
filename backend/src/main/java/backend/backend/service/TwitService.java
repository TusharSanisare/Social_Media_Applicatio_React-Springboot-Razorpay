package backend.backend.service;

import org.springframework.stereotype.Service;

import backend.backend.exception.TwitException;
import backend.backend.exception.UserException;
import backend.backend.model.Twit;
import backend.backend.model.User;
import backend.backend.request.TwitReplyReques;

import java.util.List;

@Service
public interface TwitService {

  public Twit createTwit(Twit req, User user) throws UserException;

  public List<Twit> findAllTwit();

  public Twit retwit(Long twitId, User user) throws UserException, TwitException;

  public Twit findById(Long twitId) throws TwitException;

  public void deleteTwitById(Long twitId, Long userId) throws TwitException, UserException;

  public Twit removeFromRetwit(Long twitId, User user) throws TwitException, UserException;

  public Twit createReply(TwitReplyReques req, User user) throws TwitException;

  public List<Twit> getUserTwit(User user);

  public List<Twit> findByLikesContainUser(User user);
}
