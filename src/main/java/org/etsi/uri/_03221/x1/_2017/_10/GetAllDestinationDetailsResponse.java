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
import jakarta.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for GetAllDestinationDetailsResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="GetAllDestinationDetailsResponse">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage">
 *       <sequence>
 *         <element name="listOfDestinationResponseDetails" type="{http://uri.etsi.org/03221/X1/2017/10}ListOfDestinationResponseDetails" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllDestinationDetailsResponse", propOrder = { "listOfDestinationResponseDetails" })
public class GetAllDestinationDetailsResponse extends X1ResponseMessage implements Copyable, PartialCopyable {

  protected ListOfDestinationResponseDetails listOfDestinationResponseDetails;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public GetAllDestinationDetailsResponse() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a GetAllDestinationDetailsResponse copying the state of another GetAllDestinationDetailsResponse
   *
   * @param _other
   *     The original GetAllDestinationDetailsResponse from which to copy state.
   */
  public GetAllDestinationDetailsResponse(final GetAllDestinationDetailsResponse _other) {
    super(_other);
    this.listOfDestinationResponseDetails = ((_other.listOfDestinationResponseDetails == null)
        ? null
        : _other.listOfDestinationResponseDetails.createCopy());
  }

  /**
   * Instantiates a GetAllDestinationDetailsResponse copying the state of another GetAllDestinationDetailsResponse
   *
   * @param _other
   *     The original GetAllDestinationDetailsResponse from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public GetAllDestinationDetailsResponse(
    final GetAllDestinationDetailsResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree listOfDestinationResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("listOfDestinationResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (listOfDestinationResponseDetailsPropertyTree != null)
          : ((listOfDestinationResponseDetailsPropertyTree == null) ||
            (!listOfDestinationResponseDetailsPropertyTree.isLeaf())))
    ) {
      this.listOfDestinationResponseDetails = ((_other.listOfDestinationResponseDetails == null)
          ? null
          : _other.listOfDestinationResponseDetails.createCopy(
            listOfDestinationResponseDetailsPropertyTree,
            _propertyTreeUse
          ));
    }
  }

  /**
   * Gets the value of the listOfDestinationResponseDetails property.
   *
   * @return
   *     possible object is
   *     {@link ListOfDestinationResponseDetails }
   *
   */
  public ListOfDestinationResponseDetails getListOfDestinationResponseDetails() {
    return listOfDestinationResponseDetails;
  }

  /**
   * Sets the value of the listOfDestinationResponseDetails property.
   *
   * @param value
   *     allowed object is
   *     {@link ListOfDestinationResponseDetails }
   *
   */
  public void setListOfDestinationResponseDetails(ListOfDestinationResponseDetails value) {
    this.listOfDestinationResponseDetails = value;
  }

  @Override
  public GetAllDestinationDetailsResponse createCopy() {
    final GetAllDestinationDetailsResponse _newObject = ((GetAllDestinationDetailsResponse) super.createCopy());
    _newObject.listOfDestinationResponseDetails = ((this.listOfDestinationResponseDetails == null)
        ? null
        : this.listOfDestinationResponseDetails.createCopy());
    return _newObject;
  }

