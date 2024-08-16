//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.2
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03221.x1._2017._10;

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
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for ModifyObjectResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="ModifyObjectResponse">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage">
 *       <sequence>
 *         <element name="oK" type="{http://uri.etsi.org/03221/X1/2017/10}OK"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifyObjectResponse", propOrder = { "ok" })
public class ModifyObjectResponse extends X1ResponseMessage implements Copyable, PartialCopyable {

  @XmlElement(name = "oK", required = true)
  @XmlSchemaType(name = "string")
  protected OK ok;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ModifyObjectResponse() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ModifyObjectResponse copying the state of another ModifyObjectResponse
   *
   * @param _other
   *     The original ModifyObjectResponse from which to copy state.
   */
  public ModifyObjectResponse(final ModifyObjectResponse _other) {
    super(_other);
    this.ok = _other.ok;
  }

  /**
   * Instantiates a ModifyObjectResponse copying the state of another ModifyObjectResponse
   *
   * @param _other
   *     The original ModifyObjectResponse from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public ModifyObjectResponse(
    final ModifyObjectResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree okPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("ok"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (okPropertyTree != null)
          : ((okPropertyTree == null) || (!okPropertyTree.isLeaf())))
    ) {
      this.ok = _other.ok;
    }
  }

  /**
   * Gets the value of the ok property.
   *
   * @return
   *     possible object is
   *     {@link OK }
   *
   */
  public OK getOK() {
    return ok;
  }

  /**
   * Sets the value of the ok property.
   *
   * @param value
   *     allowed object is
   *     {@link OK }
   *
   */
  public void setOK(OK value) {
    this.ok = value;
  }

  @Override
  public ModifyObjectResponse createCopy() {
    final ModifyObjectResponse _newObject = ((ModifyObjectResponse) super.createCopy());
    _newObject.ok = this.ok;
    return _newObject;
  }

  @Override
  public ModifyObjectResponse createCopy(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final ModifyObjectResponse _newObject = ((ModifyObjectResponse) super.createCopy(_propertyTree, _propertyTreeUse));
    final PropertyTree okPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("ok"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (okPropertyTree != null)
          : ((okPropertyTree == null) || (!okPropertyTree.isLeaf())))
    ) {
      _newObject.ok = this.ok;
    }
    return _newObject;
  }

  @Override
  public ModifyObjectResponse copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public ModifyObjectResponse copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final ModifyObjectResponse.Builder<_B> _other) {
    super.copyTo(_other);
    _other.ok = this.ok;
  }

  @Override
  public <_B> ModifyObjectResponse.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ModifyObjectResponse.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public ModifyObjectResponse.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ModifyObjectResponse.Builder<Void> builder() {
    return new ModifyObjectResponse.Builder<>(null, null, false);
  }

  public static <_B> ModifyObjectResponse.Builder<_B> copyOf(final X1ResponseMessage _other) {
    final ModifyObjectResponse.Builder<_B> _newBuilder = new ModifyObjectResponse.Builder<>(null, null, false);
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> ModifyObjectResponse.Builder<_B> copyOf(final ModifyObjectResponse _other) {
    final ModifyObjectResponse.Builder<_B> _newBuilder = new ModifyObjectResponse.Builder<>(null, null, false);
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
    final ModifyObjectResponse.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree okPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("ok"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (okPropertyTree != null)
          : ((okPropertyTree == null) || (!okPropertyTree.isLeaf())))
    ) {
      _other.ok = this.ok;
    }
  }

  @Override
  public <_B> ModifyObjectResponse.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ModifyObjectResponse.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public ModifyObjectResponse.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ModifyObjectResponse.Builder<_B> copyOf(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ModifyObjectResponse.Builder<_B> _newBuilder = new ModifyObjectResponse.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> ModifyObjectResponse.Builder<_B> copyOf(
    final ModifyObjectResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ModifyObjectResponse.Builder<_B> _newBuilder = new ModifyObjectResponse.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ModifyObjectResponse.Builder<Void> copyExcept(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ModifyObjectResponse.Builder<Void> copyExcept(
    final ModifyObjectResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ModifyObjectResponse.Builder<Void> copyOnly(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static ModifyObjectResponse.Builder<Void> copyOnly(
    final ModifyObjectResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1ResponseMessage.Builder<_B> implements Buildable {

    private OK ok;

    public Builder(final _B _parentBuilder, final ModifyObjectResponse _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {
        this.ok = _other.ok;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final ModifyObjectResponse _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {
        final PropertyTree okPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("ok"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (okPropertyTree != null)
              : ((okPropertyTree == null) || (!okPropertyTree.isLeaf())))
        ) {
          this.ok = _other.ok;
        }
      }
    }

    protected <_P extends ModifyObjectResponse> _P init(final _P _product) {
      _product.ok = this.ok;
      return super.init(_product);
    }

    /**
     * Sets the new value of "ok" (any previous value will be replaced)
     *
     * @param ok
     *     New value of the "ok" property.
     */
    public ModifyObjectResponse.Builder<_B> withOK(final OK ok) {
      this.ok = ok;
      return this;
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public ModifyObjectResponse.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
      super.withAdmfIdentifier(admfIdentifier);
      return this;
    }

    /**
     * Sets the new value of "neIdentifier" (any previous value will be replaced)
     *
     * @param neIdentifier
     *     New value of the "neIdentifier" property.
     */
    @Override
    public ModifyObjectResponse.Builder<_B> withNeIdentifier(final String neIdentifier) {
      super.withNeIdentifier(neIdentifier);
      return this;
    }

    /**
     * Sets the new value of "messageTimestamp" (any previous value will be replaced)
     *
     * @param messageTimestamp
     *     New value of the "messageTimestamp" property.
     */
    @Override
    public ModifyObjectResponse.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
      super.withMessageTimestamp(messageTimestamp);
      return this;
    }

    /**
     * Sets the new value of "version" (any previous value will be replaced)
     *
     * @param version
     *     New value of the "version" property.
     */
    @Override
    public ModifyObjectResponse.Builder<_B> withVersion(final String version) {
      super.withVersion(version);
      return this;
    }

    /**
     * Sets the new value of "x1TransactionId" (any previous value will be replaced)
     *
     * @param x1TransactionId
     *     New value of the "x1TransactionId" property.
     */
    @Override
    public ModifyObjectResponse.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public ModifyObjectResponse build() {
      if (_storedValue == null) {
        return this.init(new ModifyObjectResponse());
      } else {
        return ((ModifyObjectResponse) _storedValue);
      }
    }

    public ModifyObjectResponse.Builder<_B> copyOf(final ModifyObjectResponse _other) {
      _other.copyTo(this);
      return this;
    }

    public ModifyObjectResponse.Builder<_B> copyOf(final ModifyObjectResponse.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends ModifyObjectResponse.Selector<ModifyObjectResponse.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static ModifyObjectResponse.Select _root() {
      return new ModifyObjectResponse.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends X1ResponseMessage.Selector<TRoot, TParent> {

    private com.kscs.util.jaxb.Selector<TRoot, ModifyObjectResponse.Selector<TRoot, TParent>> ok = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.ok != null) {
        products.put("ok", this.ok.init());
      }
      return products;
    }

    public com.kscs.util.jaxb.Selector<TRoot, ModifyObjectResponse.Selector<TRoot, TParent>> ok() {
      return ((this.ok == null) ? this.ok = new com.kscs.util.jaxb.Selector<>(this._root, this, "ok") : this.ok);
    }
  }
}
