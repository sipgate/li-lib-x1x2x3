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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Java class for ListOfGenericObjectResponseDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="ListOfGenericObjectResponseDetails">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="genericObjectResponseDetails" type="{http://uri.etsi.org/03221/X1/2017/10}GenericObjectResponseDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfGenericObjectResponseDetails", propOrder = { "genericObjectResponseDetails" })
public class ListOfGenericObjectResponseDetails implements Copyable, PartialCopyable {

  protected List<GenericObjectResponseDetails> genericObjectResponseDetails;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ListOfGenericObjectResponseDetails() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ListOfGenericObjectResponseDetails copying the state of another ListOfGenericObjectResponseDetails
   *
   * @param _other
   *     The original ListOfGenericObjectResponseDetails from which to copy state.
   */
  public ListOfGenericObjectResponseDetails(final ListOfGenericObjectResponseDetails _other) {
    if (_other.genericObjectResponseDetails == null) {
      this.genericObjectResponseDetails = null;
    } else {
      this.genericObjectResponseDetails = new ArrayList<>();
      for (GenericObjectResponseDetails _item : _other.genericObjectResponseDetails) {
        this.genericObjectResponseDetails.add(((_item == null) ? null : _item.createCopy()));
      }
    }
  }

  /**
   * Instantiates a ListOfGenericObjectResponseDetails copying the state of another ListOfGenericObjectResponseDetails
   *
   * @param _other
   *     The original ListOfGenericObjectResponseDetails from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public ListOfGenericObjectResponseDetails(
    final ListOfGenericObjectResponseDetails _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree genericObjectResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("genericObjectResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (genericObjectResponseDetailsPropertyTree != null)
          : ((genericObjectResponseDetailsPropertyTree == null) ||
            (!genericObjectResponseDetailsPropertyTree.isLeaf())))
    ) {
      if (_other.genericObjectResponseDetails == null) {
        this.genericObjectResponseDetails = null;
      } else {
        this.genericObjectResponseDetails = new ArrayList<>();
        for (GenericObjectResponseDetails _item : _other.genericObjectResponseDetails) {
          this.genericObjectResponseDetails.add(
              ((_item == null) ? null : _item.createCopy(genericObjectResponseDetailsPropertyTree, _propertyTreeUse))
            );
        }
      }
    }
  }

  /**
   * Gets the value of the genericObjectResponseDetails property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the Jakarta XML Binding object.
   * This is why there is not a {@code set} method for the genericObjectResponseDetails property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getGenericObjectResponseDetails().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link GenericObjectResponseDetails }
   *
   *
   * @return
   *     The value of the genericObjectResponseDetails property.
   */
  public List<GenericObjectResponseDetails> getGenericObjectResponseDetails() {
    if (genericObjectResponseDetails == null) {
      genericObjectResponseDetails = new ArrayList<>();
    }
    return this.genericObjectResponseDetails;
  }

  @Override
  public ListOfGenericObjectResponseDetails createCopy() {
    final ListOfGenericObjectResponseDetails _newObject;
    try {
      _newObject = ((ListOfGenericObjectResponseDetails) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    if (this.genericObjectResponseDetails == null) {
      _newObject.genericObjectResponseDetails = null;
    } else {
      _newObject.genericObjectResponseDetails = new ArrayList<>();
      for (GenericObjectResponseDetails _item : this.genericObjectResponseDetails) {
        _newObject.genericObjectResponseDetails.add(((_item == null) ? null : _item.createCopy()));
      }
    }
    return _newObject;
  }

  @Override
  public ListOfGenericObjectResponseDetails createCopy(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ListOfGenericObjectResponseDetails _newObject;
    try {
      _newObject = ((ListOfGenericObjectResponseDetails) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    final PropertyTree genericObjectResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("genericObjectResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (genericObjectResponseDetailsPropertyTree != null)
          : ((genericObjectResponseDetailsPropertyTree == null) ||
            (!genericObjectResponseDetailsPropertyTree.isLeaf())))
    ) {
      if (this.genericObjectResponseDetails == null) {
        _newObject.genericObjectResponseDetails = null;
      } else {
        _newObject.genericObjectResponseDetails = new ArrayList<>();
        for (GenericObjectResponseDetails _item : this.genericObjectResponseDetails) {
          _newObject.genericObjectResponseDetails.add(
            ((_item == null) ? null : _item.createCopy(genericObjectResponseDetailsPropertyTree, _propertyTreeUse))
          );
        }
      }
    }
    return _newObject;
  }

  @Override
  public ListOfGenericObjectResponseDetails copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public ListOfGenericObjectResponseDetails copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final ListOfGenericObjectResponseDetails.Builder<_B> _other) {
    if (this.genericObjectResponseDetails == null) {
      _other.genericObjectResponseDetails = null;
    } else {
      _other.genericObjectResponseDetails = new ArrayList<>();
      for (GenericObjectResponseDetails _item : this.genericObjectResponseDetails) {
        _other.genericObjectResponseDetails.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
      }
    }
  }

  public <_B> ListOfGenericObjectResponseDetails.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ListOfGenericObjectResponseDetails.Builder<_B>(_parentBuilder, this, true);
  }

  public ListOfGenericObjectResponseDetails.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ListOfGenericObjectResponseDetails.Builder<Void> builder() {
    return new ListOfGenericObjectResponseDetails.Builder<>(null, null, false);
  }

  public static <_B> ListOfGenericObjectResponseDetails.Builder<_B> copyOf(
    final ListOfGenericObjectResponseDetails _other
  ) {
    final ListOfGenericObjectResponseDetails.Builder<_B> _newBuilder = new ListOfGenericObjectResponseDetails.Builder<>(
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
    final ListOfGenericObjectResponseDetails.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree genericObjectResponseDetailsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("genericObjectResponseDetails"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (genericObjectResponseDetailsPropertyTree != null)
          : ((genericObjectResponseDetailsPropertyTree == null) ||
            (!genericObjectResponseDetailsPropertyTree.isLeaf())))
    ) {
      if (this.genericObjectResponseDetails == null) {
        _other.genericObjectResponseDetails = null;
      } else {
        _other.genericObjectResponseDetails = new ArrayList<>();
        for (GenericObjectResponseDetails _item : this.genericObjectResponseDetails) {
          _other.genericObjectResponseDetails.add(
            ((_item == null)
                ? null
                : _item.newCopyBuilder(_other, genericObjectResponseDetailsPropertyTree, _propertyTreeUse))
          );
        }
      }
    }
  }

  public <_B> ListOfGenericObjectResponseDetails.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ListOfGenericObjectResponseDetails.Builder<_B>(
      _parentBuilder,
      this,
      true,
      _propertyTree,
      _propertyTreeUse
    );
  }

