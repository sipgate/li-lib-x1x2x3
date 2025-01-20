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
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for ModifyDestinationRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="ModifyDestinationRequest">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1RequestMessage">
 *       <sequence>
 *         <element name="destinationDetails" type="{http://uri.etsi.org/03221/X1/2017/10}DestinationDetails"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifyDestinationRequest", propOrder = { "destinationDetails" })
public class ModifyDestinationRequest extends X1RequestMessage implements Copyable, PartialCopyable {

  @XmlElement(required = true)
  protected DestinationDetails destinationDetails;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ModifyDestinationRequest() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ModifyDestinationRequest copying the state of another ModifyDestinationRequest
   *
   * @param _other
   *     The original ModifyDestinationRequest from which to copy state.
   */
  public ModifyDestinationRequest(final ModifyDestinationRequest _other) {
    super(_other);
    this.destinationDetails = ((_other.destinationDetails == null) ? null : _other.destinationDetails.createCopy());
  }

  /**
   * Instantiates a ModifyDestinationRequest copying the state of another ModifyDestinationRequest
   *
   * @param _other
   *     The original ModifyDestinationRequest from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public ModifyDestinationRequest(
    final ModifyDestinationRequest _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree destinationDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationDetailsPropertyTree != null)
          : ((destinationDetailsPropertyTree == null) || (!destinationDetailsPropertyTree.isLeaf())))
    ) {
      this.destinationDetails = ((_other.destinationDetails == null)
          ? null
          : _other.destinationDetails.createCopy(destinationDetailsPropertyTree, _propertyTreeUse));
    }
  }

  /**
   * Gets the value of the destinationDetails property.
   *
   * @return
   *     possible object is
   *     {@link DestinationDetails }
   *
   */
  public DestinationDetails getDestinationDetails() {
    return destinationDetails;
  }

  /**
   * Sets the value of the destinationDetails property.
   *
   * @param value
   *     allowed object is
   *     {@link DestinationDetails }
   *
   */
  public void setDestinationDetails(DestinationDetails value) {
    this.destinationDetails = value;
  }

  @Override
  public ModifyDestinationRequest createCopy() {
    final ModifyDestinationRequest _newObject = ((ModifyDestinationRequest) super.createCopy());
    _newObject.destinationDetails = ((this.destinationDetails == null) ? null : this.destinationDetails.createCopy());
    return _newObject;
  }

