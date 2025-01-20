/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.client;

import com.sipgate.li.lib.x2x3.protocol.PduObject;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class X2X3Client implements AutoCloseable {

  public static final Logger LOGGER = LoggerFactory.getLogger(X2X3Client.class);

  private final Socket socket;

  public X2X3Client(final SocketFactory socketFactory, final String ipAddress, final int port, final int timeoutMillis)
    throws IOException {
    LOGGER.info("Connecting to {}:{}", ipAddress, port);
    this.socket = socketFactory.createSocket();
    this.socket.connect(new InetSocketAddress(ipAddress, port), timeoutMillis);
    LOGGER.info("Connected to {}:{}", ipAddress, port);
  }

  public X2X3Client(final SocketFactory socketFactory, final String ipAddress, final int port) throws IOException {
    this(socketFactory, ipAddress, port, 5000);
  }

  public void send(final PduObject pduObject) throws IOException {
    LOGGER.debug("Sending PDU: {}", pduObject);
    PduLogger.handlePduLogging(pduObject);
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

class PduLogger {

  public static final Logger PDU_LOGGER = LoggerFactory.getLogger(PduLogger.class);

  public static void handlePduLogging(final PduObject pduObject) {
    if (PDU_LOGGER.isTraceEnabled()) {
      PDU_LOGGER.debug(pduObject.debugToString());
    }
  }
}
