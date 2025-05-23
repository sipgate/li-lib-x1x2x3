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
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for DeactivateTaskRequest complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="DeactivateTaskRequest">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1RequestMessage">
 *       <sequence>
 *         <element name="xId" type="{http://uri.etsi.org/03221/X1/2017/10}XId"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeactivateTaskRequest", propOrder = { "xId" })
public class DeactivateTaskRequest extends X1RequestMessage implements Copyable {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String xId;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public DeactivateTaskRequest() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a DeactivateTaskRequest copying the state of another DeactivateTaskRequest
   *
   * @param _other
   *     The original DeactivateTaskRequest from which to copy state.
   */
  public DeactivateTaskRequest(final DeactivateTaskRequest _other) {
    super(_other);
    this.xId = _other.xId;
  }

  /**
   * Gets the value of the xId property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getXId() {
    return xId;
  }

  /**
   * Sets the value of the xId property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setXId(String value) {
    this.xId = value;
  }

  @Override
  public DeactivateTaskRequest createCopy() {
    final DeactivateTaskRequest _newObject = ((DeactivateTaskRequest) super.createCopy());
    _newObject.xId = this.xId;
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final DeactivateTaskRequest.Builder<_B> _other) {
    super.copyTo(_other);
    _other.xId = this.xId;
  }

  @Override
  public <_B> DeactivateTaskRequest.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new DeactivateTaskRequest.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public DeactivateTaskRequest.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static DeactivateTaskRequest.Builder<Void> builder() {
    return new DeactivateTaskRequest.Builder<>(null, null, false);
  }

  public static <_B> DeactivateTaskRequest.Builder<_B> copyOf(final X1RequestMessage _other) {
    final DeactivateTaskRequest.Builder<_B> _newBuilder = new DeactivateTaskRequest.Builder<>(null, null, false);
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> DeactivateTaskRequest.Builder<_B> copyOf(final DeactivateTaskRequest _other) {
    final DeactivateTaskRequest.Builder<_B> _newBuilder = new DeactivateTaskRequest.Builder<>(null, null, false);
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
    final DeactivateTaskRequest.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree xIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("xId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (xIdPropertyTree != null)
          : ((xIdPropertyTree == null) || (!xIdPropertyTree.isLeaf())))
    ) {
      _other.xId = this.xId;
    }
  }

  @Override
  public <_B> DeactivateTaskRequest.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new DeactivateTaskRequest.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public DeactivateTaskRequest.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> DeactivateTaskRequest.Builder<_B> copyOf(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final DeactivateTaskRequest.Builder<_B> _newBuilder = new DeactivateTaskRequest.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> DeactivateTaskRequest.Builder<_B> copyOf(
    final DeactivateTaskRequest _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final DeactivateTaskRequest.Builder<_B> _newBuilder = new DeactivateTaskRequest.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static DeactivateTaskRequest.Builder<Void> copyExcept(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static DeactivateTaskRequest.Builder<Void> copyExcept(
    final DeactivateTaskRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static DeactivateTaskRequest.Builder<Void> copyOnly(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static DeactivateTaskRequest.Builder<Void> copyOnly(
    final DeactivateTaskRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1RequestMessage.Builder<_B> implements Buildable {

    private String xId;

    public Builder(final _B _parentBuilder, final DeactivateTaskRequest _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {
        this.xId = _other.xId;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final DeactivateTaskRequest _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {
        final PropertyTree xIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("xId"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (xIdPropertyTree != null)
              : ((xIdPropertyTree == null) || (!xIdPropertyTree.isLeaf())))
        ) {
          this.xId = _other.xId;
        }
      }
    }

    protected <_P extends DeactivateTaskRequest> _P init(final _P _product) {
      _product.xId = this.xId;
      return super.init(_product);
    }

    /**
     * Sets the new value of "xId" (any previous value will be replaced)
     *
     * @param xId
     *     New value of the "xId" property.
     */
    public DeactivateTaskRequest.Builder<_B> withXId(final String xId) {
      this.xId = xId;
      return this;
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public DeactivateTaskRequest.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public DeactivateTaskRequest.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public DeactivateTaskRequest.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
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
    public DeactivateTaskRequest.Builder<_B> withVersion(final String version) {
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
    public DeactivateTaskRequest.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public DeactivateTaskRequest build() {
      if (_storedValue == null) {
        return this.init(new DeactivateTaskRequest());
      } else {
        return ((DeactivateTaskRequest) _storedValue);
      }
    }

    public DeactivateTaskRequest.Builder<_B> copyOf(final DeactivateTaskRequest _other) {
      _other.copyTo(this);
      return this;
    }

    public DeactivateTaskRequest.Builder<_B> copyOf(final DeactivateTaskRequest.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
