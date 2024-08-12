package backend.backend.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TwitReplyReques {
  private String content;
  private Long twitId;
  private LocalDateTime createdAt;
  private String image;
}
