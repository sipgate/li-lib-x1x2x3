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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Java class for ResponseContainer complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="ResponseContainer">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="x1ResponseMessage" type="{http://uri.etsi.org/03221/X1/2017/10}X1ResponseMessage" maxOccurs="unbounded"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseContainer", propOrder = { "x1ResponseMessage" })
public class ResponseContainer implements Copyable {

  @XmlElement(required = true)
  protected List<X1ResponseMessage> x1ResponseMessage;

  /**
   * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
   *
   */
  public ResponseContainer() {
    // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
  }

  /**
   * Instantiates a ResponseContainer copying the state of another ResponseContainer
   *
   * @param _other
   *     The original ResponseContainer from which to copy state.
   */
  public ResponseContainer(final ResponseContainer _other) {
    if (_other.x1ResponseMessage == null) {
      this.x1ResponseMessage = null;
    } else {
      this.x1ResponseMessage = new ArrayList<>();
      for (X1ResponseMessage _item : _other.x1ResponseMessage) {
        this.x1ResponseMessage.add(((_item == null) ? null : _item.createCopy()));
      }
    }
  }

  /**
   * Gets the value of the x1ResponseMessage property.
   *
   * <p>This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the x1ResponseMessage property.</p>
   *
   * <p>
   * For example, to add a new item, do as follows:
   * </p>
   * <pre>
   * getX1ResponseMessage().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link X1ResponseMessage }
   * </p>
   *
   *
   * @return
   *     The value of the x1ResponseMessage property.
   */
  public List<X1ResponseMessage> getX1ResponseMessage() {
    if (x1ResponseMessage == null) {
      x1ResponseMessage = new ArrayList<>();
    }
    return this.x1ResponseMessage;
  }

