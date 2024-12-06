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
import jakarta.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for GetDestinationDetailsResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="GetDestinationDetailsResponse">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage">
 *       <sequence>
 *         <element name="destinationResponseDetails" type="{http://uri.etsi.org/03221/X1/2017/10}DestinationResponseDetails"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDestinationDetailsResponse", propOrder = { "destinationResponseDetails" })
public class GetDestinationDetailsResponse extends X1ResponseMessage implements Copyable, PartialCopyable {

  @XmlElement(required = true)
  protected DestinationResponseDetails destinationResponseDetails;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public GetDestinationDetailsResponse() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a GetDestinationDetailsResponse copying the state of another GetDestinationDetailsResponse
   *
   * @param _other
   *     The original GetDestinationDetailsResponse from which to copy state.
   */
  public GetDestinationDetailsResponse(final GetDestinationDetailsResponse _other) {
    super(_other);
    this.destinationResponseDetails = ((_other.destinationResponseDetails == null)
        ? null
        : _other.destinationResponseDetails.createCopy());
  }

  /**
   * Instantiates a GetDestinationDetailsResponse copying the state of another GetDestinationDetailsResponse
   *
   * @param _other
   *     The original GetDestinationDetailsResponse from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public GetDestinationDetailsResponse(
    final GetDestinationDetailsResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree destinationResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationResponseDetailsPropertyTree != null)
          : ((destinationResponseDetailsPropertyTree == null) || (!destinationResponseDetailsPropertyTree.isLeaf())))
    ) {
      this.destinationResponseDetails = ((_other.destinationResponseDetails == null)
          ? null
          : _other.destinationResponseDetails.createCopy(destinationResponseDetailsPropertyTree, _propertyTreeUse));
    }
  }

  /**
   * Gets the value of the destinationResponseDetails property.
   *
   * @return
   *     possible object is
   *     {@link DestinationResponseDetails }
   *
   */
  public DestinationResponseDetails getDestinationResponseDetails() {
    return destinationResponseDetails;
  }

  /**
   * Sets the value of the destinationResponseDetails property.
   *
   * @param value
   *     allowed object is
   *     {@link DestinationResponseDetails }
   *
   */
  public void setDestinationResponseDetails(DestinationResponseDetails value) {
    this.destinationResponseDetails = value;
  }

  @Override
  public GetDestinationDetailsResponse createCopy() {
    final GetDestinationDetailsResponse _newObject = ((GetDestinationDetailsResponse) super.createCopy());
    _newObject.destinationResponseDetails = ((this.destinationResponseDetails == null)
        ? null
        : this.destinationResponseDetails.createCopy());
    return _newObject;
  }

