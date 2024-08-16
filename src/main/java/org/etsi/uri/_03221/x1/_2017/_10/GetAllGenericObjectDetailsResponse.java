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
import jakarta.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for GetAllGenericObjectDetailsResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="GetAllGenericObjectDetailsResponse">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage">
 *       <sequence>
 *         <element name="listOfGenericObjectResponseDetails" type="{http://uri.etsi.org/03221/X1/2017/10}ListOfGenericObjectResponseDetails" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllGenericObjectDetailsResponse", propOrder = { "listOfGenericObjectResponseDetails" })
public class GetAllGenericObjectDetailsResponse extends X1ResponseMessage implements Copyable, PartialCopyable {

  protected ListOfGenericObjectResponseDetails listOfGenericObjectResponseDetails;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public GetAllGenericObjectDetailsResponse() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a GetAllGenericObjectDetailsResponse copying the state of another GetAllGenericObjectDetailsResponse
   *
   * @param _other
   *     The original GetAllGenericObjectDetailsResponse from which to copy state.
   */
  public GetAllGenericObjectDetailsResponse(final GetAllGenericObjectDetailsResponse _other) {
    super(_other);
    this.listOfGenericObjectResponseDetails = ((_other.listOfGenericObjectResponseDetails == null)
        ? null
        : _other.listOfGenericObjectResponseDetails.createCopy());
  }

  /**
   * Instantiates a GetAllGenericObjectDetailsResponse copying the state of another GetAllGenericObjectDetailsResponse
   *
   * @param _other
   *     The original GetAllGenericObjectDetailsResponse from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public GetAllGenericObjectDetailsResponse(
    final GetAllGenericObjectDetailsResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree listOfGenericObjectResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("listOfGenericObjectResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (listOfGenericObjectResponseDetailsPropertyTree != null)
          : ((listOfGenericObjectResponseDetailsPropertyTree == null) ||
            (!listOfGenericObjectResponseDetailsPropertyTree.isLeaf())))
    ) {
      this.listOfGenericObjectResponseDetails = ((_other.listOfGenericObjectResponseDetails == null)
          ? null
          : _other.listOfGenericObjectResponseDetails.createCopy(
            listOfGenericObjectResponseDetailsPropertyTree,
            _propertyTreeUse
          ));
    }
  }

  /**
   * Gets the value of the listOfGenericObjectResponseDetails property.
   *
   * @return
   *     possible object is
   *     {@link ListOfGenericObjectResponseDetails }
   *
   */
  public ListOfGenericObjectResponseDetails getListOfGenericObjectResponseDetails() {
    return listOfGenericObjectResponseDetails;
  }

  /**
   * Sets the value of the listOfGenericObjectResponseDetails property.
   *
   * @param value
   *     allowed object is
   *     {@link ListOfGenericObjectResponseDetails }
   *
   */
  public void setListOfGenericObjectResponseDetails(ListOfGenericObjectResponseDetails value) {
    this.listOfGenericObjectResponseDetails = value;
  }

  @Override
  public GetAllGenericObjectDetailsResponse createCopy() {
    final GetAllGenericObjectDetailsResponse _newObject = ((GetAllGenericObjectDetailsResponse) super.createCopy());
    _newObject.listOfGenericObjectResponseDetails = ((this.listOfGenericObjectResponseDetails == null)
        ? null
        : this.listOfGenericObjectResponseDetails.createCopy());
    return _newObject;
  }

