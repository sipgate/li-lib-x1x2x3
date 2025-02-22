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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for DestinationStatus complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="DestinationStatus">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="destinationDeliveryStatus" type="{http://uri.etsi.org/03221/X1/2017/10}DestinationDeliveryStatus"/>
 *         <element name="listOfFaults" type="{http://uri.etsi.org/03221/X1/2017/10}ListOfFaults"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DestinationStatus", propOrder = { "destinationDeliveryStatus", "listOfFaults" })
public class DestinationStatus implements Copyable {

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected DestinationDeliveryStatus destinationDeliveryStatus;

  @XmlElement(required = true)
  protected ListOfFaults listOfFaults;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public DestinationStatus() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a DestinationStatus copying the state of another DestinationStatus
   *
   * @param _other
   *     The original DestinationStatus from which to copy state.
   */
  public DestinationStatus(final DestinationStatus _other) {
    this.destinationDeliveryStatus = _other.destinationDeliveryStatus;
    this.listOfFaults = ((_other.listOfFaults == null) ? null : _other.listOfFaults.createCopy());
  }

  /**
   * Gets the value of the destinationDeliveryStatus property.
   *
   * @return
   *     possible object is
   *     {@link DestinationDeliveryStatus }
   *
   */
  public DestinationDeliveryStatus getDestinationDeliveryStatus() {
    return destinationDeliveryStatus;
  }

  /**
   * Sets the value of the destinationDeliveryStatus property.
   *
   * @param value
   *     allowed object is
   *     {@link DestinationDeliveryStatus }
   *
   */
  public void setDestinationDeliveryStatus(DestinationDeliveryStatus value) {
    this.destinationDeliveryStatus = value;
  }

  /**
   * Gets the value of the listOfFaults property.
   *
   * @return
   *     possible object is
   *     {@link ListOfFaults }
   *
   */
  public ListOfFaults getListOfFaults() {
    return listOfFaults;
  }

  /**
   * Sets the value of the listOfFaults property.
   *
   * @param value
   *     allowed object is
   *     {@link ListOfFaults }
   *
   */
  public void setListOfFaults(ListOfFaults value) {
    this.listOfFaults = value;
  }

