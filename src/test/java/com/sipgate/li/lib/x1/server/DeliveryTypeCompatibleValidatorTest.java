package com.sipgate.li.lib.x1.server;

import static com.sipgate.li.lib.x1.server.DeliveryTypeCompatibleValidator.isValid;
import static org.assertj.core.api.Assertions.assertThat;

import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.junit.jupiter.api.Test;

class DeliveryTypeCompatibleValidatorTest {

  @Test
  void it_matches_expected() {
    assertThat(isValid(DeliveryType.X_2_AND_X_3, DeliveryType.X_2_AND_X_3)).isTrue();
    assertThat(isValid(DeliveryType.X_2_AND_X_3, DeliveryType.X_2_ONLY)).isTrue();
    assertThat(isValid(DeliveryType.X_2_AND_X_3, DeliveryType.X_3_ONLY)).isTrue();

    assertThat(isValid(DeliveryType.X_2_ONLY, DeliveryType.X_2_AND_X_3)).isFalse();
    assertThat(isValid(DeliveryType.X_2_ONLY, DeliveryType.X_2_ONLY)).isTrue();
    assertThat(isValid(DeliveryType.X_2_ONLY, DeliveryType.X_3_ONLY)).isFalse();

    assertThat(isValid(DeliveryType.X_3_ONLY, DeliveryType.X_2_AND_X_3)).isFalse();
    assertThat(isValid(DeliveryType.X_3_ONLY, DeliveryType.X_2_ONLY)).isFalse();
    assertThat(isValid(DeliveryType.X_3_ONLY, DeliveryType.X_3_ONLY)).isTrue();
  }
}
