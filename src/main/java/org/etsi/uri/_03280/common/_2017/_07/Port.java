//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.2
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03280.common._2017._07;

import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.Copyable;
import com.kscs.util.jaxb.PartialCopyable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Java class for Port complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="Port">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <choice>
 *         <element name="TCPPort" type="{http://uri.etsi.org/03280/common/2017/07}TCPPort"/>
 *         <element name="UDPPort" type="{http://uri.etsi.org/03280/common/2017/07}UDPPort"/>
 *       </choice>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Port", propOrder = { "tcpPort", "udpPort" })
public class Port implements Copyable, PartialCopyable {

  @XmlElement(name = "TCPPort")
  @XmlSchemaType(name = "integer")
  protected Integer tcpPort;

  @XmlElement(name = "UDPPort")
  @XmlSchemaType(name = "integer")
  protected Integer udpPort;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public Port() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a Port copying the state of another Port
   *
   * @param _other
   *     The original Port from which to copy state.
   */
  public Port(final Port _other) {
    this.tcpPort = _other.tcpPort;
    this.udpPort = _other.udpPort;
  }

  /**
   * Instantiates a Port copying the state of another Port
   *
   * @param _other
   *     The original Port from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public Port(final Port _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final PropertyTree tcpPortPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("tcpPort"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (tcpPortPropertyTree != null)
          : ((tcpPortPropertyTree == null) || (!tcpPortPropertyTree.isLeaf())))
    ) {
      this.tcpPort = _other.tcpPort;
    }
    final PropertyTree udpPortPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("udpPort"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (udpPortPropertyTree != null)
          : ((udpPortPropertyTree == null) || (!udpPortPropertyTree.isLeaf())))
    ) {
      this.udpPort = _other.udpPort;
    }
  }

  /**
   * Gets the value of the tcpPort property.
   *
   * @return
   *     possible object is
   *     {@link Integer }
   *
   */
  public Integer getTCPPort() {
    return tcpPort;
  }

  /**
   * Sets the value of the tcpPort property.
   *
   * @param value
   *     allowed object is
   *     {@link Integer }
   *
   */
  public void setTCPPort(Integer value) {
    this.tcpPort = value;
  }

  /**
   * Gets the value of the udpPort property.
   *
   * @return
   *     possible object is
   *     {@link Integer }
   *
   */
  public Integer getUDPPort() {
    return udpPort;
  }

  /**
   * Sets the value of the udpPort property.
   *
   * @param value
   *     allowed object is
   *     {@link Integer }
   *
   */
  public void setUDPPort(Integer value) {
    this.udpPort = value;
  }

  @Override
  public Port createCopy() {
    final Port _newObject;
    try {
      _newObject = ((Port) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.tcpPort = this.tcpPort;
    _newObject.udpPort = this.udpPort;
    return _newObject;
  }

  @Override
  public Port createCopy(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final Port _newObject;
    try {
      _newObject = ((Port) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    final PropertyTree tcpPortPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("tcpPort"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (tcpPortPropertyTree != null)
          : ((tcpPortPropertyTree == null) || (!tcpPortPropertyTree.isLeaf())))
    ) {
      _newObject.tcpPort = this.tcpPort;
    }
    final PropertyTree udpPortPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("udpPort"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (udpPortPropertyTree != null)
          : ((udpPortPropertyTree == null) || (!udpPortPropertyTree.isLeaf())))
    ) {
      _newObject.udpPort = this.udpPort;
    }
    return _newObject;
  }

  @Override
  public Port copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public Port copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final Port.Builder<_B> _other) {
    _other.tcpPort = this.tcpPort;
    _other.udpPort = this.udpPort;
  }

  public <_B> Port.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new Port.Builder<_B>(_parentBuilder, this, true);
  }

  public Port.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static Port.Builder<Void> builder() {
    return new Port.Builder<>(null, null, false);
  }

