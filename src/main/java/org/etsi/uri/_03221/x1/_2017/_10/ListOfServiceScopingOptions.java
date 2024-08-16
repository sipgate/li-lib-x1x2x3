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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Java class for ListOfServiceScopingOptions complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="ListOfServiceScopingOptions">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="serviceScopingOptions" type="{http://uri.etsi.org/03221/X1/2017/10}ServiceScopingOptions" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfServiceScopingOptions", propOrder = { "serviceScopingOptions" })
public class ListOfServiceScopingOptions implements Copyable, PartialCopyable {

  protected List<ServiceScopingOptions> serviceScopingOptions;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ListOfServiceScopingOptions() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ListOfServiceScopingOptions copying the state of another ListOfServiceScopingOptions
   *
   * @param _other
   *     The original ListOfServiceScopingOptions from which to copy state.
   */
  public ListOfServiceScopingOptions(final ListOfServiceScopingOptions _other) {
    if (_other.serviceScopingOptions == null) {
      this.serviceScopingOptions = null;
    } else {
      this.serviceScopingOptions = new ArrayList<>();
      for (ServiceScopingOptions _item : _other.serviceScopingOptions) {
        this.serviceScopingOptions.add(((_item == null) ? null : _item.createCopy()));
      }
    }
  }

  /**
   * Instantiates a ListOfServiceScopingOptions copying the state of another ListOfServiceScopingOptions
   *
   * @param _other
   *     The original ListOfServiceScopingOptions from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public ListOfServiceScopingOptions(
    final ListOfServiceScopingOptions _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree serviceScopingOptionsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("serviceScopingOptions"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (serviceScopingOptionsPropertyTree != null)
          : ((serviceScopingOptionsPropertyTree == null) || (!serviceScopingOptionsPropertyTree.isLeaf())))
    ) {
      if (_other.serviceScopingOptions == null) {
        this.serviceScopingOptions = null;
      } else {
        this.serviceScopingOptions = new ArrayList<>();
        for (ServiceScopingOptions _item : _other.serviceScopingOptions) {
          this.serviceScopingOptions.add(
              ((_item == null) ? null : _item.createCopy(serviceScopingOptionsPropertyTree, _propertyTreeUse))
            );
        }
      }
    }
  }

  /**
   * Gets the value of the serviceScopingOptions property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the Jakarta XML Binding object.
   * This is why there is not a {@code set} method for the serviceScopingOptions property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getServiceScopingOptions().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link ServiceScopingOptions }
   *
   *
   * @return
   *     The value of the serviceScopingOptions property.
   */
  public List<ServiceScopingOptions> getServiceScopingOptions() {
    if (serviceScopingOptions == null) {
      serviceScopingOptions = new ArrayList<>();
    }
    return this.serviceScopingOptions;
  }

