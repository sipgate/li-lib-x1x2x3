//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03221.x1._2017._10.hashedid;

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
import jakarta.xml.bind.annotation.adapters.HexBinaryAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>Java class for HashedIdentifier complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="HashedIdentifier">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="hashContextID" type="{http://uri.etsi.org/03221/X1/2017/10}GenericObjectID"/>
 *         <element name="targetIdentityType" type="{http://uri.etsi.org/03280/common/2017/07}ShortString"/>
 *         <element name="hashDigest" type="{http://www.w3.org/2001/XMLSchema}hexBinary"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HashedIdentifier", propOrder = { "hashContextID", "targetIdentityType", "hashDigest" })
public class HashedIdentifier implements Copyable {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String hashContextID;

  @XmlElement(required = true)
  protected String targetIdentityType;

  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(HexBinaryAdapter.class)
  @XmlSchemaType(name = "hexBinary")
  protected byte[] hashDigest;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public HashedIdentifier() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a HashedIdentifier copying the state of another HashedIdentifier
   *
   * @param _other
   *     The original HashedIdentifier from which to copy state.
   */
  public HashedIdentifier(final HashedIdentifier _other) {
    this.hashContextID = _other.hashContextID;
    this.targetIdentityType = _other.targetIdentityType;
    this.hashDigest = _other.hashDigest;
  }

  /**
   * Gets the value of the hashContextID property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getHashContextID() {
    return hashContextID;
  }

  /**
   * Sets the value of the hashContextID property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setHashContextID(String value) {
    this.hashContextID = value;
  }

  /**
   * Gets the value of the targetIdentityType property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getTargetIdentityType() {
    return targetIdentityType;
  }

  /**
   * Sets the value of the targetIdentityType property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setTargetIdentityType(String value) {
    this.targetIdentityType = value;
  }

  /**
   * Gets the value of the hashDigest property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public byte[] getHashDigest() {
    return hashDigest;
  }

  /**
   * Sets the value of the hashDigest property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setHashDigest(byte[] value) {
    this.hashDigest = value;
  }

  @Override
  public HashedIdentifier createCopy() {
    final HashedIdentifier _newObject;
    try {
      _newObject = ((HashedIdentifier) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.hashContextID = this.hashContextID;
    _newObject.targetIdentityType = this.targetIdentityType;
    _newObject.hashDigest = this.hashDigest;
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final HashedIdentifier.Builder<_B> _other) {
    _other.hashContextID = this.hashContextID;
    _other.targetIdentityType = this.targetIdentityType;
    _other.hashDigest = this.hashDigest;
  }

  public <_B> HashedIdentifier.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new HashedIdentifier.Builder<_B>(_parentBuilder, this, true);
  }

  public HashedIdentifier.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static HashedIdentifier.Builder<Void> builder() {
    return new HashedIdentifier.Builder<>(null, null, false);
  }

  public static <_B> HashedIdentifier.Builder<_B> copyOf(final HashedIdentifier _other) {
    final HashedIdentifier.Builder<_B> _newBuilder = new HashedIdentifier.Builder<>(null, null, false);
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
    final HashedIdentifier.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree hashContextIDPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("hashContextID"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (hashContextIDPropertyTree != null)
          : ((hashContextIDPropertyTree == null) || (!hashContextIDPropertyTree.isLeaf())))
    ) {
      _other.hashContextID = this.hashContextID;
    }
    final PropertyTree targetIdentityTypePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("targetIdentityType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (targetIdentityTypePropertyTree != null)
          : ((targetIdentityTypePropertyTree == null) || (!targetIdentityTypePropertyTree.isLeaf())))
    ) {
      _other.targetIdentityType = this.targetIdentityType;
    }
    final PropertyTree hashDigestPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("hashDigest"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (hashDigestPropertyTree != null)
          : ((hashDigestPropertyTree == null) || (!hashDigestPropertyTree.isLeaf())))
    ) {
      _other.hashDigest = this.hashDigest;
    }
  }

  public <_B> HashedIdentifier.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new HashedIdentifier.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public HashedIdentifier.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> HashedIdentifier.Builder<_B> copyOf(
    final HashedIdentifier _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final HashedIdentifier.Builder<_B> _newBuilder = new HashedIdentifier.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static HashedIdentifier.Builder<Void> copyExcept(
    final HashedIdentifier _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static HashedIdentifier.Builder<Void> copyOnly(
    final HashedIdentifier _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final HashedIdentifier _storedValue;
    private String hashContextID;
    private String targetIdentityType;
    private byte[] hashDigest;

    public Builder(final _B _parentBuilder, final HashedIdentifier _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.hashContextID = _other.hashContextID;
          this.targetIdentityType = _other.targetIdentityType;
          this.hashDigest = _other.hashDigest;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final HashedIdentifier _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree hashContextIDPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("hashContextID"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (hashContextIDPropertyTree != null)
                : ((hashContextIDPropertyTree == null) || (!hashContextIDPropertyTree.isLeaf())))
          ) {
            this.hashContextID = _other.hashContextID;
          }
          final PropertyTree targetIdentityTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("targetIdentityType"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (targetIdentityTypePropertyTree != null)
                : ((targetIdentityTypePropertyTree == null) || (!targetIdentityTypePropertyTree.isLeaf())))
          ) {
            this.targetIdentityType = _other.targetIdentityType;
          }
          final PropertyTree hashDigestPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("hashDigest"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (hashDigestPropertyTree != null)
                : ((hashDigestPropertyTree == null) || (!hashDigestPropertyTree.isLeaf())))
          ) {
            this.hashDigest = _other.hashDigest;
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

    protected <_P extends HashedIdentifier> _P init(final _P _product) {
      _product.hashContextID = this.hashContextID;
      _product.targetIdentityType = this.targetIdentityType;
      _product.hashDigest = this.hashDigest;
      return _product;
    }

    /**
     * Sets the new value of "hashContextID" (any previous value will be replaced)
     *
     * @param hashContextID
     *     New value of the "hashContextID" property.
     */
    public HashedIdentifier.Builder<_B> withHashContextID(final String hashContextID) {
      this.hashContextID = hashContextID;
      return this;
    }

    /**
     * Sets the new value of "targetIdentityType" (any previous value will be replaced)
     *
     * @param targetIdentityType
     *     New value of the "targetIdentityType" property.
     */
    public HashedIdentifier.Builder<_B> withTargetIdentityType(final String targetIdentityType) {
      this.targetIdentityType = targetIdentityType;
      return this;
    }

    /**
     * Sets the new value of "hashDigest" (any previous value will be replaced)
     *
     * @param hashDigest
     *     New value of the "hashDigest" property.
     */
    public HashedIdentifier.Builder<_B> withHashDigest(final byte[] hashDigest) {
      this.hashDigest = hashDigest;
      return this;
    }

    @Override
    public HashedIdentifier build() {
      if (_storedValue == null) {
        return this.init(new HashedIdentifier());
      } else {
        return ((HashedIdentifier) _storedValue);
      }
    }

    public HashedIdentifier.Builder<_B> copyOf(final HashedIdentifier _other) {
      _other.copyTo(this);
      return this;
    }

    public HashedIdentifier.Builder<_B> copyOf(final HashedIdentifier.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
