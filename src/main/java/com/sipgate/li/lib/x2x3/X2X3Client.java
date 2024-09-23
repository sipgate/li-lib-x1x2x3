package com.sipgate.li.lib.x2x3;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.net.SocketFactory;

public class X2X3Client implements AutoCloseable {

  private final Socket socket;

  public X2X3Client(final SocketFactory socketFactory, final String ipAddress, final int port) throws IOException {
    this.socket = socketFactory.createSocket(ipAddress, port);
  }

  public void send(final PduObject pduObject) throws IOException {
    final DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    outputStream.write(pduObject.majorVersion());
    outputStream.write(pduObject.minorVersion());
    outputStream.writeShort(pduObject.pduType().value);
    outputStream.writeInt((int) pduObject.headerLength());
    outputStream.writeInt((int) pduObject.payloadLength());
    outputStream.writeShort(pduObject.payloadFormat().value);
    outputStream.writeShort(pduObject.payloadDirection().value);
    outputStream.writeLong(pduObject.xid().getMostSignificantBits());
    outputStream.writeLong(pduObject.xid().getLeastSignificantBits());
    outputStream.write(pduObject.correlationID());
    outputStream.write(pduObject.conditionalAttributeFields());
    outputStream.write(pduObject.payload());

    outputStream.flush();
  }

  @Override
  public void close() throws Exception {
    socket.close();
  }
}
