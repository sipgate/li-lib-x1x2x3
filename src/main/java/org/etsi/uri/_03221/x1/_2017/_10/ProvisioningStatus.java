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
 * <p>Java class for ProvisioningStatus</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
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
  public static ProvisioningStatus fromValue(String v) {
    for (ProvisioningStatus c : ProvisioningStatus.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
