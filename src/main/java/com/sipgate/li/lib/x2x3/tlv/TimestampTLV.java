package com.sipgate.li.lib.x2x3.tlv;

import java.io.DataOutputStream;
import java.io.IOException;
import java.time.Instant;

public record TimestampTLV(Instant timestmap) implements TLV {
  @Override
  public int getType() {
    return 9;
  }

  @Override
  public void writeValueTo(final DataOutputStream outputStream) throws IOException {
    outputStream.writeInt((int) timestmap.getEpochSecond());
    outputStream.writeInt(timestmap.getNano());
  }
}
