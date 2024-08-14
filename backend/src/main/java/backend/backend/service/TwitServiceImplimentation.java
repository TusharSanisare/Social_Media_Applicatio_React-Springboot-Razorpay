package backend.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backend.exception.TwitException;
import backend.backend.exception.UserException;
import backend.backend.model.Twit;
import backend.backend.model.User;
import backend.backend.repository.TwitRepository;
import backend.backend.request.TwitReplyReques;

@Service
public class TwitServiceImplimentation implements TwitService {

  @Autowired
  private TwitRepository twitRepository;

  @Override
  public Twit createTwit(Twit req, User user) throws UserException {
    Twit twit = new Twit();
    twit.setContent(req.getContent());
    twit.setCreatedAt(LocalDateTime.now());
    twit.setImage(req.getImage());
    twit.setUser(user);
    twit.setReply(false);
    twit.setTwit(true);
    twit.setVideo(req.getVideo());

    return twitRepository.save(twit);
  }

  @Override
  public List<Twit> findAllTwit() {
    return twitRepository.findAllByIsTwitTrueOrderByCreatedAtDesc();
    // return twitRepository.findAllByTwitTrueOrderByCreatedAtDesc();
  }

  @Override
  public Twit retwit(Long twitId, User user) throws UserException, TwitException {
    Twit twit = findById(twitId);
    if (twit.getReTwitUser().contains(user)) {
      twit.getReTwitUser().remove(user);
    } else {
      twit.getReTwitUser().add(user);
    }
    return twitRepository.save(twit);
  }

  @Override
  public Twit findById(Long twitId) throws TwitException {
    Twit twit = twitRepository.findById(twitId)
        .orElseThrow(() -> new TwitException("Twit not fount with id " + twitId));
    return twit;
  }

  @Override
  public void deleteTwitById(Long twitId, Long userId) throws TwitException, UserException {

    Twit twit = findById(twitId);
    if (!userId.equals(twit.getUser().getId())) {
      throw new UserException("You can't delete another user's twit");
    }
    twitRepository.deleteById(twit.getId());
  }

  @Override
  public Twit removeFromRetwit(Long twitId, User user) throws TwitException, UserException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeFromRetwit'");
  }

  @Override
  public Twit createReply(TwitReplyReques req, User user) throws TwitException {

    Twit replyFor = findById(req.getTwitId());

    Twit twit = new Twit();
    twit.setContent(req.getContent());
    twit.setCreatedAt(LocalDateTime.now());
    twit.setImage(req.getImage());
    twit.setUser(user);
    twit.setReply(true);
    twit.setTwit(false);
    twit.setReplyFor(replyFor);

    Twit savedReply = twitRepository.save(twit);
    twit.getReplyTwits().add(savedReply);
    twitRepository.save(replyFor);

    return replyFor;
  }

  @Override
  public List<Twit> getUserTwit(User user) {
    return twitRepository.findByReTwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(user, user.getId());
  }

  @Override
  public List<Twit> findByLikesContainUser(User user) {
    return twitRepository.findByLikesUser_id(user.getId());
  }

}
