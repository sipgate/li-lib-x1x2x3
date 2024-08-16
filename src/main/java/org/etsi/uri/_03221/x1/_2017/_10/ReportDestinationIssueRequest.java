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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for ReportDestinationIssueRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="ReportDestinationIssueRequest">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}X1RequestMessage">
 *       <sequence>
 *         <element name="dId" type="{http://uri.etsi.org/03221/X1/2017/10}DId"/>
 *         <element name="destinationReportType" type="{http://uri.etsi.org/03221/X1/2017/10}TaskReportType"/>
 *         <element name="destinationIssueErrorCode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         <element name="destinationIssueDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "ReportDestinationIssueRequest",
  propOrder = { "dId", "destinationReportType", "destinationIssueErrorCode", "destinationIssueDetails" }
)
public class ReportDestinationIssueRequest extends X1RequestMessage implements Copyable, PartialCopyable {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String dId;

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected TaskReportType destinationReportType;

  protected BigInteger destinationIssueErrorCode;
  protected String destinationIssueDetails;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ReportDestinationIssueRequest() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ReportDestinationIssueRequest copying the state of another ReportDestinationIssueRequest
   *
   * @param _other
   *     The original ReportDestinationIssueRequest from which to copy state.
   */
  public ReportDestinationIssueRequest(final ReportDestinationIssueRequest _other) {
    super(_other);
    this.dId = _other.dId;
    this.destinationReportType = _other.destinationReportType;
    this.destinationIssueErrorCode = _other.destinationIssueErrorCode;
    this.destinationIssueDetails = _other.destinationIssueDetails;
  }

  /**
   * Instantiates a ReportDestinationIssueRequest copying the state of another ReportDestinationIssueRequest
   *
   * @param _other
   *     The original ReportDestinationIssueRequest from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public ReportDestinationIssueRequest(
    final ReportDestinationIssueRequest _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree dIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("dId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (dIdPropertyTree != null)
          : ((dIdPropertyTree == null) || (!dIdPropertyTree.isLeaf())))
    ) {
      this.dId = _other.dId;
    }
    final PropertyTree destinationReportTypePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationReportType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationReportTypePropertyTree != null)
          : ((destinationReportTypePropertyTree == null) || (!destinationReportTypePropertyTree.isLeaf())))
    ) {
      this.destinationReportType = _other.destinationReportType;
    }
    final PropertyTree destinationIssueErrorCodePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationIssueErrorCode"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationIssueErrorCodePropertyTree != null)
          : ((destinationIssueErrorCodePropertyTree == null) || (!destinationIssueErrorCodePropertyTree.isLeaf())))
    ) {
      this.destinationIssueErrorCode = _other.destinationIssueErrorCode;
    }
    final PropertyTree destinationIssueDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationIssueDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationIssueDetailsPropertyTree != null)
          : ((destinationIssueDetailsPropertyTree == null) || (!destinationIssueDetailsPropertyTree.isLeaf())))
    ) {
      this.destinationIssueDetails = _other.destinationIssueDetails;
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
   * Gets the value of the destinationReportType property.
   *
   * @return
   *     possible object is
   *     {@link TaskReportType }
   *
   */
  public TaskReportType getDestinationReportType() {
    return destinationReportType;
  }

  /**
   * Sets the value of the destinationReportType property.
   *
   * @param value
   *     allowed object is
   *     {@link TaskReportType }
   *
   */
  public void setDestinationReportType(TaskReportType value) {
    this.destinationReportType = value;
  }

  /**
   * Gets the value of the destinationIssueErrorCode property.
   *
   * @return
   *     possible object is
   *     {@link BigInteger }
   *
   */
  public BigInteger getDestinationIssueErrorCode() {
    return destinationIssueErrorCode;
  }

  /**
   * Sets the value of the destinationIssueErrorCode property.
   *
   * @param value
   *     allowed object is
   *     {@link BigInteger }
   *
   */
  public void setDestinationIssueErrorCode(BigInteger value) {
    this.destinationIssueErrorCode = value;
  }

