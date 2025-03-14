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
 * <p>Java class for TypeOfNeIssueMessage</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="TypeOfNeIssueMessage">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="Warning"/>
 *     <enumeration value="FaultCleared"/>
 *     <enumeration value="FaultReport"/>
 *     <enumeration value="Alert"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 *
 */
@XmlType(name = "TypeOfNeIssueMessage")
@XmlEnum
public enum TypeOfNeIssueMessage {
  @XmlEnumValue("Warning")
  WARNING("Warning"),
  @XmlEnumValue("FaultCleared")
  FAULT_CLEARED("FaultCleared"),
  @XmlEnumValue("FaultReport")
  FAULT_REPORT("FaultReport"),
  @XmlEnumValue("Alert")
  ALERT("Alert");

  private final String value;

  TypeOfNeIssueMessage(String v) {
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
  public static TypeOfNeIssueMessage fromValue(String v) {
    for (TypeOfNeIssueMessage c : TypeOfNeIssueMessage.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
