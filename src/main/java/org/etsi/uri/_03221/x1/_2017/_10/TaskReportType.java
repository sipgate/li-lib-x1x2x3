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
 * <p>Java class for TaskReportType</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="TaskReportType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="AllClear"/>
 *     <enumeration value="Warning"/>
 *     <enumeration value="NonTerminatingFault"/>
 *     <enumeration value="TerminatingFault"/>
 *     <enumeration value="ImplicitDeactivation"/>
 *     <enumeration value="FullyActionedAndSuccessful"/>
 *     <enumeration value="FullyActionedAndUnsuccessful"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 *
 */
@XmlType(name = "TaskReportType")
@XmlEnum
public enum TaskReportType {
  @XmlEnumValue("AllClear")
  ALL_CLEAR("AllClear"),
  @XmlEnumValue("Warning")
  WARNING("Warning"),
  @XmlEnumValue("NonTerminatingFault")
  NON_TERMINATING_FAULT("NonTerminatingFault"),
  @XmlEnumValue("TerminatingFault")
  TERMINATING_FAULT("TerminatingFault"),
  @XmlEnumValue("ImplicitDeactivation")
  IMPLICIT_DEACTIVATION("ImplicitDeactivation"),
  @XmlEnumValue("FullyActionedAndSuccessful")
  FULLY_ACTIONED_AND_SUCCESSFUL("FullyActionedAndSuccessful"),
  @XmlEnumValue("FullyActionedAndUnsuccessful")
  FULLY_ACTIONED_AND_UNSUCCESSFUL("FullyActionedAndUnsuccessful");

  private final String value;

  TaskReportType(String v) {
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
  public static TaskReportType fromValue(String v) {
    for (TaskReportType c : TaskReportType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
