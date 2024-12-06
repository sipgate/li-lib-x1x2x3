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
 * <p>Java class for ListOfXids complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="ListOfXids">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="xId" type="{http://uri.etsi.org/03221/X1/2017/10}XId" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfXids", propOrder = { "xId" })
public class ListOfXids implements Copyable, PartialCopyable {

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected List<String> xId;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ListOfXids() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ListOfXids copying the state of another ListOfXids
   *
   * @param _other
   *     The original ListOfXids from which to copy state.
   */
  public ListOfXids(final ListOfXids _other) {
    this.xId = ((_other.xId == null) ? null : new ArrayList<>(_other.xId));
  }

  /**
   * Instantiates a ListOfXids copying the state of another ListOfXids
   *
   * @param _other
   *     The original ListOfXids from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public ListOfXids(final ListOfXids _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final PropertyTree xIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("xId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (xIdPropertyTree != null)
          : ((xIdPropertyTree == null) || (!xIdPropertyTree.isLeaf())))
    ) {
      this.xId = ((_other.xId == null) ? null : new ArrayList<>(_other.xId));
    }
  }

  /**
   * Gets the value of the xId property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the Jakarta XML Binding object.
   * This is why there is not a {@code set} method for the xId property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getXId().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link String }
   *
   *
   * @return
   *     The value of the xId property.
   */
  public List<String> getXId() {
    if (xId == null) {
      xId = new ArrayList<>();
    }
    return this.xId;
  }

  @Override
  public ListOfXids createCopy() {
    final ListOfXids _newObject;
    try {
      _newObject = ((ListOfXids) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    _newObject.xId = ((this.xId == null) ? null : new ArrayList<>(this.xId));
    return _newObject;
  }

  @Override
  public ListOfXids createCopy(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final ListOfXids _newObject;
    try {
      _newObject = ((ListOfXids) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    final PropertyTree xIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("xId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (xIdPropertyTree != null)
          : ((xIdPropertyTree == null) || (!xIdPropertyTree.isLeaf())))
    ) {
      _newObject.xId = ((this.xId == null) ? null : new ArrayList<>(this.xId));
    }
    return _newObject;
  }

  @Override
  public ListOfXids copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public ListOfXids copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final ListOfXids.Builder<_B> _other) {
    if (this.xId == null) {
      _other.xId = null;
    } else {
      _other.xId = new ArrayList<>();
      for (String _item : this.xId) {
        _other.xId.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
      }
    }
  }

  public <_B> ListOfXids.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ListOfXids.Builder<_B>(_parentBuilder, this, true);
  }

  public ListOfXids.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ListOfXids.Builder<Void> builder() {
    return new ListOfXids.Builder<>(null, null, false);
  }

  public static <_B> ListOfXids.Builder<_B> copyOf(final ListOfXids _other) {
    final ListOfXids.Builder<_B> _newBuilder = new ListOfXids.Builder<>(null, null, false);
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
    final ListOfXids.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree xIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("xId"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (xIdPropertyTree != null)
          : ((xIdPropertyTree == null) || (!xIdPropertyTree.isLeaf())))
    ) {
      if (this.xId == null) {
        _other.xId = null;
      } else {
        _other.xId = new ArrayList<>();
        for (String _item : this.xId) {
          _other.xId.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
        }
      }
    }
  }

  public <_B> ListOfXids.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ListOfXids.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public ListOfXids.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ListOfXids.Builder<_B> copyOf(
    final ListOfXids _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ListOfXids.Builder<_B> _newBuilder = new ListOfXids.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ListOfXids.Builder<Void> copyExcept(final ListOfXids _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ListOfXids.Builder<Void> copyOnly(final ListOfXids _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final ListOfXids _storedValue;
    private List<Buildable> xId;

    public Builder(final _B _parentBuilder, final ListOfXids _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          if (_other.xId == null) {
            this.xId = null;
          } else {
            this.xId = new ArrayList<>();
            for (String _item : _other.xId) {
              this.xId.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
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
      final ListOfXids _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree xIdPropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("xId"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (xIdPropertyTree != null)
                : ((xIdPropertyTree == null) || (!xIdPropertyTree.isLeaf())))
          ) {
            if (_other.xId == null) {
              this.xId = null;
            } else {
              this.xId = new ArrayList<>();
              for (String _item : _other.xId) {
                this.xId.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
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

    protected <_P extends ListOfXids> _P init(final _P _product) {
      if (this.xId != null) {
        final List<String> xId = new ArrayList<>(this.xId.size());
        for (Buildable _item : this.xId) {
          xId.add(((String) _item.build()));
        }
        _product.xId = xId;
      }
      return _product;
    }

    /**
     * Adds the given items to the value of "xId"
     *
     * @param xId
     *     Items to add to the value of the "xId" property
     */
    public ListOfXids.Builder<_B> addXId(final Iterable<? extends String> xId) {
      if (xId != null) {
        if (this.xId == null) {
          this.xId = new ArrayList<>();
        }
        for (String _item : xId) {
          this.xId.add(new Buildable.PrimitiveBuildable(_item));
        }
      }
      return this;
    }

    /**
     * Sets the new value of "xId" (any previous value will be replaced)
     *
     * @param xId
     *     New value of the "xId" property.
     */
    public ListOfXids.Builder<_B> withXId(final Iterable<? extends String> xId) {
      if (this.xId != null) {
        this.xId.clear();
      }
      return addXId(xId);
    }

    /**
     * Adds the given items to the value of "xId"
     *
     * @param xId
     *     Items to add to the value of the "xId" property
     */
    public ListOfXids.Builder<_B> addXId(String... xId) {
      addXId(Arrays.asList(xId));
      return this;
    }

    /**
     * Sets the new value of "xId" (any previous value will be replaced)
     *
     * @param xId
     *     New value of the "xId" property.
     */
    public ListOfXids.Builder<_B> withXId(String... xId) {
      withXId(Arrays.asList(xId));
      return this;
    }

    @Override
    public ListOfXids build() {
      if (_storedValue == null) {
        return this.init(new ListOfXids());
      } else {
        return ((ListOfXids) _storedValue);
      }
    }

    public ListOfXids.Builder<_B> copyOf(final ListOfXids _other) {
      _other.copyTo(this);
      return this;
    }

    public ListOfXids.Builder<_B> copyOf(final ListOfXids.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends ListOfXids.Selector<ListOfXids.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static ListOfXids.Select _root() {
      return new ListOfXids.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private com.kscs.util.jaxb.Selector<TRoot, ListOfXids.Selector<TRoot, TParent>> xId = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.xId != null) {
        products.put("xId", this.xId.init());
      }
      return products;
    }

    public com.kscs.util.jaxb.Selector<TRoot, ListOfXids.Selector<TRoot, TParent>> xId() {
      return ((this.xId == null) ? this.xId = new com.kscs.util.jaxb.Selector<>(this._root, this, "xId") : this.xId);
    }
  }
}