  @Override
  public ListOfServiceScopingOptions createCopy() {
    final ListOfServiceScopingOptions _newObject;
    try {
      _newObject = ((ListOfServiceScopingOptions) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    if (this.serviceScopingOptions == null) {
      _newObject.serviceScopingOptions = null;
    } else {
      _newObject.serviceScopingOptions = new ArrayList<>();
      for (ServiceScopingOptions _item : this.serviceScopingOptions) {
        _newObject.serviceScopingOptions.add(((_item == null) ? null : _item.createCopy()));
      }
    }
    return _newObject;
  }

  @Override
  public ListOfServiceScopingOptions createCopy(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ListOfServiceScopingOptions _newObject;
    try {
      _newObject = ((ListOfServiceScopingOptions) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    final PropertyTree serviceScopingOptionsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("serviceScopingOptions"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (serviceScopingOptionsPropertyTree != null)
          : ((serviceScopingOptionsPropertyTree == null) || (!serviceScopingOptionsPropertyTree.isLeaf())))
    ) {
      if (this.serviceScopingOptions == null) {
        _newObject.serviceScopingOptions = null;
      } else {
        _newObject.serviceScopingOptions = new ArrayList<>();
        for (ServiceScopingOptions _item : this.serviceScopingOptions) {
          _newObject.serviceScopingOptions.add(
            ((_item == null) ? null : _item.createCopy(serviceScopingOptionsPropertyTree, _propertyTreeUse))
          );
        }
      }
    }
    return _newObject;
  }

  @Override
  public ListOfServiceScopingOptions copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public ListOfServiceScopingOptions copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final ListOfServiceScopingOptions.Builder<_B> _other) {
    if (this.serviceScopingOptions == null) {
      _other.serviceScopingOptions = null;
    } else {
      _other.serviceScopingOptions = new ArrayList<>();
      for (ServiceScopingOptions _item : this.serviceScopingOptions) {
        _other.serviceScopingOptions.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
      }
    }
  }

  public <_B> ListOfServiceScopingOptions.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ListOfServiceScopingOptions.Builder<_B>(_parentBuilder, this, true);
  }

  public ListOfServiceScopingOptions.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ListOfServiceScopingOptions.Builder<Void> builder() {
    return new ListOfServiceScopingOptions.Builder<>(null, null, false);
  }

  public static <_B> ListOfServiceScopingOptions.Builder<_B> copyOf(final ListOfServiceScopingOptions _other) {
    final ListOfServiceScopingOptions.Builder<_B> _newBuilder = new ListOfServiceScopingOptions.Builder<>(
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
    final ListOfServiceScopingOptions.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree serviceScopingOptionsPropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("serviceScopingOptions"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (serviceScopingOptionsPropertyTree != null)
          : ((serviceScopingOptionsPropertyTree == null) || (!serviceScopingOptionsPropertyTree.isLeaf())))
    ) {
      if (this.serviceScopingOptions == null) {
        _other.serviceScopingOptions = null;
      } else {
        _other.serviceScopingOptions = new ArrayList<>();
        for (ServiceScopingOptions _item : this.serviceScopingOptions) {
          _other.serviceScopingOptions.add(
            ((_item == null) ? null : _item.newCopyBuilder(_other, serviceScopingOptionsPropertyTree, _propertyTreeUse))
          );
        }
      }
    }
  }

  public <_B> ListOfServiceScopingOptions.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ListOfServiceScopingOptions.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public ListOfServiceScopingOptions.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ListOfServiceScopingOptions.Builder<_B> copyOf(
    final ListOfServiceScopingOptions _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ListOfServiceScopingOptions.Builder<_B> _newBuilder = new ListOfServiceScopingOptions.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ListOfServiceScopingOptions.Builder<Void> copyExcept(
    final ListOfServiceScopingOptions _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ListOfServiceScopingOptions.Builder<Void> copyOnly(
    final ListOfServiceScopingOptions _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final ListOfServiceScopingOptions _storedValue;
    private List<ServiceScopingOptions.Builder<ListOfServiceScopingOptions.Builder<_B>>> serviceScopingOptions;

    public Builder(final _B _parentBuilder, final ListOfServiceScopingOptions _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          if (_other.serviceScopingOptions == null) {
            this.serviceScopingOptions = null;
          } else {
            this.serviceScopingOptions = new ArrayList<>();
            for (ServiceScopingOptions _item : _other.serviceScopingOptions) {
              this.serviceScopingOptions.add(((_item == null) ? null : _item.newCopyBuilder(this)));
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
      final ListOfServiceScopingOptions _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree serviceScopingOptionsPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("serviceScopingOptions"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (serviceScopingOptionsPropertyTree != null)
                : ((serviceScopingOptionsPropertyTree == null) || (!serviceScopingOptionsPropertyTree.isLeaf())))
          ) {
            if (_other.serviceScopingOptions == null) {
              this.serviceScopingOptions = null;
            } else {
              this.serviceScopingOptions = new ArrayList<>();
              for (ServiceScopingOptions _item : _other.serviceScopingOptions) {
                this.serviceScopingOptions.add(
                    ((_item == null)
                        ? null
                        : _item.newCopyBuilder(this, serviceScopingOptionsPropertyTree, _propertyTreeUse))
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

    protected <_P extends ListOfServiceScopingOptions> _P init(final _P _product) {
      if (this.serviceScopingOptions != null) {
        final List<ServiceScopingOptions> serviceScopingOptions = new ArrayList<>(this.serviceScopingOptions.size());
        for (ServiceScopingOptions.Builder<
          ListOfServiceScopingOptions.Builder<_B>
        > _item : this.serviceScopingOptions) {
          serviceScopingOptions.add(_item.build());
        }
        _product.serviceScopingOptions = serviceScopingOptions;
      }
      return _product;
    }

    /**
     * Adds the given items to the value of "serviceScopingOptions"
     *
     * @param serviceScopingOptions
     *     Items to add to the value of the "serviceScopingOptions" property
     */
    public ListOfServiceScopingOptions.Builder<_B> addServiceScopingOptions(
      final Iterable<? extends ServiceScopingOptions> serviceScopingOptions
    ) {
      if (serviceScopingOptions != null) {
        if (this.serviceScopingOptions == null) {
          this.serviceScopingOptions = new ArrayList<>();
        }
        for (ServiceScopingOptions _item : serviceScopingOptions) {
          this.serviceScopingOptions.add(new ServiceScopingOptions.Builder<>(this, _item, false));
        }
      }
      return this;
    }

    /**
     * Sets the new value of "serviceScopingOptions" (any previous value will be
     * replaced)
     *
     * @param serviceScopingOptions
     *     New value of the "serviceScopingOptions" property.
     */
    public ListOfServiceScopingOptions.Builder<_B> withServiceScopingOptions(
      final Iterable<? extends ServiceScopingOptions> serviceScopingOptions
    ) {
      if (this.serviceScopingOptions != null) {
        this.serviceScopingOptions.clear();
      }
      return addServiceScopingOptions(serviceScopingOptions);
    }

    /**
     * Adds the given items to the value of "serviceScopingOptions"
     *
     * @param serviceScopingOptions
     *     Items to add to the value of the "serviceScopingOptions" property
     */
    public ListOfServiceScopingOptions.Builder<_B> addServiceScopingOptions(
      ServiceScopingOptions... serviceScopingOptions
    ) {
      addServiceScopingOptions(Arrays.asList(serviceScopingOptions));
      return this;
    }

    /**
     * Sets the new value of "serviceScopingOptions" (any previous value will be
     * replaced)
     *
     * @param serviceScopingOptions
     *     New value of the "serviceScopingOptions" property.
     */
    public ListOfServiceScopingOptions.Builder<_B> withServiceScopingOptions(
      ServiceScopingOptions... serviceScopingOptions
    ) {
      withServiceScopingOptions(Arrays.asList(serviceScopingOptions));
      return this;
    }

    /**
     * Returns a new builder to build an additional value of the
     * "ServiceScopingOptions" property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.ServiceScopingOptions.Builder#end()}
     * to return to the current builder.
     *
     * @return
     *     a new builder to build an additional value of the "ServiceScopingOptions"
     *     property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.ServiceScopingOptions.Builder#end()}
     *     to return to the current builder.
     */
    public ServiceScopingOptions.Builder<? extends ListOfServiceScopingOptions.Builder<_B>> addServiceScopingOptions() {
      if (this.serviceScopingOptions == null) {
        this.serviceScopingOptions = new ArrayList<>();
      }
      final ServiceScopingOptions.Builder<ListOfServiceScopingOptions.Builder<_B>> serviceScopingOptions_Builder =
        new ServiceScopingOptions.Builder<>(this, null, false);
      this.serviceScopingOptions.add(serviceScopingOptions_Builder);
      return serviceScopingOptions_Builder;
    }

    @Override
    public ListOfServiceScopingOptions build() {
      if (_storedValue == null) {
        return this.init(new ListOfServiceScopingOptions());
      } else {
        return ((ListOfServiceScopingOptions) _storedValue);
      }
    }

    public ListOfServiceScopingOptions.Builder<_B> copyOf(final ListOfServiceScopingOptions _other) {
      _other.copyTo(this);
      return this;
    }

    public ListOfServiceScopingOptions.Builder<_B> copyOf(final ListOfServiceScopingOptions.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends ListOfServiceScopingOptions.Selector<ListOfServiceScopingOptions.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static ListOfServiceScopingOptions.Select _root() {
      return new ListOfServiceScopingOptions.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private ServiceScopingOptions.Selector<
      TRoot,
      ListOfServiceScopingOptions.Selector<TRoot, TParent>
    > serviceScopingOptions = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      if (this.serviceScopingOptions != null) {
        products.put("serviceScopingOptions", this.serviceScopingOptions.init());
      }
      return products;
    }

    public ServiceScopingOptions.Selector<
      TRoot,
      ListOfServiceScopingOptions.Selector<TRoot, TParent>
    > serviceScopingOptions() {
      return (
        (this.serviceScopingOptions == null)
          ? this.serviceScopingOptions = new ServiceScopingOptions.Selector<>(this._root, this, "serviceScopingOptions")
          : this.serviceScopingOptions
      );
    }
  }
}
