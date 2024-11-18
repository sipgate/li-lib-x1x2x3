package com.sipgate.li.lib.x1.protocol.error;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.reflections.ReflectionUtils;

class ErrorResponseExceptionTest {

  @Test
  void itHasUniqueErrorCodes() throws IllegalAccessException {
    final var fields = ReflectionUtils.getFields(
      ErrorResponseException.class,
      field -> field.getType() == BigInteger.class,
      field -> Modifier.isStatic(field.getModifiers()),
      field -> Modifier.isFinal(field.getModifiers())
    );

    final var allErrorCodes = new ArrayList<BigInteger>();
    for (final var field : fields) {
      allErrorCodes.add(((BigInteger) field.get(null)));
    }

    final var uniqueErrorCodes = new HashSet<>(allErrorCodes);
    assertThat(uniqueErrorCodes).hasSameSizeAs(allErrorCodes);
  }
}
