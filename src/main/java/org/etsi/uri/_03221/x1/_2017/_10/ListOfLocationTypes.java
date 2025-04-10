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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Java class for ListOfLocationTypes complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="ListOfLocationTypes">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="locationType" type="{http://uri.etsi.org/03221/X1/2017/10}LocationType" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfLocationTypes", propOrder = { "locationType" })
public class ListOfLocationTypes implements Copyable {

  protected List<LocationType> locationType;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ListOfLocationTypes() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ListOfLocationTypes copying the state of another ListOfLocationTypes
   *
   * @param _other
   *     The original ListOfLocationTypes from which to copy state.
   */
  public ListOfLocationTypes(final ListOfLocationTypes _other) {
    if (_other.locationType == null) {
      this.locationType = null;
    } else {
      this.locationType = new ArrayList<>();
      for (LocationType _item : _other.locationType) {
        this.locationType.add(((_item == null) ? null : _item.createCopy()));
      }
    }
  }

  /**
   * Gets the value of the locationType property.
   *
   * <p>This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the locationType property.</p>
   *
   * <p>
   * For example, to add a new item, do as follows:
   * </p>
   * <pre>
   * getLocationType().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link LocationType }
   * </p>
   *
   *
   * @return
   *     The value of the locationType property.
   */
  public List<LocationType> getLocationType() {
    if (locationType == null) {
      locationType = new ArrayList<>();
    }
    return this.locationType;
  }