  public ListOfGenericObjectResponseDetails.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ListOfGenericObjectResponseDetails.Builder<_B> copyOf(
    final ListOfGenericObjectResponseDetails _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ListOfGenericObjectResponseDetails.Builder<_B> _newBuilder = new ListOfGenericObjectResponseDetails.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ListOfGenericObjectResponseDetails.Builder<Void> copyExcept(
    final ListOfGenericObjectResponseDetails _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ListOfGenericObjectResponseDetails.Builder<Void> copyOnly(
    final ListOfGenericObjectResponseDetails _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final ListOfGenericObjectResponseDetails _storedValue;
    private List<
      GenericObjectResponseDetails.Builder<ListOfGenericObjectResponseDetails.Builder<_B>>
    > genericObjectResponseDetails;

    public Builder(final _B _parentBuilder, final ListOfGenericObjectResponseDetails _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          if (_other.genericObjectResponseDetails == null) {
            this.genericObjectResponseDetails = null;
          } else {
            this.genericObjectResponseDetails = new ArrayList<>();
            for (GenericObjectResponseDetails _item : _other.genericObjectResponseDetails) {
              this.genericObjectResponseDetails.add(((_item == null) ? null : _item.newCopyBuilder(this)));
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
      final ListOfGenericObjectResponseDetails _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree genericObjectResponseDetailsPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("genericObjectResponseDetails"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (genericObjectResponseDetailsPropertyTree != null)
                : ((genericObjectResponseDetailsPropertyTree == null) ||
                  (!genericObjectResponseDetailsPropertyTree.isLeaf())))
          ) {
            if (_other.genericObjectResponseDetails == null) {
              this.genericObjectResponseDetails = null;
            } else {
              this.genericObjectResponseDetails = new ArrayList<>();
              for (GenericObjectResponseDetails _item : _other.genericObjectResponseDetails) {
                this.genericObjectResponseDetails.add(
                    ((_item == null)
                        ? null
                        : _item.newCopyBuilder(this, genericObjectResponseDetailsPropertyTree, _propertyTreeUse))
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

    protected <_P extends ListOfGenericObjectResponseDetails> _P init(final _P _product) {
      if (this.genericObjectResponseDetails != null) {
        final List<GenericObjectResponseDetails> genericObjectResponseDetails = new ArrayList<>(
          this.genericObjectResponseDetails.size()
        );
        for (GenericObjectResponseDetails.Builder<
          ListOfGenericObjectResponseDetails.Builder<_B>
        > _item : this.genericObjectResponseDetails) {
          genericObjectResponseDetails.add(_item.build());
        }
        _product.genericObjectResponseDetails = genericObjectResponseDetails;
      }
      return _product;
    }

    /**
     * Adds the given items to the value of "genericObjectResponseDetails"
     *
     * @param genericObjectResponseDetails
     *     Items to add to the value of the "genericObjectResponseDetails" property
     */
    public ListOfGenericObjectResponseDetails.Builder<_B> addGenericObjectResponseDetails(
      final Iterable<? extends GenericObjectResponseDetails> genericObjectResponseDetails
    ) {
      if (genericObjectResponseDetails != null) {
        if (this.genericObjectResponseDetails == null) {
          this.genericObjectResponseDetails = new ArrayList<>();
        }
        for (GenericObjectResponseDetails _item : genericObjectResponseDetails) {
          this.genericObjectResponseDetails.add(new GenericObjectResponseDetails.Builder<>(this, _item, false));
        }
      }
      return this;
    }

    /**
     * Sets the new value of "genericObjectResponseDetails" (any previous value will be
     * replaced)
     *
     * @param genericObjectResponseDetails
     *     New value of the "genericObjectResponseDetails" property.
     */
    public ListOfGenericObjectResponseDetails.Builder<_B> withGenericObjectResponseDetails(
      final Iterable<? extends GenericObjectResponseDetails> genericObjectResponseDetails
    ) {
      if (this.genericObjectResponseDetails != null) {
        this.genericObjectResponseDetails.clear();
      }
      return addGenericObjectResponseDetails(genericObjectResponseDetails);
    }

    /**
     * Adds the given items to the value of "genericObjectResponseDetails"
     *
     * @param genericObjectResponseDetails
     *     Items to add to the value of the "genericObjectResponseDetails" property
     */
    public ListOfGenericObjectResponseDetails.Builder<_B> addGenericObjectResponseDetails(
      GenericObjectResponseDetails... genericObjectResponseDetails
    ) {
      addGenericObjectResponseDetails(Arrays.asList(genericObjectResponseDetails));
      return this;
    }

    /**
     * Sets the new value of "genericObjectResponseDetails" (any previous value will be
     * replaced)
     *
     * @param genericObjectResponseDetails
     *     New value of the "genericObjectResponseDetails" property.
     */
    public ListOfGenericObjectResponseDetails.Builder<_B> withGenericObjectResponseDetails(
      GenericObjectResponseDetails... genericObjectResponseDetails
    ) {
      withGenericObjectResponseDetails(Arrays.asList(genericObjectResponseDetails));
      return this;
    }

    /**
     * Returns a new builder to build an additional value of the
     * "GenericObjectResponseDetails" property.
     * Use {@link
     * org.etsi.uri._03221.x1._2017._10.GenericObjectResponseDetails.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     a new builder to build an additional value of the "GenericObjectResponseDetails"
     *     property.
     *     Use {@link
     *     org.etsi.uri._03221.x1._2017._10.GenericObjectResponseDetails.Builder#end()} to
     *     return to the current builder.
     */
    public GenericObjectResponseDetails.Builder<
      ? extends ListOfGenericObjectResponseDetails.Builder<_B>
    > addGenericObjectResponseDetails() {
      if (this.genericObjectResponseDetails == null) {
        this.genericObjectResponseDetails = new ArrayList<>();
      }
      final GenericObjectResponseDetails.Builder<
        ListOfGenericObjectResponseDetails.Builder<_B>
      > genericObjectResponseDetails_Builder = new GenericObjectResponseDetails.Builder<>(this, null, false);
      this.genericObjectResponseDetails.add(genericObjectResponseDetails_Builder);
      return genericObjectResponseDetails_Builder;
    }

    @Override
    public ListOfGenericObjectResponseDetails build() {
      if (_storedValue == null) {
        return this.init(new ListOfGenericObjectResponseDetails());
      } else {
        return ((ListOfGenericObjectResponseDetails) _storedValue);
      }
    }

    public ListOfGenericObjectResponseDetails.Builder<_B> copyOf(final ListOfGenericObjectResponseDetails _other) {
      _other.copyTo(this);
      return this;
    }

    public ListOfGenericObjectResponseDetails.Builder<_B> copyOf(
      final ListOfGenericObjectResponseDetails.Builder _other
    ) {
      return copyOf(_other.build());
    }
  }

  public static class Select
    extends ListOfGenericObjectResponseDetails.Selector<ListOfGenericObjectResponseDetails.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static ListOfGenericObjectResponseDetails.Select _root() {
      return new ListOfGenericObjectResponseDetails.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private GenericObjectResponseDetails.Selector<
      TRoot,
      ListOfGenericObjectResponseDetails.Selector<TRoot, TParent>
    > genericObjectResponseDetails = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.genericObjectResponseDetails != null) {
        products.put("genericObjectResponseDetails", this.genericObjectResponseDetails.init());
      }
      return products;
    }

    public GenericObjectResponseDetails.Selector<
      TRoot,
      ListOfGenericObjectResponseDetails.Selector<TRoot, TParent>
    > genericObjectResponseDetails() {
      return (
        (this.genericObjectResponseDetails == null)
          ? this.genericObjectResponseDetails = new GenericObjectResponseDetails.Selector<>(
            this._root,
            this,
            "genericObjectResponseDetails"
          )
          : this.genericObjectResponseDetails
      );
    }
  }
}
