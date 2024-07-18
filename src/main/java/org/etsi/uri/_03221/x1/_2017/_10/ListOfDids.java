//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03221.x1._2017._10;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for ListOfDids complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="ListOfDids">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="dId" type="{http://uri.etsi.org/03221/X1/2017/10}DId" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="dSId" type="{http://uri.etsi.org/03221/X1/2017/10}GenericObjectID" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfDids", propOrder = { "dId", "dsId" })
public class ListOfDids {

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected List<String> dId;

  @XmlElement(name = "dSId")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected List<String> dsId;

  /**
   * Gets the value of the dId property.
   *
   * <p>This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the dId property.</p>
   *
   * <p>
   * For example, to add a new item, do as follows:
   * </p>
   * <pre>
   * getDId().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link String }
   * </p>
   *
   *
   * @return
   *     The value of the dId property.
   */
  public List<String> getDId() {
    if (dId == null) {
      dId = new ArrayList<>();
    }
    return this.dId;
  }

  /**
   * Gets the value of the dsId property.
   *
   * <p>This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the dsId property.</p>
   *
   * <p>
   * For example, to add a new item, do as follows:
   * </p>
   * <pre>
   * getDSId().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link String }
   * </p>
   *
   *
   * @return
   *     The value of the dsId property.
   */
  public List<String> getDSId() {
    if (dsId == null) {
      dsId = new ArrayList<>();
    }
    return this.dsId;
  }
}
