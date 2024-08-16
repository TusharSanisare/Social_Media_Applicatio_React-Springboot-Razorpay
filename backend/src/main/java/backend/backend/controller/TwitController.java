package backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import backend.backend.dto.TwitDto;
import backend.backend.exception.TwitException;
import backend.backend.exception.UserException;
import backend.backend.mapper.TwitDtoMapper;
import backend.backend.model.Twit;
import backend.backend.model.User;
import backend.backend.request.TwitReplyReques;
import backend.backend.response.ApiResponse;
import backend.backend.service.TwitService;
import backend.backend.service.UserService;

@Controller
@RequestMapping("/api/twits")
public class TwitController {

  @Autowired
  private TwitService twitService;

  @Autowired
  private UserService userService;

  @PostMapping("/create")
  public ResponseEntity<TwitDto> createTwit(@RequestBody Twit req, @RequestHeader("Authorization") String jwt)
      throws TwitException, UserException {

    User user = userService.findUserProfileByJwt(jwt);
    Twit twit = twitService.createTwit(req, user);
    TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);

    return new ResponseEntity<>(twitDto, HttpStatus.CREATED);
  }

  @PostMapping("/reply")
  public ResponseEntity<TwitDto> replyTwit(@RequestBody TwitReplyReques req, @RequestHeader("Authorization") String jwt)
      throws TwitException, UserException {

    User user = userService.findUserProfileByJwt(jwt);
    Twit twit = twitService.createReply(req, user);
    TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);

    return new ResponseEntity<>(twitDto, HttpStatus.CREATED);
  }

  @PutMapping("/{twitId}/retwit")
  public ResponseEntity<TwitDto> retwit(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt)
      throws TwitException, UserException {

    User user = userService.findUserProfileByJwt(jwt);
    Twit twit = twitService.retwit(twitId, user);
    TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);

    return new ResponseEntity<>(twitDto, HttpStatus.OK);
  }

  @GetMapping("/{twitId}")
  public ResponseEntity<TwitDto> findTwitById(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt)
      throws TwitException, UserException {

    User user = userService.findUserProfileByJwt(jwt);
    Twit twit = twitService.findById(twitId);
    TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);

    return new ResponseEntity<>(twitDto, HttpStatus.OK);
  }

  @DeleteMapping("/{twitId}")
  public ResponseEntity<ApiResponse> deleteTwit(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt)
      throws TwitException, UserException {

    User user = userService.findUserProfileByJwt(jwt);
    twitService.deleteTwitById(twitId, user.getId());
    ApiResponse res = new ApiResponse();
    res.setMessage("Twit Delete Successfully");
    res.setStatus(true);

    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<List<TwitDto>> getAllTwit(@RequestHeader("Authorization") String jwt)
      throws TwitException, UserException {

    User user = userService.findUserProfileByJwt(jwt);
    List<Twit> twit = twitService.findAllTwit();
    List<TwitDto> twitDtos = TwitDtoMapper.toTwitDtos(twit, user);

    return new ResponseEntity<>(twitDtos, HttpStatus.OK);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<TwitDto>> getUsersAllTwit(@PathVariable Long userId,
      @RequestHeader("Authorization") String jwt) throws TwitException, UserException {

    User user = userService.findUserProfileByJwt(jwt);
    List<Twit> twit = twitService.getUserTwit(user);
    List<TwitDto> twitDtos = TwitDtoMapper.toTwitDtos(twit, user);

    return new ResponseEntity<>(twitDtos, HttpStatus.OK);
  }

  @GetMapping("/user/{userId}/likes")
  public ResponseEntity<List<TwitDto>> findTwitByLikesContainesUser(@PathVariable Long userId,
      @RequestHeader("Authorization") String jwt) throws TwitException, UserException {

    User user = userService.findUserProfileByJwt(jwt);
    List<Twit> twit = twitService.findByLikesContainUser(user);
    List<TwitDto> twitDtos = TwitDtoMapper.toTwitDtos(twit, user);

    return new ResponseEntity<>(twitDtos, HttpStatus.OK);
  }

}
