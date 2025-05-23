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
 * <p>Java class for DeliveryType</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="DeliveryType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="X2Only"/>
 *     <enumeration value="X3Only"/>
 *     <enumeration value="X2andX3"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 *
 */
@XmlType(name = "DeliveryType")
@XmlEnum
public enum DeliveryType {
  @XmlEnumValue("X2Only")
  X_2_ONLY("X2Only"),
  @XmlEnumValue("X3Only")
  X_3_ONLY("X3Only"),
  @XmlEnumValue("X2andX3")
  X_2_AND_X_3("X2andX3");

  private final String value;

  DeliveryType(String v) {
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
  public static DeliveryType fromValue(String v) {
    for (DeliveryType c : DeliveryType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
