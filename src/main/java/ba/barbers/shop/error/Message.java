package ba.barbers.shop.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Message {
  private MessageSeverity severity;
  private int code;
  private String title;
  private MessageDetail details;
}
