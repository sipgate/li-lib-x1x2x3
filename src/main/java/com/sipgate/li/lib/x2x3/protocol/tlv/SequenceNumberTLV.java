/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.protocol.tlv;

import java.io.DataOutputStream;
import java.io.IOException;

// 4 byte unsigned int, is allowed to wrap around at 0xffffffff + 1
public record SequenceNumberTLV(int sequenceNumber) implements TLV {
  @Override
  public int getType() {
    return 8;
  }

  @Override
  public void writeValueTo(final DataOutputStream outputStream) throws IOException {
    outputStream.writeInt(sequenceNumber);
  }
}
