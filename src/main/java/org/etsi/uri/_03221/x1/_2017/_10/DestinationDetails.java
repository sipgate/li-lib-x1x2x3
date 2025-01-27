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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Java class for DestinationDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="DestinationDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="dId" type="{http://uri.etsi.org/03221/X1/2017/10}DId"/>
 *         <element name="friendlyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="deliveryType" type="{http://uri.etsi.org/03221/X1/2017/10}DeliveryType"/>
 *         <element name="deliveryAddress" type="{http://uri.etsi.org/03221/X1/2017/10}DeliveryAddress"/>
 *         <element name="destinationDetailsExtensions" type="{http://uri.etsi.org/03221/X1/2017/10}DestinationDetailsExtensions" maxOccurs="unbounded" minOccurs="0"/>
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
  name = "DestinationDetails",
  propOrder = { "dId", "friendlyName", "deliveryType", "deliveryAddress", "destinationDetailsExtensions" }
)
public class DestinationDetails implements Copyable, PartialCopyable {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String dId;

  protected String friendlyName;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected DeliveryType deliveryType;

  @XmlElement(required = true)
  protected DeliveryAddress deliveryAddress;

  protected List<DestinationDetailsExtensions> destinationDetailsExtensions;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public DestinationDetails() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a DestinationDetails copying the state of another DestinationDetails
   *
   * @param _other
   *     The original DestinationDetails from which to copy state.
   */
  public DestinationDetails(final DestinationDetails _other) {
    this.dId = _other.dId;
    this.friendlyName = _other.friendlyName;
    this.deliveryType = _other.deliveryType;
    this.deliveryAddress = ((_other.deliveryAddress == null) ? null : _other.deliveryAddress.createCopy());
    if (_other.destinationDetailsExtensions == null) {
      this.destinationDetailsExtensions = null;
    } else {
      this.destinationDetailsExtensions = new ArrayList<>();
      for (DestinationDetailsExtensions _item : _other.destinationDetailsExtensions) {
        this.destinationDetailsExtensions.add(((_item == null) ? null : _item.createCopy()));
      }
    }
  }

  /**
   * Instantiates a DestinationDetails copying the state of another DestinationDetails
   *
   * @param _other
   *     The original DestinationDetails from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public DestinationDetails(
    final DestinationDetails _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree dIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("dId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (dIdPropertyTree != null)
          : ((dIdPropertyTree == null) || (!dIdPropertyTree.isLeaf())))
    ) {
      this.dId = _other.dId;
    }
    final PropertyTree friendlyNamePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("friendlyName"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (friendlyNamePropertyTree != null)
          : ((friendlyNamePropertyTree == null) || (!friendlyNamePropertyTree.isLeaf())))
    ) {
      this.friendlyName = _other.friendlyName;
    }
    final PropertyTree deliveryTypePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("deliveryType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (deliveryTypePropertyTree != null)
          : ((deliveryTypePropertyTree == null) || (!deliveryTypePropertyTree.isLeaf())))
    ) {
      this.deliveryType = _other.deliveryType;
    }
    final PropertyTree deliveryAddressPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("deliveryAddress"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (deliveryAddressPropertyTree != null)
          : ((deliveryAddressPropertyTree == null) || (!deliveryAddressPropertyTree.isLeaf())))
    ) {
      this.deliveryAddress = ((_other.deliveryAddress == null)
          ? null
          : _other.deliveryAddress.createCopy(deliveryAddressPropertyTree, _propertyTreeUse));
    }
    final PropertyTree destinationDetailsExtensionsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationDetailsExtensions"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationDetailsExtensionsPropertyTree != null)
          : ((destinationDetailsExtensionsPropertyTree == null) ||
            (!destinationDetailsExtensionsPropertyTree.isLeaf())))
    ) {
      if (_other.destinationDetailsExtensions == null) {
        this.destinationDetailsExtensions = null;
      } else {
        this.destinationDetailsExtensions = new ArrayList<>();
        for (DestinationDetailsExtensions _item : _other.destinationDetailsExtensions) {
          this.destinationDetailsExtensions.add(
              ((_item == null) ? null : _item.createCopy(destinationDetailsExtensionsPropertyTree, _propertyTreeUse))
            );
        }
      }
    }
  }

  /**
   * Gets the value of the dId property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getDId() {
    return dId;
  }

  /**
   * Sets the value of the dId property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setDId(String value) {
    this.dId = value;
  }

  /**
   * Gets the value of the friendlyName property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getFriendlyName() {
    return friendlyName;
  }

  /**
   * Sets the value of the friendlyName property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setFriendlyName(String value) {
    this.friendlyName = value;
  }

  /**
   * Gets the value of the deliveryType property.
   *
   * @return
   *     possible object is
   *     {@link DeliveryType }
   *
   */
  public DeliveryType getDeliveryType() {
    return deliveryType;
  }

  /**
   * Sets the value of the deliveryType property.
   *
   * @param value
   *     allowed object is
   *     {@link DeliveryType }
   *
   */
  public void setDeliveryType(DeliveryType value) {
    this.deliveryType = value;
  }

  /**
   * Gets the value of the deliveryAddress property.
   *
   * @return
   *     possible object is
   *     {@link DeliveryAddress }
   *
   */
  public DeliveryAddress getDeliveryAddress() {
    return deliveryAddress;
  }

  /**
   * Sets the value of the deliveryAddress property.
   *
   * @param value
   *     allowed object is
   *     {@link DeliveryAddress }
   *
   */
  public void setDeliveryAddress(DeliveryAddress value) {
    this.deliveryAddress = value;
  }

  /**
   * Gets the value of the destinationDetailsExtensions property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the Jakarta XML Binding object.
   * This is why there is not a {@code set} method for the destinationDetailsExtensions property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getDestinationDetailsExtensions().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link DestinationDetailsExtensions }
   *
   *
   * @return
   *     The value of the destinationDetailsExtensions property.
   */
  public List<DestinationDetailsExtensions> getDestinationDetailsExtensions() {
    if (destinationDetailsExtensions == null) {
      destinationDetailsExtensions = new ArrayList<>();
    }
    return this.destinationDetailsExtensions;
  }

  @Override
  public DestinationDetails createCopy() {
    final DestinationDetails _newObject;
    try {
      _newObject = ((DestinationDetails) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.dId = this.dId;
    _newObject.friendlyName = this.friendlyName;
    _newObject.deliveryType = this.deliveryType;
    _newObject.deliveryAddress = ((this.deliveryAddress == null) ? null : this.deliveryAddress.createCopy());
    if (this.destinationDetailsExtensions == null) {
      _newObject.destinationDetailsExtensions = null;
    } else {
      _newObject.destinationDetailsExtensions = new ArrayList<>();
      for (DestinationDetailsExtensions _item : this.destinationDetailsExtensions) {
        _newObject.destinationDetailsExtensions.add(((_item == null) ? null : _item.createCopy()));
      }
    }
    return _newObject;
  }

  @Override
  public DestinationDetails createCopy(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final DestinationDetails _newObject;
    try {
      _newObject = ((DestinationDetails) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    final PropertyTree dIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("dId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (dIdPropertyTree != null)
          : ((dIdPropertyTree == null) || (!dIdPropertyTree.isLeaf())))
    ) {
      _newObject.dId = this.dId;
    }
    final PropertyTree friendlyNamePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("friendlyName"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (friendlyNamePropertyTree != null)
          : ((friendlyNamePropertyTree == null) || (!friendlyNamePropertyTree.isLeaf())))
    ) {
      _newObject.friendlyName = this.friendlyName;
    }
    final PropertyTree deliveryTypePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("deliveryType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (deliveryTypePropertyTree != null)
          : ((deliveryTypePropertyTree == null) || (!deliveryTypePropertyTree.isLeaf())))
    ) {
      _newObject.deliveryType = this.deliveryType;
    }
    final PropertyTree deliveryAddressPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("deliveryAddress"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (deliveryAddressPropertyTree != null)
          : ((deliveryAddressPropertyTree == null) || (!deliveryAddressPropertyTree.isLeaf())))
    ) {
      _newObject.deliveryAddress = ((this.deliveryAddress == null)
          ? null
          : this.deliveryAddress.createCopy(deliveryAddressPropertyTree, _propertyTreeUse));
    }
    final PropertyTree destinationDetailsExtensionsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationDetailsExtensions"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationDetailsExtensionsPropertyTree != null)
          : ((destinationDetailsExtensionsPropertyTree == null) ||
            (!destinationDetailsExtensionsPropertyTree.isLeaf())))
    ) {
      if (this.destinationDetailsExtensions == null) {
        _newObject.destinationDetailsExtensions = null;
      } else {
        _newObject.destinationDetailsExtensions = new ArrayList<>();
        for (DestinationDetailsExtensions _item : this.destinationDetailsExtensions) {
          _newObject.destinationDetailsExtensions.add(
            ((_item == null) ? null : _item.createCopy(destinationDetailsExtensionsPropertyTree, _propertyTreeUse))
          );
        }
      }
    }
    return _newObject;
  }

  @Override
  public DestinationDetails copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public DestinationDetails copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final DestinationDetails.Builder<_B> _other) {
    _other.dId = this.dId;
    _other.friendlyName = this.friendlyName;
    _other.deliveryType = this.deliveryType;
    _other.deliveryAddress = ((this.deliveryAddress == null) ? null : this.deliveryAddress.newCopyBuilder(_other));
    if (this.destinationDetailsExtensions == null) {
      _other.destinationDetailsExtensions = null;
    } else {
      _other.destinationDetailsExtensions = new ArrayList<>();
      for (DestinationDetailsExtensions _item : this.destinationDetailsExtensions) {
        _other.destinationDetailsExtensions.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
      }
    }
  }

  public <_B> DestinationDetails.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new DestinationDetails.Builder<_B>(_parentBuilder, this, true);
  }

  public DestinationDetails.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static DestinationDetails.Builder<Void> builder() {
    return new DestinationDetails.Builder<>(null, null, false);
  }

  public static <_B> DestinationDetails.Builder<_B> copyOf(final DestinationDetails _other) {
    final DestinationDetails.Builder<_B> _newBuilder = new DestinationDetails.Builder<>(null, null, false);
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
    final DestinationDetails.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree dIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("dId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (dIdPropertyTree != null)
          : ((dIdPropertyTree == null) || (!dIdPropertyTree.isLeaf())))
    ) {
      _other.dId = this.dId;
    }
    final PropertyTree friendlyNamePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("friendlyName"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (friendlyNamePropertyTree != null)
          : ((friendlyNamePropertyTree == null) || (!friendlyNamePropertyTree.isLeaf())))
    ) {
      _other.friendlyName = this.friendlyName;
    }
    final PropertyTree deliveryTypePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("deliveryType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (deliveryTypePropertyTree != null)
          : ((deliveryTypePropertyTree == null) || (!deliveryTypePropertyTree.isLeaf())))
    ) {
      _other.deliveryType = this.deliveryType;
    }
    final PropertyTree deliveryAddressPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("deliveryAddress"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (deliveryAddressPropertyTree != null)
          : ((deliveryAddressPropertyTree == null) || (!deliveryAddressPropertyTree.isLeaf())))
    ) {
      _other.deliveryAddress = ((this.deliveryAddress == null)
          ? null
          : this.deliveryAddress.newCopyBuilder(_other, deliveryAddressPropertyTree, _propertyTreeUse));
    }
    final PropertyTree destinationDetailsExtensionsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationDetailsExtensions"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationDetailsExtensionsPropertyTree != null)
          : ((destinationDetailsExtensionsPropertyTree == null) ||
            (!destinationDetailsExtensionsPropertyTree.isLeaf())))
    ) {
      if (this.destinationDetailsExtensions == null) {
        _other.destinationDetailsExtensions = null;
      } else {
        _other.destinationDetailsExtensions = new ArrayList<>();
        for (DestinationDetailsExtensions _item : this.destinationDetailsExtensions) {
          _other.destinationDetailsExtensions.add(
            ((_item == null)
                ? null
                : _item.newCopyBuilder(_other, destinationDetailsExtensionsPropertyTree, _propertyTreeUse))
          );
        }
      }
    }
  }

  public <_B> DestinationDetails.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new DestinationDetails.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public DestinationDetails.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> DestinationDetails.Builder<_B> copyOf(
    final DestinationDetails _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final DestinationDetails.Builder<_B> _newBuilder = new DestinationDetails.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static DestinationDetails.Builder<Void> copyExcept(
    final DestinationDetails _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static DestinationDetails.Builder<Void> copyOnly(
    final DestinationDetails _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final DestinationDetails _storedValue;
    private String dId;
    private String friendlyName;
    private DeliveryType deliveryType;
    private DeliveryAddress.Builder<DestinationDetails.Builder<_B>> deliveryAddress;
    private List<DestinationDetailsExtensions.Builder<DestinationDetails.Builder<_B>>> destinationDetailsExtensions;

    public Builder(final _B _parentBuilder, final DestinationDetails _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.dId = _other.dId;
          this.friendlyName = _other.friendlyName;
          this.deliveryType = _other.deliveryType;
          this.deliveryAddress = ((_other.deliveryAddress == null)
              ? null
              : _other.deliveryAddress.newCopyBuilder(this));
          if (_other.destinationDetailsExtensions == null) {
            this.destinationDetailsExtensions = null;
          } else {
            this.destinationDetailsExtensions = new ArrayList<>();
            for (DestinationDetailsExtensions _item : _other.destinationDetailsExtensions) {
              this.destinationDetailsExtensions.add(((_item == null) ? null : _item.newCopyBuilder(this)));
            }
          }
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final DestinationDetails _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree dIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("dId"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (dIdPropertyTree != null)
                : ((dIdPropertyTree == null) || (!dIdPropertyTree.isLeaf())))
          ) {
            this.dId = _other.dId;
          }
          final PropertyTree friendlyNamePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("friendlyName"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (friendlyNamePropertyTree != null)
                : ((friendlyNamePropertyTree == null) || (!friendlyNamePropertyTree.isLeaf())))
          ) {
            this.friendlyName = _other.friendlyName;
          }
          final PropertyTree deliveryTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("deliveryType"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (deliveryTypePropertyTree != null)
                : ((deliveryTypePropertyTree == null) || (!deliveryTypePropertyTree.isLeaf())))
          ) {
            this.deliveryType = _other.deliveryType;
          }
          final PropertyTree deliveryAddressPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("deliveryAddress"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (deliveryAddressPropertyTree != null)
                : ((deliveryAddressPropertyTree == null) || (!deliveryAddressPropertyTree.isLeaf())))
          ) {
            this.deliveryAddress = ((_other.deliveryAddress == null)
                ? null
                : _other.deliveryAddress.newCopyBuilder(this, deliveryAddressPropertyTree, _propertyTreeUse));
          }
          final PropertyTree destinationDetailsExtensionsPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("destinationDetailsExtensions"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (destinationDetailsExtensionsPropertyTree != null)
                : ((destinationDetailsExtensionsPropertyTree == null) ||
                  (!destinationDetailsExtensionsPropertyTree.isLeaf())))
          ) {
            if (_other.destinationDetailsExtensions == null) {
              this.destinationDetailsExtensions = null;
            } else {
              this.destinationDetailsExtensions = new ArrayList<>();
              for (DestinationDetailsExtensions _item : _other.destinationDetailsExtensions) {
                this.destinationDetailsExtensions.add(
                    ((_item == null)
                        ? null
                        : _item.newCopyBuilder(this, destinationDetailsExtensionsPropertyTree, _propertyTreeUse))
                  );
              }
            }
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

    protected <_P extends DestinationDetails> _P init(final _P _product) {
      _product.dId = this.dId;
      _product.friendlyName = this.friendlyName;
      _product.deliveryType = this.deliveryType;
      _product.deliveryAddress = ((this.deliveryAddress == null) ? null : this.deliveryAddress.build());
      if (this.destinationDetailsExtensions != null) {
        final List<DestinationDetailsExtensions> destinationDetailsExtensions = new ArrayList<>(
          this.destinationDetailsExtensions.size()
        );
        for (DestinationDetailsExtensions.Builder<
          DestinationDetails.Builder<_B>
        > _item : this.destinationDetailsExtensions) {
          destinationDetailsExtensions.add(_item.build());
        }
        _product.destinationDetailsExtensions = destinationDetailsExtensions;
      }
      return _product;
    }

    /**
     * Sets the new value of "dId" (any previous value will be replaced)
     *
     * @param dId
     *     New value of the "dId" property.
     */
    public DestinationDetails.Builder<_B> withDId(final String dId) {
      this.dId = dId;
      return this;
    }

    /**
     * Sets the new value of "friendlyName" (any previous value will be replaced)
     *
     * @param friendlyName
     *     New value of the "friendlyName" property.
     */
    public DestinationDetails.Builder<_B> withFriendlyName(final String friendlyName) {
      this.friendlyName = friendlyName;
      return this;
    }

    /**
     * Sets the new value of "deliveryType" (any previous value will be replaced)
     *
     * @param deliveryType
     *     New value of the "deliveryType" property.
     */
    public DestinationDetails.Builder<_B> withDeliveryType(final DeliveryType deliveryType) {
      this.deliveryType = deliveryType;
      return this;
    }

    /**
     * Sets the new value of "deliveryAddress" (any previous value will be replaced)
     *
     * @param deliveryAddress
     *     New value of the "deliveryAddress" property.
     */
    public DestinationDetails.Builder<_B> withDeliveryAddress(final DeliveryAddress deliveryAddress) {
      this.deliveryAddress = ((deliveryAddress == null)
          ? null
          : new DeliveryAddress.Builder<>(this, deliveryAddress, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "deliveryAddress" property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.DeliveryAddress.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "deliveryAddress" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.DeliveryAddress.Builder#end()} to
     *     return to the current builder.
     */
    public DeliveryAddress.Builder<? extends DestinationDetails.Builder<_B>> withDeliveryAddress() {
      if (this.deliveryAddress != null) {
        return this.deliveryAddress;
      }
      return this.deliveryAddress = new DeliveryAddress.Builder<>(this, null, false);
    }

    /**
     * Adds the given items to the value of "destinationDetailsExtensions"
     *
     * @param destinationDetailsExtensions
     *     Items to add to the value of the "destinationDetailsExtensions" property
     */
    public DestinationDetails.Builder<_B> addDestinationDetailsExtensions(
      final Iterable<? extends DestinationDetailsExtensions> destinationDetailsExtensions
    ) {
      if (destinationDetailsExtensions != null) {
        if (this.destinationDetailsExtensions == null) {
          this.destinationDetailsExtensions = new ArrayList<>();
        }
        for (DestinationDetailsExtensions _item : destinationDetailsExtensions) {
          this.destinationDetailsExtensions.add(new DestinationDetailsExtensions.Builder<>(this, _item, false));
        }
      }
      return this;
    }

    /**
     * Sets the new value of "destinationDetailsExtensions" (any previous value will be
     * replaced)
     *
     * @param destinationDetailsExtensions
     *     New value of the "destinationDetailsExtensions" property.
     */
    public DestinationDetails.Builder<_B> withDestinationDetailsExtensions(
      final Iterable<? extends DestinationDetailsExtensions> destinationDetailsExtensions
    ) {
      if (this.destinationDetailsExtensions != null) {
        this.destinationDetailsExtensions.clear();
      }
      return addDestinationDetailsExtensions(destinationDetailsExtensions);
    }

    /**
     * Adds the given items to the value of "destinationDetailsExtensions"
     *
     * @param destinationDetailsExtensions
     *     Items to add to the value of the "destinationDetailsExtensions" property
     */
    public DestinationDetails.Builder<_B> addDestinationDetailsExtensions(
      DestinationDetailsExtensions... destinationDetailsExtensions
    ) {
      addDestinationDetailsExtensions(Arrays.asList(destinationDetailsExtensions));
      return this;
    }

    /**
     * Sets the new value of "destinationDetailsExtensions" (any previous value will be
     * replaced)
     *
     * @param destinationDetailsExtensions
     *     New value of the "destinationDetailsExtensions" property.
     */
    public DestinationDetails.Builder<_B> withDestinationDetailsExtensions(
      DestinationDetailsExtensions... destinationDetailsExtensions
    ) {
      withDestinationDetailsExtensions(Arrays.asList(destinationDetailsExtensions));
      return this;
    }

    /**
     * Returns a new builder to build an additional value of the
     * "DestinationDetailsExtensions" property.
     * Use {@link
     * org.etsi.uri._03221.x1._2017._10.DestinationDetailsExtensions.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     a new builder to build an additional value of the "DestinationDetailsExtensions"
     *     property.
     *     Use {@link
     *     org.etsi.uri._03221.x1._2017._10.DestinationDetailsExtensions.Builder#end()} to
     *     return to the current builder.
     */
    public DestinationDetailsExtensions.Builder<
      ? extends DestinationDetails.Builder<_B>
    > addDestinationDetailsExtensions() {
      if (this.destinationDetailsExtensions == null) {
        this.destinationDetailsExtensions = new ArrayList<>();
      }
      final DestinationDetailsExtensions.Builder<DestinationDetails.Builder<_B>> destinationDetailsExtensions_Builder =
        new DestinationDetailsExtensions.Builder<>(this, null, false);
      this.destinationDetailsExtensions.add(destinationDetailsExtensions_Builder);
      return destinationDetailsExtensions_Builder;
    }

    @Override
    public DestinationDetails build() {
      if (_storedValue == null) {
        return this.init(new DestinationDetails());
      } else {
        return ((DestinationDetails) _storedValue);
      }
    }

    public DestinationDetails.Builder<_B> copyOf(final DestinationDetails _other) {
      _other.copyTo(this);
      return this;
    }

    public DestinationDetails.Builder<_B> copyOf(final DestinationDetails.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends DestinationDetails.Selector<DestinationDetails.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static DestinationDetails.Select _root() {
      return new DestinationDetails.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private com.kscs.util.jaxb.Selector<TRoot, DestinationDetails.Selector<TRoot, TParent>> dId = null;
    private com.kscs.util.jaxb.Selector<TRoot, DestinationDetails.Selector<TRoot, TParent>> friendlyName = null;
    private com.kscs.util.jaxb.Selector<TRoot, DestinationDetails.Selector<TRoot, TParent>> deliveryType = null;
    private DeliveryAddress.Selector<TRoot, DestinationDetails.Selector<TRoot, TParent>> deliveryAddress = null;
    private DestinationDetailsExtensions.Selector<
      TRoot,
      DestinationDetails.Selector<TRoot, TParent>
    > destinationDetailsExtensions = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.dId != null) {
        products.put("dId", this.dId.init());
      }
      if (this.friendlyName != null) {
        products.put("friendlyName", this.friendlyName.init());
      }
      if (this.deliveryType != null) {
        products.put("deliveryType", this.deliveryType.init());
      }
      if (this.deliveryAddress != null) {
        products.put("deliveryAddress", this.deliveryAddress.init());
      }
      if (this.destinationDetailsExtensions != null) {
        products.put("destinationDetailsExtensions", this.destinationDetailsExtensions.init());
      }
      return products;
    }

    public com.kscs.util.jaxb.Selector<TRoot, DestinationDetails.Selector<TRoot, TParent>> dId() {
      return ((this.dId == null) ? this.dId = new com.kscs.util.jaxb.Selector<>(this._root, this, "dId") : this.dId);
    }

    public com.kscs.util.jaxb.Selector<TRoot, DestinationDetails.Selector<TRoot, TParent>> friendlyName() {
      return (
        (this.friendlyName == null)
          ? this.friendlyName = new com.kscs.util.jaxb.Selector<>(this._root, this, "friendlyName")
          : this.friendlyName
      );
    }

    public com.kscs.util.jaxb.Selector<TRoot, DestinationDetails.Selector<TRoot, TParent>> deliveryType() {
      return (
        (this.deliveryType == null)
          ? this.deliveryType = new com.kscs.util.jaxb.Selector<>(this._root, this, "deliveryType")
          : this.deliveryType
      );
    }

    public DeliveryAddress.Selector<TRoot, DestinationDetails.Selector<TRoot, TParent>> deliveryAddress() {
      return (
        (this.deliveryAddress == null)
          ? this.deliveryAddress = new DeliveryAddress.Selector<>(this._root, this, "deliveryAddress")
          : this.deliveryAddress
      );
    }

    public DestinationDetailsExtensions.Selector<
      TRoot,
      DestinationDetails.Selector<TRoot, TParent>
    > destinationDetailsExtensions() {
      return (
        (this.destinationDetailsExtensions == null)
          ? this.destinationDetailsExtensions = new DestinationDetailsExtensions.Selector<>(
            this._root,
            this,
            "destinationDetailsExtensions"
          )
          : this.destinationDetailsExtensions
      );
    }
  }
}