  /**
   * Gets the value of the destinationIssueDetails property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getDestinationIssueDetails() {
    return destinationIssueDetails;
  }

  /**
   * Sets the value of the destinationIssueDetails property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setDestinationIssueDetails(String value) {
    this.destinationIssueDetails = value;
  }

  @Override
  public ReportDestinationIssueRequest createCopy() {
    final ReportDestinationIssueRequest _newObject = ((ReportDestinationIssueRequest) super.createCopy());
    _newObject.dId = this.dId;
    _newObject.destinationReportType = this.destinationReportType;
    _newObject.destinationIssueErrorCode = this.destinationIssueErrorCode;
    _newObject.destinationIssueDetails = this.destinationIssueDetails;
    return _newObject;
  }

  @Override
  public ReportDestinationIssueRequest createCopy(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ReportDestinationIssueRequest _newObject =
      ((ReportDestinationIssueRequest) super.createCopy(_propertyTree, _propertyTreeUse));
    final PropertyTree dIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("dId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (dIdPropertyTree != null)
          : ((dIdPropertyTree == null) || (!dIdPropertyTree.isLeaf())))
    ) {
      _newObject.dId = this.dId;
    }
    final PropertyTree destinationReportTypePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationReportType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationReportTypePropertyTree != null)
          : ((destinationReportTypePropertyTree == null) || (!destinationReportTypePropertyTree.isLeaf())))
    ) {
      _newObject.destinationReportType = this.destinationReportType;
    }
    final PropertyTree destinationIssueErrorCodePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationIssueErrorCode"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationIssueErrorCodePropertyTree != null)
          : ((destinationIssueErrorCodePropertyTree == null) || (!destinationIssueErrorCodePropertyTree.isLeaf())))
    ) {
      _newObject.destinationIssueErrorCode = this.destinationIssueErrorCode;
    }
    final PropertyTree destinationIssueDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationIssueDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationIssueDetailsPropertyTree != null)
          : ((destinationIssueDetailsPropertyTree == null) || (!destinationIssueDetailsPropertyTree.isLeaf())))
    ) {
      _newObject.destinationIssueDetails = this.destinationIssueDetails;
    }
    return _newObject;
  }

  @Override
  public ReportDestinationIssueRequest copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public ReportDestinationIssueRequest copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final ReportDestinationIssueRequest.Builder<_B> _other) {
    super.copyTo(_other);
    _other.dId = this.dId;
    _other.destinationReportType = this.destinationReportType;
    _other.destinationIssueErrorCode = this.destinationIssueErrorCode;
    _other.destinationIssueDetails = this.destinationIssueDetails;
  }

  @Override
  public <_B> ReportDestinationIssueRequest.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ReportDestinationIssueRequest.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public ReportDestinationIssueRequest.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ReportDestinationIssueRequest.Builder<Void> builder() {
    return new ReportDestinationIssueRequest.Builder<>(null, null, false);
  }

  public static <_B> ReportDestinationIssueRequest.Builder<_B> copyOf(final X1RequestMessage _other) {
    final ReportDestinationIssueRequest.Builder<_B> _newBuilder = new ReportDestinationIssueRequest.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> ReportDestinationIssueRequest.Builder<_B> copyOf(final ReportDestinationIssueRequest _other) {
    final ReportDestinationIssueRequest.Builder<_B> _newBuilder = new ReportDestinationIssueRequest.Builder<>(
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
    final ReportDestinationIssueRequest.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
    final PropertyTree dIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("dId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (dIdPropertyTree != null)
          : ((dIdPropertyTree == null) || (!dIdPropertyTree.isLeaf())))
    ) {
      _other.dId = this.dId;
    }
    final PropertyTree destinationReportTypePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationReportType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationReportTypePropertyTree != null)
          : ((destinationReportTypePropertyTree == null) || (!destinationReportTypePropertyTree.isLeaf())))
    ) {
      _other.destinationReportType = this.destinationReportType;
    }
    final PropertyTree destinationIssueErrorCodePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationIssueErrorCode"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationIssueErrorCodePropertyTree != null)
          : ((destinationIssueErrorCodePropertyTree == null) || (!destinationIssueErrorCodePropertyTree.isLeaf())))
    ) {
      _other.destinationIssueErrorCode = this.destinationIssueErrorCode;
    }
    final PropertyTree destinationIssueDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("destinationIssueDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (destinationIssueDetailsPropertyTree != null)
          : ((destinationIssueDetailsPropertyTree == null) || (!destinationIssueDetailsPropertyTree.isLeaf())))
    ) {
      _other.destinationIssueDetails = this.destinationIssueDetails;
    }
  }

  @Override
  public <_B> ReportDestinationIssueRequest.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ReportDestinationIssueRequest.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public ReportDestinationIssueRequest.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ReportDestinationIssueRequest.Builder<_B> copyOf(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ReportDestinationIssueRequest.Builder<_B> _newBuilder = new ReportDestinationIssueRequest.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> ReportDestinationIssueRequest.Builder<_B> copyOf(
    final ReportDestinationIssueRequest _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ReportDestinationIssueRequest.Builder<_B> _newBuilder = new ReportDestinationIssueRequest.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ReportDestinationIssueRequest.Builder<Void> copyExcept(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ReportDestinationIssueRequest.Builder<Void> copyExcept(
    final ReportDestinationIssueRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ReportDestinationIssueRequest.Builder<Void> copyOnly(
    final X1RequestMessage _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static ReportDestinationIssueRequest.Builder<Void> copyOnly(
    final ReportDestinationIssueRequest _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends X1RequestMessage.Builder<_B> implements Buildable {

    private String dId;
    private TaskReportType destinationReportType;
    private BigInteger destinationIssueErrorCode;
    private String destinationIssueDetails;

    public Builder(final _B _parentBuilder, final ReportDestinationIssueRequest _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {
        this.dId = _other.dId;
        this.destinationReportType = _other.destinationReportType;
        this.destinationIssueErrorCode = _other.destinationIssueErrorCode;
        this.destinationIssueDetails = _other.destinationIssueDetails;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final ReportDestinationIssueRequest _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {
        final PropertyTree dIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("dId"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (dIdPropertyTree != null)
              : ((dIdPropertyTree == null) || (!dIdPropertyTree.isLeaf())))
        ) {
          this.dId = _other.dId;
        }
        final PropertyTree destinationReportTypePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("destinationReportType"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (destinationReportTypePropertyTree != null)
              : ((destinationReportTypePropertyTree == null) || (!destinationReportTypePropertyTree.isLeaf())))
        ) {
          this.destinationReportType = _other.destinationReportType;
        }
        final PropertyTree destinationIssueErrorCodePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("destinationIssueErrorCode"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (destinationIssueErrorCodePropertyTree != null)
              : ((destinationIssueErrorCodePropertyTree == null) || (!destinationIssueErrorCodePropertyTree.isLeaf())))
        ) {
          this.destinationIssueErrorCode = _other.destinationIssueErrorCode;
        }
        final PropertyTree destinationIssueDetailsPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("destinationIssueDetails"));
        if (
          ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (destinationIssueDetailsPropertyTree != null)
              : ((destinationIssueDetailsPropertyTree == null) || (!destinationIssueDetailsPropertyTree.isLeaf())))
        ) {
          this.destinationIssueDetails = _other.destinationIssueDetails;
        }
      }
    }

    protected <_P extends ReportDestinationIssueRequest> _P init(final _P _product) {
      _product.dId = this.dId;
      _product.destinationReportType = this.destinationReportType;
      _product.destinationIssueErrorCode = this.destinationIssueErrorCode;
      _product.destinationIssueDetails = this.destinationIssueDetails;
      return super.init(_product);
    }

    /**
     * Sets the new value of "dId" (any previous value will be replaced)
     *
     * @param dId
     *     New value of the "dId" property.
     */
    public ReportDestinationIssueRequest.Builder<_B> withDId(final String dId) {
      this.dId = dId;
      return this;
    }