  @Override
  public GetAllDestinationDetailsResponse createCopy(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetAllDestinationDetailsResponse _newObject =
      ((GetAllDestinationDetailsResponse) super.createCopy(_propertyTree, _propertyTreeUse));
    final PropertyTree listOfDestinationResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("listOfDestinationResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (listOfDestinationResponseDetailsPropertyTree != null)
          : ((listOfDestinationResponseDetailsPropertyTree == null) ||
            (!listOfDestinationResponseDetailsPropertyTree.isLeaf())))
    ) {
      _newObject.listOfDestinationResponseDetails = ((this.listOfDestinationResponseDetails == null)
          ? null
          : this.listOfDestinationResponseDetails.createCopy(
              listOfDestinationResponseDetailsPropertyTree,
              _propertyTreeUse
            ));
    }
    return _newObject;
  }

  @Override
  public GetAllDestinationDetailsResponse copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public GetAllDestinationDetailsResponse copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final GetAllDestinationDetailsResponse.Builder<_B> _other) {
    super.copyTo(_other);
    _other.listOfDestinationResponseDetails = ((this.listOfDestinationResponseDetails == null)
        ? null
        : this.listOfDestinationResponseDetails.newCopyBuilder(_other));
  }

  @Override
  public <_B> GetAllDestinationDetailsResponse.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new GetAllDestinationDetailsResponse.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public GetAllDestinationDetailsResponse.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static GetAllDestinationDetailsResponse.Builder<Void> builder() {
    return new GetAllDestinationDetailsResponse.Builder<>(null, null, false);
  }

  public static <_B> GetAllDestinationDetailsResponse.Builder<_B> copyOf(final X1ResponseMessage _other) {
    final GetAllDestinationDetailsResponse.Builder<_B> _newBuilder = new GetAllDestinationDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> GetAllDestinationDetailsResponse.Builder<_B> copyOf(
    final GetAllDestinationDetailsResponse _other
  ) {
    final GetAllDestinationDetailsResponse.Builder<_B> _newBuilder = new GetAllDestinationDetailsResponse.Builder<>(
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
    final GetAllDestinationDetailsResponse.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree listOfDestinationResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("listOfDestinationResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (listOfDestinationResponseDetailsPropertyTree != null)
          : ((listOfDestinationResponseDetailsPropertyTree == null) ||
            (!listOfDestinationResponseDetailsPropertyTree.isLeaf())))
    ) {
      _other.listOfDestinationResponseDetails = ((this.listOfDestinationResponseDetails == null)
          ? null
          : this.listOfDestinationResponseDetails.newCopyBuilder(
              _other,
              listOfDestinationResponseDetailsPropertyTree,
              _propertyTreeUse
            ));
    }
  }

  @Override
  public <_B> GetAllDestinationDetailsResponse.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new GetAllDestinationDetailsResponse.Builder<_B>(
      _parentBuilder,
      this,
      true,
      _propertyTree,
      _propertyTreeUse
    );
  }

  @Override
  public GetAllDestinationDetailsResponse.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> GetAllDestinationDetailsResponse.Builder<_B> copyOf(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetAllDestinationDetailsResponse.Builder<_B> _newBuilder = new GetAllDestinationDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> GetAllDestinationDetailsResponse.Builder<_B> copyOf(
    final GetAllDestinationDetailsResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetAllDestinationDetailsResponse.Builder<_B> _newBuilder = new GetAllDestinationDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static GetAllDestinationDetailsResponse.Builder<Void> copyExcept(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetAllDestinationDetailsResponse.Builder<Void> copyExcept(
    final GetAllDestinationDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetAllDestinationDetailsResponse.Builder<Void> copyOnly(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static GetAllDestinationDetailsResponse.Builder<Void> copyOnly(
    final GetAllDestinationDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1ResponseMessage.Builder<_B> implements Buildable {

    private ListOfDestinationResponseDetails.Builder<
      GetAllDestinationDetailsResponse.Builder<_B>
    > listOfDestinationResponseDetails;

    public Builder(final _B _parentBuilder, final GetAllDestinationDetailsResponse _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {
        this.listOfDestinationResponseDetails = ((_other.listOfDestinationResponseDetails == null)
            ? null
            : _other.listOfDestinationResponseDetails.newCopyBuilder(this));
      }
    }

    public Builder(
      final _B _parentBuilder,
      final GetAllDestinationDetailsResponse _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {
        final PropertyTree listOfDestinationResponseDetailsPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("listOfDestinationResponseDetails"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (listOfDestinationResponseDetailsPropertyTree != null)
              : ((listOfDestinationResponseDetailsPropertyTree == null) ||
                (!listOfDestinationResponseDetailsPropertyTree.isLeaf())))
        ) {
          this.listOfDestinationResponseDetails = ((_other.listOfDestinationResponseDetails == null)
              ? null
              : _other.listOfDestinationResponseDetails.newCopyBuilder(
                this,
                listOfDestinationResponseDetailsPropertyTree,
                _propertyTreeUse
              ));
        }
      }
    }

    protected <_P extends GetAllDestinationDetailsResponse> _P init(final _P _product) {
      _product.listOfDestinationResponseDetails = ((this.listOfDestinationResponseDetails == null)
          ? null
          : this.listOfDestinationResponseDetails.build());
      return super.init(_product);
    }

    /**
     * Sets the new value of "listOfDestinationResponseDetails" (any previous value
     * will be replaced)
     *
     * @param listOfDestinationResponseDetails
     *     New value of the "listOfDestinationResponseDetails" property.
     */
    public GetAllDestinationDetailsResponse.Builder<_B> withListOfDestinationResponseDetails(
      final ListOfDestinationResponseDetails listOfDestinationResponseDetails
    ) {
      this.listOfDestinationResponseDetails = ((listOfDestinationResponseDetails == null)
          ? null
          : new ListOfDestinationResponseDetails.Builder<>(this, listOfDestinationResponseDetails, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "listOfDestinationResponseDetails" property.
     * Use {@link
     * org.etsi.uri._03221.x1._2017._10.ListOfDestinationResponseDetails.Builder#end()}
     * to return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "listOfDestinationResponseDetails"
     *     property.
     *     Use {@link
     *     org.etsi.uri._03221.x1._2017._10.ListOfDestinationResponseDetails.Builder#end()}
     *     to return to the current builder.
     */
    public ListOfDestinationResponseDetails.Builder<
      ? extends GetAllDestinationDetailsResponse.Builder<_B>
    > withListOfDestinationResponseDetails() {
      if (this.listOfDestinationResponseDetails != null) {
        return this.listOfDestinationResponseDetails;
      }
      return this.listOfDestinationResponseDetails = new ListOfDestinationResponseDetails.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public GetAllDestinationDetailsResponse.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public GetAllDestinationDetailsResponse.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public GetAllDestinationDetailsResponse.Builder<_B> withMessageTimestamp(
      final XMLGregorianCalendar messageTimestamp
    ) {
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
    public GetAllDestinationDetailsResponse.Builder<_B> withVersion(final String version) {
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
    public GetAllDestinationDetailsResponse.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public GetAllDestinationDetailsResponse build() {
      if (_storedValue == null) {
        return this.init(new GetAllDestinationDetailsResponse());
      } else {
        return ((GetAllDestinationDetailsResponse) _storedValue);
      }
    }

    public GetAllDestinationDetailsResponse.Builder<_B> copyOf(final GetAllDestinationDetailsResponse _other) {
      _other.copyTo(this);
      return this;
    }

    public GetAllDestinationDetailsResponse.Builder<_B> copyOf(final GetAllDestinationDetailsResponse.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select
    extends GetAllDestinationDetailsResponse.Selector<GetAllDestinationDetailsResponse.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static GetAllDestinationDetailsResponse.Select _root() {
      return new GetAllDestinationDetailsResponse.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends X1ResponseMessage.Selector<TRoot, TParent> {

    private ListOfDestinationResponseDetails.Selector<
      TRoot,
      GetAllDestinationDetailsResponse.Selector<TRoot, TParent>
    > listOfDestinationResponseDetails = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.listOfDestinationResponseDetails != null) {
        products.put("listOfDestinationResponseDetails", this.listOfDestinationResponseDetails.init());
      }
      return products;
    }

    public ListOfDestinationResponseDetails.Selector<
      TRoot,
      GetAllDestinationDetailsResponse.Selector<TRoot, TParent>
    > listOfDestinationResponseDetails() {
      return (
        (this.listOfDestinationResponseDetails == null)
          ? this.listOfDestinationResponseDetails = new ListOfDestinationResponseDetails.Selector<>(
            this._root,
            this,
            "listOfDestinationResponseDetails"
          )
          : this.listOfDestinationResponseDetails
      );
    }
  }
}
