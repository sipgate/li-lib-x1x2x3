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
 * <p>Java class for GetObjectResponse complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="GetObjectResponse">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage">
 *       <sequence>
 *         <element name="genericObjectResponseDetails" type="{http://uri.etsi.org/03221/X1/2017/10}GenericObjectResponseDetails"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetObjectResponse", propOrder = {
    "genericObjectResponseDetails"
})
public class GetObjectResponse
    extends X1ResponseMessage
{

    @XmlElement(required = true)
    protected GenericObjectResponseDetails genericObjectResponseDetails;

    /**
     * Gets the value of the genericObjectResponseDetails property.
     * 
     * @return
     *     possible object is
     *     {@link GenericObjectResponseDetails }
     *     
     */
    public GenericObjectResponseDetails getGenericObjectResponseDetails() {
        return genericObjectResponseDetails;
    }

    /**
     * Sets the value of the genericObjectResponseDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericObjectResponseDetails }
     *     
     */
    public void setGenericObjectResponseDetails(GenericObjectResponseDetails value) {
        this.genericObjectResponseDetails = value;
    }

}
