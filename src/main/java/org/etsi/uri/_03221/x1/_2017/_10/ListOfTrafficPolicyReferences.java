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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Java class for ListOfTrafficPolicyReferences complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="ListOfTrafficPolicyReferences">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="trafficPolicyReference" type="{http://uri.etsi.org/03221/X1/2017/10}TrafficPolicyReference" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfTrafficPolicyReferences", propOrder = { "trafficPolicyReference" })
public class ListOfTrafficPolicyReferences implements Copyable, PartialCopyable {

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected List<String> trafficPolicyReference;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ListOfTrafficPolicyReferences() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ListOfTrafficPolicyReferences copying the state of another ListOfTrafficPolicyReferences
   *
   * @param _other
   *     The original ListOfTrafficPolicyReferences from which to copy state.
   */
  public ListOfTrafficPolicyReferences(final ListOfTrafficPolicyReferences _other) {
    this.trafficPolicyReference = ((_other.trafficPolicyReference == null)
        ? null
        : new ArrayList<>(_other.trafficPolicyReference));
  }

  /**
   * Instantiates a ListOfTrafficPolicyReferences copying the state of another ListOfTrafficPolicyReferences
   *
   * @param _other
   *     The original ListOfTrafficPolicyReferences from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public ListOfTrafficPolicyReferences(
    final ListOfTrafficPolicyReferences _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree trafficPolicyReferencePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("trafficPolicyReference"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (trafficPolicyReferencePropertyTree != null)
          : ((trafficPolicyReferencePropertyTree == null) || (!trafficPolicyReferencePropertyTree.isLeaf())))
    ) {
      this.trafficPolicyReference = ((_other.trafficPolicyReference == null)
          ? null
          : new ArrayList<>(_other.trafficPolicyReference));
    }
  }

  /**
   * Gets the value of the trafficPolicyReference property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the Jakarta XML Binding object.
   * This is why there is not a {@code set} method for the trafficPolicyReference property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getTrafficPolicyReference().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link String }
   *
   *
   * @return
   *     The value of the trafficPolicyReference property.
   */
  public List<String> getTrafficPolicyReference() {
    if (trafficPolicyReference == null) {
      trafficPolicyReference = new ArrayList<>();
    }
    return this.trafficPolicyReference;
  }

