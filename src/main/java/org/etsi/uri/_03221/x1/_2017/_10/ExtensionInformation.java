//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package org.etsi.uri._03221.x1._2017._10;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtensionInformation complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ExtensionInformation">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="extensionSpecification" type="{http://uri.etsi.org/03221/X1/2017/10}ExtensionSpecification"/>
 *         <element name="extendedRequestMessageType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtensionInformation", propOrder = {
    "extensionSpecification",
    "extendedRequestMessageType"
})
public class ExtensionInformation {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ExtensionSpecification extensionSpecification;
    @XmlElement(required = true)
    protected String extendedRequestMessageType;

    /**
     * Gets the value of the extensionSpecification property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionSpecification }
     *     
     */
    public ExtensionSpecification getExtensionSpecification() {
        return extensionSpecification;
    }

    /**
     * Sets the value of the extensionSpecification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionSpecification }
     *     
     */
    public void setExtensionSpecification(ExtensionSpecification value) {
        this.extensionSpecification = value;
    }

    /**
     * Gets the value of the extendedRequestMessageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtendedRequestMessageType() {
        return extendedRequestMessageType;
    }

    /**
     * Sets the value of the extendedRequestMessageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtendedRequestMessageType(String value) {
        this.extendedRequestMessageType = value;
    }

}