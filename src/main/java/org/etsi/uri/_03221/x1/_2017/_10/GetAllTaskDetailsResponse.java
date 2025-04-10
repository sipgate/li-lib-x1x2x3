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
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for GetAllTaskDetailsResponse complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="GetAllTaskDetailsResponse">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage">
 *       <sequence>
 *         <element name="listOfTaskResponseDetails" type="{http://uri.etsi.org/03221/X1/2017/10}ListOfTaskResponseDetails" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllTaskDetailsResponse", propOrder = { "listOfTaskResponseDetails" })
public class GetAllTaskDetailsResponse extends X1ResponseMessage implements Copyable {

  protected ListOfTaskResponseDetails listOfTaskResponseDetails;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public GetAllTaskDetailsResponse() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a GetAllTaskDetailsResponse copying the state of another GetAllTaskDetailsResponse
   *
   * @param _other
   *     The original GetAllTaskDetailsResponse from which to copy state.
   */
  public GetAllTaskDetailsResponse(final GetAllTaskDetailsResponse _other) {
    super(_other);
    this.listOfTaskResponseDetails = ((_other.listOfTaskResponseDetails == null)
        ? null
        : _other.listOfTaskResponseDetails.createCopy());
  }

  /**
   * Gets the value of the listOfTaskResponseDetails property.
   *
   * @return
   *     possible object is
   *     {@link ListOfTaskResponseDetails }
   *
   */
  public ListOfTaskResponseDetails getListOfTaskResponseDetails() {
    return listOfTaskResponseDetails;
  }

  /**
   * Sets the value of the listOfTaskResponseDetails property.
   *
   * @param value
   *     allowed object is
   *     {@link ListOfTaskResponseDetails }
   *
   */
  public void setListOfTaskResponseDetails(ListOfTaskResponseDetails value) {
    this.listOfTaskResponseDetails = value;
  }

  @Override
  public GetAllTaskDetailsResponse createCopy() {
    final GetAllTaskDetailsResponse _newObject = ((GetAllTaskDetailsResponse) super.createCopy());
    _newObject.listOfTaskResponseDetails = ((this.listOfTaskResponseDetails == null)
        ? null
        : this.listOfTaskResponseDetails.createCopy());
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final GetAllTaskDetailsResponse.Builder<_B> _other) {
    super.copyTo(_other);
    _other.listOfTaskResponseDetails = ((this.listOfTaskResponseDetails == null)
        ? null
        : this.listOfTaskResponseDetails.newCopyBuilder(_other));
  }

  @Override
  public <_B> GetAllTaskDetailsResponse.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new GetAllTaskDetailsResponse.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public GetAllTaskDetailsResponse.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static GetAllTaskDetailsResponse.Builder<Void> builder() {
    return new GetAllTaskDetailsResponse.Builder<>(null, null, false);
  }