  @Override
  public ListOfLocationTypes createCopy() {
    final ListOfLocationTypes _newObject;
    try {
      _newObject = ((ListOfLocationTypes) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    if (this.locationType == null) {
      _newObject.locationType = null;
    } else {
      _newObject.locationType = new ArrayList<>();
      for (LocationType _item : this.locationType) {
        _newObject.locationType.add(((_item == null) ? null : _item.createCopy()));
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
  public <_B> void copyTo(final ListOfLocationTypes.Builder<_B> _other) {
    if (this.locationType == null) {
      _other.locationType = null;
    } else {
      _other.locationType = new ArrayList<>();
      for (LocationType _item : this.locationType) {
        _other.locationType.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
      }
    }
  }

  public <_B> ListOfLocationTypes.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ListOfLocationTypes.Builder<_B>(_parentBuilder, this, true);
  }

  public ListOfLocationTypes.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ListOfLocationTypes.Builder<Void> builder() {
    return new ListOfLocationTypes.Builder<>(null, null, false);
  }

  public static <_B> ListOfLocationTypes.Builder<_B> copyOf(final ListOfLocationTypes _other) {
    final ListOfLocationTypes.Builder<_B> _newBuilder = new ListOfLocationTypes.Builder<>(null, null, false);
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
    final ListOfLocationTypes.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree locationTypePropertyTree = ((_propertyTree == null) ? null : _propertyTree.get("locationType"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (locationTypePropertyTree != null)
          : ((locationTypePropertyTree == null) || (!locationTypePropertyTree.isLeaf())))
    ) {
      if (this.locationType == null) {
        _other.locationType = null;
      } else {
        _other.locationType = new ArrayList<>();
        for (LocationType _item : this.locationType) {
          _other.locationType.add(
            ((_item == null) ? null : _item.newCopyBuilder(_other, locationTypePropertyTree, _propertyTreeUse))
          );
        }
      }
    }
  }

  public <_B> ListOfLocationTypes.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ListOfLocationTypes.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public ListOfLocationTypes.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ListOfLocationTypes.Builder<_B> copyOf(
    final ListOfLocationTypes _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ListOfLocationTypes.Builder<_B> _newBuilder = new ListOfLocationTypes.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ListOfLocationTypes.Builder<Void> copyExcept(
    final ListOfLocationTypes _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ListOfLocationTypes.Builder<Void> copyOnly(
    final ListOfLocationTypes _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final ListOfLocationTypes _storedValue;
    private List<LocationType.Builder<ListOfLocationTypes.Builder<_B>>> locationType;

    public Builder(final _B _parentBuilder, final ListOfLocationTypes _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          if (_other.locationType == null) {
            this.locationType = null;
          } else {
            this.locationType = new ArrayList<>();
            for (LocationType _item : _other.locationType) {
              this.locationType.add(((_item == null) ? null : _item.newCopyBuilder(this)));
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
      final ListOfLocationTypes _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree locationTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("locationType"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (locationTypePropertyTree != null)
                : ((locationTypePropertyTree == null) || (!locationTypePropertyTree.isLeaf())))
          ) {
            if (_other.locationType == null) {
              this.locationType = null;
            } else {
              this.locationType = new ArrayList<>();
              for (LocationType _item : _other.locationType) {
                this.locationType.add(
                    ((_item == null) ? null : _item.newCopyBuilder(this, locationTypePropertyTree, _propertyTreeUse))
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

    protected <_P extends ListOfLocationTypes> _P init(final _P _product) {
      if (this.locationType != null) {
        final List<LocationType> locationType = new ArrayList<>(this.locationType.size());
        for (LocationType.Builder<ListOfLocationTypes.Builder<_B>> _item : this.locationType) {
          locationType.add(_item.build());
        }
        _product.locationType = locationType;
      }
      return _product;
    }

    /**
     * Adds the given items to the value of "locationType"
     *
     * @param locationType
     *     Items to add to the value of the "locationType" property
     */
    public ListOfLocationTypes.Builder<_B> addLocationType(final Iterable<? extends LocationType> locationType) {
      if (locationType != null) {
        if (this.locationType == null) {
          this.locationType = new ArrayList<>();
        }
        for (LocationType _item : locationType) {
          this.locationType.add(new LocationType.Builder<>(this, _item, false));
        }
      }
      return this;
    }

    /**
     * Sets the new value of "locationType" (any previous value will be replaced)
     *
     * @param locationType
     *     New value of the "locationType" property.
     */
    public ListOfLocationTypes.Builder<_B> withLocationType(final Iterable<? extends LocationType> locationType) {
      if (this.locationType != null) {
        this.locationType.clear();
      }
      return addLocationType(locationType);
    }

    /**
     * Adds the given items to the value of "locationType"
     *
     * @param locationType
     *     Items to add to the value of the "locationType" property
     */
    public ListOfLocationTypes.Builder<_B> addLocationType(LocationType... locationType) {
      addLocationType(Arrays.asList(locationType));
      return this;
    }

    /**
     * Sets the new value of "locationType" (any previous value will be replaced)
     *
     * @param locationType
     *     New value of the "locationType" property.
     */
    public ListOfLocationTypes.Builder<_B> withLocationType(LocationType... locationType) {
      withLocationType(Arrays.asList(locationType));
      return this;
    }

    /**
     * Returns a new builder to build an additional value of the "LocationType"
     * property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.LocationType.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     a new builder to build an additional value of the "LocationType" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.LocationType.Builder#end()} to
     *     return to the current builder.
     */
    public LocationType.Builder<? extends ListOfLocationTypes.Builder<_B>> addLocationType() {
      if (this.locationType == null) {
        this.locationType = new ArrayList<>();
      }
      final LocationType.Builder<ListOfLocationTypes.Builder<_B>> locationType_Builder = new LocationType.Builder<>(
        this,
        null,
        false
      );
      this.locationType.add(locationType_Builder);
      return locationType_Builder;
    }

    @Override
    public ListOfLocationTypes build() {
      if (_storedValue == null) {
        return this.init(new ListOfLocationTypes());
      } else {
        return ((ListOfLocationTypes) _storedValue);
      }
    }

    public ListOfLocationTypes.Builder<_B> copyOf(final ListOfLocationTypes _other) {
      _other.copyTo(this);
      return this;
    }

    public ListOfLocationTypes.Builder<_B> copyOf(final ListOfLocationTypes.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
