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
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Java class for IPCIDR complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="IPCIDR">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <choice>
 *         <element name="IPv4CIDR" type="{http://uri.etsi.org/03280/common/2017/07}IPv4CIDR"/>
 *         <element name="IPv6CIDR" type="{http://uri.etsi.org/03280/common/2017/07}IPv6CIDR"/>
 *       </choice>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPCIDR", propOrder = { "iPv4CIDR", "iPv6CIDR" })
public class IPCIDR implements Copyable, PartialCopyable {

  @XmlElement(name = "IPv4CIDR")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String iPv4CIDR;

  @XmlElement(name = "IPv6CIDR")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String iPv6CIDR;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public IPCIDR() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a IPCIDR copying the state of another IPCIDR
   *
   * @param _other
   *     The original IPCIDR from which to copy state.
   */
  public IPCIDR(final IPCIDR _other) {
    this.iPv4CIDR = _other.iPv4CIDR;
    this.iPv6CIDR = _other.iPv6CIDR;
  }

  /**
   * Instantiates a IPCIDR copying the state of another IPCIDR
   *
   * @param _other
   *     The original IPCIDR from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public IPCIDR(final IPCIDR _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final PropertyTree iPv4CIDRPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv4CIDR"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (iPv4CIDRPropertyTree != null)
          : ((iPv4CIDRPropertyTree == null) || (!iPv4CIDRPropertyTree.isLeaf())))
    ) {
      this.iPv4CIDR = _other.iPv4CIDR;
    }
    final PropertyTree iPv6CIDRPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv6CIDR"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (iPv6CIDRPropertyTree != null)
          : ((iPv6CIDRPropertyTree == null) || (!iPv6CIDRPropertyTree.isLeaf())))
    ) {
      this.iPv6CIDR = _other.iPv6CIDR;
    }
  }

  /**
   * Gets the value of the iPv4CIDR property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getIPv4CIDR() {
    return iPv4CIDR;
  }

  /**
   * Sets the value of the iPv4CIDR property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setIPv4CIDR(String value) {
    this.iPv4CIDR = value;
  }

  /**
   * Gets the value of the iPv6CIDR property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getIPv6CIDR() {
    return iPv6CIDR;
  }

  /**
   * Sets the value of the iPv6CIDR property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setIPv6CIDR(String value) {
    this.iPv6CIDR = value;
  }

  @Override
  public IPCIDR createCopy() {
    final IPCIDR _newObject;
    try {
      _newObject = ((IPCIDR) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.iPv4CIDR = this.iPv4CIDR;
    _newObject.iPv6CIDR = this.iPv6CIDR;
    return _newObject;
  }

  @Override
  public IPCIDR createCopy(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final IPCIDR _newObject;
    try {
      _newObject = ((IPCIDR) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    final PropertyTree iPv4CIDRPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv4CIDR"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (iPv4CIDRPropertyTree != null)
          : ((iPv4CIDRPropertyTree == null) || (!iPv4CIDRPropertyTree.isLeaf())))
    ) {
      _newObject.iPv4CIDR = this.iPv4CIDR;
    }
    final PropertyTree iPv6CIDRPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv6CIDR"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (iPv6CIDRPropertyTree != null)
          : ((iPv6CIDRPropertyTree == null) || (!iPv6CIDRPropertyTree.isLeaf())))
    ) {
      _newObject.iPv6CIDR = this.iPv6CIDR;
    }
    return _newObject;
  }

  @Override
  public IPCIDR copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public IPCIDR copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final IPCIDR.Builder<_B> _other) {
    _other.iPv4CIDR = this.iPv4CIDR;
    _other.iPv6CIDR = this.iPv6CIDR;
  }

  public <_B> IPCIDR.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new IPCIDR.Builder<_B>(_parentBuilder, this, true);
  }

  public IPCIDR.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static IPCIDR.Builder<Void> builder() {
    return new IPCIDR.Builder<>(null, null, false);
  }

  public static <_B> IPCIDR.Builder<_B> copyOf(final IPCIDR _other) {
    final IPCIDR.Builder<_B> _newBuilder = new IPCIDR.Builder<>(null, null, false);
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
    final IPCIDR.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree iPv4CIDRPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv4CIDR"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (iPv4CIDRPropertyTree != null)
          : ((iPv4CIDRPropertyTree == null) || (!iPv4CIDRPropertyTree.isLeaf())))
    ) {
      _other.iPv4CIDR = this.iPv4CIDR;
    }
    final PropertyTree iPv6CIDRPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv6CIDR"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (iPv6CIDRPropertyTree != null)
          : ((iPv6CIDRPropertyTree == null) || (!iPv6CIDRPropertyTree.isLeaf())))
    ) {
      _other.iPv6CIDR = this.iPv6CIDR;
    }
  }

  public <_B> IPCIDR.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new IPCIDR.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public IPCIDR.Builder<Void> newCopyBuilder(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> IPCIDR.Builder<_B> copyOf(
    final IPCIDR _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final IPCIDR.Builder<_B> _newBuilder = new IPCIDR.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static IPCIDR.Builder<Void> copyExcept(final IPCIDR _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static IPCIDR.Builder<Void> copyOnly(final IPCIDR _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final IPCIDR _storedValue;
    private String iPv4CIDR;
    private String iPv6CIDR;

    public Builder(final _B _parentBuilder, final IPCIDR _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.iPv4CIDR = _other.iPv4CIDR;
          this.iPv6CIDR = _other.iPv6CIDR;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final IPCIDR _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree iPv4CIDRPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv4CIDR"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (iPv4CIDRPropertyTree != null)
                : ((iPv4CIDRPropertyTree == null) || (!iPv4CIDRPropertyTree.isLeaf())))
          ) {
            this.iPv4CIDR = _other.iPv4CIDR;
          }
          final PropertyTree iPv6CIDRPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("iPv6CIDR"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (iPv6CIDRPropertyTree != null)
                : ((iPv6CIDRPropertyTree == null) || (!iPv6CIDRPropertyTree.isLeaf())))
          ) {
            this.iPv6CIDR = _other.iPv6CIDR;
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

    protected <_P extends IPCIDR> _P init(final _P _product) {
      _product.iPv4CIDR = this.iPv4CIDR;
      _product.iPv6CIDR = this.iPv6CIDR;
      return _product;
    }

    /**
     * Sets the new value of "iPv4CIDR" (any previous value will be replaced)
     *
     * @param iPv4CIDR
     *     New value of the "iPv4CIDR" property.
     */
    public IPCIDR.Builder<_B> withIPv4CIDR(final String iPv4CIDR) {
      this.iPv4CIDR = iPv4CIDR;
      return this;
    }

