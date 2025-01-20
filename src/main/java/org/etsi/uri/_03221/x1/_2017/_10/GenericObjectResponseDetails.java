//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.2
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

/*
 * SPDX-License-Identifier: MIT
 */
package org.etsi.uri._03221.x1._2017._10;

import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.Copyable;
import com.kscs.util.jaxb.PartialCopyable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Java class for GenericObjectResponseDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="GenericObjectResponseDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="object" type="{http://uri.etsi.org/03221/X1/2017/10}GenericObject"/>
 *         <element name="status" type="{http://uri.etsi.org/03221/X1/2017/10}GenericObjectStatus" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericObjectResponseDetails", propOrder = { "object", "status" })
public class GenericObjectResponseDetails implements Copyable, PartialCopyable {

  @XmlElement(required = true)
  protected GenericObject object;

  protected GenericObjectStatus status;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public GenericObjectResponseDetails() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a GenericObjectResponseDetails copying the state of another GenericObjectResponseDetails
   *
   * @param _other
   *     The original GenericObjectResponseDetails from which to copy state.
   */
  public GenericObjectResponseDetails(final GenericObjectResponseDetails _other) {
    this.object = ((_other.object == null) ? null : _other.object.createCopy());
    this.status = ((_other.status == null) ? null : _other.status.createCopy());
  }

  /**
   * Instantiates a GenericObjectResponseDetails copying the state of another GenericObjectResponseDetails
   *
   * @param _other
   *     The original GenericObjectResponseDetails from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public GenericObjectResponseDetails(
    final GenericObjectResponseDetails _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree objectPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("object"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (objectPropertyTree != null)
          : ((objectPropertyTree == null) || (!objectPropertyTree.isLeaf())))
    ) {
      this.object = ((_other.object == null) ? null : _other.object.createCopy(objectPropertyTree, _propertyTreeUse));
    }
    final PropertyTree statusPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("status"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (statusPropertyTree != null)
          : ((statusPropertyTree == null) || (!statusPropertyTree.isLeaf())))
    ) {
      this.status = ((_other.status == null) ? null : _other.status.createCopy(statusPropertyTree, _propertyTreeUse));
    }
  }

  /**
   * Gets the value of the object property.
   *
   * @return
   *     possible object is
   *     {@link GenericObject }
   *
   */
  public GenericObject getObject() {
    return object;
  }

  /**
   * Sets the value of the object property.
   *
   * @param value
   *     allowed object is
   *     {@link GenericObject }
   *
   */
  public void setObject(GenericObject value) {
    this.object = value;
  }

  /**
   * Gets the value of the status property.
   *
   * @return
   *     possible object is
   *     {@link GenericObjectStatus }
   *
   */
  public GenericObjectStatus getStatus() {
    return status;
  }

  /**
   * Sets the value of the status property.
   *
   * @param value
   *     allowed object is
   *     {@link GenericObjectStatus }
   *
   */
  public void setStatus(GenericObjectStatus value) {
    this.status = value;
  }

  @Override
  public GenericObjectResponseDetails createCopy() {
    final GenericObjectResponseDetails _newObject;
    try {
      _newObject = ((GenericObjectResponseDetails) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.object = ((this.object == null) ? null : this.object.createCopy());
    _newObject.status = ((this.status == null) ? null : this.status.createCopy());
    return _newObject;
  }

  @Override
  public GenericObjectResponseDetails createCopy(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GenericObjectResponseDetails _newObject;
    try {
      _newObject = ((GenericObjectResponseDetails) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    final PropertyTree objectPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("object"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (objectPropertyTree != null)
          : ((objectPropertyTree == null) || (!objectPropertyTree.isLeaf())))
    ) {
      _newObject.object = ((this.object == null) ? null : this.object.createCopy(objectPropertyTree, _propertyTreeUse));
    }
    final PropertyTree statusPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("status"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (statusPropertyTree != null)
          : ((statusPropertyTree == null) || (!statusPropertyTree.isLeaf())))
    ) {
      _newObject.status = ((this.status == null) ? null : this.status.createCopy(statusPropertyTree, _propertyTreeUse));
    }
    return _newObject;
  }

  @Override
  public GenericObjectResponseDetails copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public GenericObjectResponseDetails copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final GenericObjectResponseDetails.Builder<_B> _other) {
    _other.object = ((this.object == null) ? null : this.object.newCopyBuilder(_other));
    _other.status = ((this.status == null) ? null : this.status.newCopyBuilder(_other));
  }

  public <_B> GenericObjectResponseDetails.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new GenericObjectResponseDetails.Builder<_B>(_parentBuilder, this, true);
  }

  public GenericObjectResponseDetails.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static GenericObjectResponseDetails.Builder<Void> builder() {
    return new GenericObjectResponseDetails.Builder<>(null, null, false);
  }

  public static <_B> GenericObjectResponseDetails.Builder<_B> copyOf(final GenericObjectResponseDetails _other) {
    final GenericObjectResponseDetails.Builder<_B> _newBuilder = new GenericObjectResponseDetails.Builder<>(
      null,
      null,
      false
    );
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
    final GenericObjectResponseDetails.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree objectPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("object"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (objectPropertyTree != null)
          : ((objectPropertyTree == null) || (!objectPropertyTree.isLeaf())))
    ) {
      _other.object = ((this.object == null)
          ? null
          : this.object.newCopyBuilder(_other, objectPropertyTree, _propertyTreeUse));
    }
    final PropertyTree statusPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("status"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (statusPropertyTree != null)
          : ((statusPropertyTree == null) || (!statusPropertyTree.isLeaf())))
    ) {
      _other.status = ((this.status == null)
          ? null
          : this.status.newCopyBuilder(_other, statusPropertyTree, _propertyTreeUse));
    }
  }

  public <_B> GenericObjectResponseDetails.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new GenericObjectResponseDetails.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public GenericObjectResponseDetails.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> GenericObjectResponseDetails.Builder<_B> copyOf(
    final GenericObjectResponseDetails _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GenericObjectResponseDetails.Builder<_B> _newBuilder = new GenericObjectResponseDetails.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static GenericObjectResponseDetails.Builder<Void> copyExcept(
    final GenericObjectResponseDetails _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GenericObjectResponseDetails.Builder<Void> copyOnly(
    final GenericObjectResponseDetails _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final GenericObjectResponseDetails _storedValue;
    private GenericObject.Builder<GenericObjectResponseDetails.Builder<_B>> object;
    private GenericObjectStatus.Builder<GenericObjectResponseDetails.Builder<_B>> status;

    public Builder(final _B _parentBuilder, final GenericObjectResponseDetails _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.object = ((_other.object == null) ? null : _other.object.newCopyBuilder(this));
          this.status = ((_other.status == null) ? null : _other.status.newCopyBuilder(this));
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final GenericObjectResponseDetails _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree objectPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("object"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (objectPropertyTree != null)
                : ((objectPropertyTree == null) || (!objectPropertyTree.isLeaf())))
          ) {
            this.object = ((_other.object == null)
                ? null
                : _other.object.newCopyBuilder(this, objectPropertyTree, _propertyTreeUse));
          }
          final PropertyTree statusPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("status"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (statusPropertyTree != null)
                : ((statusPropertyTree == null) || (!statusPropertyTree.isLeaf())))
          ) {
            this.status = ((_other.status == null)
                ? null
                : _other.status.newCopyBuilder(this, statusPropertyTree, _propertyTreeUse));
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

    protected <_P extends GenericObjectResponseDetails> _P init(final _P _product) {
      _product.object = ((this.object == null) ? null : this.object.build());
      _product.status = ((this.status == null) ? null : this.status.build());
      return _product;
    }

    /**
     * Sets the new value of "object" (any previous value will be replaced)
     *
     * @param object
     *     New value of the "object" property.
     */
    public GenericObjectResponseDetails.Builder<_B> withObject(final GenericObject object) {
      this.object = ((object == null) ? null : new GenericObject.Builder<>(this, object, false));
      return this;
    }

    /**
     * Sets the new value of "status" (any previous value will be replaced)
     *
     * @param status
     *     New value of the "status" property.
     */
    public GenericObjectResponseDetails.Builder<_B> withStatus(final GenericObjectStatus status) {
      this.status = ((status == null) ? null : new GenericObjectStatus.Builder<>(this, status, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "status"
     * property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.GenericObjectStatus.Builder#end()}
     * to return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "status" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.GenericObjectStatus.Builder#end()}
     *     to return to the current builder.
     */
    public GenericObjectStatus.Builder<? extends GenericObjectResponseDetails.Builder<_B>> withStatus() {
      if (this.status != null) {
        return this.status;
      }
      return this.status = new GenericObjectStatus.Builder<>(this, null, false);
    }

    @Override
    public GenericObjectResponseDetails build() {
      if (_storedValue == null) {
        return this.init(new GenericObjectResponseDetails());
      } else {
        return ((GenericObjectResponseDetails) _storedValue);
      }
    }

    public GenericObjectResponseDetails.Builder<_B> copyOf(final GenericObjectResponseDetails _other) {
      _other.copyTo(this);
      return this;
    }

    public GenericObjectResponseDetails.Builder<_B> copyOf(final GenericObjectResponseDetails.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends GenericObjectResponseDetails.Selector<GenericObjectResponseDetails.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static GenericObjectResponseDetails.Select _root() {
      return new GenericObjectResponseDetails.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private GenericObject.Selector<TRoot, GenericObjectResponseDetails.Selector<TRoot, TParent>> object = null;
    private GenericObjectStatus.Selector<TRoot, GenericObjectResponseDetails.Selector<TRoot, TParent>> status = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.object != null) {
        products.put("object", this.object.init());
      }
      if (this.status != null) {
        products.put("status", this.status.init());
      }
      return products;
    }

    public GenericObject.Selector<TRoot, GenericObjectResponseDetails.Selector<TRoot, TParent>> object() {
      return (
        (this.object == null) ? this.object = new GenericObject.Selector<>(this._root, this, "object") : this.object
      );
    }

    public GenericObjectStatus.Selector<TRoot, GenericObjectResponseDetails.Selector<TRoot, TParent>> status() {
      return (
        (this.status == null)
          ? this.status = new GenericObjectStatus.Selector<>(this._root, this, "status")
          : this.status
      );
    }
  }
}
