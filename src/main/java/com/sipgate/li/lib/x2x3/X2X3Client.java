package com.sipgate.li.lib.x2x3;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
    final var outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    pduObject.writeTo(outputStream);
    outputStream.flush();
  }

  @Override
  public void close() throws Exception {
    LOGGER.debug("Closing socket {}:{}", socket.getInetAddress(), socket.getPort());
    socket.close();
  }
}
