//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03280.common._2017._07;

import jakarta.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.etsi.uri._03280.common._2017._07 package.
 * <p>An ObjectFactory allows you to programmatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.etsi.uri._03280.common._2017._07
   *
   */
  public ObjectFactory() {}

  /**
   * Create an instance of {@link IPAddress }
   *
   * @return
   *     the new instance of {@link IPAddress }
   */
  public IPAddress createIPAddress() {
    return new IPAddress();
  }

  /**
   * Create an instance of {@link IPCIDR }
   *
   * @return
   *     the new instance of {@link IPCIDR }
   */
  public IPCIDR createIPCIDR() {
    return new IPCIDR();
  }

  /**
   * Create an instance of {@link TCPPortRange }
   *
   * @return
   *     the new instance of {@link TCPPortRange }
   */
  public TCPPortRange createTCPPortRange() {
    return new TCPPortRange();
  }

  /**
   * Create an instance of {@link UDPPortRange }
   *
   * @return
   *     the new instance of {@link UDPPortRange }
   */
  public UDPPortRange createUDPPortRange() {
    return new UDPPortRange();
  }

  /**
   * Create an instance of {@link Port }
   *
   * @return
   *     the new instance of {@link Port }
   */
  public Port createPort() {
    return new Port();
  }

  /**
   * Create an instance of {@link PortRange }
   *
   * @return
   *     the new instance of {@link PortRange }
   */
  public PortRange createPortRange() {
    return new PortRange();
  }

  /**
   * Create an instance of {@link IPAddressPort }
   *
   * @return
   *     the new instance of {@link IPAddressPort }
   */
  public IPAddressPort createIPAddressPort() {
    return new IPAddressPort();
  }

  /**
   * Create an instance of {@link IPAddressPortRange }
   *
   * @return
   *     the new instance of {@link IPAddressPortRange }
   */
  public IPAddressPortRange createIPAddressPortRange() {
    return new IPAddressPortRange();
  }

  /**
   * Create an instance of {@link WGS84CoordinateDecimal }
   *
   * @return
   *     the new instance of {@link WGS84CoordinateDecimal }
   */
  public WGS84CoordinateDecimal createWGS84CoordinateDecimal() {
    return new WGS84CoordinateDecimal();
  }

  /**
   * Create an instance of {@link WGS84CoordinateAngular }
   *
   * @return
   *     the new instance of {@link WGS84CoordinateAngular }
   */
  public WGS84CoordinateAngular createWGS84CoordinateAngular() {
    return new WGS84CoordinateAngular();
  }
}
