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
 * <p>Java class for ProvisioningStatus.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="ProvisioningStatus">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="awaitingProvisioning"/>
 *     <enumeration value="failed"/>
 *     <enumeration value="complete"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 *
 */
@XmlType(name = "ProvisioningStatus")
@XmlEnum
public enum ProvisioningStatus {
  @XmlEnumValue("awaitingProvisioning")
  AWAITING_PROVISIONING("awaitingProvisioning"),
  @XmlEnumValue("failed")
  FAILED("failed"),
  @XmlEnumValue("complete")
  COMPLETE("complete");

  private final String value;

  ProvisioningStatus(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static ProvisioningStatus fromValue(String v) {
    for (ProvisioningStatus c : ProvisioningStatus.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
