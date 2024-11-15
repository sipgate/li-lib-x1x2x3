package com.sipgate.li.lib.x1.protocol.error;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.HashSet;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

class ErrorResponseFactoryTest {

  @Test
  void itUsesUniqueRequestMessageTypes() {
    final var reflections = new Reflections(
      "org.etsi.uri._03221.x1._2017._10",
      Scanners.SubTypes.filterResultsBy(ignored -> true)
    );

    final var subTypes = reflections.getSubTypesOf(X1RequestMessage.class);

    final var exception = mock(X1ErrorException.class);
    final var allRequestMessageTypes = subTypes
      .stream()
      .map(type -> {
        final var requestMessage = mock(type);
        final var errorResponse = ErrorResponseFactory.makeErrorResponse(exception, requestMessage);
        return errorResponse.getRequestMessageType();
      })
      .toList();

    final var uniqueRequestMessageTypes = new HashSet<>(allRequestMessageTypes);
    assertThat(uniqueRequestMessageTypes).hasSameSizeAs(allRequestMessageTypes);
  }

  @Test
  void itDoesNotSetRequestMessageTypeIfUnknown() {
    // GIVEN
    final var exception = mock(X1ErrorException.class);
    final var requestMessage = new UnkownRequestMessage();

    // WHEN
    final var errorResponse = ErrorResponseFactory.makeErrorResponse(exception, requestMessage);

    // THEN
    assertThat(errorResponse.getRequestMessageType()).isNull();
  }

  private static class UnkownRequestMessage extends X1RequestMessage {}
}
