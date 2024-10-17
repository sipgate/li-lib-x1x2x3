package com.sipgate.li.lib.x2x3.protocol.tlv;

import java.io.DataOutputStream;
import java.io.IOException;

public record GenericTLV(int type, byte[] contents) implements TLV {
  @Override
  public int getType() {
    return type;
  }

  @Override
  public void writeValueTo(final DataOutputStream outputStream) throws IOException {
    outputStream.write(contents);
  }
}
