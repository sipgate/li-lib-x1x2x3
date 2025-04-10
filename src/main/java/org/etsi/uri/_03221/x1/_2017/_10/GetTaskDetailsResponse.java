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
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for GetTaskDetailsResponse complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="GetTaskDetailsResponse">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage">
 *       <sequence>
 *         <element name="taskResponseDetails" type="{http://uri.etsi.org/03221/X1/2017/10}TaskResponseDetails"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTaskDetailsResponse", propOrder = { "taskResponseDetails" })
public class GetTaskDetailsResponse extends X1ResponseMessage implements Copyable {

  @XmlElement(required = true)
  protected TaskResponseDetails taskResponseDetails;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public GetTaskDetailsResponse() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a GetTaskDetailsResponse copying the state of another GetTaskDetailsResponse
   *
   * @param _other
   *     The original GetTaskDetailsResponse from which to copy state.
   */
  public GetTaskDetailsResponse(final GetTaskDetailsResponse _other) {
    super(_other);
    this.taskResponseDetails = ((_other.taskResponseDetails == null) ? null : _other.taskResponseDetails.createCopy());
  }

  /**
   * Gets the value of the taskResponseDetails property.
   *
   * @return
   *     possible object is
   *     {@link TaskResponseDetails }
   *
   */
  public TaskResponseDetails getTaskResponseDetails() {
    return taskResponseDetails;
  }

  /**
   * Sets the value of the taskResponseDetails property.
   *
   * @param value
   *     allowed object is
   *     {@link TaskResponseDetails }
   *
   */
  public void setTaskResponseDetails(TaskResponseDetails value) {
    this.taskResponseDetails = value;
  }

  @Override
  public GetTaskDetailsResponse createCopy() {
    final GetTaskDetailsResponse _newObject = ((GetTaskDetailsResponse) super.createCopy());
    _newObject.taskResponseDetails = ((this.taskResponseDetails == null)
        ? null
        : this.taskResponseDetails.createCopy());
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final GetTaskDetailsResponse.Builder<_B> _other) {
    super.copyTo(_other);
    _other.taskResponseDetails = ((this.taskResponseDetails == null)
        ? null
        : this.taskResponseDetails.newCopyBuilder(_other));
  }

  @Override
  public <_B> GetTaskDetailsResponse.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new GetTaskDetailsResponse.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public GetTaskDetailsResponse.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static GetTaskDetailsResponse.Builder<Void> builder() {
    return new GetTaskDetailsResponse.Builder<>(null, null, false);
  }

  public static <_B> GetTaskDetailsResponse.Builder<_B> copyOf(final X1ResponseMessage _other) {
    final GetTaskDetailsResponse.Builder<_B> _newBuilder = new GetTaskDetailsResponse.Builder<>(null, null, false);
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> GetTaskDetailsResponse.Builder<_B> copyOf(final GetTaskDetailsResponse _other) {
    final GetTaskDetailsResponse.Builder<_B> _newBuilder = new GetTaskDetailsResponse.Builder<>(null, null, false);
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
    final GetTaskDetailsResponse.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree taskResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("taskResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (taskResponseDetailsPropertyTree != null)
          : ((taskResponseDetailsPropertyTree == null) || (!taskResponseDetailsPropertyTree.isLeaf())))
    ) {
      _other.taskResponseDetails = ((this.taskResponseDetails == null)
          ? null
          : this.taskResponseDetails.newCopyBuilder(_other, taskResponseDetailsPropertyTree, _propertyTreeUse));
    }
  }

  @Override
  public <_B> GetTaskDetailsResponse.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new GetTaskDetailsResponse.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public GetTaskDetailsResponse.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> GetTaskDetailsResponse.Builder<_B> copyOf(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetTaskDetailsResponse.Builder<_B> _newBuilder = new GetTaskDetailsResponse.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> GetTaskDetailsResponse.Builder<_B> copyOf(
    final GetTaskDetailsResponse _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final GetTaskDetailsResponse.Builder<_B> _newBuilder = new GetTaskDetailsResponse.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static GetTaskDetailsResponse.Builder<Void> copyExcept(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetTaskDetailsResponse.Builder<Void> copyExcept(
    final GetTaskDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static GetTaskDetailsResponse.Builder<Void> copyOnly(
    final X1ResponseMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static GetTaskDetailsResponse.Builder<Void> copyOnly(
    final GetTaskDetailsResponse _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1ResponseMessage.Builder<_B> implements Buildable {

    private TaskResponseDetails.Builder<GetTaskDetailsResponse.Builder<_B>> taskResponseDetails;

    public Builder(final _B _parentBuilder, final GetTaskDetailsResponse _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {
        this.taskResponseDetails = ((_other.taskResponseDetails == null)
            ? null
            : _other.taskResponseDetails.newCopyBuilder(this));
      }
    }

    public Builder(
      final _B _parentBuilder,
      final GetTaskDetailsResponse _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {
        final PropertyTree taskResponseDetailsPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("taskResponseDetails"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (taskResponseDetailsPropertyTree != null)
              : ((taskResponseDetailsPropertyTree == null) || (!taskResponseDetailsPropertyTree.isLeaf())))
        ) {
          this.taskResponseDetails = ((_other.taskResponseDetails == null)
              ? null
              : _other.taskResponseDetails.newCopyBuilder(this, taskResponseDetailsPropertyTree, _propertyTreeUse));
        }
      }
    }

    protected <_P extends GetTaskDetailsResponse> _P init(final _P _product) {
      _product.taskResponseDetails = ((this.taskResponseDetails == null) ? null : this.taskResponseDetails.build());
      return super.init(_product);
    }

    /**
     * Sets the new value of "taskResponseDetails" (any previous value will be
     * replaced)
     *
     * @param taskResponseDetails
     *     New value of the "taskResponseDetails" property.
     */
    public GetTaskDetailsResponse.Builder<_B> withTaskResponseDetails(final TaskResponseDetails taskResponseDetails) {
      this.taskResponseDetails = ((taskResponseDetails == null)
          ? null
          : new TaskResponseDetails.Builder<>(this, taskResponseDetails, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "taskResponseDetails" property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.TaskResponseDetails.Builder#end()}
     * to return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "taskResponseDetails" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.TaskResponseDetails.Builder#end()}
     *     to return to the current builder.
     */
    public TaskResponseDetails.Builder<? extends GetTaskDetailsResponse.Builder<_B>> withTaskResponseDetails() {
      if (this.taskResponseDetails != null) {
        return this.taskResponseDetails;
      }
      return this.taskResponseDetails = new TaskResponseDetails.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public GetTaskDetailsResponse.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public GetTaskDetailsResponse.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public GetTaskDetailsResponse.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
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
    public GetTaskDetailsResponse.Builder<_B> withVersion(final String version) {
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
    public GetTaskDetailsResponse.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public GetTaskDetailsResponse build() {
      if (_storedValue == null) {
        return this.init(new GetTaskDetailsResponse());
      } else {
        return ((GetTaskDetailsResponse) _storedValue);
      }
    }

    public GetTaskDetailsResponse.Builder<_B> copyOf(final GetTaskDetailsResponse _other) {
      _other.copyTo(this);
      return this;
    }

    public GetTaskDetailsResponse.Builder<_B> copyOf(final GetTaskDetailsResponse.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
