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
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3._2001.xmlschema.Adapter1;

/**
 * <p>Java class for TaskStatus complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="TaskStatus">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="provisioningStatus" type="{http://uri.etsi.org/03221/X1/2017/10}ProvisioningStatus"/>
 *         <element name="listOfFaults" type="{http://uri.etsi.org/03221/X1/2017/10}ListOfFaults"/>
 *         <element name="timeOfLastIntercept" type="{http://uri.etsi.org/03280/common/2017/07}QualifiedMicrosecondDateTime" minOccurs="0"/>
 *         <element name="amountOfX2Data" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         <element name="amountOfX3Data" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         <element name="timeOfLastModification" type="{http://uri.etsi.org/03280/common/2017/07}QualifiedMicrosecondDateTime" minOccurs="0"/>
 *         <element name="numberOfModifications" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         <element name="taskStatusExtensions" type="{http://uri.etsi.org/03221/X1/2017/10}TaskStatusExtensions" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "TaskStatus",
  propOrder = {
    "provisioningStatus",
    "listOfFaults",
    "timeOfLastIntercept",
    "amountOfX2Data",
    "amountOfX3Data",
    "timeOfLastModification",
    "numberOfModifications",
    "taskStatusExtensions",
  }
)
public class TaskStatus implements Copyable {

  @XmlElement(required = true)
  @XmlSchemaType(name = "string")
  protected ProvisioningStatus provisioningStatus;

  @XmlElement(required = true)
  protected ListOfFaults listOfFaults;

  @XmlSchemaType(name = "dateTime")
  protected XMLGregorianCalendar timeOfLastIntercept;

  @XmlElement(type = String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name = "integer")
  protected Long amountOfX2Data;

  @XmlElement(type = String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name = "integer")
  protected Long amountOfX3Data;

  @XmlSchemaType(name = "dateTime")
  protected XMLGregorianCalendar timeOfLastModification;

  @XmlElement(type = String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name = "integer")
  protected Long numberOfModifications;

  protected List<TaskStatusExtensions> taskStatusExtensions;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public TaskStatus() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a TaskStatus copying the state of another TaskStatus
   *
   * @param _other
   *     The original TaskStatus from which to copy state.
   */
  public TaskStatus(final TaskStatus _other) {
    this.provisioningStatus = _other.provisioningStatus;
    this.listOfFaults = ((_other.listOfFaults == null) ? null : _other.listOfFaults.createCopy());
    this.timeOfLastIntercept = ((_other.timeOfLastIntercept == null)
        ? null
        : ((XMLGregorianCalendar) _other.timeOfLastIntercept.clone()));
    this.amountOfX2Data = _other.amountOfX2Data;
    this.amountOfX3Data = _other.amountOfX3Data;
    this.timeOfLastModification = ((_other.timeOfLastModification == null)
        ? null
        : ((XMLGregorianCalendar) _other.timeOfLastModification.clone()));
    this.numberOfModifications = _other.numberOfModifications;
    if (_other.taskStatusExtensions == null) {
      this.taskStatusExtensions = null;
    } else {
      this.taskStatusExtensions = new ArrayList<>();
      for (TaskStatusExtensions _item : _other.taskStatusExtensions) {
        this.taskStatusExtensions.add(((_item == null) ? null : _item.createCopy()));
      }
    }
  }

  /**
   * Gets the value of the provisioningStatus property.
   *
   * @return
   *     possible object is
   *     {@link ProvisioningStatus }
   *
   */
  public ProvisioningStatus getProvisioningStatus() {
    return provisioningStatus;
  }

  /**
   * Sets the value of the provisioningStatus property.
   *
   * @param value
   *     allowed object is
   *     {@link ProvisioningStatus }
   *
   */
  public void setProvisioningStatus(ProvisioningStatus value) {
    this.provisioningStatus = value;
  }

  /**
   * Gets the value of the listOfFaults property.
   *
   * @return
   *     possible object is
   *     {@link ListOfFaults }
   *
   */
  public ListOfFaults getListOfFaults() {
    return listOfFaults;
  }

  /**
   * Sets the value of the listOfFaults property.
   *
   * @param value
   *     allowed object is
   *     {@link ListOfFaults }
   *
   */
  public void setListOfFaults(ListOfFaults value) {
    this.listOfFaults = value;
  }

  /**
   * Gets the value of the timeOfLastIntercept property.
   *
   * @return
   *     possible object is
   *     {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getTimeOfLastIntercept() {
    return timeOfLastIntercept;
  }

  /**
   * Sets the value of the timeOfLastIntercept property.
   *
   * @param value
   *     allowed object is
   *     {@link XMLGregorianCalendar }
   *
   */
  public void setTimeOfLastIntercept(XMLGregorianCalendar value) {
    this.timeOfLastIntercept = value;
  }

  /**
   * Gets the value of the amountOfX2Data property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public Long getAmountOfX2Data() {
    return amountOfX2Data;
  }

  /**
   * Sets the value of the amountOfX2Data property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setAmountOfX2Data(Long value) {
    this.amountOfX2Data = value;
  }

  /**
   * Gets the value of the amountOfX3Data property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public Long getAmountOfX3Data() {
    return amountOfX3Data;
  }

  /**
   * Sets the value of the amountOfX3Data property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setAmountOfX3Data(Long value) {
    this.amountOfX3Data = value;
  }

  /**
   * Gets the value of the timeOfLastModification property.
   *
   * @return
   *     possible object is
   *     {@link XMLGregorianCalendar }
   *
   */
  public XMLGregorianCalendar getTimeOfLastModification() {
    return timeOfLastModification;
  }

  /**
   * Sets the value of the timeOfLastModification property.
   *
   * @param value
   *     allowed object is
   *     {@link XMLGregorianCalendar }
   *
   */
  public void setTimeOfLastModification(XMLGregorianCalendar value) {
    this.timeOfLastModification = value;
  }

  /**
   * Gets the value of the numberOfModifications property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public Long getNumberOfModifications() {
    return numberOfModifications;
  }

  /**
   * Sets the value of the numberOfModifications property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setNumberOfModifications(Long value) {
    this.numberOfModifications = value;
  }

  /**
   * Gets the value of the taskStatusExtensions property.
   *
   * <p>This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the taskStatusExtensions property.</p>
   *
   * <p>
   * For example, to add a new item, do as follows:
   * </p>
   * <pre>
   * getTaskStatusExtensions().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link TaskStatusExtensions }
   * </p>
   *
   *
   * @return
   *     The value of the taskStatusExtensions property.
   */
  public List<TaskStatusExtensions> getTaskStatusExtensions() {
    if (taskStatusExtensions == null) {
      taskStatusExtensions = new ArrayList<>();
    }
    return this.taskStatusExtensions;
  }

  @Override
  public TaskStatus createCopy() {
    final TaskStatus _newObject;
    try {
      _newObject = ((TaskStatus) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.provisioningStatus = this.provisioningStatus;
    _newObject.listOfFaults = ((this.listOfFaults == null) ? null : this.listOfFaults.createCopy());
    _newObject.timeOfLastIntercept = ((this.timeOfLastIntercept == null)
        ? null
        : ((XMLGregorianCalendar) this.timeOfLastIntercept.clone()));
    _newObject.amountOfX2Data = this.amountOfX2Data;
    _newObject.amountOfX3Data = this.amountOfX3Data;
    _newObject.timeOfLastModification = ((this.timeOfLastModification == null)
        ? null
        : ((XMLGregorianCalendar) this.timeOfLastModification.clone()));
    _newObject.numberOfModifications = this.numberOfModifications;
    if (this.taskStatusExtensions == null) {
      _newObject.taskStatusExtensions = null;
    } else {
      _newObject.taskStatusExtensions = new ArrayList<>();
      for (TaskStatusExtensions _item : this.taskStatusExtensions) {
        _newObject.taskStatusExtensions.add(((_item == null) ? null : _item.createCopy()));
      }
    }
    return _newObject;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final TaskStatus.Builder<_B> _other) {
    _other.provisioningStatus = this.provisioningStatus;
    _other.listOfFaults = ((this.listOfFaults == null) ? null : this.listOfFaults.newCopyBuilder(_other));
    _other.timeOfLastIntercept = ((this.timeOfLastIntercept == null)
        ? null
        : ((XMLGregorianCalendar) this.timeOfLastIntercept.clone()));
    _other.amountOfX2Data = this.amountOfX2Data;
    _other.amountOfX3Data = this.amountOfX3Data;
    _other.timeOfLastModification = ((this.timeOfLastModification == null)
        ? null
        : ((XMLGregorianCalendar) this.timeOfLastModification.clone()));
    _other.numberOfModifications = this.numberOfModifications;
    if (this.taskStatusExtensions == null) {
      _other.taskStatusExtensions = null;
    } else {
      _other.taskStatusExtensions = new ArrayList<>();
      for (TaskStatusExtensions _item : this.taskStatusExtensions) {
        _other.taskStatusExtensions.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
      }
    }
  }

  public <_B> TaskStatus.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new TaskStatus.Builder<_B>(_parentBuilder, this, true);
  }

  public TaskStatus.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static TaskStatus.Builder<Void> builder() {
    return new TaskStatus.Builder<>(null, null, false);
  }

  public static <_B> TaskStatus.Builder<_B> copyOf(final TaskStatus _other) {
    final TaskStatus.Builder<_B> _newBuilder = new TaskStatus.Builder<>(null, null, false);
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
    final TaskStatus.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree provisioningStatusPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("provisioningStatus"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (provisioningStatusPropertyTree != null)
          : ((provisioningStatusPropertyTree == null) || (!provisioningStatusPropertyTree.isLeaf())))
    ) {
      _other.provisioningStatus = this.provisioningStatus;
    }
    final PropertyTree listOfFaultsPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("listOfFaults"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (listOfFaultsPropertyTree != null)
          : ((listOfFaultsPropertyTree == null) || (!listOfFaultsPropertyTree.isLeaf())))
    ) {
      _other.listOfFaults = ((this.listOfFaults == null)
          ? null
          : this.listOfFaults.newCopyBuilder(_other, listOfFaultsPropertyTree, _propertyTreeUse));
    }
    final PropertyTree timeOfLastInterceptPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("timeOfLastIntercept"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (timeOfLastInterceptPropertyTree != null)
          : ((timeOfLastInterceptPropertyTree == null) || (!timeOfLastInterceptPropertyTree.isLeaf())))
    ) {
      _other.timeOfLastIntercept = ((this.timeOfLastIntercept == null)
          ? null
          : ((XMLGregorianCalendar) this.timeOfLastIntercept.clone()));
    }
    final PropertyTree amountOfX2DataPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("amountOfX2Data"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (amountOfX2DataPropertyTree != null)
          : ((amountOfX2DataPropertyTree == null) || (!amountOfX2DataPropertyTree.isLeaf())))
    ) {
      _other.amountOfX2Data = this.amountOfX2Data;
    }
    final PropertyTree amountOfX3DataPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("amountOfX3Data"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (amountOfX3DataPropertyTree != null)
          : ((amountOfX3DataPropertyTree == null) || (!amountOfX3DataPropertyTree.isLeaf())))
    ) {
      _other.amountOfX3Data = this.amountOfX3Data;
    }
    final PropertyTree timeOfLastModificationPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("timeOfLastModification"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (timeOfLastModificationPropertyTree != null)
          : ((timeOfLastModificationPropertyTree == null) || (!timeOfLastModificationPropertyTree.isLeaf())))
    ) {
      _other.timeOfLastModification = ((this.timeOfLastModification == null)
          ? null
          : ((XMLGregorianCalendar) this.timeOfLastModification.clone()));
    }
    final PropertyTree numberOfModificationsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("numberOfModifications"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (numberOfModificationsPropertyTree != null)
          : ((numberOfModificationsPropertyTree == null) || (!numberOfModificationsPropertyTree.isLeaf())))
    ) {
      _other.numberOfModifications = this.numberOfModifications;
    }
    final PropertyTree taskStatusExtensionsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("taskStatusExtensions"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (taskStatusExtensionsPropertyTree != null)
          : ((taskStatusExtensionsPropertyTree == null) || (!taskStatusExtensionsPropertyTree.isLeaf())))
    ) {
      if (this.taskStatusExtensions == null) {
        _other.taskStatusExtensions = null;
      } else {
        _other.taskStatusExtensions = new ArrayList<>();
        for (TaskStatusExtensions _item : this.taskStatusExtensions) {
          _other.taskStatusExtensions.add(
            ((_item == null) ? null : _item.newCopyBuilder(_other, taskStatusExtensionsPropertyTree, _propertyTreeUse))
          );
        }
      }
    }
  }

  public <_B> TaskStatus.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new TaskStatus.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public TaskStatus.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> TaskStatus.Builder<_B> copyOf(
    final TaskStatus _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final TaskStatus.Builder<_B> _newBuilder = new TaskStatus.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static TaskStatus.Builder<Void> copyExcept(final TaskStatus _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static TaskStatus.Builder<Void> copyOnly(final TaskStatus _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final TaskStatus _storedValue;
    private ProvisioningStatus provisioningStatus;
    private ListOfFaults.Builder<TaskStatus.Builder<_B>> listOfFaults;
    private XMLGregorianCalendar timeOfLastIntercept;
    private Long amountOfX2Data;
    private Long amountOfX3Data;
    private XMLGregorianCalendar timeOfLastModification;
    private Long numberOfModifications;
    private List<TaskStatusExtensions.Builder<TaskStatus.Builder<_B>>> taskStatusExtensions;

    public Builder(final _B _parentBuilder, final TaskStatus _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.provisioningStatus = _other.provisioningStatus;
          this.listOfFaults = ((_other.listOfFaults == null) ? null : _other.listOfFaults.newCopyBuilder(this));
          this.timeOfLastIntercept = ((_other.timeOfLastIntercept == null)
              ? null
              : ((XMLGregorianCalendar) _other.timeOfLastIntercept.clone()));
          this.amountOfX2Data = _other.amountOfX2Data;
          this.amountOfX3Data = _other.amountOfX3Data;
          this.timeOfLastModification = ((_other.timeOfLastModification == null)
              ? null
              : ((XMLGregorianCalendar) _other.timeOfLastModification.clone()));
          this.numberOfModifications = _other.numberOfModifications;
          if (_other.taskStatusExtensions == null) {
            this.taskStatusExtensions = null;
          } else {
            this.taskStatusExtensions = new ArrayList<>();
            for (TaskStatusExtensions _item : _other.taskStatusExtensions) {
              this.taskStatusExtensions.add(((_item == null) ? null : _item.newCopyBuilder(this)));
            }
          }
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
      final _B _parentBuilder,
      final TaskStatus _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree provisioningStatusPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("provisioningStatus"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (provisioningStatusPropertyTree != null)
                : ((provisioningStatusPropertyTree == null) || (!provisioningStatusPropertyTree.isLeaf())))
          ) {
            this.provisioningStatus = _other.provisioningStatus;
          }
          final PropertyTree listOfFaultsPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("listOfFaults"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (listOfFaultsPropertyTree != null)
                : ((listOfFaultsPropertyTree == null) || (!listOfFaultsPropertyTree.isLeaf())))
          ) {
            this.listOfFaults = ((_other.listOfFaults == null)
                ? null
                : _other.listOfFaults.newCopyBuilder(this, listOfFaultsPropertyTree, _propertyTreeUse));
          }
          final PropertyTree timeOfLastInterceptPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("timeOfLastIntercept"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (timeOfLastInterceptPropertyTree != null)
                : ((timeOfLastInterceptPropertyTree == null) || (!timeOfLastInterceptPropertyTree.isLeaf())))
          ) {
            this.timeOfLastIntercept = ((_other.timeOfLastIntercept == null)
                ? null
                : ((XMLGregorianCalendar) _other.timeOfLastIntercept.clone()));
          }
          final PropertyTree amountOfX2DataPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("amountOfX2Data"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (amountOfX2DataPropertyTree != null)
                : ((amountOfX2DataPropertyTree == null) || (!amountOfX2DataPropertyTree.isLeaf())))
          ) {
            this.amountOfX2Data = _other.amountOfX2Data;
          }
          final PropertyTree amountOfX3DataPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("amountOfX3Data"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (amountOfX3DataPropertyTree != null)
                : ((amountOfX3DataPropertyTree == null) || (!amountOfX3DataPropertyTree.isLeaf())))
          ) {
            this.amountOfX3Data = _other.amountOfX3Data;
          }
          final PropertyTree timeOfLastModificationPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("timeOfLastModification"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (timeOfLastModificationPropertyTree != null)
                : ((timeOfLastModificationPropertyTree == null) || (!timeOfLastModificationPropertyTree.isLeaf())))
          ) {
            this.timeOfLastModification = ((_other.timeOfLastModification == null)
                ? null
                : ((XMLGregorianCalendar) _other.timeOfLastModification.clone()));
          }
          final PropertyTree numberOfModificationsPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("numberOfModifications"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (numberOfModificationsPropertyTree != null)
                : ((numberOfModificationsPropertyTree == null) || (!numberOfModificationsPropertyTree.isLeaf())))
          ) {
            this.numberOfModifications = _other.numberOfModifications;
          }
          final PropertyTree taskStatusExtensionsPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("taskStatusExtensions"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (taskStatusExtensionsPropertyTree != null)
                : ((taskStatusExtensionsPropertyTree == null) || (!taskStatusExtensionsPropertyTree.isLeaf())))
          ) {
            if (_other.taskStatusExtensions == null) {
              this.taskStatusExtensions = null;
            } else {
              this.taskStatusExtensions = new ArrayList<>();
              for (TaskStatusExtensions _item : _other.taskStatusExtensions) {
                this.taskStatusExtensions.add(
                    ((_item == null)
                        ? null
                        : _item.newCopyBuilder(this, taskStatusExtensionsPropertyTree, _propertyTreeUse))
                  );
              }
            }
          }
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public _B end() {
      return this._parentBuilder;
    }

    protected <_P extends TaskStatus> _P init(final _P _product) {
      _product.provisioningStatus = this.provisioningStatus;
      _product.listOfFaults = ((this.listOfFaults == null) ? null : this.listOfFaults.build());
      _product.timeOfLastIntercept = this.timeOfLastIntercept;
      _product.amountOfX2Data = this.amountOfX2Data;
      _product.amountOfX3Data = this.amountOfX3Data;
      _product.timeOfLastModification = this.timeOfLastModification;
      _product.numberOfModifications = this.numberOfModifications;
      if (this.taskStatusExtensions != null) {
        final List<TaskStatusExtensions> taskStatusExtensions = new ArrayList<>(this.taskStatusExtensions.size());
        for (TaskStatusExtensions.Builder<TaskStatus.Builder<_B>> _item : this.taskStatusExtensions) {
          taskStatusExtensions.add(_item.build());
        }
        _product.taskStatusExtensions = taskStatusExtensions;
      }
      return _product;
    }

    /**
     * Sets the new value of "provisioningStatus" (any previous value will be replaced)
     *
     * @param provisioningStatus
     *     New value of the "provisioningStatus" property.
     */
    public TaskStatus.Builder<_B> withProvisioningStatus(final ProvisioningStatus provisioningStatus) {
      this.provisioningStatus = provisioningStatus;
      return this;
    }

    /**
     * Sets the new value of "listOfFaults" (any previous value will be replaced)
     *
     * @param listOfFaults
     *     New value of the "listOfFaults" property.
     */
    public TaskStatus.Builder<_B> withListOfFaults(final ListOfFaults listOfFaults) {
      this.listOfFaults = ((listOfFaults == null) ? null : new ListOfFaults.Builder<>(this, listOfFaults, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "listOfFaults" property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.ListOfFaults.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     A new builder to build the value of the "listOfFaults" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.ListOfFaults.Builder#end()} to
     *     return to the current builder.
     */
    public ListOfFaults.Builder<? extends TaskStatus.Builder<_B>> withListOfFaults() {
      if (this.listOfFaults != null) {
        return this.listOfFaults;
      }
      return this.listOfFaults = new ListOfFaults.Builder<>(this, null, false);
    }

    /**
     * Sets the new value of "timeOfLastIntercept" (any previous value will be
     * replaced)
     *
     * @param timeOfLastIntercept
     *     New value of the "timeOfLastIntercept" property.
     */
    public TaskStatus.Builder<_B> withTimeOfLastIntercept(final XMLGregorianCalendar timeOfLastIntercept) {
      this.timeOfLastIntercept = timeOfLastIntercept;
      return this;
    }

    /**
     * Sets the new value of "amountOfX2Data" (any previous value will be replaced)
     *
     * @param amountOfX2Data
     *     New value of the "amountOfX2Data" property.
     */
    public TaskStatus.Builder<_B> withAmountOfX2Data(final Long amountOfX2Data) {
      this.amountOfX2Data = amountOfX2Data;
      return this;
    }

    /**
     * Sets the new value of "amountOfX3Data" (any previous value will be replaced)
     *
     * @param amountOfX3Data
     *     New value of the "amountOfX3Data" property.
     */
    public TaskStatus.Builder<_B> withAmountOfX3Data(final Long amountOfX3Data) {
      this.amountOfX3Data = amountOfX3Data;
      return this;
    }

    /**
     * Sets the new value of "timeOfLastModification" (any previous value will be
     * replaced)
     *
     * @param timeOfLastModification
     *     New value of the "timeOfLastModification" property.
     */
    public TaskStatus.Builder<_B> withTimeOfLastModification(final XMLGregorianCalendar timeOfLastModification) {
      this.timeOfLastModification = timeOfLastModification;
      return this;
    }

    /**
     * Sets the new value of "numberOfModifications" (any previous value will be
     * replaced)
     *
     * @param numberOfModifications
     *     New value of the "numberOfModifications" property.
     */
    public TaskStatus.Builder<_B> withNumberOfModifications(final Long numberOfModifications) {
      this.numberOfModifications = numberOfModifications;
      return this;
    }

    /**
     * Adds the given items to the value of "taskStatusExtensions"
     *
     * @param taskStatusExtensions
     *     Items to add to the value of the "taskStatusExtensions" property
     */
    public TaskStatus.Builder<_B> addTaskStatusExtensions(
      final Iterable<? extends TaskStatusExtensions> taskStatusExtensions
    ) {
      if (taskStatusExtensions != null) {
        if (this.taskStatusExtensions == null) {
          this.taskStatusExtensions = new ArrayList<>();
        }
        for (TaskStatusExtensions _item : taskStatusExtensions) {
          this.taskStatusExtensions.add(new TaskStatusExtensions.Builder<>(this, _item, false));
        }
      }
      return this;
    }

    /**
     * Sets the new value of "taskStatusExtensions" (any previous value will be
     * replaced)
     *
     * @param taskStatusExtensions
     *     New value of the "taskStatusExtensions" property.
     */
    public TaskStatus.Builder<_B> withTaskStatusExtensions(
      final Iterable<? extends TaskStatusExtensions> taskStatusExtensions
    ) {
      if (this.taskStatusExtensions != null) {
        this.taskStatusExtensions.clear();
      }
      return addTaskStatusExtensions(taskStatusExtensions);
    }

    /**
     * Adds the given items to the value of "taskStatusExtensions"
     *
     * @param taskStatusExtensions
     *     Items to add to the value of the "taskStatusExtensions" property
     */
    public TaskStatus.Builder<_B> addTaskStatusExtensions(TaskStatusExtensions... taskStatusExtensions) {
      addTaskStatusExtensions(Arrays.asList(taskStatusExtensions));
      return this;
    }

    /**
     * Sets the new value of "taskStatusExtensions" (any previous value will be
     * replaced)
     *
     * @param taskStatusExtensions
     *     New value of the "taskStatusExtensions" property.
     */
    public TaskStatus.Builder<_B> withTaskStatusExtensions(TaskStatusExtensions... taskStatusExtensions) {
      withTaskStatusExtensions(Arrays.asList(taskStatusExtensions));
      return this;
    }

    /**
     * Returns a new builder to build an additional value of the "TaskStatusExtensions"
     * property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.TaskStatusExtensions.Builder#end()}
     * to return to the current builder.
     *
     * @return
     *     a new builder to build an additional value of the "TaskStatusExtensions"
     *     property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.TaskStatusExtensions.Builder#end()}
     *     to return to the current builder.
     */
    public TaskStatusExtensions.Builder<? extends TaskStatus.Builder<_B>> addTaskStatusExtensions() {
      if (this.taskStatusExtensions == null) {
        this.taskStatusExtensions = new ArrayList<>();
      }
      final TaskStatusExtensions.Builder<TaskStatus.Builder<_B>> taskStatusExtensions_Builder =
        new TaskStatusExtensions.Builder<>(this, null, false);
      this.taskStatusExtensions.add(taskStatusExtensions_Builder);
      return taskStatusExtensions_Builder;
    }

    @Override
    public TaskStatus build() {
      if (_storedValue == null) {
        return this.init(new TaskStatus());
      } else {
        return ((TaskStatus) _storedValue);
      }
    }

    public TaskStatus.Builder<_B> copyOf(final TaskStatus _other) {
      _other.copyTo(this);
      return this;
    }

    public TaskStatus.Builder<_B> copyOf(final TaskStatus.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
