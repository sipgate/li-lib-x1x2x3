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
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for ServiceScopingOptions complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="ServiceScopingOptions">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="serviceType" type="{http://uri.etsi.org/03221/X1/2017/10}ListOfServiceTypes" minOccurs="0"/>
 *         <element name="locationType" type="{http://uri.etsi.org/03221/X1/2017/10}LocationTypeOptions" minOccurs="0"/>
 *         <element name="suspendOnOutboundInternationalRoaming" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         <element name="reportPostDialledDigits" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "ServiceScopingOptions",
  propOrder = { "serviceType", "locationType", "suspendOnOutboundInternationalRoaming", "reportPostDialledDigits" }
)
public class ServiceScopingOptions implements Copyable {

  protected ListOfServiceTypes serviceType;
  protected LocationTypeOptions locationType;
  protected Boolean suspendOnOutboundInternationalRoaming;
  protected Boolean reportPostDialledDigits;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ServiceScopingOptions() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ServiceScopingOptions copying the state of another ServiceScopingOptions
   *
   * @param _other
   *     The original ServiceScopingOptions from which to copy state.
   */
  public ServiceScopingOptions(final ServiceScopingOptions _other) {
    this.serviceType = ((_other.serviceType == null) ? null : _other.serviceType.createCopy());
    this.locationType = ((_other.locationType == null) ? null : _other.locationType.createCopy());
    this.suspendOnOutboundInternationalRoaming = _other.suspendOnOutboundInternationalRoaming;
    this.reportPostDialledDigits = _other.reportPostDialledDigits;
  }

  /**
   * Gets the value of the serviceType property.
   *
   * @return
   *     possible object is
   *     {@link ListOfServiceTypes }
   *
   */
  public ListOfServiceTypes getServiceType() {
    return serviceType;
  }

  /**
   * Sets the value of the serviceType property.
   *
   * @param value
   *     allowed object is
   *     {@link ListOfServiceTypes }
   *
   */
  public void setServiceType(ListOfServiceTypes value) {
    this.serviceType = value;
  }

  /**
   * Gets the value of the locationType property.
   *
   * @return
   *     possible object is
   *     {@link LocationTypeOptions }
   *
   */
  public LocationTypeOptions getLocationType() {
    return locationType;
  }

  /**
   * Sets the value of the locationType property.
   *
   * @param value
   *     allowed object is
   *     {@link LocationTypeOptions }
   *
   */
  public void setLocationType(LocationTypeOptions value) {
    this.locationType = value;
  }

  /**
   * Gets the value of the suspendOnOutboundInternationalRoaming property.
   *
   * @return
   *     possible object is
   *     {@link Boolean }
   *
   */
  public Boolean isSuspendOnOutboundInternationalRoaming() {
    return suspendOnOutboundInternationalRoaming;
  }

  /**
   * Sets the value of the suspendOnOutboundInternationalRoaming property.
   *
   * @param value
   *     allowed object is
   *     {@link Boolean }
   *
   */
  public void setSuspendOnOutboundInternationalRoaming(Boolean value) {
    this.suspendOnOutboundInternationalRoaming = value;
  }

  /**
   * Gets the value of the reportPostDialledDigits property.
   *
   * @return
   *     possible object is
   *     {@link Boolean }
   *
   */
  public Boolean isReportPostDialledDigits() {
    return reportPostDialledDigits;
  }

  /**
   * Sets the value of the reportPostDialledDigits property.
   *
   * @param value
   *     allowed object is
   *     {@link Boolean }
   *
   */
  public void setReportPostDialledDigits(Boolean value) {
    this.reportPostDialledDigits = value;
  }

