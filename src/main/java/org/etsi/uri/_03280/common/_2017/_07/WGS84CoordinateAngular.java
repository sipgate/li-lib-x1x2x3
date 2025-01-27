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
 * <p>Java class for WGS84CoordinateAngular complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="WGS84CoordinateAngular">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="latitude" type="{http://uri.etsi.org/03280/common/2017/07}WGS84LatitudeAngular"/>
 *         <element name="longitude" type="{http://uri.etsi.org/03280/common/2017/07}WGS84LongitudeAngular"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WGS84CoordinateAngular", propOrder = { "latitude", "longitude" })
public class WGS84CoordinateAngular implements Copyable {

  @XmlElement(required = true)
  protected String latitude;

  @XmlElement(required = true)
  protected String longitude;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public WGS84CoordinateAngular() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a WGS84CoordinateAngular copying the state of another WGS84CoordinateAngular
   *
   * @param _other
   *     The original WGS84CoordinateAngular from which to copy state.
   */
  public WGS84CoordinateAngular(final WGS84CoordinateAngular _other) {
    this.latitude = _other.latitude;
    this.longitude = _other.longitude;
  }

  /**
   * Gets the value of the latitude property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * Sets the value of the latitude property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setLatitude(String value) {
    this.latitude = value;
  }

  /**
   * Gets the value of the longitude property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * Sets the value of the longitude property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setLongitude(String value) {
    this.longitude = value;
  }

  @Override
  public WGS84CoordinateAngular createCopy() {
    final WGS84CoordinateAngular _newObject;
    try {
      _newObject = ((WGS84CoordinateAngular) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.latitude = this.latitude;
    _newObject.longitude = this.longitude;
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final WGS84CoordinateAngular.Builder<_B> _other) {
    _other.latitude = this.latitude;
    _other.longitude = this.longitude;
  }

  public <_B> WGS84CoordinateAngular.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new WGS84CoordinateAngular.Builder<_B>(_parentBuilder, this, true);
  }

  public WGS84CoordinateAngular.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static WGS84CoordinateAngular.Builder<Void> builder() {
    return new WGS84CoordinateAngular.Builder<>(null, null, false);
  }

  public static <_B> WGS84CoordinateAngular.Builder<_B> copyOf(final WGS84CoordinateAngular _other) {
    final WGS84CoordinateAngular.Builder<_B> _newBuilder = new WGS84CoordinateAngular.Builder<>(null, null, false);
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
    final WGS84CoordinateAngular.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree latitudePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("latitude"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (latitudePropertyTree != null)
          : ((latitudePropertyTree == null) || (!latitudePropertyTree.isLeaf())))
    ) {
      _other.latitude = this.latitude;
    }
    final PropertyTree longitudePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("longitude"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (longitudePropertyTree != null)
          : ((longitudePropertyTree == null) || (!longitudePropertyTree.isLeaf())))
    ) {
      _other.longitude = this.longitude;
    }
  }

  public <_B> WGS84CoordinateAngular.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new WGS84CoordinateAngular.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public WGS84CoordinateAngular.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> WGS84CoordinateAngular.Builder<_B> copyOf(
    final WGS84CoordinateAngular _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final WGS84CoordinateAngular.Builder<_B> _newBuilder = new WGS84CoordinateAngular.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static WGS84CoordinateAngular.Builder<Void> copyExcept(
    final WGS84CoordinateAngular _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static WGS84CoordinateAngular.Builder<Void> copyOnly(
    final WGS84CoordinateAngular _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final WGS84CoordinateAngular _storedValue;
    private String latitude;
    private String longitude;

    public Builder(final _B _parentBuilder, final WGS84CoordinateAngular _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.latitude = _other.latitude;
          this.longitude = _other.longitude;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final WGS84CoordinateAngular _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree latitudePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("latitude"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (latitudePropertyTree != null)
                : ((latitudePropertyTree == null) || (!latitudePropertyTree.isLeaf())))
          ) {
            this.latitude = _other.latitude;
          }
          final PropertyTree longitudePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("longitude"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (longitudePropertyTree != null)
                : ((longitudePropertyTree == null) || (!longitudePropertyTree.isLeaf())))
          ) {
            this.longitude = _other.longitude;
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

    protected <_P extends WGS84CoordinateAngular> _P init(final _P _product) {
      _product.latitude = this.latitude;
      _product.longitude = this.longitude;
      return _product;
    }

    /**
     * Sets the new value of "latitude" (any previous value will be replaced)
     *
     * @param latitude
     *     New value of the "latitude" property.
     */
    public WGS84CoordinateAngular.Builder<_B> withLatitude(final String latitude) {
      this.latitude = latitude;
      return this;
    }

    /**
     * Sets the new value of "longitude" (any previous value will be replaced)
     *
     * @param longitude
     *     New value of the "longitude" property.
     */
    public WGS84CoordinateAngular.Builder<_B> withLongitude(final String longitude) {
      this.longitude = longitude;
      return this;
    }

    @Override
    public WGS84CoordinateAngular build() {
      if (_storedValue == null) {
        return this.init(new WGS84CoordinateAngular());
      } else {
        return ((WGS84CoordinateAngular) _storedValue);
      }
    }

    public WGS84CoordinateAngular.Builder<_B> copyOf(final WGS84CoordinateAngular _other) {
      _other.copyTo(this);
      return this;
    }

    public WGS84CoordinateAngular.Builder<_B> copyOf(final WGS84CoordinateAngular.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