  @Override
  public ListOfTrafficPolicyReferences createCopy() {
    final ListOfTrafficPolicyReferences _newObject;
    try {
      _newObject = ((ListOfTrafficPolicyReferences) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.trafficPolicyReference = ((this.trafficPolicyReference == null)
        ? null
        : new ArrayList<>(this.trafficPolicyReference));
    return _newObject;
  }

  @Override
  public ListOfTrafficPolicyReferences createCopy(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ListOfTrafficPolicyReferences _newObject;
    try {
      _newObject = ((ListOfTrafficPolicyReferences) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    final PropertyTree trafficPolicyReferencePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("trafficPolicyReference"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (trafficPolicyReferencePropertyTree != null)
          : ((trafficPolicyReferencePropertyTree == null) || (!trafficPolicyReferencePropertyTree.isLeaf())))
    ) {
      _newObject.trafficPolicyReference = ((this.trafficPolicyReference == null)
          ? null
          : new ArrayList<>(this.trafficPolicyReference));
    }
    return _newObject;
  }

  @Override
  public ListOfTrafficPolicyReferences copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public ListOfTrafficPolicyReferences copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final ListOfTrafficPolicyReferences.Builder<_B> _other) {
    if (this.trafficPolicyReference == null) {
      _other.trafficPolicyReference = null;
    } else {
      _other.trafficPolicyReference = new ArrayList<>();
      for (String _item : this.trafficPolicyReference) {
        _other.trafficPolicyReference.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
      }
    }
  }

  public <_B> ListOfTrafficPolicyReferences.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ListOfTrafficPolicyReferences.Builder<_B>(_parentBuilder, this, true);
  }

  public ListOfTrafficPolicyReferences.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ListOfTrafficPolicyReferences.Builder<Void> builder() {
    return new ListOfTrafficPolicyReferences.Builder<>(null, null, false);
  }

  public static <_B> ListOfTrafficPolicyReferences.Builder<_B> copyOf(final ListOfTrafficPolicyReferences _other) {
    final ListOfTrafficPolicyReferences.Builder<_B> _newBuilder = new ListOfTrafficPolicyReferences.Builder<>(
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
    final ListOfTrafficPolicyReferences.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree trafficPolicyReferencePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("trafficPolicyReference"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (trafficPolicyReferencePropertyTree != null)
          : ((trafficPolicyReferencePropertyTree == null) || (!trafficPolicyReferencePropertyTree.isLeaf())))
    ) {
      if (this.trafficPolicyReference == null) {
        _other.trafficPolicyReference = null;
      } else {
        _other.trafficPolicyReference = new ArrayList<>();
        for (String _item : this.trafficPolicyReference) {
          _other.trafficPolicyReference.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
        }
      }
    }
  }

  public <_B> ListOfTrafficPolicyReferences.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ListOfTrafficPolicyReferences.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public ListOfTrafficPolicyReferences.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ListOfTrafficPolicyReferences.Builder<_B> copyOf(
    final ListOfTrafficPolicyReferences _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ListOfTrafficPolicyReferences.Builder<_B> _newBuilder = new ListOfTrafficPolicyReferences.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ListOfTrafficPolicyReferences.Builder<Void> copyExcept(
    final ListOfTrafficPolicyReferences _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ListOfTrafficPolicyReferences.Builder<Void> copyOnly(
    final ListOfTrafficPolicyReferences _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final ListOfTrafficPolicyReferences _storedValue;
    private List<Buildable> trafficPolicyReference;

    public Builder(final _B _parentBuilder, final ListOfTrafficPolicyReferences _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          if (_other.trafficPolicyReference == null) {
            this.trafficPolicyReference = null;
          } else {
            this.trafficPolicyReference = new ArrayList<>();
            for (String _item : _other.trafficPolicyReference) {
              this.trafficPolicyReference.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
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
      final ListOfTrafficPolicyReferences _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree trafficPolicyReferencePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("trafficPolicyReference"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (trafficPolicyReferencePropertyTree != null)
                : ((trafficPolicyReferencePropertyTree == null) || (!trafficPolicyReferencePropertyTree.isLeaf())))
          ) {
            if (_other.trafficPolicyReference == null) {
              this.trafficPolicyReference = null;
            } else {
              this.trafficPolicyReference = new ArrayList<>();
              for (String _item : _other.trafficPolicyReference) {
                this.trafficPolicyReference.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
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

    protected <_P extends ListOfTrafficPolicyReferences> _P init(final _P _product) {
      if (this.trafficPolicyReference != null) {
        final List<String> trafficPolicyReference = new ArrayList<>(this.trafficPolicyReference.size());
        for (Buildable _item : this.trafficPolicyReference) {
          trafficPolicyReference.add(((String) _item.build()));
        }
        _product.trafficPolicyReference = trafficPolicyReference;
      }
      return _product;
    }

    /**
     * Adds the given items to the value of "trafficPolicyReference"
     *
     * @param trafficPolicyReference
     *     Items to add to the value of the "trafficPolicyReference" property
     */
    public ListOfTrafficPolicyReferences.Builder<_B> addTrafficPolicyReference(
      final Iterable<? extends String> trafficPolicyReference
    ) {
      if (trafficPolicyReference != null) {
        if (this.trafficPolicyReference == null) {
          this.trafficPolicyReference = new ArrayList<>();
        }
        for (String _item : trafficPolicyReference) {
          this.trafficPolicyReference.add(new Buildable.PrimitiveBuildable(_item));
        }
      }
      return this;
    }

    /**
     * Sets the new value of "trafficPolicyReference" (any previous value will be
     * replaced)
     *
     * @param trafficPolicyReference
     *     New value of the "trafficPolicyReference" property.
     */
    public ListOfTrafficPolicyReferences.Builder<_B> withTrafficPolicyReference(
      final Iterable<? extends String> trafficPolicyReference
    ) {
      if (this.trafficPolicyReference != null) {
        this.trafficPolicyReference.clear();
      }
      return addTrafficPolicyReference(trafficPolicyReference);
    }

    /**
     * Adds the given items to the value of "trafficPolicyReference"
     *
     * @param trafficPolicyReference
     *     Items to add to the value of the "trafficPolicyReference" property
     */
    public ListOfTrafficPolicyReferences.Builder<_B> addTrafficPolicyReference(String... trafficPolicyReference) {
      addTrafficPolicyReference(Arrays.asList(trafficPolicyReference));
      return this;
    }

    /**
     * Sets the new value of "trafficPolicyReference" (any previous value will be
     * replaced)
     *
     * @param trafficPolicyReference
     *     New value of the "trafficPolicyReference" property.
     */
    public ListOfTrafficPolicyReferences.Builder<_B> withTrafficPolicyReference(String... trafficPolicyReference) {
      withTrafficPolicyReference(Arrays.asList(trafficPolicyReference));
      return this;
    }

    @Override
    public ListOfTrafficPolicyReferences build() {
      if (_storedValue == null) {
        return this.init(new ListOfTrafficPolicyReferences());
      } else {
        return ((ListOfTrafficPolicyReferences) _storedValue);
      }
    }

    public ListOfTrafficPolicyReferences.Builder<_B> copyOf(final ListOfTrafficPolicyReferences _other) {
      _other.copyTo(this);
      return this;
    }

    public ListOfTrafficPolicyReferences.Builder<_B> copyOf(final ListOfTrafficPolicyReferences.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select
    extends ListOfTrafficPolicyReferences.Selector<ListOfTrafficPolicyReferences.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static ListOfTrafficPolicyReferences.Select _root() {
      return new ListOfTrafficPolicyReferences.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private com.kscs.util.jaxb.Selector<
      TRoot,
      ListOfTrafficPolicyReferences.Selector<TRoot, TParent>
    > trafficPolicyReference = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.trafficPolicyReference != null) {
        products.put("trafficPolicyReference", this.trafficPolicyReference.init());
      }
      return products;
    }

    public com.kscs.util.jaxb.Selector<
      TRoot,
      ListOfTrafficPolicyReferences.Selector<TRoot, TParent>
    > trafficPolicyReference() {
      return (
        (this.trafficPolicyReference == null)
          ? this.trafficPolicyReference = new com.kscs.util.jaxb.Selector<>(this._root, this, "trafficPolicyReference")
          : this.trafficPolicyReference
      );
    }
  }
}
