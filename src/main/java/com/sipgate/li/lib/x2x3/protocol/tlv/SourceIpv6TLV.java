package com.sipgate.li.lib.x2x3.protocol.tlv;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet6Address;

public record SourceIpv6TLV(Inet6Address ipAddress) implements TLV {
  @Override
  public int getType() {
    return 12;
  }

  @Override
  public void writeValueTo(final DataOutputStream outputStream) throws IOException {
    outputStream.write(ipAddress.getAddress());
  }
}
