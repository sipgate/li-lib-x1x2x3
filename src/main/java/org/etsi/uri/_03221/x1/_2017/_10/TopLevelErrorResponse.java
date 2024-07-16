//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package org.etsi.uri._03221.x1._2017._10;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for TopLevelErrorResponse complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="TopLevelErrorResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="admfIdentifier" type="{http://uri.etsi.org/03221/X1/2017/10}AdmfIdentifier"/>
 *         <element name="neIdentifier" type="{http://uri.etsi.org/03221/X1/2017/10}NeIdentifier"/>
 *         <element name="messageTimestamp" type="{http://uri.etsi.org/03280/common/2017/07}QualifiedMicrosecondDateTime"/>
 *         <element name="version" type="{http://uri.etsi.org/03221/X1/2017/10}Version"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TopLevelErrorResponse", propOrder = {
    "admfIdentifier",
    "neIdentifier",
    "messageTimestamp",
    "version"
})
public class TopLevelErrorResponse {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String admfIdentifier;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String neIdentifier;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar messageTimestamp;
    @XmlElement(required = true)
    protected String version;

    /**
     * Gets the value of the admfIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmfIdentifier() {
        return admfIdentifier;
    }

    /**
     * Sets the value of the admfIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmfIdentifier(String value) {
        this.admfIdentifier = value;
    }

    /**
     * Gets the value of the neIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNeIdentifier() {
        return neIdentifier;
    }

    /**
     * Sets the value of the neIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNeIdentifier(String value) {
        this.neIdentifier = value;
    }

    /**
     * Gets the value of the messageTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMessageTimestamp() {
        return messageTimestamp;
    }

    /**
     * Sets the value of the messageTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMessageTimestamp(XMLGregorianCalendar value) {
        this.messageTimestamp = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
