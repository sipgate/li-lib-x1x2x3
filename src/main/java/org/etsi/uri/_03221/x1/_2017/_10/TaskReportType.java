//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.2
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

/*
 * SPDX-License-Identifier: MIT
 */
package org.etsi.uri._03221.x1._2017._10;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for TaskReportType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
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

  public String value() {
    return value;
  }

  public static TaskReportType fromValue(String v) {
    for (TaskReportType c : TaskReportType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
