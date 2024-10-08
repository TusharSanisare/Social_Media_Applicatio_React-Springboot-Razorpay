package backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.backend.model.Twit;
import backend.backend.model.User;

import java.util.List;

@Repository
public interface TwitRepository extends JpaRepository<Twit, Long> {

  List<Twit> findAllByIsTwitTrueOrderByCreatedAtDesc();

  // List<Twit>
  // findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(User user,
  // Long userId);
  List<Twit> findByReTwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(User user, Long userId);

  List<Twit> findByLikesContainingOrderByCreatedAtDesc(User user);

  @Query("SELECT t FROM Twit t JOIN t.likes l WHERE l.user.id=:userId")
  List<Twit> findByLikesUser_id(Long userId);

}
