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
@XmlType(name = "ExtensionInformation", propOrder = { "extensionSpecification", "extendedRequestMessageType" })
public class ExtensionInformation implements Copyable {

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected ExtensionSpecification extensionSpecification;

  @XmlElement(required = true)
  protected String extendedRequestMessageType;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ExtensionInformation() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ExtensionInformation copying the state of another ExtensionInformation
   *
   * @param _other
   *     The original ExtensionInformation from which to copy state.
   */
  public ExtensionInformation(final ExtensionInformation _other) {
    this.extensionSpecification = _other.extensionSpecification;
    this.extendedRequestMessageType = _other.extendedRequestMessageType;
  }

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

  @Override
  public ExtensionInformation createCopy() {
    final ExtensionInformation _newObject;
    try {
      _newObject = ((ExtensionInformation) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.extensionSpecification = this.extensionSpecification;
    _newObject.extendedRequestMessageType = this.extendedRequestMessageType;
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final ExtensionInformation.Builder<_B> _other) {
    _other.extensionSpecification = this.extensionSpecification;
    _other.extendedRequestMessageType = this.extendedRequestMessageType;
  }

  public <_B> ExtensionInformation.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ExtensionInformation.Builder<_B>(_parentBuilder, this, true);
  }

  public ExtensionInformation.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ExtensionInformation.Builder<Void> builder() {
    return new ExtensionInformation.Builder<>(null, null, false);
  }

  public static <_B> ExtensionInformation.Builder<_B> copyOf(final ExtensionInformation _other) {
    final ExtensionInformation.Builder<_B> _newBuilder = new ExtensionInformation.Builder<>(null, null, false);
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
    final ExtensionInformation.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree extensionSpecificationPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("extensionSpecification"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (extensionSpecificationPropertyTree != null)
          : ((extensionSpecificationPropertyTree == null) || (!extensionSpecificationPropertyTree.isLeaf())))
    ) {
      _other.extensionSpecification = this.extensionSpecification;
    }
    final PropertyTree extendedRequestMessageTypePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("extendedRequestMessageType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (extendedRequestMessageTypePropertyTree != null)
          : ((extendedRequestMessageTypePropertyTree == null) || (!extendedRequestMessageTypePropertyTree.isLeaf())))
    ) {
      _other.extendedRequestMessageType = this.extendedRequestMessageType;
    }
  }

  public <_B> ExtensionInformation.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ExtensionInformation.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public ExtensionInformation.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ExtensionInformation.Builder<_B> copyOf(
    final ExtensionInformation _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ExtensionInformation.Builder<_B> _newBuilder = new ExtensionInformation.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ExtensionInformation.Builder<Void> copyExcept(
    final ExtensionInformation _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ExtensionInformation.Builder<Void> copyOnly(
    final ExtensionInformation _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final ExtensionInformation _storedValue;
    private ExtensionSpecification extensionSpecification;
    private String extendedRequestMessageType;

    public Builder(final _B _parentBuilder, final ExtensionInformation _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.extensionSpecification = _other.extensionSpecification;
          this.extendedRequestMessageType = _other.extendedRequestMessageType;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final ExtensionInformation _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree extensionSpecificationPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("extensionSpecification"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (extensionSpecificationPropertyTree != null)
                : ((extensionSpecificationPropertyTree == null) || (!extensionSpecificationPropertyTree.isLeaf())))
          ) {
            this.extensionSpecification = _other.extensionSpecification;
          }
          final PropertyTree extendedRequestMessageTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("extendedRequestMessageType"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (extendedRequestMessageTypePropertyTree != null)
                : ((extendedRequestMessageTypePropertyTree == null) ||
                  (!extendedRequestMessageTypePropertyTree.isLeaf())))
          ) {
            this.extendedRequestMessageType = _other.extendedRequestMessageType;
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

    protected <_P extends ExtensionInformation> _P init(final _P _product) {
      _product.extensionSpecification = this.extensionSpecification;
      _product.extendedRequestMessageType = this.extendedRequestMessageType;
      return _product;
    }

    /**
     * Sets the new value of "extensionSpecification" (any previous value will be
     * replaced)
     *
     * @param extensionSpecification
     *     New value of the "extensionSpecification" property.
     */
    public ExtensionInformation.Builder<_B> withExtensionSpecification(
      final ExtensionSpecification extensionSpecification
    ) {
      this.extensionSpecification = extensionSpecification;
      return this;
    }

    /**
     * Sets the new value of "extendedRequestMessageType" (any previous value will be
     * replaced)
     *
     * @param extendedRequestMessageType
     *     New value of the "extendedRequestMessageType" property.
     */
    public ExtensionInformation.Builder<_B> withExtendedRequestMessageType(final String extendedRequestMessageType) {
      this.extendedRequestMessageType = extendedRequestMessageType;
      return this;
    }

    @Override
    public ExtensionInformation build() {
      if (_storedValue == null) {
        return this.init(new ExtensionInformation());
      } else {
        return ((ExtensionInformation) _storedValue);
      }
    }

    public ExtensionInformation.Builder<_B> copyOf(final ExtensionInformation _other) {
      _other.copyTo(this);
      return this;
    }

    public ExtensionInformation.Builder<_B> copyOf(final ExtensionInformation.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
