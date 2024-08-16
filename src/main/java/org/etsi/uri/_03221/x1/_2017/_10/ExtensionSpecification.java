//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.2
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03221.x1._2017._10;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for ExtensionSpecification.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="ExtensionSpecification">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="TS133128"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 *
 */
@XmlType(name = "ExtensionSpecification")
@XmlEnum
public enum ExtensionSpecification {
  @XmlEnumValue("TS133128")
  TS_133128("TS133128");

  private final String value;

  ExtensionSpecification(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static ExtensionSpecification fromValue(String v) {
    for (ExtensionSpecification c : ExtensionSpecification.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
