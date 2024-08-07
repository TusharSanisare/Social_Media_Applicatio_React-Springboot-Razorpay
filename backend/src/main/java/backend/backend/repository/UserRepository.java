package backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import backend.backend.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  public User findByEmail(String email);

  @Query("SELECT DISTINCT u FROM User u WHERE u.fullName LIKE %:query% OR u.email LIKE %:query%")
  public List<User> searchUser(@Param("query") String query);

}
