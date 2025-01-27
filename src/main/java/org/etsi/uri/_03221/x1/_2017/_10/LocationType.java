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
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for LocationType complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="LocationType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="beginningAndEnd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         <element name="uponChange" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         <element name="LALS" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationType", propOrder = { "beginningAndEnd", "uponChange", "lals" })
public class LocationType implements Copyable {

  protected Boolean beginningAndEnd;
  protected Boolean uponChange;

  @XmlElement(name = "LALS")
  protected Boolean lals;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public LocationType() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a LocationType copying the state of another LocationType
   *
   * @param _other
   *     The original LocationType from which to copy state.
   */
  public LocationType(final LocationType _other) {
    this.beginningAndEnd = _other.beginningAndEnd;
    this.uponChange = _other.uponChange;
    this.lals = _other.lals;
  }

  /**
   * Gets the value of the beginningAndEnd property.
   *
   * @return
   *     possible object is
   *     {@link Boolean }
   *
   */
  public Boolean isBeginningAndEnd() {
    return beginningAndEnd;
  }

  /**
   * Sets the value of the beginningAndEnd property.
   *
   * @param value
   *     allowed object is
   *     {@link Boolean }
   *
   */
  public void setBeginningAndEnd(Boolean value) {
    this.beginningAndEnd = value;
  }

  /**
   * Gets the value of the uponChange property.
   *
   * @return
   *     possible object is
   *     {@link Boolean }
   *
   */
  public Boolean isUponChange() {
    return uponChange;
  }

  /**
   * Sets the value of the uponChange property.
   *
   * @param value
   *     allowed object is
   *     {@link Boolean }
   *
   */
  public void setUponChange(Boolean value) {
    this.uponChange = value;
  }

  /**
   * Gets the value of the lals property.
   *
   * @return
   *     possible object is
   *     {@link Boolean }
   *
   */
  public Boolean isLALS() {
    return lals;
  }

  /**
   * Sets the value of the lals property.
   *
   * @param value
   *     allowed object is
   *     {@link Boolean }
   *
   */
  public void setLALS(Boolean value) {
    this.lals = value;
  }

  @Override
  public LocationType createCopy() {
    final LocationType _newObject;
    try {
      _newObject = ((LocationType) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.beginningAndEnd = this.beginningAndEnd;
    _newObject.uponChange = this.uponChange;
    _newObject.lals = this.lals;
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final LocationType.Builder<_B> _other) {
    _other.beginningAndEnd = this.beginningAndEnd;
    _other.uponChange = this.uponChange;
    _other.lals = this.lals;
  }

  public <_B> LocationType.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new LocationType.Builder<_B>(_parentBuilder, this, true);
  }

  public LocationType.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static LocationType.Builder<Void> builder() {
    return new LocationType.Builder<>(null, null, false);
  }

  public static <_B> LocationType.Builder<_B> copyOf(final LocationType _other) {
    final LocationType.Builder<_B> _newBuilder = new LocationType.Builder<>(null, null, false);
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
    final LocationType.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree beginningAndEndPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("beginningAndEnd"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (beginningAndEndPropertyTree != null)
          : ((beginningAndEndPropertyTree == null) || (!beginningAndEndPropertyTree.isLeaf())))
    ) {
      _other.beginningAndEnd = this.beginningAndEnd;
    }
    final PropertyTree uponChangePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("uponChange"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (uponChangePropertyTree != null)
          : ((uponChangePropertyTree == null) || (!uponChangePropertyTree.isLeaf())))
    ) {
      _other.uponChange = this.uponChange;
    }
    final PropertyTree lalsPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("lals"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (lalsPropertyTree != null)
          : ((lalsPropertyTree == null) || (!lalsPropertyTree.isLeaf())))
    ) {
      _other.lals = this.lals;
    }
  }

  public <_B> LocationType.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new LocationType.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public LocationType.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> LocationType.Builder<_B> copyOf(
    final LocationType _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final LocationType.Builder<_B> _newBuilder = new LocationType.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static LocationType.Builder<Void> copyExcept(final LocationType _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static LocationType.Builder<Void> copyOnly(final LocationType _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final LocationType _storedValue;
    private Boolean beginningAndEnd;
    private Boolean uponChange;
    private Boolean lals;

    public Builder(final _B _parentBuilder, final LocationType _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.beginningAndEnd = _other.beginningAndEnd;
          this.uponChange = _other.uponChange;
          this.lals = _other.lals;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final LocationType _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree beginningAndEndPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("beginningAndEnd"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (beginningAndEndPropertyTree != null)
                : ((beginningAndEndPropertyTree == null) || (!beginningAndEndPropertyTree.isLeaf())))
          ) {
            this.beginningAndEnd = _other.beginningAndEnd;
          }
          final PropertyTree uponChangePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("uponChange"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (uponChangePropertyTree != null)
                : ((uponChangePropertyTree == null) || (!uponChangePropertyTree.isLeaf())))
          ) {
            this.uponChange = _other.uponChange;
          }
          final PropertyTree lalsPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("lals"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (lalsPropertyTree != null)
                : ((lalsPropertyTree == null) || (!lalsPropertyTree.isLeaf())))
          ) {
            this.lals = _other.lals;
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

    protected <_P extends LocationType> _P init(final _P _product) {
      _product.beginningAndEnd = this.beginningAndEnd;
      _product.uponChange = this.uponChange;
      _product.lals = this.lals;
      return _product;
    }

    /**
     * Sets the new value of "beginningAndEnd" (any previous value will be replaced)
     *
     * @param beginningAndEnd
     *     New value of the "beginningAndEnd" property.
     */
    public LocationType.Builder<_B> withBeginningAndEnd(final Boolean beginningAndEnd) {
      this.beginningAndEnd = beginningAndEnd;
      return this;
    }

    /**
     * Sets the new value of "uponChange" (any previous value will be replaced)
     *
     * @param uponChange
     *     New value of the "uponChange" property.
     */
    public LocationType.Builder<_B> withUponChange(final Boolean uponChange) {
      this.uponChange = uponChange;
      return this;
    }

    /**
     * Sets the new value of "lals" (any previous value will be replaced)
     *
     * @param lals
     *     New value of the "lals" property.
     */
    public LocationType.Builder<_B> withLALS(final Boolean lals) {
      this.lals = lals;
      return this;
    }

    @Override
    public LocationType build() {
      if (_storedValue == null) {
        return this.init(new LocationType());
      } else {
        return ((LocationType) _storedValue);
      }
    }

    public LocationType.Builder<_B> copyOf(final LocationType _other) {
      _other.copyTo(this);
      return this;
    }

    public LocationType.Builder<_B> copyOf(final LocationType.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
