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
 * <p>Java class for GetNEStatusRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="GetNEStatusRequest">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1RequestMessage">
 *       <sequence>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetNEStatusRequest")
public class GetNEStatusRequest extends X1RequestMessage implements Copyable, PartialCopyable {

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public GetNEStatusRequest() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a GetNEStatusRequest copying the state of another GetNEStatusRequest
   *
   * @param _other
   *     The original GetNEStatusRequest from which to copy state.
   */
  public GetNEStatusRequest(final GetNEStatusRequest _other) {
    super(_other);
  }

  /**
   * Instantiates a GetNEStatusRequest copying the state of another GetNEStatusRequest
   *
   * @param _other
   *     The original GetNEStatusRequest from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public GetNEStatusRequest(
    final GetNEStatusRequest _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super(_other, _propertyTree, _propertyTreeUse);
  }

  @Override
  public GetNEStatusRequest createCopy() {
    final GetNEStatusRequest _newObject = ((GetNEStatusRequest) super.createCopy());
    return _newObject;
  }

  @Override
  public GetNEStatusRequest createCopy(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final GetNEStatusRequest _newObject = ((GetNEStatusRequest) super.createCopy(_propertyTree, _propertyTreeUse));
    return _newObject;
  }

  @Override
  public GetNEStatusRequest copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public GetNEStatusRequest copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final GetNEStatusRequest.Builder<_B> _other) {
    super.copyTo(_other);
  }

  @Override
  public <_B> GetNEStatusRequest.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new GetNEStatusRequest.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public GetNEStatusRequest.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static GetNEStatusRequest.Builder<Void> builder() {
    return new GetNEStatusRequest.Builder<>(null, null, false);
  }

  public static <_B> GetNEStatusRequest.Builder<_B> copyOf(final X1RequestMessage _other) {
    final GetNEStatusRequest.Builder<_B> _newBuilder = new GetNEStatusRequest.Builder<>(null, null, false);
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> GetNEStatusRequest.Builder<_B> copyOf(final GetNEStatusRequest _other) {
    final GetNEStatusRequest.Builder<_B> _newBuilder = new GetNEStatusRequest.Builder<>(null, null, false);
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
    final GetNEStatusRequest.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
  }

  @Override
  public <_B> GetNEStatusRequest.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new GetNEStatusRequest.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public GetNEStatusRequest.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> GetNEStatusRequest.Builder<_B> copyOf(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetNEStatusRequest.Builder<_B> _newBuilder = new GetNEStatusRequest.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> GetNEStatusRequest.Builder<_B> copyOf(
    final GetNEStatusRequest _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetNEStatusRequest.Builder<_B> _newBuilder = new GetNEStatusRequest.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static GetNEStatusRequest.Builder<Void> copyExcept(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetNEStatusRequest.Builder<Void> copyExcept(
    final GetNEStatusRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetNEStatusRequest.Builder<Void> copyOnly(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static GetNEStatusRequest.Builder<Void> copyOnly(
    final GetNEStatusRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1RequestMessage.Builder<_B> implements Buildable {

    public Builder(final _B _parentBuilder, final GetNEStatusRequest _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {}
    }

    public Builder(
      final _B _parentBuilder,
      final GetNEStatusRequest _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {}
    }

    protected <_P extends GetNEStatusRequest> _P init(final _P _product) {
      return super.init(_product);
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public GetNEStatusRequest.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public GetNEStatusRequest.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public GetNEStatusRequest.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
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
    public GetNEStatusRequest.Builder<_B> withVersion(final String version) {
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
    public GetNEStatusRequest.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public GetNEStatusRequest build() {
      if (_storedValue == null) {
        return this.init(new GetNEStatusRequest());
      } else {
        return ((GetNEStatusRequest) _storedValue);
      }
    }

    public GetNEStatusRequest.Builder<_B> copyOf(final GetNEStatusRequest _other) {
      _other.copyTo(this);
      return this;
    }

    public GetNEStatusRequest.Builder<_B> copyOf(final GetNEStatusRequest.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends GetNEStatusRequest.Selector<GetNEStatusRequest.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static GetNEStatusRequest.Select _root() {
      return new GetNEStatusRequest.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends X1RequestMessage.Selector<TRoot, TParent> {

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      return products;
    }
  }
}