  @Override
  public GetDestinationDetailsResponse createCopy(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetDestinationDetailsResponse _newObject =
      ((GetDestinationDetailsResponse) super.createCopy(_propertyTree, _propertyTreeUse));
    final PropertyTree destinationResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationResponseDetailsPropertyTree != null)
          : ((destinationResponseDetailsPropertyTree == null) || (!destinationResponseDetailsPropertyTree.isLeaf())))
    ) {
      _newObject.destinationResponseDetails = ((this.destinationResponseDetails == null)
          ? null
          : this.destinationResponseDetails.createCopy(destinationResponseDetailsPropertyTree, _propertyTreeUse));
    }
    return _newObject;
  }

  @Override
  public GetDestinationDetailsResponse copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public GetDestinationDetailsResponse copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final GetDestinationDetailsResponse.Builder<_B> _other) {
    super.copyTo(_other);
    _other.destinationResponseDetails = ((this.destinationResponseDetails == null)
        ? null
        : this.destinationResponseDetails.newCopyBuilder(_other));
  }

  @Override
  public <_B> GetDestinationDetailsResponse.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new GetDestinationDetailsResponse.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public GetDestinationDetailsResponse.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static GetDestinationDetailsResponse.Builder<Void> builder() {
    return new GetDestinationDetailsResponse.Builder<>(null, null, false);
  }

  public static <_B> GetDestinationDetailsResponse.Builder<_B> copyOf(final X1ResponseMessage _other) {
    final GetDestinationDetailsResponse.Builder<_B> _newBuilder = new GetDestinationDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> GetDestinationDetailsResponse.Builder<_B> copyOf(final GetDestinationDetailsResponse _other) {
    final GetDestinationDetailsResponse.Builder<_B> _newBuilder = new GetDestinationDetailsResponse.Builder<>(
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
    final GetDestinationDetailsResponse.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree destinationResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationResponseDetailsPropertyTree != null)
          : ((destinationResponseDetailsPropertyTree == null) || (!destinationResponseDetailsPropertyTree.isLeaf())))
    ) {
      _other.destinationResponseDetails = ((this.destinationResponseDetails == null)
          ? null
          : this.destinationResponseDetails.newCopyBuilder(
              _other,
              destinationResponseDetailsPropertyTree,
              _propertyTreeUse
            ));
    }
  }

  @Override
  public <_B> GetDestinationDetailsResponse.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new GetDestinationDetailsResponse.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public GetDestinationDetailsResponse.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> GetDestinationDetailsResponse.Builder<_B> copyOf(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetDestinationDetailsResponse.Builder<_B> _newBuilder = new GetDestinationDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> GetDestinationDetailsResponse.Builder<_B> copyOf(
    final GetDestinationDetailsResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetDestinationDetailsResponse.Builder<_B> _newBuilder = new GetDestinationDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static GetDestinationDetailsResponse.Builder<Void> copyExcept(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetDestinationDetailsResponse.Builder<Void> copyExcept(
    final GetDestinationDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetDestinationDetailsResponse.Builder<Void> copyOnly(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static GetDestinationDetailsResponse.Builder<Void> copyOnly(
    final GetDestinationDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1ResponseMessage.Builder<_B> implements Buildable {

    private DestinationResponseDetails.Builder<GetDestinationDetailsResponse.Builder<_B>> destinationResponseDetails;

    public Builder(final _B _parentBuilder, final GetDestinationDetailsResponse _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {
        this.destinationResponseDetails = ((_other.destinationResponseDetails == null)
            ? null
            : _other.destinationResponseDetails.newCopyBuilder(this));
      }
    }

    public Builder(
      final _B _parentBuilder,
      final GetDestinationDetailsResponse _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {
        final PropertyTree destinationResponseDetailsPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("destinationResponseDetails"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (destinationResponseDetailsPropertyTree != null)
              : ((destinationResponseDetailsPropertyTree == null) ||
                (!destinationResponseDetailsPropertyTree.isLeaf())))
        ) {
          this.destinationResponseDetails = ((_other.destinationResponseDetails == null)
              ? null
              : _other.destinationResponseDetails.newCopyBuilder(
                this,
                destinationResponseDetailsPropertyTree,
                _propertyTreeUse
              ));
        }
      }
    }

    protected <_P extends GetDestinationDetailsResponse> _P init(final _P _product) {
      _product.destinationResponseDetails = ((this.destinationResponseDetails == null)
          ? null
          : this.destinationResponseDetails.build());
      return super.init(_product);
    }

    /**
     * Sets the new value of "destinationResponseDetails" (any previous value will be
     * replaced)
     *
     * @param destinationResponseDetails
     *     New value of the "destinationResponseDetails" property.
     */
    public GetDestinationDetailsResponse.Builder<_B> withDestinationResponseDetails(
      final DestinationResponseDetails destinationResponseDetails
    ) {
      this.destinationResponseDetails = ((destinationResponseDetails == null)
          ? null
          : new DestinationResponseDetails.Builder<>(this, destinationResponseDetails, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "destinationResponseDetails" property.
     * Use {@link
     * org.etsi.uri._03221.x1._2017._10.DestinationResponseDetails.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "destinationResponseDetails" property.
     *     Use {@link
     *     org.etsi.uri._03221.x1._2017._10.DestinationResponseDetails.Builder#end()} to
     *     return to the current builder.
     */
    public DestinationResponseDetails.Builder<
      ? extends GetDestinationDetailsResponse.Builder<_B>
    > withDestinationResponseDetails() {
      if (this.destinationResponseDetails != null) {
        return this.destinationResponseDetails;
      }
      return this.destinationResponseDetails = new DestinationResponseDetails.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public GetDestinationDetailsResponse.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public GetDestinationDetailsResponse.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public GetDestinationDetailsResponse.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
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
    public GetDestinationDetailsResponse.Builder<_B> withVersion(final String version) {
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
    public GetDestinationDetailsResponse.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public GetDestinationDetailsResponse build() {
      if (_storedValue == null) {
        return this.init(new GetDestinationDetailsResponse());
      } else {
        return ((GetDestinationDetailsResponse) _storedValue);
      }
    }

    public GetDestinationDetailsResponse.Builder<_B> copyOf(final GetDestinationDetailsResponse _other) {
      _other.copyTo(this);
      return this;
    }

    public GetDestinationDetailsResponse.Builder<_B> copyOf(final GetDestinationDetailsResponse.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select
    extends GetDestinationDetailsResponse.Selector<GetDestinationDetailsResponse.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static GetDestinationDetailsResponse.Select _root() {
      return new GetDestinationDetailsResponse.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends X1ResponseMessage.Selector<TRoot, TParent> {

    private DestinationResponseDetails.Selector<
      TRoot,
      GetDestinationDetailsResponse.Selector<TRoot, TParent>
    > destinationResponseDetails = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.destinationResponseDetails != null) {
        products.put("destinationResponseDetails", this.destinationResponseDetails.init());
      }
      return products;
    }

    public DestinationResponseDetails.Selector<
      TRoot,
      GetDestinationDetailsResponse.Selector<TRoot, TParent>
    > destinationResponseDetails() {
      return (
        (this.destinationResponseDetails == null)
          ? this.destinationResponseDetails = new DestinationResponseDetails.Selector<>(
            this._root,
            this,
            "destinationResponseDetails"
          )
          : this.destinationResponseDetails
      );
    }
  }
}
