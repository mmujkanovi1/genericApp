package ba.barbers.shop.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class MessageDetail {
  private String text;
  private LocalDateTime timestamp;
  private Map<String, List<String>> details;
}