  @Override
  public GetAllGenericObjectDetailsResponse createCopy(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetAllGenericObjectDetailsResponse _newObject =
      ((GetAllGenericObjectDetailsResponse) super.createCopy(_propertyTree, _propertyTreeUse));
    final PropertyTree listOfGenericObjectResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("listOfGenericObjectResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (listOfGenericObjectResponseDetailsPropertyTree != null)
          : ((listOfGenericObjectResponseDetailsPropertyTree == null) ||
            (!listOfGenericObjectResponseDetailsPropertyTree.isLeaf())))
    ) {
      _newObject.listOfGenericObjectResponseDetails = ((this.listOfGenericObjectResponseDetails == null)
          ? null
          : this.listOfGenericObjectResponseDetails.createCopy(
              listOfGenericObjectResponseDetailsPropertyTree,
              _propertyTreeUse
            ));
    }
    return _newObject;
  }

  @Override
  public GetAllGenericObjectDetailsResponse copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public GetAllGenericObjectDetailsResponse copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final GetAllGenericObjectDetailsResponse.Builder<_B> _other) {
    super.copyTo(_other);
    _other.listOfGenericObjectResponseDetails = ((this.listOfGenericObjectResponseDetails == null)
        ? null
        : this.listOfGenericObjectResponseDetails.newCopyBuilder(_other));
  }

  @Override
  public <_B> GetAllGenericObjectDetailsResponse.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new GetAllGenericObjectDetailsResponse.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public GetAllGenericObjectDetailsResponse.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static GetAllGenericObjectDetailsResponse.Builder<Void> builder() {
    return new GetAllGenericObjectDetailsResponse.Builder<>(null, null, false);
  }

  public static <_B> GetAllGenericObjectDetailsResponse.Builder<_B> copyOf(final X1ResponseMessage _other) {
    final GetAllGenericObjectDetailsResponse.Builder<_B> _newBuilder = new GetAllGenericObjectDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> GetAllGenericObjectDetailsResponse.Builder<_B> copyOf(
    final GetAllGenericObjectDetailsResponse _other
  ) {
    final GetAllGenericObjectDetailsResponse.Builder<_B> _newBuilder = new GetAllGenericObjectDetailsResponse.Builder<>(
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
    final GetAllGenericObjectDetailsResponse.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree listOfGenericObjectResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("listOfGenericObjectResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (listOfGenericObjectResponseDetailsPropertyTree != null)
          : ((listOfGenericObjectResponseDetailsPropertyTree == null) ||
            (!listOfGenericObjectResponseDetailsPropertyTree.isLeaf())))
    ) {
      _other.listOfGenericObjectResponseDetails = ((this.listOfGenericObjectResponseDetails == null)
          ? null
          : this.listOfGenericObjectResponseDetails.newCopyBuilder(
              _other,
              listOfGenericObjectResponseDetailsPropertyTree,
              _propertyTreeUse
            ));
    }
  }

  @Override
  public <_B> GetAllGenericObjectDetailsResponse.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new GetAllGenericObjectDetailsResponse.Builder<_B>(
      _parentBuilder,
      this,
      true,
      _propertyTree,
      _propertyTreeUse
    );
  }

  @Override
  public GetAllGenericObjectDetailsResponse.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> GetAllGenericObjectDetailsResponse.Builder<_B> copyOf(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetAllGenericObjectDetailsResponse.Builder<_B> _newBuilder = new GetAllGenericObjectDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> GetAllGenericObjectDetailsResponse.Builder<_B> copyOf(
    final GetAllGenericObjectDetailsResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetAllGenericObjectDetailsResponse.Builder<_B> _newBuilder = new GetAllGenericObjectDetailsResponse.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static GetAllGenericObjectDetailsResponse.Builder<Void> copyExcept(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetAllGenericObjectDetailsResponse.Builder<Void> copyExcept(
    final GetAllGenericObjectDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetAllGenericObjectDetailsResponse.Builder<Void> copyOnly(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static GetAllGenericObjectDetailsResponse.Builder<Void> copyOnly(
    final GetAllGenericObjectDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1ResponseMessage.Builder<_B> implements Buildable {

    private ListOfGenericObjectResponseDetails.Builder<
      GetAllGenericObjectDetailsResponse.Builder<_B>
    > listOfGenericObjectResponseDetails;

    public Builder(final _B _parentBuilder, final GetAllGenericObjectDetailsResponse _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {
        this.listOfGenericObjectResponseDetails = ((_other.listOfGenericObjectResponseDetails == null)
            ? null
            : _other.listOfGenericObjectResponseDetails.newCopyBuilder(this));
      }
    }

    public Builder(
      final _B _parentBuilder,
      final GetAllGenericObjectDetailsResponse _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {
        final PropertyTree listOfGenericObjectResponseDetailsPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("listOfGenericObjectResponseDetails"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (listOfGenericObjectResponseDetailsPropertyTree != null)
              : ((listOfGenericObjectResponseDetailsPropertyTree == null) ||
                (!listOfGenericObjectResponseDetailsPropertyTree.isLeaf())))
        ) {
          this.listOfGenericObjectResponseDetails = ((_other.listOfGenericObjectResponseDetails == null)
              ? null
              : _other.listOfGenericObjectResponseDetails.newCopyBuilder(
                this,
                listOfGenericObjectResponseDetailsPropertyTree,
                _propertyTreeUse
              ));
        }
      }
    }

    protected <_P extends GetAllGenericObjectDetailsResponse> _P init(final _P _product) {
      _product.listOfGenericObjectResponseDetails = ((this.listOfGenericObjectResponseDetails == null)
          ? null
          : this.listOfGenericObjectResponseDetails.build());
      return super.init(_product);
    }

    /**
     * Sets the new value of "listOfGenericObjectResponseDetails" (any previous value
     * will be replaced)
     *
     * @param listOfGenericObjectResponseDetails
     *     New value of the "listOfGenericObjectResponseDetails" property.
     */
    public GetAllGenericObjectDetailsResponse.Builder<_B> withListOfGenericObjectResponseDetails(
      final ListOfGenericObjectResponseDetails listOfGenericObjectResponseDetails
    ) {
      this.listOfGenericObjectResponseDetails = ((listOfGenericObjectResponseDetails == null)
          ? null
          : new ListOfGenericObjectResponseDetails.Builder<>(this, listOfGenericObjectResponseDetails, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "listOfGenericObjectResponseDetails" property.
     * Use {@link
     * org.etsi.uri._03221.x1._2017._10.ListOfGenericObjectResponseDetails.Builder#end()}
     * to return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "listOfGenericObjectResponseDetails"
     *     property.
     *     Use {@link
     *     org.etsi.uri._03221.x1._2017._10.ListOfGenericObjectResponseDetails.Builder#end()}
     *     to return to the current builder.
     */
    public ListOfGenericObjectResponseDetails.Builder<
      ? extends GetAllGenericObjectDetailsResponse.Builder<_B>
    > withListOfGenericObjectResponseDetails() {
      if (this.listOfGenericObjectResponseDetails != null) {
        return this.listOfGenericObjectResponseDetails;
      }
      return (
        this.listOfGenericObjectResponseDetails = new ListOfGenericObjectResponseDetails.Builder<>(this, null, false)
      );
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public GetAllGenericObjectDetailsResponse.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public GetAllGenericObjectDetailsResponse.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public GetAllGenericObjectDetailsResponse.Builder<_B> withMessageTimestamp(
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
    public GetAllGenericObjectDetailsResponse.Builder<_B> withVersion(final String version) {
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
    public GetAllGenericObjectDetailsResponse.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public GetAllGenericObjectDetailsResponse build() {
      if (_storedValue == null) {
        return this.init(new GetAllGenericObjectDetailsResponse());
      } else {
        return ((GetAllGenericObjectDetailsResponse) _storedValue);
      }
    }

    public GetAllGenericObjectDetailsResponse.Builder<_B> copyOf(final GetAllGenericObjectDetailsResponse _other) {
      _other.copyTo(this);
      return this;
    }

    public GetAllGenericObjectDetailsResponse.Builder<_B> copyOf(
      final GetAllGenericObjectDetailsResponse.Builder _other
    ) {
      return copyOf(_other.build());
    }
  }

  public static class Select
    extends GetAllGenericObjectDetailsResponse.Selector<GetAllGenericObjectDetailsResponse.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static GetAllGenericObjectDetailsResponse.Select _root() {
      return new GetAllGenericObjectDetailsResponse.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends X1ResponseMessage.Selector<TRoot, TParent> {

    private ListOfGenericObjectResponseDetails.Selector<
      TRoot,
      GetAllGenericObjectDetailsResponse.Selector<TRoot, TParent>
    > listOfGenericObjectResponseDetails = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.listOfGenericObjectResponseDetails != null) {
        products.put("listOfGenericObjectResponseDetails", this.listOfGenericObjectResponseDetails.init());
      }
      return products;
    }

    public ListOfGenericObjectResponseDetails.Selector<
      TRoot,
      GetAllGenericObjectDetailsResponse.Selector<TRoot, TParent>
    > listOfGenericObjectResponseDetails() {
      return (
        (this.listOfGenericObjectResponseDetails == null)
          ? this.listOfGenericObjectResponseDetails = new ListOfGenericObjectResponseDetails.Selector<>(
            this._root,
            this,
            "listOfGenericObjectResponseDetails"
          )
          : this.listOfGenericObjectResponseDetails
      );
    }
  }
}