  @Override
  public ModifyDestinationRequest createCopy(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final ModifyDestinationRequest _newObject =
      ((ModifyDestinationRequest) super.createCopy(_propertyTree, _propertyTreeUse));
    final PropertyTree destinationDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationDetailsPropertyTree != null)
          : ((destinationDetailsPropertyTree == null) || (!destinationDetailsPropertyTree.isLeaf())))
    ) {
      _newObject.destinationDetails = ((this.destinationDetails == null)
          ? null
          : this.destinationDetails.createCopy(destinationDetailsPropertyTree, _propertyTreeUse));
    }
    return _newObject;
  }

  @Override
  public ModifyDestinationRequest copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public ModifyDestinationRequest copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final ModifyDestinationRequest.Builder<_B> _other) {
    super.copyTo(_other);
    _other.destinationDetails = ((this.destinationDetails == null)
        ? null
        : this.destinationDetails.newCopyBuilder(_other));
  }

  @Override
  public <_B> ModifyDestinationRequest.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ModifyDestinationRequest.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public ModifyDestinationRequest.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ModifyDestinationRequest.Builder<Void> builder() {
    return new ModifyDestinationRequest.Builder<>(null, null, false);
  }

  public static <_B> ModifyDestinationRequest.Builder<_B> copyOf(final X1RequestMessage _other) {
    final ModifyDestinationRequest.Builder<_B> _newBuilder = new ModifyDestinationRequest.Builder<>(null, null, false);
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> ModifyDestinationRequest.Builder<_B> copyOf(final ModifyDestinationRequest _other) {
    final ModifyDestinationRequest.Builder<_B> _newBuilder = new ModifyDestinationRequest.Builder<>(null, null, false);
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
    final ModifyDestinationRequest.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree destinationDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationDetailsPropertyTree != null)
          : ((destinationDetailsPropertyTree == null) || (!destinationDetailsPropertyTree.isLeaf())))
    ) {
      _other.destinationDetails = ((this.destinationDetails == null)
          ? null
          : this.destinationDetails.newCopyBuilder(_other, destinationDetailsPropertyTree, _propertyTreeUse));
    }
  }

  @Override
  public <_B> ModifyDestinationRequest.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ModifyDestinationRequest.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public ModifyDestinationRequest.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ModifyDestinationRequest.Builder<_B> copyOf(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ModifyDestinationRequest.Builder<_B> _newBuilder = new ModifyDestinationRequest.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> ModifyDestinationRequest.Builder<_B> copyOf(
    final ModifyDestinationRequest _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ModifyDestinationRequest.Builder<_B> _newBuilder = new ModifyDestinationRequest.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ModifyDestinationRequest.Builder<Void> copyExcept(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ModifyDestinationRequest.Builder<Void> copyExcept(
    final ModifyDestinationRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ModifyDestinationRequest.Builder<Void> copyOnly(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static ModifyDestinationRequest.Builder<Void> copyOnly(
    final ModifyDestinationRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1RequestMessage.Builder<_B> implements Buildable {

    private DestinationDetails.Builder<ModifyDestinationRequest.Builder<_B>> destinationDetails;

    public Builder(final _B _parentBuilder, final ModifyDestinationRequest _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {
        this.destinationDetails = ((_other.destinationDetails == null)
            ? null
            : _other.destinationDetails.newCopyBuilder(this));
      }
    }

    public Builder(
      final _B _parentBuilder,
      final ModifyDestinationRequest _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {
        final PropertyTree destinationDetailsPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("destinationDetails"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (destinationDetailsPropertyTree != null)
              : ((destinationDetailsPropertyTree == null) || (!destinationDetailsPropertyTree.isLeaf())))
        ) {
          this.destinationDetails = ((_other.destinationDetails == null)
              ? null
              : _other.destinationDetails.newCopyBuilder(this, destinationDetailsPropertyTree, _propertyTreeUse));
        }
      }
    }

    protected <_P extends ModifyDestinationRequest> _P init(final _P _product) {
      _product.destinationDetails = ((this.destinationDetails == null) ? null : this.destinationDetails.build());
      return super.init(_product);
    }

    /**
     * Sets the new value of "destinationDetails" (any previous value will be replaced)
     *
     * @param destinationDetails
     *     New value of the "destinationDetails" property.
     */
    public ModifyDestinationRequest.Builder<_B> withDestinationDetails(final DestinationDetails destinationDetails) {
      this.destinationDetails = ((destinationDetails == null)
          ? null
          : new DestinationDetails.Builder<>(this, destinationDetails, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "destinationDetails" property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.DestinationDetails.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "destinationDetails" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.DestinationDetails.Builder#end()} to
     *     return to the current builder.
     */
    public DestinationDetails.Builder<? extends ModifyDestinationRequest.Builder<_B>> withDestinationDetails() {
      if (this.destinationDetails != null) {
        return this.destinationDetails;
      }
      return this.destinationDetails = new DestinationDetails.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public ModifyDestinationRequest.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public ModifyDestinationRequest.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public ModifyDestinationRequest.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
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
    public ModifyDestinationRequest.Builder<_B> withVersion(final String version) {
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
    public ModifyDestinationRequest.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public ModifyDestinationRequest build() {
      if (_storedValue == null) {
        return this.init(new ModifyDestinationRequest());
      } else {
        return ((ModifyDestinationRequest) _storedValue);
      }
    }

    public ModifyDestinationRequest.Builder<_B> copyOf(final ModifyDestinationRequest _other) {
      _other.copyTo(this);
      return this;
    }

    public ModifyDestinationRequest.Builder<_B> copyOf(final ModifyDestinationRequest.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends ModifyDestinationRequest.Selector<ModifyDestinationRequest.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static ModifyDestinationRequest.Select _root() {
      return new ModifyDestinationRequest.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends X1RequestMessage.Selector<TRoot, TParent> {

    private DestinationDetails.Selector<TRoot, ModifyDestinationRequest.Selector<TRoot, TParent>> destinationDetails =
      null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.destinationDetails != null) {
        products.put("destinationDetails", this.destinationDetails.init());
      }
      return products;
    }

    public DestinationDetails.Selector<TRoot, ModifyDestinationRequest.Selector<TRoot, TParent>> destinationDetails() {
      return (
        (this.destinationDetails == null)
          ? this.destinationDetails = new DestinationDetails.Selector<>(this._root, this, "destinationDetails")
          : this.destinationDetails
      );
    }
  }
}
