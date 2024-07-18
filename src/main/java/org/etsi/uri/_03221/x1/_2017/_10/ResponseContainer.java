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
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for ResponseContainer complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="ResponseContainer">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="x1ResponseMessage" type="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage" maxOccurs="unbounded"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseContainer", propOrder = { "x1ResponseMessage" })
public class ResponseContainer {

  @XmlElement(required = true)
  protected List<X1ResponseMessage> x1ResponseMessage;

  /**
   * Gets the value of the x1ResponseMessage property.
   *
   * <p>This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the x1ResponseMessage property.</p>
   *
   * <p>
   * For example, to add a new item, do as follows:
   * </p>
   * <pre>
   * getX1ResponseMessage().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link X1ResponseMessage }
   * </p>
   *
   *
   * @return
   *     The value of the x1ResponseMessage property.
   */
  public List<X1ResponseMessage> getX1ResponseMessage() {
    if (x1ResponseMessage == null) {
      x1ResponseMessage = new ArrayList<>();
    }
    return this.x1ResponseMessage;
  }
}
