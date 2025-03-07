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
 * <p>Java class for RemoveAllDestinationsRequest complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="RemoveAllDestinationsRequest">
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
@XmlType(name = "RemoveAllDestinationsRequest")
public class RemoveAllDestinationsRequest extends X1RequestMessage implements Copyable {

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public RemoveAllDestinationsRequest() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a RemoveAllDestinationsRequest copying the state of another RemoveAllDestinationsRequest
   *
   * @param _other
   *     The original RemoveAllDestinationsRequest from which to copy state.
   */
  public RemoveAllDestinationsRequest(final RemoveAllDestinationsRequest _other) {
    super(_other);
  }

  @Override
  public RemoveAllDestinationsRequest createCopy() {
    final RemoveAllDestinationsRequest _newObject = ((RemoveAllDestinationsRequest) super.createCopy());
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final RemoveAllDestinationsRequest.Builder<_B> _other) {
    super.copyTo(_other);
  }

  @Override
  public <_B> RemoveAllDestinationsRequest.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new RemoveAllDestinationsRequest.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public RemoveAllDestinationsRequest.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static RemoveAllDestinationsRequest.Builder<Void> builder() {
    return new RemoveAllDestinationsRequest.Builder<>(null, null, false);
  }

  public static <_B> RemoveAllDestinationsRequest.Builder<_B> copyOf(final X1RequestMessage _other) {
    final RemoveAllDestinationsRequest.Builder<_B> _newBuilder = new RemoveAllDestinationsRequest.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> RemoveAllDestinationsRequest.Builder<_B> copyOf(final RemoveAllDestinationsRequest _other) {
    final RemoveAllDestinationsRequest.Builder<_B> _newBuilder = new RemoveAllDestinationsRequest.Builder<>(
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
    final RemoveAllDestinationsRequest.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
  }

  @Override
  public <_B> RemoveAllDestinationsRequest.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new RemoveAllDestinationsRequest.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public RemoveAllDestinationsRequest.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> RemoveAllDestinationsRequest.Builder<_B> copyOf(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final RemoveAllDestinationsRequest.Builder<_B> _newBuilder = new RemoveAllDestinationsRequest.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> RemoveAllDestinationsRequest.Builder<_B> copyOf(
    final RemoveAllDestinationsRequest _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final RemoveAllDestinationsRequest.Builder<_B> _newBuilder = new RemoveAllDestinationsRequest.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static RemoveAllDestinationsRequest.Builder<Void> copyExcept(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static RemoveAllDestinationsRequest.Builder<Void> copyExcept(
    final RemoveAllDestinationsRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static RemoveAllDestinationsRequest.Builder<Void> copyOnly(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static RemoveAllDestinationsRequest.Builder<Void> copyOnly(
    final RemoveAllDestinationsRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1RequestMessage.Builder<_B> implements Buildable {

    public Builder(final _B _parentBuilder, final RemoveAllDestinationsRequest _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {}
    }

    public Builder(
      final _B _parentBuilder,
      final RemoveAllDestinationsRequest _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {}
    }

    protected <_P extends RemoveAllDestinationsRequest> _P init(final _P _product) {
      return super.init(_product);
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public RemoveAllDestinationsRequest.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public RemoveAllDestinationsRequest.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public RemoveAllDestinationsRequest.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
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
    public RemoveAllDestinationsRequest.Builder<_B> withVersion(final String version) {
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
    public RemoveAllDestinationsRequest.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public RemoveAllDestinationsRequest build() {
      if (_storedValue == null) {
        return this.init(new RemoveAllDestinationsRequest());
      } else {
        return ((RemoveAllDestinationsRequest) _storedValue);
      }
    }

    public RemoveAllDestinationsRequest.Builder<_B> copyOf(final RemoveAllDestinationsRequest _other) {
      _other.copyTo(this);
      return this;
    }

    public RemoveAllDestinationsRequest.Builder<_B> copyOf(final RemoveAllDestinationsRequest.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
