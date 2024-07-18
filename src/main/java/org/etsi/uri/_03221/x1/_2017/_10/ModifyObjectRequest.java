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
 * <p>Java class for ModifyObjectRequest complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="ModifyObjectRequest">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1RequestMessage">
 *       <sequence>
 *         <element name="modifyObject" type="{http://uri.etsi.org/03221/X1/2017/10}GenericObject"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifyObjectRequest", propOrder = { "modifyObject" })
public class ModifyObjectRequest extends X1RequestMessage {

  @XmlElement(required = true)
  protected GenericObject modifyObject;

  /**
   * Gets the value of the modifyObject property.
   *
   * @return
   *     possible object is
   *     {@link GenericObject }
   *
   */
  public GenericObject getModifyObject() {
    return modifyObject;
  }

  /**
   * Sets the value of the modifyObject property.
   *
   * @param value
   *     allowed object is
   *     {@link GenericObject }
   *
   */
  public void setModifyObject(GenericObject value) {
    this.modifyObject = value;
  }
}