  public static <_B> Port.Builder<_B> copyOf(final Port _other) {
    final Port.Builder<_B> _newBuilder = new Port.Builder<>(null, null, false);
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
    final Port.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree tcpPortPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("tcpPort"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (tcpPortPropertyTree != null)
          : ((tcpPortPropertyTree == null) || (!tcpPortPropertyTree.isLeaf())))
    ) {
      _other.tcpPort = this.tcpPort;
    }
    final PropertyTree udpPortPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("udpPort"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (udpPortPropertyTree != null)
          : ((udpPortPropertyTree == null) || (!udpPortPropertyTree.isLeaf())))
    ) {
      _other.udpPort = this.udpPort;
    }
  }

  public <_B> Port.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new Port.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public Port.Builder<Void> newCopyBuilder(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> Port.Builder<_B> copyOf(
    final Port _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final Port.Builder<_B> _newBuilder = new Port.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static Port.Builder<Void> copyExcept(final Port _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static Port.Builder<Void> copyOnly(final Port _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final Port _storedValue;
    private Integer tcpPort;
    private Integer udpPort;

    public Builder(final _B _parentBuilder, final Port _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.tcpPort = _other.tcpPort;
          this.udpPort = _other.udpPort;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final Port _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree tcpPortPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("tcpPort"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (tcpPortPropertyTree != null)
                : ((tcpPortPropertyTree == null) || (!tcpPortPropertyTree.isLeaf())))
          ) {
            this.tcpPort = _other.tcpPort;
          }
          final PropertyTree udpPortPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("udpPort"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (udpPortPropertyTree != null)
                : ((udpPortPropertyTree == null) || (!udpPortPropertyTree.isLeaf())))
          ) {
            this.udpPort = _other.udpPort;
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

    protected <_P extends Port> _P init(final _P _product) {
      _product.tcpPort = this.tcpPort;
      _product.udpPort = this.udpPort;
      return _product;
    }

    /**
     * Sets the new value of "tcpPort" (any previous value will be replaced)
     *
     * @param tcpPort
     *     New value of the "tcpPort" property.
     */
    public Port.Builder<_B> withTCPPort(final Integer tcpPort) {
      this.tcpPort = tcpPort;
      return this;
    }

    /**
     * Sets the new value of "udpPort" (any previous value will be replaced)
     *
     * @param udpPort
     *     New value of the "udpPort" property.
     */
    public Port.Builder<_B> withUDPPort(final Integer udpPort) {
      this.udpPort = udpPort;
      return this;
    }

    @Override
    public Port build() {
      if (_storedValue == null) {
        return this.init(new Port());
      } else {
        return ((Port) _storedValue);
      }
    }

    public Port.Builder<_B> copyOf(final Port _other) {
      _other.copyTo(this);
      return this;
    }

    public Port.Builder<_B> copyOf(final Port.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends Port.Selector<Port.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static Port.Select _root() {
      return new Port.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private com.kscs.util.jaxb.Selector<TRoot, Port.Selector<TRoot, TParent>> tcpPort = null;
    private com.kscs.util.jaxb.Selector<TRoot, Port.Selector<TRoot, TParent>> udpPort = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.tcpPort != null) {
        products.put("tcpPort", this.tcpPort.init());
      }
      if (this.udpPort != null) {
        products.put("udpPort", this.udpPort.init());
      }
      return products;
    }

    public com.kscs.util.jaxb.Selector<TRoot, Port.Selector<TRoot, TParent>> tcpPort() {
      return (
        (this.tcpPort == null)
          ? this.tcpPort = new com.kscs.util.jaxb.Selector<>(this._root, this, "tcpPort")
          : this.tcpPort
      );
    }

    public com.kscs.util.jaxb.Selector<TRoot, Port.Selector<TRoot, TParent>> udpPort() {
      return (
        (this.udpPort == null)
          ? this.udpPort = new com.kscs.util.jaxb.Selector<>(this._root, this, "udpPort")
          : this.udpPort
      );
    }
  }
}
