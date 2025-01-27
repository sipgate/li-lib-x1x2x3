//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03280.common._2017._07;

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

/**
 * <p>Java class for IPAddress complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="IPAddress">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <choice>
 *         <element name="IPv4Address" type="{http://uri.etsi.org/03280/common/2017/07}IPv4Address"/>
 *         <element name="IPv6Address" type="{http://uri.etsi.org/03280/common/2017/07}IPv6Address"/>
 *       </choice>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPAddress", propOrder = { "iPv4Address", "iPv6Address" })
public class IPAddress implements Copyable {

  @XmlElement(name = "IPv4Address")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String iPv4Address;

  @XmlElement(name = "IPv6Address")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String iPv6Address;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public IPAddress() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a IPAddress copying the state of another IPAddress
   *
   * @param _other
   *     The original IPAddress from which to copy state.
   */
  public IPAddress(final IPAddress _other) {
    this.iPv4Address = _other.iPv4Address;
    this.iPv6Address = _other.iPv6Address;
  }

  /**
   * Gets the value of the iPv4Address property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getIPv4Address() {
    return iPv4Address;
  }

  /**
   * Sets the value of the iPv4Address property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setIPv4Address(String value) {
    this.iPv4Address = value;
  }

  /**
   * Gets the value of the iPv6Address property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getIPv6Address() {
    return iPv6Address;
  }

  /**
   * Sets the value of the iPv6Address property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setIPv6Address(String value) {
    this.iPv6Address = value;
  }

  @Override
  public IPAddress createCopy() {
    final IPAddress _newObject;
    try {
      _newObject = ((IPAddress) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.iPv4Address = this.iPv4Address;
    _newObject.iPv6Address = this.iPv6Address;
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final IPAddress.Builder<_B> _other) {
    _other.iPv4Address = this.iPv4Address;
    _other.iPv6Address = this.iPv6Address;
  }

  public <_B> IPAddress.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new IPAddress.Builder<_B>(_parentBuilder, this, true);
  }

  public IPAddress.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static IPAddress.Builder<Void> builder() {
    return new IPAddress.Builder<>(null, null, false);
  }

  public static <_B> IPAddress.Builder<_B> copyOf(final IPAddress _other) {
    final IPAddress.Builder<_B> _newBuilder = new IPAddress.Builder<>(null, null, false);
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
    final IPAddress.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree iPv4AddressPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv4Address"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (iPv4AddressPropertyTree != null)
          : ((iPv4AddressPropertyTree == null) || (!iPv4AddressPropertyTree.isLeaf())))
    ) {
      _other.iPv4Address = this.iPv4Address;
    }
    final PropertyTree iPv6AddressPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv6Address"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (iPv6AddressPropertyTree != null)
          : ((iPv6AddressPropertyTree == null) || (!iPv6AddressPropertyTree.isLeaf())))
    ) {
      _other.iPv6Address = this.iPv6Address;
    }
  }

  public <_B> IPAddress.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new IPAddress.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public IPAddress.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> IPAddress.Builder<_B> copyOf(
    final IPAddress _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final IPAddress.Builder<_B> _newBuilder = new IPAddress.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static IPAddress.Builder<Void> copyExcept(final IPAddress _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static IPAddress.Builder<Void> copyOnly(final IPAddress _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final IPAddress _storedValue;
    private String iPv4Address;
    private String iPv6Address;

    public Builder(final _B _parentBuilder, final IPAddress _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.iPv4Address = _other.iPv4Address;
          this.iPv6Address = _other.iPv6Address;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final IPAddress _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree iPv4AddressPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("iPv4Address"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (iPv4AddressPropertyTree != null)
                : ((iPv4AddressPropertyTree == null) || (!iPv4AddressPropertyTree.isLeaf())))
          ) {
            this.iPv4Address = _other.iPv4Address;
          }
          final PropertyTree iPv6AddressPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("iPv6Address"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (iPv6AddressPropertyTree != null)
                : ((iPv6AddressPropertyTree == null) || (!iPv6AddressPropertyTree.isLeaf())))
          ) {
            this.iPv6Address = _other.iPv6Address;
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

    protected <_P extends IPAddress> _P init(final _P _product) {
      _product.iPv4Address = this.iPv4Address;
      _product.iPv6Address = this.iPv6Address;
      return _product;
    }

    /**
     * Sets the new value of "iPv4Address" (any previous value will be replaced)
     *
     * @param iPv4Address
     *     New value of the "iPv4Address" property.
     */
    public IPAddress.Builder<_B> withIPv4Address(final String iPv4Address) {
      this.iPv4Address = iPv4Address;
      return this;
    }

    /**
     * Sets the new value of "iPv6Address" (any previous value will be replaced)
     *
     * @param iPv6Address
     *     New value of the "iPv6Address" property.
     */
    public IPAddress.Builder<_B> withIPv6Address(final String iPv6Address) {
      this.iPv6Address = iPv6Address;
      return this;
    }

    @Override
    public IPAddress build() {
      if (_storedValue == null) {
        return this.init(new IPAddress());
      } else {
        return ((IPAddress) _storedValue);
      }
    }

    public IPAddress.Builder<_B> copyOf(final IPAddress _other) {
      _other.copyTo(this);
      return this;
    }

    public IPAddress.Builder<_B> copyOf(final IPAddress.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
