/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.protocol.tlv;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public record NetworkFunctionIdTLV(String value) implements TLV {
  @Override
  public int getType() {
    return 6;
  }

  @Override
  public void writeValueTo(final DataOutputStream outputStream) throws IOException {
    outputStream.write(value.getBytes(StandardCharsets.UTF_8));
  }
}
