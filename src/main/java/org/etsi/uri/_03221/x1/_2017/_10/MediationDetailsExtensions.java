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
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Java class for MediationDetailsExtensions complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="MediationDetailsExtensions">
 *   <complexContent>
 *     <extension base="{http://uri.etsi.org/03221/X1/2017/10}Extension">
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediationDetailsExtensions")
public class MediationDetailsExtensions extends Extension implements Copyable, PartialCopyable {

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public MediationDetailsExtensions() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a MediationDetailsExtensions copying the state of another MediationDetailsExtensions
   *
   * @param _other
   *     The original MediationDetailsExtensions from which to copy state.
   */
  public MediationDetailsExtensions(final MediationDetailsExtensions _other) {
    super(_other);
  }

  /**
   * Instantiates a MediationDetailsExtensions copying the state of another MediationDetailsExtensions
   *
   * @param _other
   *     The original MediationDetailsExtensions from which to copy state.
   * @param _propertyTree
   *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
   * @param _propertyTreeUse
   *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
   */
  public MediationDetailsExtensions(
    final MediationDetailsExtensions _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super(_other, _propertyTree, _propertyTreeUse);
  }

  @Override
  public MediationDetailsExtensions createCopy() {
    final MediationDetailsExtensions _newObject = ((MediationDetailsExtensions) super.createCopy());
    return _newObject;
  }

  @Override
  public MediationDetailsExtensions createCopy(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final MediationDetailsExtensions _newObject =
      ((MediationDetailsExtensions) super.createCopy(_propertyTree, _propertyTreeUse));
    return _newObject;
  }

  @Override
  public MediationDetailsExtensions copyExcept(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
  }

  @Override
  public MediationDetailsExtensions copyOnly(final PropertyTree _propertyTree) {
    return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
  }

  /**
   * Copies all state of this object to a builder. This method is used by the copyOf
   * method and should not be called directly by client code.
   *
   * @param _other
   *     A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final MediationDetailsExtensions.Builder<_B> _other) {
    super.copyTo(_other);
  }

  @Override
  public <_B> MediationDetailsExtensions.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new MediationDetailsExtensions.Builder<_B>(_parentBuilder, this, true);
  }

  @Override
  public MediationDetailsExtensions.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static MediationDetailsExtensions.Builder<Void> builder() {
    return new MediationDetailsExtensions.Builder<>(null, null, false);
  }

  public static <_B> MediationDetailsExtensions.Builder<_B> copyOf(final Extension _other) {
    final MediationDetailsExtensions.Builder<_B> _newBuilder = new MediationDetailsExtensions.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  public static <_B> MediationDetailsExtensions.Builder<_B> copyOf(final MediationDetailsExtensions _other) {
    final MediationDetailsExtensions.Builder<_B> _newBuilder = new MediationDetailsExtensions.Builder<>(
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
    final MediationDetailsExtensions.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    super.copyTo(_other, _propertyTree, _propertyTreeUse);
  }

  @Override
  public <_B> MediationDetailsExtensions.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new MediationDetailsExtensions.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  @Override
  public MediationDetailsExtensions.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> MediationDetailsExtensions.Builder<_B> copyOf(
    final Extension _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final MediationDetailsExtensions.Builder<_B> _newBuilder = new MediationDetailsExtensions.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static <_B> MediationDetailsExtensions.Builder<_B> copyOf(
    final MediationDetailsExtensions _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final MediationDetailsExtensions.Builder<_B> _newBuilder = new MediationDetailsExtensions.Builder<>(
      null,
      null,
      false
    );
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static MediationDetailsExtensions.Builder<Void> copyExcept(
    final Extension _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static MediationDetailsExtensions.Builder<Void> copyExcept(
    final MediationDetailsExtensions _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static MediationDetailsExtensions.Builder<Void> copyOnly(
    final Extension _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static MediationDetailsExtensions.Builder<Void> copyOnly(
    final MediationDetailsExtensions _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> extends Extension.Builder<_B> implements Buildable {

    public Builder(final _B _parentBuilder, final MediationDetailsExtensions _other, final boolean _copy) {
      super(_parentBuilder, _other, _copy);
      if (_other != null) {}
    }

    public Builder(
      final _B _parentBuilder,
      final MediationDetailsExtensions _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      super(_parentBuilder, _other, _copy, _propertyTree, _propertyTreeUse);
      if (_other != null) {}
    }

    protected <_P extends MediationDetailsExtensions> _P init(final _P _product) {
      return super.init(_product);
    }

    /**
     * Sets the new value of "owner" (any previous value will be replaced)
     *
     * @param owner
     *     New value of the "owner" property.
     */
    @Override
    public MediationDetailsExtensions.Builder<_B> withOwner(final String owner) {
      super.withOwner(owner);
      return this;
    }

    /**
     * Adds the given items to the value of "any"
     *
     * @param any
     *     Items to add to the value of the "any" property
     */
    @Override
    public MediationDetailsExtensions.Builder<_B> addAny(final Iterable<?> any) {
      super.addAny(any);
      return this;
    }

    /**
     * Adds the given items to the value of "any"
     *
     * @param any
     *     Items to add to the value of the "any" property
     */
    @Override
    public MediationDetailsExtensions.Builder<_B> addAny(Object... any) {
      super.addAny(any);
      return this;
    }

    /**
     * Sets the new value of "any" (any previous value will be replaced)
     *
     * @param any
     *     New value of the "any" property.
     */
    @Override
    public MediationDetailsExtensions.Builder<_B> withAny(final Iterable<?> any) {
      super.withAny(any);
      return this;
    }

    /**
     * Sets the new value of "any" (any previous value will be replaced)
     *
     * @param any
     *     New value of the "any" property.
     */
    @Override
    public MediationDetailsExtensions.Builder<_B> withAny(Object... any) {
      super.withAny(any);
      return this;
    }

    @Override
    public MediationDetailsExtensions build() {
      if (_storedValue == null) {
        return this.init(new MediationDetailsExtensions());
      } else {
        return ((MediationDetailsExtensions) _storedValue);
      }
    }

    public MediationDetailsExtensions.Builder<_B> copyOf(final MediationDetailsExtensions _other) {
      _other.copyTo(this);
      return this;
    }

    public MediationDetailsExtensions.Builder<_B> copyOf(final MediationDetailsExtensions.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends MediationDetailsExtensions.Selector<MediationDetailsExtensions.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static MediationDetailsExtensions.Select _root() {
      return new MediationDetailsExtensions.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
    extends Extension.Selector<TRoot, TParent> {

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<>();
      products.putAll(super.buildChildren());
      return products;
    }
  }
}