    /**
     * Sets the new value of "destinationReportType" (any previous value will be
     * replaced)
     *
     * @param destinationReportType
     *     New value of the "destinationReportType" property.
     */
    public ReportDestinationIssueRequest.Builder<_B> withDestinationReportType(
      final TaskReportType destinationReportType
    ) {
      this.destinationReportType = destinationReportType;
      return this;
    }

    /**
     * Sets the new value of "destinationIssueErrorCode" (any previous value will be
     * replaced)
     *
     * @param destinationIssueErrorCode
     *     New value of the "destinationIssueErrorCode" property.
     */
    public ReportDestinationIssueRequest.Builder<_B> withDestinationIssueErrorCode(
      final BigInteger destinationIssueErrorCode
    ) {
      this.destinationIssueErrorCode = destinationIssueErrorCode;
      return this;
    }

    /**
     * Sets the new value of "destinationIssueDetails" (any previous value will be
     * replaced)
     *
     * @param destinationIssueDetails
     *     New value of the "destinationIssueDetails" property.
     */
    public ReportDestinationIssueRequest.Builder<_B> withDestinationIssueDetails(final String destinationIssueDetails) {
      this.destinationIssueDetails = destinationIssueDetails;
      return this;
    }

    /**
     * Sets the new value of "admfIdentifier" (any previous value will be replaced)
     *
     * @param admfIdentifier
     *     New value of the "admfIdentifier" property.
     */
    @Override
    public ReportDestinationIssueRequest.Builder<_B> withAdmfIdentifier(final String admfIdentifier) {
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
    public ReportDestinationIssueRequest.Builder<_B> withNeIdentifier(final String neIdentifier) {
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
    public ReportDestinationIssueRequest.Builder<_B> withMessageTimestamp(final XMLGregorianCalendar messageTimestamp) {
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
    public ReportDestinationIssueRequest.Builder<_B> withVersion(final String version) {
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
    public ReportDestinationIssueRequest.Builder<_B> withX1TransactionId(final String x1TransactionId) {
      super.withX1TransactionId(x1TransactionId);
      return this;
    }

    @Override
    public ReportDestinationIssueRequest build() {
      if (_storedValue == null) {
        return this.init(new ReportDestinationIssueRequest());
      } else {
        return ((ReportDestinationIssueRequest) _storedValue);
      }
    }

    public ReportDestinationIssueRequest.Builder<_B> copyOf(final ReportDestinationIssueRequest _other) {
      _other.copyTo(this);
      return this;
    }

    public ReportDestinationIssueRequest.Builder<_B> copyOf(final ReportDestinationIssueRequest.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select
    extends ReportDestinationIssueRequest.Selector<ReportDestinationIssueRequest.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static ReportDestinationIssueRequest.Select _root() {
      return new ReportDestinationIssueRequest.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends X1RequestMessage.Selector<TRoot, TParent> {

    private com.kscs.util.jaxb.Selector<TRoot, ReportDestinationIssueRequest.Selector<TRoot, TParent>> dId = null;
    private com.kscs.util.jaxb.Selector<
      TRoot,
      ReportDestinationIssueRequest.Selector<TRoot, TParent>
    > destinationReportType = null;
    private com.kscs.util.jaxb.Selector<
      TRoot,
      ReportDestinationIssueRequest.Selector<TRoot, TParent>
    > destinationIssueErrorCode = null;
    private com.kscs.util.jaxb.Selector<
      TRoot,
      ReportDestinationIssueRequest.Selector<TRoot, TParent>
    > destinationIssueDetails = null;

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
      if (this.destinationReportType != null) {
        products.put("destinationReportType", this.destinationReportType.init());
      }
      if (this.destinationIssueErrorCode != null) {
        products.put("destinationIssueErrorCode", this.destinationIssueErrorCode.init());
      }
      if (this.destinationIssueDetails != null) {
        products.put("destinationIssueDetails", this.destinationIssueDetails.init());
      }
      return products;
    }

    public com.kscs.util.jaxb.Selector<TRoot, ReportDestinationIssueRequest.Selector<TRoot, TParent>> dId() {
      return ((this.dId == null) ? this.dId = new com.kscs.util.jaxb.Selector<>(this._root, this, "dId") : this.dId);
    }

    public com.kscs.util.jaxb.Selector<
      TRoot,
      ReportDestinationIssueRequest.Selector<TRoot, TParent>
    > destinationReportType() {
      return (
        (this.destinationReportType == null)
          ? this.destinationReportType = new com.kscs.util.jaxb.Selector<>(this._root, this, "destinationReportType")
          : this.destinationReportType
      );
    }

    public com.kscs.util.jaxb.Selector<
      TRoot,
      ReportDestinationIssueRequest.Selector<TRoot, TParent>
    > destinationIssueErrorCode() {
      return (
        (this.destinationIssueErrorCode == null)
          ? this.destinationIssueErrorCode = new com.kscs.util.jaxb.Selector<>(
            this._root,
            this,
            "destinationIssueErrorCode"
          )
          : this.destinationIssueErrorCode
      );
    }

    public com.kscs.util.jaxb.Selector<
      TRoot,
      ReportDestinationIssueRequest.Selector<TRoot, TParent>
    > destinationIssueDetails() {
      return (
        (this.destinationIssueDetails == null)
          ? this.destinationIssueDetails = new com.kscs.util.jaxb.Selector<>(
            this._root,
            this,
            "destinationIssueDetails"
          )
          : this.destinationIssueDetails
      );
    }
  }
}
