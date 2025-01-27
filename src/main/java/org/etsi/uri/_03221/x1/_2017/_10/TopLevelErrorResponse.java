//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03221.x1._2017._10;

import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.Copyable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

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
@XmlType(
  name = "TopLevelErrorResponse",
  propOrder = { "admfIdentifier", "neIdentifier", "messageTimestamp", "version" }
)
public class TopLevelErrorResponse implements Copyable {

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
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public TopLevelErrorResponse() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a TopLevelErrorResponse copying the state of another TopLevelErrorResponse
   *
   * @param _other
   *     The original TopLevelErrorResponse from which to copy state.
   */
  public TopLevelErrorResponse(final TopLevelErrorResponse _other) {
    this.admfIdentifier = _other.admfIdentifier;
    this.neIdentifier = _other.neIdentifier;
    this.messageTimestamp = ((_other.messageTimestamp == null)
        ? null
        : ((XMLGregorianCalendar) _other.messageTimestamp.clone()));
    this.version = _other.version;
  }

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

  @Override
  public TopLevelErrorResponse createCopy() {
    final TopLevelErrorResponse _newObject;
    try {
      _newObject = ((TopLevelErrorResponse) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.admfIdentifier = this.admfIdentifier;
    _newObject.neIdentifier = this.neIdentifier;
    _newObject.messageTimestamp = ((this.messageTimestamp == null)
        ? null
        : ((XMLGregorianCalendar) this.messageTimestamp.clone()));
    _newObject.version = this.version;
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final TopLevelErrorResponse.Builder<_B> _other) {
    _other.admfIdentifier = this.admfIdentifier;
    _other.neIdentifier = this.neIdentifier;
    _other.messageTimestamp = ((this.messageTimestamp == null)
        ? null
        : ((XMLGregorianCalendar) this.messageTimestamp.clone()));
    _other.version = this.version;
  }

  public <_B> TopLevelErrorResponse.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new TopLevelErrorResponse.Builder<_B>(_parentBuilder, this, true);
  }

  public TopLevelErrorResponse.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static TopLevelErrorResponse.Builder<Void> builder() {
    return new TopLevelErrorResponse.Builder<>(null, null, false);
  }

  public static <_B> TopLevelErrorResponse.Builder<_B> copyOf(final TopLevelErrorResponse _other) {
    final TopLevelErrorResponse.Builder<_B> _newBuilder = new TopLevelErrorResponse.Builder<>(null, null, false);
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(
    final TopLevelErrorResponse.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree admfIdentifierPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("admfIdentifier"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (admfIdentifierPropertyTree != null)
          : ((admfIdentifierPropertyTree == null) || (!admfIdentifierPropertyTree.isLeaf())))
    ) {
      _other.admfIdentifier = this.admfIdentifier;
    }
    final PropertyTree neIdentifierPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("neIdentifier"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (neIdentifierPropertyTree != null)
          : ((neIdentifierPropertyTree == null) || (!neIdentifierPropertyTree.isLeaf())))
    ) {
      _other.neIdentifier = this.neIdentifier;
    }
    final PropertyTree messageTimestampPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("messageTimestamp"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (messageTimestampPropertyTree != null)
          : ((messageTimestampPropertyTree == null) || (!messageTimestampPropertyTree.isLeaf())))
    ) {
      _other.messageTimestamp = ((this.messageTimestamp == null)
          ? null
          : ((XMLGregorianCalendar) this.messageTimestamp.clone()));
    }
    final PropertyTree versionPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("version"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (versionPropertyTree != null)
          : ((versionPropertyTree == null) || (!versionPropertyTree.isLeaf())))
    ) {
      _other.version = this.version;
    }
  }

  public <_B> TopLevelErrorResponse.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new TopLevelErrorResponse.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public TopLevelErrorResponse.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> TopLevelErrorResponse.Builder<_B> copyOf(
    final TopLevelErrorResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final TopLevelErrorResponse.Builder<_B> _newBuilder = new TopLevelErrorResponse.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static TopLevelErrorResponse.Builder<Void> copyExcept(
    final TopLevelErrorResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static TopLevelErrorResponse.Builder<Void> copyOnly(
    final TopLevelErrorResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final TopLevelErrorResponse _storedValue;
    private String admfIdentifier;
    private String neIdentifier;
    private XMLGregorianCalendar messageTimestamp;
    private String version;

    public Builder(final _B _parentBuilder, final TopLevelErrorResponse _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.admfIdentifier = _other.admfIdentifier;
          this.neIdentifier = _other.neIdentifier;
          this.messageTimestamp = ((_other.messageTimestamp == null)
              ? null
              : ((XMLGregorianCalendar) _other.messageTimestamp.clone()));
          this.version = _other.version;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final TopLevelErrorResponse _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree admfIdentifierPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("admfIdentifier"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (admfIdentifierPropertyTree != null)
                : ((admfIdentifierPropertyTree == null) || (!admfIdentifierPropertyTree.isLeaf())))
          ) {
            this.admfIdentifier = _other.admfIdentifier;
          }
          final PropertyTree neIdentifierPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("neIdentifier"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (neIdentifierPropertyTree != null)
                : ((neIdentifierPropertyTree == null) || (!neIdentifierPropertyTree.isLeaf())))
          ) {
            this.neIdentifier = _other.neIdentifier;
          }
          final PropertyTree messageTimestampPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("messageTimestamp"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (messageTimestampPropertyTree != null)
                : ((messageTimestampPropertyTree == null) || (!messageTimestampPropertyTree.isLeaf())))
          ) {
            this.messageTimestamp = ((_other.messageTimestamp == null)
                ? null
                : ((XMLGregorianCalendar) _other.messageTimestamp.clone()));
          }
          final PropertyTree versionPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("version"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (versionPropertyTree != null)
                : ((versionPropertyTree == null) || (!versionPropertyTree.isLeaf())))
          ) {
            this.version = _other.version;
          }
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public _B end() {
      return this._parentBuilder;
    }

    protected <_P extends TopLevelErrorResponse> _P init(final _P _product) {
      _product.admfIdentifier = this.admfIdentifier;
      _product.neIdentifier = this.neIdentifier;
      _product.messageTimestamp = this.messageTimestamp;
      _product.version = this.version;
      return _product;
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    public TopLevelErrorResponse.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
      this.admfIdentifier = admfIdentifier;
      return this;
    }

    /**
     * Sets the new value of "neIdentifier" (any previous value will be replaced)
     *
     * @param neIdentifier
     *     New value of the "neIdentifier" property.
     */
    public TopLevelErrorResponse.Builder<_B> withNeIdentifier(final String neIdentifier) {
      this.neIdentifier = neIdentifier;
      return this;
    }

    /**
     * Sets the new value of "messageTimestamp" (any previous value will be replaced)
     *
     * @param messageTimestamp
     *     New value of the "messageTimestamp" property.
     */
    public TopLevelErrorResponse.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
      this.messageTimestamp = messageTimestamp;
      return this;
    }

    /**
     * Sets the new value of "version" (any previous value will be replaced)
     *
     * @param version
     *     New value of the "version" property.
     */
    public TopLevelErrorResponse.Builder<_B> withVersion(final String version) {
      this.version = version;
      return this;
    }

    @Override
    public TopLevelErrorResponse build() {
      if (_storedValue == null) {
        return this.init(new TopLevelErrorResponse());
      } else {
        return ((TopLevelErrorResponse) _storedValue);
      }
    }

    public TopLevelErrorResponse.Builder<_B> copyOf(final TopLevelErrorResponse _other) {
      _other.copyTo(this);
      return this;
    }

    public TopLevelErrorResponse.Builder<_B> copyOf(final TopLevelErrorResponse.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
