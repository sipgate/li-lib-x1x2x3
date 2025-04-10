/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.protocol;

import com.sipgate.li.lib.x2x3.protocol.tlv.TLV;
import java.util.List;
import java.util.UUID;

public class PduObjectBuilder {

  private short majorVersion = PduObject.MAJOR_VERSION;
  private short minorVersion = PduObject.MINOR_VERSION;
  private PduType pduType = PduType.X2_PDU;
  private PayloadFormat payloadFormat = PayloadFormat.SIP;
  private PayloadDirection payloadDirection = PayloadDirection.UNKNOWN;
  private UUID xid = UUID.randomUUID();
  private byte[] correlationID = new byte[0]; // must be set before build(), is initialized to incorrect length by design.
  private TLV[] conditionalAttributeFields = new TLV[0];
  private byte[] payload = new byte[0];

  public PduObjectBuilder majorVersion(final Short majorVersion) {
    this.majorVersion = majorVersion;
    return this;
  }

  public PduObjectBuilder minorVersion(final Short minorVersion) {
    this.minorVersion = minorVersion;
    return this;
  }

  public PduObjectBuilder pduTypeAndFormat(final PduType pduType, final PayloadFormat payloadFormat) {
    this.pduType = pduType;
    this.payloadFormat = payloadFormat;
    return this;
  }

  public PduObjectBuilder payloadDirection(final PayloadDirection payloadDirection) {
    this.payloadDirection = payloadDirection;
    return this;
  }

  public PduObjectBuilder xid(final UUID xid) {
    this.xid = xid;
    return this;
  }

  public PduObjectBuilder correlationID(final byte[] correlationID) {
    this.correlationID = correlationID;
    return this;
  }

  public PduObjectBuilder conditionalAttributeFields(final List<TLV> conditionalAttributeFields) {
    this.conditionalAttributeFields = conditionalAttributeFields.toArray(this.conditionalAttributeFields);
    return this;
  }

  public PduObjectBuilder payload(final byte[] payload) {
    this.payload = payload;
    return this;
  }

  public PduObject build() {
    return new PduObject(
      majorVersion,
      minorVersion,
      pduType,
      payloadFormat,
      payloadDirection,
      xid,
      correlationID,
      conditionalAttributeFields,
      payload
    );
  }

  public PduObjectBuilder sip() {
    return this.pduTypeAndFormat(PduType.X2_PDU, PayloadFormat.SIP);
  }

  public PduObjectBuilder rtp() {
    return this.pduTypeAndFormat(PduType.X3_PDU, PayloadFormat.RTP);
  }
}