    /**
     * Sets the new value of "iPv6CIDR" (any previous value will be replaced)
     *
     * @param iPv6CIDR
     *     New value of the "iPv6CIDR" property.
     */
    public IPCIDR.Builder<_B> withIPv6CIDR(final String iPv6CIDR) {
      this.iPv6CIDR = iPv6CIDR;
      return this;
    }

    @Override
    public IPCIDR build() {
      if (_storedValue == null) {
        return this.init(new IPCIDR());
      } else {
        return ((IPCIDR) _storedValue);
      }
    }

    public IPCIDR.Builder<_B> copyOf(final IPCIDR _other) {
      _other.copyTo(this);
      return this;
    }

    public IPCIDR.Builder<_B> copyOf(final IPCIDR.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends IPCIDR.Selector<IPCIDR.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static IPCIDR.Select _root() {
      return new IPCIDR.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private com.kscs.util.jaxb.Selector<TRoot, IPCIDR.Selector<TRoot, TParent>> iPv4CIDR = null;
    private com.kscs.util.jaxb.Selector<TRoot, IPCIDR.Selector<TRoot, TParent>> iPv6CIDR = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.iPv4CIDR != null) {
        products.put("iPv4CIDR", this.iPv4CIDR.init());
      }
      if (this.iPv6CIDR != null) {
        products.put("iPv6CIDR", this.iPv6CIDR.init());
      }
      return products;
    }

    public com.kscs.util.jaxb.Selector<TRoot, IPCIDR.Selector<TRoot, TParent>> iPv4CIDR() {
      return (
        (this.iPv4CIDR == null)
          ? this.iPv4CIDR = new com.kscs.util.jaxb.Selector<>(this._root, this, "iPv4CIDR")
          : this.iPv4CIDR
      );
    }

    public com.kscs.util.jaxb.Selector<TRoot, IPCIDR.Selector<TRoot, TParent>> iPv6CIDR() {
      return (
        (this.iPv6CIDR == null)
          ? this.iPv6CIDR = new com.kscs.util.jaxb.Selector<>(this._root, this, "iPv6CIDR")
          : this.iPv6CIDR
      );
    }
  }
}
