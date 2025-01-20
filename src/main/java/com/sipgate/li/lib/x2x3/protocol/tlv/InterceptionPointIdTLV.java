/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.protocol.tlv;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public record InterceptionPointIdTLV(String value) implements TLV {
  @Override
  public int getType() {
    return 7;
  }

  @Override
  public void writeValueTo(final DataOutputStream outputStream) throws IOException {
    outputStream.write(value.getBytes(StandardCharsets.UTF_8));
  }
}
