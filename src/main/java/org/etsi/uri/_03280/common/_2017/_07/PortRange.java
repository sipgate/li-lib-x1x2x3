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
 * <p>Java class for PortRange complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="PortRange">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <choice>
 *         <element name="TCPPortRange" type="{http://uri.etsi.org/03280/common/2017/07}TCPPortRange"/>
 *         <element name="UDPPortRange" type="{http://uri.etsi.org/03280/common/2017/07}UDPPortRange"/>
 *       </choice>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PortRange", propOrder = { "tcpPortRange", "udpPortRange" })
public class PortRange implements Copyable {

  @XmlElement(name = "TCPPortRange")
  protected TCPPortRange tcpPortRange;

  @XmlElement(name = "UDPPortRange")
  protected UDPPortRange udpPortRange;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public PortRange() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a PortRange copying the state of another PortRange
   *
   * @param _other
   *     The original PortRange from which to copy state.
   */
  public PortRange(final PortRange _other) {
    this.tcpPortRange = ((_other.tcpPortRange == null) ? null : _other.tcpPortRange.createCopy());
    this.udpPortRange = ((_other.udpPortRange == null) ? null : _other.udpPortRange.createCopy());
  }

  /**
   * Gets the value of the tcpPortRange property.
   *
   * @return
   *     possible object is
   *     {@link TCPPortRange }
   *
   */
  public TCPPortRange getTCPPortRange() {
    return tcpPortRange;
  }

  /**
   * Sets the value of the tcpPortRange property.
   *
   * @param value
   *     allowed object is
   *     {@link TCPPortRange }
   *
   */
  public void setTCPPortRange(TCPPortRange value) {
    this.tcpPortRange = value;
  }

  /**
   * Gets the value of the udpPortRange property.
   *
   * @return
   *     possible object is
   *     {@link UDPPortRange }
   *
   */
  public UDPPortRange getUDPPortRange() {
    return udpPortRange;
  }

  /**
   * Sets the value of the udpPortRange property.
   *
   * @param value
   *     allowed object is
   *     {@link UDPPortRange }
   *
   */
  public void setUDPPortRange(UDPPortRange value) {
    this.udpPortRange = value;
  }