  @Override
  public ServiceScopingOptions createCopy() {
    final ServiceScopingOptions _newObject;
    try {
      _newObject = ((ServiceScopingOptions) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.serviceType = ((this.serviceType == null) ? null : this.serviceType.createCopy());
    _newObject.locationType = ((this.locationType == null) ? null : this.locationType.createCopy());
    _newObject.suspendOnOutboundInternationalRoaming = this.suspendOnOutboundInternationalRoaming;
    _newObject.reportPostDialledDigits = this.reportPostDialledDigits;
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final ServiceScopingOptions.Builder<_B> _other) {
    _other.serviceType = ((this.serviceType == null) ? null : this.serviceType.newCopyBuilder(_other));
    _other.locationType = ((this.locationType == null) ? null : this.locationType.newCopyBuilder(_other));
    _other.suspendOnOutboundInternationalRoaming = this.suspendOnOutboundInternationalRoaming;
    _other.reportPostDialledDigits = this.reportPostDialledDigits;
  }

  public <_B> ServiceScopingOptions.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ServiceScopingOptions.Builder<_B>(_parentBuilder, this, true);
  }

  public ServiceScopingOptions.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ServiceScopingOptions.Builder<Void> builder() {
    return new ServiceScopingOptions.Builder<>(null, null, false);
  }

  public static <_B> ServiceScopingOptions.Builder<_B> copyOf(final ServiceScopingOptions _other) {
    final ServiceScopingOptions.Builder<_B> _newBuilder = new ServiceScopingOptions.Builder<>(null, null, false);
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
    final ServiceScopingOptions.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree serviceTypePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("serviceType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (serviceTypePropertyTree != null)
          : ((serviceTypePropertyTree == null) || (!serviceTypePropertyTree.isLeaf())))
    ) {
      _other.serviceType = ((this.serviceType == null)
          ? null
          : this.serviceType.newCopyBuilder(_other, serviceTypePropertyTree, _propertyTreeUse));
    }
    final PropertyTree locationTypePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("locationType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (locationTypePropertyTree != null)
          : ((locationTypePropertyTree == null) || (!locationTypePropertyTree.isLeaf())))
    ) {
      _other.locationType = ((this.locationType == null)
          ? null
          : this.locationType.newCopyBuilder(_other, locationTypePropertyTree, _propertyTreeUse));
    }
    final PropertyTree suspendOnOutboundInternationalRoamingPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("suspendOnOutboundInternationalRoaming"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (suspendOnOutboundInternationalRoamingPropertyTree != null)
          : ((suspendOnOutboundInternationalRoamingPropertyTree == null) ||
            (!suspendOnOutboundInternationalRoamingPropertyTree.isLeaf())))
    ) {
      _other.suspendOnOutboundInternationalRoaming = this.suspendOnOutboundInternationalRoaming;
    }
    final PropertyTree reportPostDialledDigitsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("reportPostDialledDigits"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (reportPostDialledDigitsPropertyTree != null)
          : ((reportPostDialledDigitsPropertyTree == null) || (!reportPostDialledDigitsPropertyTree.isLeaf())))
    ) {
      _other.reportPostDialledDigits = this.reportPostDialledDigits;
    }
  }

  public <_B> ServiceScopingOptions.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ServiceScopingOptions.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public ServiceScopingOptions.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ServiceScopingOptions.Builder<_B> copyOf(
    final ServiceScopingOptions _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ServiceScopingOptions.Builder<_B> _newBuilder = new ServiceScopingOptions.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ServiceScopingOptions.Builder<Void> copyExcept(
    final ServiceScopingOptions _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ServiceScopingOptions.Builder<Void> copyOnly(
    final ServiceScopingOptions _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final ServiceScopingOptions _storedValue;
    private ListOfServiceTypes.Builder<ServiceScopingOptions.Builder<_B>> serviceType;
    private LocationTypeOptions.Builder<ServiceScopingOptions.Builder<_B>> locationType;
    private Boolean suspendOnOutboundInternationalRoaming;
    private Boolean reportPostDialledDigits;

    public Builder(final _B _parentBuilder, final ServiceScopingOptions _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.serviceType = ((_other.serviceType == null) ? null : _other.serviceType.newCopyBuilder(this));
          this.locationType = ((_other.locationType == null) ? null : _other.locationType.newCopyBuilder(this));
          this.suspendOnOutboundInternationalRoaming = _other.suspendOnOutboundInternationalRoaming;
          this.reportPostDialledDigits = _other.reportPostDialledDigits;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final ServiceScopingOptions _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree serviceTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("serviceType"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (serviceTypePropertyTree != null)
                : ((serviceTypePropertyTree == null) || (!serviceTypePropertyTree.isLeaf())))
          ) {
            this.serviceType = ((_other.serviceType == null)
                ? null
                : _other.serviceType.newCopyBuilder(this, serviceTypePropertyTree, _propertyTreeUse));
          }
          final PropertyTree locationTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("locationType"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (locationTypePropertyTree != null)
                : ((locationTypePropertyTree == null) || (!locationTypePropertyTree.isLeaf())))
          ) {
            this.locationType = ((_other.locationType == null)
                ? null
                : _other.locationType.newCopyBuilder(this, locationTypePropertyTree, _propertyTreeUse));
          }
          final PropertyTree suspendOnOutboundInternationalRoamingPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("suspendOnOutboundInternationalRoaming"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (suspendOnOutboundInternationalRoamingPropertyTree != null)
                : ((suspendOnOutboundInternationalRoamingPropertyTree == null) ||
                  (!suspendOnOutboundInternationalRoamingPropertyTree.isLeaf())))
          ) {
            this.suspendOnOutboundInternationalRoaming = _other.suspendOnOutboundInternationalRoaming;
          }
          final PropertyTree reportPostDialledDigitsPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("reportPostDialledDigits"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (reportPostDialledDigitsPropertyTree != null)
                : ((reportPostDialledDigitsPropertyTree == null) || (!reportPostDialledDigitsPropertyTree.isLeaf())))
          ) {
            this.reportPostDialledDigits = _other.reportPostDialledDigits;
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

    protected <_P extends ServiceScopingOptions> _P init(final _P _product) {
      _product.serviceType = ((this.serviceType == null) ? null : this.serviceType.build());
      _product.locationType = ((this.locationType == null) ? null : this.locationType.build());
      _product.suspendOnOutboundInternationalRoaming = this.suspendOnOutboundInternationalRoaming;
      _product.reportPostDialledDigits = this.reportPostDialledDigits;
      return _product;
    }

    /**
     * Sets the new value of "serviceType" (any previous value will be replaced)
     *
     * @param serviceType
     *     New value of the "serviceType" property.
     */
    public ServiceScopingOptions.Builder<_B> withServiceType(final ListOfServiceTypes serviceType) {
      this.serviceType = ((serviceType == null) ? null : new ListOfServiceTypes.Builder<>(this, serviceType, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "serviceType" property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.ListOfServiceTypes.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "serviceType" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.ListOfServiceTypes.Builder#end()} to
     *     return to the current builder.
     */
    public ListOfServiceTypes.Builder<? extends ServiceScopingOptions.Builder<_B>> withServiceType() {
      if (this.serviceType != null) {
        return this.serviceType;
      }
      return this.serviceType = new ListOfServiceTypes.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "locationType" (any previous value will be replaced)
     *
     * @param locationType
     *     New value of the "locationType" property.
     */
    public ServiceScopingOptions.Builder<_B> withLocationType(final LocationTypeOptions locationType) {
      this.locationType = ((locationType == null)
          ? null
          : new LocationTypeOptions.Builder<>(this, locationType, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "locationType" property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.LocationTypeOptions.Builder#end()}
     * to return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "locationType" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.LocationTypeOptions.Builder#end()}
     *     to return to the current builder.
     */
    public LocationTypeOptions.Builder<? extends ServiceScopingOptions.Builder<_B>> withLocationType() {
      if (this.locationType != null) {
        return this.locationType;
      }
      return this.locationType = new LocationTypeOptions.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "suspendOnOutboundInternationalRoaming" (any previous
     * value will be replaced)
     *
     * @param suspendOnOutboundInternationalRoaming
     *     New value of the "suspendOnOutboundInternationalRoaming" property.
     */
    public ServiceScopingOptions.Builder<_B> withSuspendOnOutboundInternationalRoaming(
      final Boolean suspendOnOutboundInternationalRoaming
    ) {
      this.suspendOnOutboundInternationalRoaming = suspendOnOutboundInternationalRoaming;
      return this;
    }

    /**
     * Sets the new value of "reportPostDialledDigits" (any previous value will be
     * replaced)
     *
     * @param reportPostDialledDigits
     *     New value of the "reportPostDialledDigits" property.
     */
    public ServiceScopingOptions.Builder<_B> withReportPostDialledDigits(final Boolean reportPostDialledDigits) {
      this.reportPostDialledDigits = reportPostDialledDigits;
      return this;
    }

    @Override
    public ServiceScopingOptions build() {
      if (_storedValue == null) {
        return this.init(new ServiceScopingOptions());
      } else {
        return ((ServiceScopingOptions) _storedValue);
      }
    }

    public ServiceScopingOptions.Builder<_B> copyOf(final ServiceScopingOptions _other) {
      _other.copyTo(this);
      return this;
    }

    public ServiceScopingOptions.Builder<_B> copyOf(final ServiceScopingOptions.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
