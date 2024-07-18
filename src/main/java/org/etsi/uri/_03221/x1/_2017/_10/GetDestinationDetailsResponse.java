//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03221.x1._2017._10;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for GetDestinationDetailsResponse complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="GetDestinationDetailsResponse">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage">
 *       <sequence>
 *         <element name="destinationResponseDetails" type="{http://uri.etsi.org/03221/X1/2017/10}DestinationResponseDetails"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "GetDestinationDetailsResponse",
  propOrder = { "destinationResponseDetails" }
)
public class GetDestinationDetailsResponse extends X1ResponseMessage {

  @XmlElement(required = true)
  protected DestinationResponseDetails destinationResponseDetails;

  /**
   * Gets the value of the destinationResponseDetails property.
   *
   * @return
   *     possible object is
   *     {@link DestinationResponseDetails }
   *
   */
  public DestinationResponseDetails getDestinationResponseDetails() {
    return destinationResponseDetails;
  }

  /**
   * Sets the value of the destinationResponseDetails property.
   *
   * @param value
   *     allowed object is
   *     {@link DestinationResponseDetails }
   *
   */
  public void setDestinationResponseDetails(DestinationResponseDetails value) {
    this.destinationResponseDetails = value;
  }
}
