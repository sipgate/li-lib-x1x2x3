//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package org.etsi.uri._03221.x1._2017._10;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActivateTaskRequest complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ActivateTaskRequest">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1RequestMessage">
 *       <sequence>
 *         <element name="taskDetails" type="{http://uri.etsi.org/03221/X1/2017/10}TaskDetails"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivateTaskRequest", propOrder = {
    "taskDetails"
})
public class ActivateTaskRequest
    extends X1RequestMessage
{

    @XmlElement(required = true)
    protected TaskDetails taskDetails;

    /**
     * Gets the value of the taskDetails property.
     * 
     * @return
     *     possible object is
     *     {@link TaskDetails }
     *     
     */
    public TaskDetails getTaskDetails() {
        return taskDetails;
    }

    /**
     * Sets the value of the taskDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskDetails }
     *     
     */
    public void setTaskDetails(TaskDetails value) {
        this.taskDetails = value;
    }

}