  public static <_B> GetAllTaskDetailsResponse.Builder<_B> copyOf(final X1ResponseMessage _other) {
    final GetAllTaskDetailsResponse.Builder<_B> _newBuilder = new GetAllTaskDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> GetAllTaskDetailsResponse.Builder<_B> copyOf(final GetAllTaskDetailsResponse _other) {
    final GetAllTaskDetailsResponse.Builder<_B> _newBuilder = new GetAllTaskDetailsResponse.Builder<>(
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
    final GetAllTaskDetailsResponse.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree listOfTaskResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("listOfTaskResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (listOfTaskResponseDetailsPropertyTree != null)
          : ((listOfTaskResponseDetailsPropertyTree == null) || (!listOfTaskResponseDetailsPropertyTree.isLeaf())))
    ) {
      _other.listOfTaskResponseDetails = ((this.listOfTaskResponseDetails == null)
          ? null
          : this.listOfTaskResponseDetails.newCopyBuilder(
              _other,
              listOfTaskResponseDetailsPropertyTree,
              _propertyTreeUse
            ));
    }
  }

  @Override
  public <_B> GetAllTaskDetailsResponse.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new GetAllTaskDetailsResponse.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public GetAllTaskDetailsResponse.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> GetAllTaskDetailsResponse.Builder<_B> copyOf(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetAllTaskDetailsResponse.Builder<_B> _newBuilder = new GetAllTaskDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> GetAllTaskDetailsResponse.Builder<_B> copyOf(
    final GetAllTaskDetailsResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetAllTaskDetailsResponse.Builder<_B> _newBuilder = new GetAllTaskDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static GetAllTaskDetailsResponse.Builder<Void> copyExcept(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetAllTaskDetailsResponse.Builder<Void> copyExcept(
    final GetAllTaskDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetAllTaskDetailsResponse.Builder<Void> copyOnly(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static GetAllTaskDetailsResponse.Builder<Void> copyOnly(
    final GetAllTaskDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1ResponseMessage.Builder<_B> implements Buildable {

    private ListOfTaskResponseDetails.Builder<GetAllTaskDetailsResponse.Builder<_B>> listOfTaskResponseDetails;

    public Builder(final _B _parentBuilder, final GetAllTaskDetailsResponse _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {
        this.listOfTaskResponseDetails = ((_other.listOfTaskResponseDetails == null)
            ? null
            : _other.listOfTaskResponseDetails.newCopyBuilder(this));
      }
    }

    public Builder(
      final _B _parentBuilder,
      final GetAllTaskDetailsResponse _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {
        final PropertyTree listOfTaskResponseDetailsPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("listOfTaskResponseDetails"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (listOfTaskResponseDetailsPropertyTree != null)
              : ((listOfTaskResponseDetailsPropertyTree == null) || (!listOfTaskResponseDetailsPropertyTree.isLeaf())))
        ) {
          this.listOfTaskResponseDetails = ((_other.listOfTaskResponseDetails == null)
              ? null
              : _other.listOfTaskResponseDetails.newCopyBuilder(
                this,
                listOfTaskResponseDetailsPropertyTree,
                _propertyTreeUse
              ));
        }
      }
    }

    protected <_P extends GetAllTaskDetailsResponse> _P init(final _P _product) {
      _product.listOfTaskResponseDetails = ((this.listOfTaskResponseDetails == null)
          ? null
          : this.listOfTaskResponseDetails.build());
      return super.init(_product);
    }

    /**
     * Sets the new value of "listOfTaskResponseDetails" (any previous value will be
     * replaced)
     *
     * @param listOfTaskResponseDetails
     *     New value of the "listOfTaskResponseDetails" property.
     */
    public GetAllTaskDetailsResponse.Builder<_B> withListOfTaskResponseDetails(
      final ListOfTaskResponseDetails listOfTaskResponseDetails
    ) {
      this.listOfTaskResponseDetails = ((listOfTaskResponseDetails == null)
          ? null
          : new ListOfTaskResponseDetails.Builder<>(this, listOfTaskResponseDetails, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "listOfTaskResponseDetails" property.
     * Use {@link
     * org.etsi.uri._03221.x1._2017._10.ListOfTaskResponseDetails.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "listOfTaskResponseDetails" property.
     *     Use {@link
     *     org.etsi.uri._03221.x1._2017._10.ListOfTaskResponseDetails.Builder#end()} to
     *     return to the current builder.
     */
    public ListOfTaskResponseDetails.Builder<
      ? extends GetAllTaskDetailsResponse.Builder<_B>
    > withListOfTaskResponseDetails() {
      if (this.listOfTaskResponseDetails != null) {
        return this.listOfTaskResponseDetails;
      }
      return this.listOfTaskResponseDetails = new ListOfTaskResponseDetails.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public GetAllTaskDetailsResponse.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public GetAllTaskDetailsResponse.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public GetAllTaskDetailsResponse.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
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
    public GetAllTaskDetailsResponse.Builder<_B> withVersion(final String version) {
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
    public GetAllTaskDetailsResponse.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public GetAllTaskDetailsResponse build() {
      if (_storedValue == null) {
        return this.init(new GetAllTaskDetailsResponse());
      } else {
        return ((GetAllTaskDetailsResponse) _storedValue);
      }
    }

    public GetAllTaskDetailsResponse.Builder<_B> copyOf(final GetAllTaskDetailsResponse _other) {
      _other.copyTo(this);
      return this;
    }

    public GetAllTaskDetailsResponse.Builder<_B> copyOf(final GetAllTaskDetailsResponse.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
