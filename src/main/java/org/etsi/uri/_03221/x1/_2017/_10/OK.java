//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03221.x1._2017._10;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 *
 *
 * <p>Java class for OK</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="OK">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="AcknowledgedAndCompleted"/>
 *     <enumeration value="Acknowledged"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 *
 */
@XmlType(name = "OK")
@XmlEnum
public enum OK {
  @XmlEnumValue("AcknowledgedAndCompleted")
  ACKNOWLEDGED_AND_COMPLETED("AcknowledgedAndCompleted"),
  @XmlEnumValue("Acknowledged")
  ACKNOWLEDGED("Acknowledged");

  private final String value;

  OK(String v) {
    value = v;
  }

  /**
   * Gets the value associated to the enum constant.
   *
   * @return
   *     The value linked to the enum.
   */
  public String value() {
    return value;
  }

  /**
   * Gets the enum associated to the value passed as parameter.
   *
   * @param v
   *     The value to get the enum from.
   * @return
   *     The enum which corresponds to the value, if it exists.
   * @throws IllegalArgumentException
   *     If no value matches in the enum declaration.
   */
  public static OK fromValue(String v) {
    for (OK c : OK.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
