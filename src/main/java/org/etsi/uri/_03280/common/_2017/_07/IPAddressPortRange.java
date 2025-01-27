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
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for IPAddressPortRange complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="IPAddressPortRange">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="address" type="{http://uri.etsi.org/03280/common/2017/07}IPAddress"/>
 *         <element name="portRange" type="{http://uri.etsi.org/03280/common/2017/07}PortRange"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPAddressPortRange", propOrder = { "address", "portRange" })
public class IPAddressPortRange implements Copyable {

  @XmlElement(required = true)
  protected IPAddress address;

  @XmlElement(required = true)
  protected PortRange portRange;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public IPAddressPortRange() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a IPAddressPortRange copying the state of another IPAddressPortRange
   *
   * @param _other
   *     The original IPAddressPortRange from which to copy state.
   */
  public IPAddressPortRange(final IPAddressPortRange _other) {
    this.address = ((_other.address == null) ? null : _other.address.createCopy());
    this.portRange = ((_other.portRange == null) ? null : _other.portRange.createCopy());
  }

  /**
   * Gets the value of the address property.
   *
   * @return
   *     possible object is
   *     {@link IPAddress }
   *
   */
  public IPAddress getAddress() {
    return address;
  }

  /**
   * Sets the value of the address property.
   *
   * @param value
   *     allowed object is
   *     {@link IPAddress }
   *
   */
  public void setAddress(IPAddress value) {
    this.address = value;
  }

  /**
   * Gets the value of the portRange property.
   *
   * @return
   *     possible object is
   *     {@link PortRange }
   *
   */
  public PortRange getPortRange() {
    return portRange;
  }

  /**
   * Sets the value of the portRange property.
   *
   * @param value
   *     allowed object is
   *     {@link PortRange }
   *
   */
  public void setPortRange(PortRange value) {
    this.portRange = value;
  }

  @Override
  public IPAddressPortRange createCopy() {
    final IPAddressPortRange _newObject;
    try {
      _newObject = ((IPAddressPortRange) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.address = ((this.address == null) ? null : this.address.createCopy());
    _newObject.portRange = ((this.portRange == null) ? null : this.portRange.createCopy());
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final IPAddressPortRange.Builder<_B> _other) {
    _other.address = ((this.address == null) ? null : this.address.newCopyBuilder(_other));
    _other.portRange = ((this.portRange == null) ? null : this.portRange.newCopyBuilder(_other));
  }

  public <_B> IPAddressPortRange.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new IPAddressPortRange.Builder<_B>(_parentBuilder, this, true);
  }

  public IPAddressPortRange.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static IPAddressPortRange.Builder<Void> builder() {
    return new IPAddressPortRange.Builder<>(null, null, false);
  }

  public static <_B> IPAddressPortRange.Builder<_B> copyOf(final IPAddressPortRange _other) {
    final IPAddressPortRange.Builder<_B> _newBuilder = new IPAddressPortRange.Builder<>(null, null, false);
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
    final IPAddressPortRange.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree addressPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("address"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (addressPropertyTree != null)
          : ((addressPropertyTree == null) || (!addressPropertyTree.isLeaf())))
    ) {
      _other.address = ((this.address == null)
          ? null
          : this.address.newCopyBuilder(_other, addressPropertyTree, _propertyTreeUse));
    }
    final PropertyTree portRangePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("portRange"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (portRangePropertyTree != null)
          : ((portRangePropertyTree == null) || (!portRangePropertyTree.isLeaf())))
    ) {
      _other.portRange = ((this.portRange == null)
          ? null
          : this.portRange.newCopyBuilder(_other, portRangePropertyTree, _propertyTreeUse));
    }
  }

  public <_B> IPAddressPortRange.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new IPAddressPortRange.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public IPAddressPortRange.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> IPAddressPortRange.Builder<_B> copyOf(
    final IPAddressPortRange _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final IPAddressPortRange.Builder<_B> _newBuilder = new IPAddressPortRange.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static IPAddressPortRange.Builder<Void> copyExcept(
    final IPAddressPortRange _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static IPAddressPortRange.Builder<Void> copyOnly(
    final IPAddressPortRange _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final IPAddressPortRange _storedValue;
    private IPAddress.Builder<IPAddressPortRange.Builder<_B>> address;
    private PortRange.Builder<IPAddressPortRange.Builder<_B>> portRange;

    public Builder(final _B _parentBuilder, final IPAddressPortRange _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.address = ((_other.address == null) ? null : _other.address.newCopyBuilder(this));
          this.portRange = ((_other.portRange == null) ? null : _other.portRange.newCopyBuilder(this));
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final IPAddressPortRange _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree addressPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("address"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (addressPropertyTree != null)
                : ((addressPropertyTree == null) || (!addressPropertyTree.isLeaf())))
          ) {
            this.address = ((_other.address == null)
                ? null
                : _other.address.newCopyBuilder(this, addressPropertyTree, _propertyTreeUse));
          }
          final PropertyTree portRangePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("portRange"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (portRangePropertyTree != null)
                : ((portRangePropertyTree == null) || (!portRangePropertyTree.isLeaf())))
          ) {
            this.portRange = ((_other.portRange == null)
                ? null
                : _other.portRange.newCopyBuilder(this, portRangePropertyTree, _propertyTreeUse));
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

    protected <_P extends IPAddressPortRange> _P init(final _P _product) {
      _product.address = ((this.address == null) ? null : this.address.build());
      _product.portRange = ((this.portRange == null) ? null : this.portRange.build());
      return _product;
    }

    /**
     * Sets the new value of "address" (any previous value will be replaced)
     *
     * @param address
     *     New value of the "address" property.
     */
    public IPAddressPortRange.Builder<_B> withAddress(final IPAddress address) {
      this.address = ((address == null) ? null : new IPAddress.Builder<>(this, address, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "address" property.
     * Use {@link org.etsi.uri._03280.common._2017._07.IPAddress.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "address" property.
     *     Use {@link org.etsi.uri._03280.common._2017._07.IPAddress.Builder#end()} to
     *     return to the current builder.
     */
    public IPAddress.Builder<? extends IPAddressPortRange.Builder<_B>> withAddress() {
      if (this.address != null) {
        return this.address;
      }
      return this.address = new IPAddress.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "portRange" (any previous value will be replaced)
     *
     * @param portRange
     *     New value of the "portRange" property.
     */
    public IPAddressPortRange.Builder<_B> withPortRange(final PortRange portRange) {
      this.portRange = ((portRange == null) ? null : new PortRange.Builder<>(this, portRange, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "portRange" property.
     * Use {@link org.etsi.uri._03280.common._2017._07.PortRange.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "portRange" property.
     *     Use {@link org.etsi.uri._03280.common._2017._07.PortRange.Builder#end()} to
     *     return to the current builder.
     */
    public PortRange.Builder<? extends IPAddressPortRange.Builder<_B>> withPortRange() {
      if (this.portRange != null) {
        return this.portRange;
      }
      return this.portRange = new PortRange.Builder<>(this, null, false);
    }

    @Override
    public IPAddressPortRange build() {
      if (_storedValue == null) {
        return this.init(new IPAddressPortRange());
      } else {
        return ((IPAddressPortRange) _storedValue);
      }
    }

    public IPAddressPortRange.Builder<_B> copyOf(final IPAddressPortRange _other) {
      _other.copyTo(this);
      return this;
    }

    public IPAddressPortRange.Builder<_B> copyOf(final IPAddressPortRange.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
