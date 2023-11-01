package ba.barbers.shop.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {
  private String source;
  private List<Message> messages;
}