  @Override
  public PortRange createCopy() {
    final PortRange _newObject;
    try {
      _newObject = ((PortRange) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.tcpPortRange = ((this.tcpPortRange == null) ? null : this.tcpPortRange.createCopy());
    _newObject.udpPortRange = ((this.udpPortRange == null) ? null : this.udpPortRange.createCopy());
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final PortRange.Builder<_B> _other) {
    _other.tcpPortRange = ((this.tcpPortRange == null) ? null : this.tcpPortRange.newCopyBuilder(_other));
    _other.udpPortRange = ((this.udpPortRange == null) ? null : this.udpPortRange.newCopyBuilder(_other));
  }

  public <_B> PortRange.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new PortRange.Builder<_B>(_parentBuilder, this, true);
  }

  public PortRange.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static PortRange.Builder<Void> builder() {
    return new PortRange.Builder<>(null, null, false);
  }

  public static <_B> PortRange.Builder<_B> copyOf(final PortRange _other) {
    final PortRange.Builder<_B> _newBuilder = new PortRange.Builder<>(null, null, false);
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
    final PortRange.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree tcpPortRangePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("tcpPortRange"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (tcpPortRangePropertyTree != null)
          : ((tcpPortRangePropertyTree == null) || (!tcpPortRangePropertyTree.isLeaf())))
    ) {
      _other.tcpPortRange = ((this.tcpPortRange == null)
          ? null
          : this.tcpPortRange.newCopyBuilder(_other, tcpPortRangePropertyTree, _propertyTreeUse));
    }
    final PropertyTree udpPortRangePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("udpPortRange"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (udpPortRangePropertyTree != null)
          : ((udpPortRangePropertyTree == null) || (!udpPortRangePropertyTree.isLeaf())))
    ) {
      _other.udpPortRange = ((this.udpPortRange == null)
          ? null
          : this.udpPortRange.newCopyBuilder(_other, udpPortRangePropertyTree, _propertyTreeUse));
    }
  }

  public <_B> PortRange.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new PortRange.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public PortRange.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> PortRange.Builder<_B> copyOf(
    final PortRange _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PortRange.Builder<_B> _newBuilder = new PortRange.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static PortRange.Builder<Void> copyExcept(final PortRange _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static PortRange.Builder<Void> copyOnly(final PortRange _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final PortRange _storedValue;
    private TCPPortRange.Builder<PortRange.Builder<_B>> tcpPortRange;
    private UDPPortRange.Builder<PortRange.Builder<_B>> udpPortRange;

    public Builder(final _B _parentBuilder, final PortRange _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.tcpPortRange = ((_other.tcpPortRange == null) ? null : _other.tcpPortRange.newCopyBuilder(this));
          this.udpPortRange = ((_other.udpPortRange == null) ? null : _other.udpPortRange.newCopyBuilder(this));
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final PortRange _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree tcpPortRangePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("tcpPortRange"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (tcpPortRangePropertyTree != null)
                : ((tcpPortRangePropertyTree == null) || (!tcpPortRangePropertyTree.isLeaf())))
          ) {
            this.tcpPortRange = ((_other.tcpPortRange == null)
                ? null
                : _other.tcpPortRange.newCopyBuilder(this, tcpPortRangePropertyTree, _propertyTreeUse));
          }
          final PropertyTree udpPortRangePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("udpPortRange"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (udpPortRangePropertyTree != null)
                : ((udpPortRangePropertyTree == null) || (!udpPortRangePropertyTree.isLeaf())))
          ) {
            this.udpPortRange = ((_other.udpPortRange == null)
                ? null
                : _other.udpPortRange.newCopyBuilder(this, udpPortRangePropertyTree, _propertyTreeUse));
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

    protected <_P extends PortRange> _P init(final _P _product) {
      _product.tcpPortRange = ((this.tcpPortRange == null) ? null : this.tcpPortRange.build());
      _product.udpPortRange = ((this.udpPortRange == null) ? null : this.udpPortRange.build());
      return _product;
    }

    /**
     * Sets the new value of "tcpPortRange" (any previous value will be replaced)
     *
     * @param tcpPortRange
     *     New value of the "tcpPortRange" property.
     */
    public PortRange.Builder<_B> withTCPPortRange(final TCPPortRange tcpPortRange) {
      this.tcpPortRange = ((tcpPortRange == null) ? null : new TCPPortRange.Builder<>(this, tcpPortRange, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "tcpPortRange" property.
     * Use {@link org.etsi.uri._03280.common._2017._07.TCPPortRange.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "tcpPortRange" property.
     *     Use {@link org.etsi.uri._03280.common._2017._07.TCPPortRange.Builder#end()} to
     *     return to the current builder.
     */
    public TCPPortRange.Builder<? extends PortRange.Builder<_B>> withTCPPortRange() {
      if (this.tcpPortRange != null) {
        return this.tcpPortRange;
      }
      return this.tcpPortRange = new TCPPortRange.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "udpPortRange" (any previous value will be replaced)
     *
     * @param udpPortRange
     *     New value of the "udpPortRange" property.
     */
    public PortRange.Builder<_B> withUDPPortRange(final UDPPortRange udpPortRange) {
      this.udpPortRange = ((udpPortRange == null) ? null : new UDPPortRange.Builder<>(this, udpPortRange, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "udpPortRange" property.
     * Use {@link org.etsi.uri._03280.common._2017._07.UDPPortRange.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "udpPortRange" property.
     *     Use {@link org.etsi.uri._03280.common._2017._07.UDPPortRange.Builder#end()} to
     *     return to the current builder.
     */
    public UDPPortRange.Builder<? extends PortRange.Builder<_B>> withUDPPortRange() {
      if (this.udpPortRange != null) {
        return this.udpPortRange;
      }
      return this.udpPortRange = new UDPPortRange.Builder<>(this, null, false);
    }

    @Override
    public PortRange build() {
      if (_storedValue == null) {
        return this.init(new PortRange());
      } else {
        return ((PortRange) _storedValue);
      }
    }

    public PortRange.Builder<_B> copyOf(final PortRange _other) {
      _other.copyTo(this);
      return this;
    }

    public PortRange.Builder<_B> copyOf(final PortRange.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