  @Override
  public ResponseContainer createCopy() {
    final ResponseContainer _newObject;
    try {
      _newObject = ((ResponseContainer) super.clone());
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    if (this.x1ResponseMessage == null) {
      _newObject.x1ResponseMessage = null;
    } else {
      _newObject.x1ResponseMessage = new ArrayList<>();
      for (X1ResponseMessage _item : this.x1ResponseMessage) {
        _newObject.x1ResponseMessage.add(((_item == null) ? null : _item.createCopy()));
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
  public <_B> void copyTo(final ResponseContainer.Builder<_B> _other) {
    if (this.x1ResponseMessage == null) {
      _other.x1ResponseMessage = null;
    } else {
      _other.x1ResponseMessage = new ArrayList<>();
      for (X1ResponseMessage _item : this.x1ResponseMessage) {
        _other.x1ResponseMessage.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
      }
    }
  }

  public <_B> ResponseContainer.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new ResponseContainer.Builder<_B>(_parentBuilder, this, true);
  }

  public ResponseContainer.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static ResponseContainer.Builder<Void> builder() {
    return new ResponseContainer.Builder<>(null, null, false);
  }

  public static <_B> ResponseContainer.Builder<_B> copyOf(final ResponseContainer _other) {
    final ResponseContainer.Builder<_B> _newBuilder = new ResponseContainer.Builder<>(null, null, false);
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
    final ResponseContainer.Builder<_B> _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final PropertyTree x1ResponseMessagePropertyTree =
      ((_propertyTree == null) ? null : _propertyTree.get("x1ResponseMessage"));
    if (
      ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (x1ResponseMessagePropertyTree != null)
          : ((x1ResponseMessagePropertyTree == null) || (!x1ResponseMessagePropertyTree.isLeaf())))
    ) {
      if (this.x1ResponseMessage == null) {
        _other.x1ResponseMessage = null;
      } else {
        _other.x1ResponseMessage = new ArrayList<>();
        for (X1ResponseMessage _item : this.x1ResponseMessage) {
          _other.x1ResponseMessage.add(
            ((_item == null) ? null : _item.newCopyBuilder(_other, x1ResponseMessagePropertyTree, _propertyTreeUse))
          );
        }
      }
    }
  }

  public <_B> ResponseContainer.Builder<_B> newCopyBuilder(
    final _B _parentBuilder,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return new ResponseContainer.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public ResponseContainer.Builder<Void> newCopyBuilder(
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> ResponseContainer.Builder<_B> copyOf(
    final ResponseContainer _other,
    final PropertyTree _propertyTree,
    final PropertyTreeUse _propertyTreeUse
  ) {
    final ResponseContainer.Builder<_B> _newBuilder = new ResponseContainer.Builder<>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static ResponseContainer.Builder<Void> copyExcept(
    final ResponseContainer _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static ResponseContainer.Builder<Void> copyOnly(
    final ResponseContainer _other,
    final PropertyTree _propertyTree
  ) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final ResponseContainer _storedValue;
    private List<X1ResponseMessage.Builder<ResponseContainer.Builder<_B>>> x1ResponseMessage;

    public Builder(final _B _parentBuilder, final ResponseContainer _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          if (_other.x1ResponseMessage == null) {
            this.x1ResponseMessage = null;
          } else {
            this.x1ResponseMessage = new ArrayList<>();
            for (X1ResponseMessage _item : _other.x1ResponseMessage) {
              this.x1ResponseMessage.add(((_item == null) ? null : _item.newCopyBuilder(this)));
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
      final ResponseContainer _other,
      final boolean _copy,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse
    ) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree x1ResponseMessagePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("x1ResponseMessage"));
          if (
            ((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (x1ResponseMessagePropertyTree != null)
                : ((x1ResponseMessagePropertyTree == null) || (!x1ResponseMessagePropertyTree.isLeaf())))
          ) {
            if (_other.x1ResponseMessage == null) {
              this.x1ResponseMessage = null;
            } else {
              this.x1ResponseMessage = new ArrayList<>();
              for (X1ResponseMessage _item : _other.x1ResponseMessage) {
                this.x1ResponseMessage.add(
                    ((_item == null)
                        ? null
                        : _item.newCopyBuilder(this, x1ResponseMessagePropertyTree, _propertyTreeUse))
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

    protected <_P extends ResponseContainer> _P init(final _P _product) {
      if (this.x1ResponseMessage != null) {
        final List<X1ResponseMessage> x1ResponseMessage = new ArrayList<>(this.x1ResponseMessage.size());
        for (X1ResponseMessage.Builder<ResponseContainer.Builder<_B>> _item : this.x1ResponseMessage) {
          x1ResponseMessage.add(_item.build());
        }
        _product.x1ResponseMessage = x1ResponseMessage;
      }
      return _product;
    }

    /**
     * Adds the given items to the value of "x1ResponseMessage"
     *
     * @param x1ResponseMessage
     *     Items to add to the value of the "x1ResponseMessage" property
     */
    public ResponseContainer.Builder<_B> addX1ResponseMessage(
      final Iterable<? extends X1ResponseMessage> x1ResponseMessage
    ) {
      if (x1ResponseMessage != null) {
        if (this.x1ResponseMessage == null) {
          this.x1ResponseMessage = new ArrayList<>();
        }
        for (X1ResponseMessage _item : x1ResponseMessage) {
          this.x1ResponseMessage.add(new X1ResponseMessage.Builder<>(this, _item, false));
        }
      }
      return this;
    }

    /**
     * Sets the new value of "x1ResponseMessage" (any previous value will be replaced)
     *
     * @param x1ResponseMessage
     *     New value of the "x1ResponseMessage" property.
     */
    public ResponseContainer.Builder<_B> withX1ResponseMessage(
      final Iterable<? extends X1ResponseMessage> x1ResponseMessage
    ) {
      if (this.x1ResponseMessage != null) {
        this.x1ResponseMessage.clear();
      }
      return addX1ResponseMessage(x1ResponseMessage);
    }

    /**
     * Adds the given items to the value of "x1ResponseMessage"
     *
     * @param x1ResponseMessage
     *     Items to add to the value of the "x1ResponseMessage" property
     */
    public ResponseContainer.Builder<_B> addX1ResponseMessage(X1ResponseMessage... x1ResponseMessage) {
      addX1ResponseMessage(Arrays.asList(x1ResponseMessage));
      return this;
    }

    /**
     * Sets the new value of "x1ResponseMessage" (any previous value will be replaced)
     *
     * @param x1ResponseMessage
     *     New value of the "x1ResponseMessage" property.
     */
    public ResponseContainer.Builder<_B> withX1ResponseMessage(X1ResponseMessage... x1ResponseMessage) {
      withX1ResponseMessage(Arrays.asList(x1ResponseMessage));
      return this;
    }

    /**
     * Returns a new builder to build an additional value of the "X1ResponseMessage"
     * property.
     * Use {@link org.etsi.uri._03221.x1._2017._10.X1ResponseMessage.Builder#end()} to
     * return to the current builder.
     *
     * @return
     *     a new builder to build an additional value of the "X1ResponseMessage" property.
     *     Use {@link org.etsi.uri._03221.x1._2017._10.X1ResponseMessage.Builder#end()} to
     *     return to the current builder.
     */
    public X1ResponseMessage.Builder<? extends ResponseContainer.Builder<_B>> addX1ResponseMessage() {
      if (this.x1ResponseMessage == null) {
        this.x1ResponseMessage = new ArrayList<>();
      }
      final X1ResponseMessage.Builder<ResponseContainer.Builder<_B>> x1ResponseMessage_Builder =
        new X1ResponseMessage.Builder<>(this, null, false);
      this.x1ResponseMessage.add(x1ResponseMessage_Builder);
      return x1ResponseMessage_Builder;
    }

    @Override
    public ResponseContainer build() {
      if (_storedValue == null) {
        return this.init(new ResponseContainer());
      } else {
        return ((ResponseContainer) _storedValue);
      }
    }

    public ResponseContainer.Builder<_B> copyOf(final ResponseContainer _other) {
      _other.copyTo(this);
      return this;
    }

    public ResponseContainer.Builder<_B> copyOf(final ResponseContainer.Builder _other) {
      return copyOf(_other.build());
    }
  }
}
