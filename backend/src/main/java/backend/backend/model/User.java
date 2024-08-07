package backend.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String fullName;
  private String location;
  private String website;
  private String birthDate;
  private String email;
  private String password;
  private String mobile;
  private String image;
  private String backgroundImage;
  private String bio;
  private boolean reg_user;
  private boolean login_with_google;

  @JsonIgnore
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Twit> twit = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Like> likes = new ArrayList<>();

  @Embedded
  private Varification verification;

  @JsonIgnore
  @ManyToMany
  private List<User> follower = new ArrayList<>();

  @JsonIgnore
  @ManyToMany
  private List<User> following = new ArrayList<>();
}