  @Override
  public DestinationStatus createCopy() {
    final DestinationStatus _newObject;
    try {
      _newObject = ((DestinationStatus) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.destinationDeliveryStatus = this.destinationDeliveryStatus;
    _newObject.listOfFaults = ((this.listOfFaults == null) ? null : this.listOfFaults.createCopy());
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final DestinationStatus.Builder<_B> _other) {
    _other.destinationDeliveryStatus = this.destinationDeliveryStatus;
    _other.listOfFaults = ((this.listOfFaults == null) ? null : this.listOfFaults.newCopyBuilder(_other));
  }

  public <_B> DestinationStatus.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new DestinationStatus.Builder<_B>(_parentBuilder, this, true);
  }

  public DestinationStatus.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static DestinationStatus.Builder<Void> builder() {
    return new DestinationStatus.Builder<>(null, null, false);
  }

  public static <_B> DestinationStatus.Builder<_B> copyOf(final DestinationStatus _other) {
    final DestinationStatus.Builder<_B> _newBuilder = new DestinationStatus.Builder<>(null, null, false);
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
    final DestinationStatus.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree destinationDeliveryStatusPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationDeliveryStatus"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationDeliveryStatusPropertyTree != null)
          : ((destinationDeliveryStatusPropertyTree == null) || (!destinationDeliveryStatusPropertyTree.isLeaf())))
    ) {
      _other.destinationDeliveryStatus = this.destinationDeliveryStatus;
    }
    final PropertyTree listOfFaultsPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("listOfFaults"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (listOfFaultsPropertyTree != null)
          : ((listOfFaultsPropertyTree == null) || (!listOfFaultsPropertyTree.isLeaf())))
    ) {
      _other.listOfFaults = ((this.listOfFaults == null)
          ? null
          : this.listOfFaults.newCopyBuilder(_other, listOfFaultsPropertyTree, _propertyTreeUse));
    }
  }

  public <_B> DestinationStatus.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new DestinationStatus.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public DestinationStatus.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> DestinationStatus.Builder<_B> copyOf(
    final DestinationStatus _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final DestinationStatus.Builder<_B> _newBuilder = new DestinationStatus.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static DestinationStatus.Builder<Void> copyExcept(
    final DestinationStatus _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static DestinationStatus.Builder<Void> copyOnly(
    final DestinationStatus _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final DestinationStatus _storedValue;
    private DestinationDeliveryStatus destinationDeliveryStatus;
    private ListOfFaults.Builder<DestinationStatus.Builder<_B>> listOfFaults;

    public Builder(final _B _parentBuilder, final DestinationStatus _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.destinationDeliveryStatus = _other.destinationDeliveryStatus;
          this.listOfFaults = ((_other.listOfFaults == null) ? null : _other.listOfFaults.newCopyBuilder(this));
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final DestinationStatus _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree destinationDeliveryStatusPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("destinationDeliveryStatus"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (destinationDeliveryStatusPropertyTree != null)
                : ((destinationDeliveryStatusPropertyTree == null) ||
                  (!destinationDeliveryStatusPropertyTree.isLeaf())))
          ) {
            this.destinationDeliveryStatus = _other.destinationDeliveryStatus;
          }
          final PropertyTree listOfFaultsPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("listOfFaults"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (listOfFaultsPropertyTree != null)
                : ((listOfFaultsPropertyTree == null) || (!listOfFaultsPropertyTree.isLeaf())))
          ) {
            this.listOfFaults = ((_other.listOfFaults == null)
                ? null
                : _other.listOfFaults.newCopyBuilder(this, listOfFaultsPropertyTree, _propertyTreeUse));
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

    protected <_P extends DestinationStatus> _P init(final _P _product) {
      _product.destinationDeliveryStatus = this.destinationDeliveryStatus;
      _product.listOfFaults = ((this.listOfFaults == null) ? null : this.listOfFaults.build());
      return _product;
    }

    /**
     * Sets the new value of "destinationDeliveryStatus" (any previous value will be
     * replaced)
     *
     * @param destinationDeliveryStatus
     *     New value of the "destinationDeliveryStatus" property.
     */
    public DestinationStatus.Builder<_B> withDestinationDeliveryStatus(
      final DestinationDeliveryStatus destinationDeliveryStatus
    ) {
      this.destinationDeliveryStatus = destinationDeliveryStatus;
      return this;
    }

    /**
     * Sets the new value of "listOfFaults" (any previous value will be replaced)
     *
     * @param listOfFaults
     *     New value of the "listOfFaults" property.
     */
    public DestinationStatus.Builder<_B> withListOfFaults(final ListOfFaults listOfFaults) {
      this.listOfFaults = ((listOfFaults == null) ? null : new ListOfFaults.Builder<>(this, listOfFaults, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "listOfFaults" property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.ListOfFaults.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "listOfFaults" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.ListOfFaults.Builder#end()} to
     *     return to the current builder.
     */
    public ListOfFaults.Builder<? extends DestinationStatus.Builder<_B>> withListOfFaults() {
      if (this.listOfFaults != null) {
        return this.listOfFaults;
      }
      return this.listOfFaults = new ListOfFaults.Builder<>(this, null, false);
    }

    @Override
    public DestinationStatus build() {
      if (_storedValue == null) {
        return this.init(new DestinationStatus());
      } else {
        return ((DestinationStatus) _storedValue);
      }
    }

    public DestinationStatus.Builder<_B> copyOf(final DestinationStatus _other) {
      _other.copyTo(this);
      return this;
    }

    public DestinationStatus.Builder<_B> copyOf(final DestinationStatus.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
