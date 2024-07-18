//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03280.common._2017._07;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Port complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="Port">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <choice>
 *         <element name="TCPPort" type="{http://uri.etsi.org/03280/common/2017/07}TCPPort"/>
 *         <element name="UDPPort" type="{http://uri.etsi.org/03280/common/2017/07}UDPPort"/>
 *       </choice>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Port", propOrder = { "tcpPort", "udpPort" })
public class Port {

  @XmlElement(name = "TCPPort")
  @XmlSchemaType(name = "integer")
  protected Integer tcpPort;

  @XmlElement(name = "UDPPort")
  @XmlSchemaType(name = "integer")
  protected Integer udpPort;

  /**
   * Gets the value of the tcpPort property.
   *
   * @return
   *     possible object is
   *     {@link Integer }
   *
   */
  public Integer getTCPPort() {
    return tcpPort;
  }

  /**
   * Sets the value of the tcpPort property.
   *
   * @param value
   *     allowed object is
   *     {@link Integer }
   *
   */
  public void setTCPPort(Integer value) {
    this.tcpPort = value;
  }

  /**
   * Gets the value of the udpPort property.
   *
   * @return
   *     possible object is
   *     {@link Integer }
   *
   */
  public Integer getUDPPort() {
    return udpPort;
  }

  /**
   * Sets the value of the udpPort property.
   *
   * @param value
   *     allowed object is
   *     {@link Integer }
   *
   */
  public void setUDPPort(Integer value) {
    this.udpPort = value;
  }
}
