package com.sipgate.li.lib.x2x3.protocol.tlv;

import java.io.DataOutputStream;
import java.io.IOException;

public interface TLV {
  int getType();
  void writeValueTo(DataOutputStream outputStream) throws IOException;
}
