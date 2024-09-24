package com.sipgate.li.lib.x2x3;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.net.SocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class X2X3Client implements AutoCloseable {

  public static final Logger LOGGER = LoggerFactory.getLogger(X2X3Client.class);

  private final Socket socket;

  public X2X3Client(final SocketFactory socketFactory, final String ipAddress, final int port) throws IOException {
    LOGGER.info("Connecting to {}:{}", ipAddress, port);
    this.socket = socketFactory.createSocket(ipAddress, port);
  }

  public void send(final PduObject pduObject) throws IOException {
    LOGGER.debug("Sending PDU: {}", pduObject);
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
    LOGGER.debug("Closing socket {}:{}", socket.getInetAddress(), socket.getPort());
    socket.close();
  }
}
