package ba.barbers.shop.util;

import ba.barbers.shop.error.ErrorResponse;
import ba.barbers.shop.error.Message;
import ba.barbers.shop.error.MessageDetail;
import ba.barbers.shop.error.MessageSeverity;
import ba.barbers.shop.exception.BadRequestException;
import ba.barbers.shop.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private ResponseEntity<ErrorResponse> handleRuntimeException(final RuntimeException exception,
      final HttpServletRequest httpServletRequest,
      final HttpStatus httpStatus) {
    Throwable exceptionCause = exception.getCause();
    List<String> exceptionCauseMessageList = exceptionCause != null ? List.of(exceptionCause.getMessage()) : new ArrayList<>();
    List<StackTraceElement> stackTraceElementList = Arrays.stream(exception.getStackTrace())
        .toList();
    List<String> stackTraceStringList = new ArrayList<>();
    for (StackTraceElement stackTraceElement : stackTraceElementList) {
      stackTraceStringList.add(stackTraceElement.toString());
    }
    Map<String, List<String>> messageDetails = new HashMap<>();
    messageDetails.put("exception cause", exceptionCauseMessageList);
    messageDetails.put("stack trace", stackTraceStringList);
    MessageDetail messageDetail = new MessageDetail(exception.getMessage(),
        LocalDateTime.now(),
        messageDetails);
    Message message = new Message(MessageSeverity.ERROR,
        httpStatus.value(),
        exception.getClass().getName(),
        messageDetail);
    ErrorResponse errorResponse = new ErrorResponse(httpServletRequest.getRequestURI(), List.of(message));
    return ResponseEntity.status(httpStatus).body(errorResponse);
  }

  @ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleResourceNotFoundException(final ResourceNotFoundException exception,
      final HttpServletRequest httpServletRequest) {
    return handleRuntimeException(exception, httpServletRequest, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = BadRequestException.class)
  public ResponseEntity<ErrorResponse> handleBadRequestException(final BadRequestException exception,
      final HttpServletRequest httpServletRequest) {
    return handleRuntimeException(exception, httpServletRequest, HttpStatus.BAD_REQUEST);
  }
}