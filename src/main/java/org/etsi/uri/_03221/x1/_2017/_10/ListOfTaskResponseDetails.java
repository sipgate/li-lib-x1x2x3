//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03221.x1._2017._10;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for ListOfTaskResponseDetails complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="ListOfTaskResponseDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="taskResponseDetails" type="{http://uri.etsi.org/03221/X1/2017/10}TaskResponseDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "ListOfTaskResponseDetails",
  propOrder = { "taskResponseDetails" }
)
public class ListOfTaskResponseDetails {

  protected List<TaskResponseDetails> taskResponseDetails;

  /**
   * Gets the value of the taskResponseDetails property.
   *
   * <p>This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the taskResponseDetails property.</p>
   *
   * <p>
   * For example, to add a new item, do as follows:
   * </p>
   * <pre>
   * getTaskResponseDetails().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link TaskResponseDetails }
   * </p>
   *
   *
   * @return
   *     The value of the taskResponseDetails property.
   */
  public List<TaskResponseDetails> getTaskResponseDetails() {
    if (taskResponseDetails == null) {
      taskResponseDetails = new ArrayList<>();
    }
    return this.taskResponseDetails;
  }
}
