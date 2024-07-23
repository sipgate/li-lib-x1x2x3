package com.sipgate.util;

import java.util.Objects;

public class Either<LEFT, RIGHT> {

  private final LEFT left;
  private final RIGHT right;

  public static <LEFT, RIGHT> Either<LEFT, RIGHT> left(final LEFT left) {
    return new Either<>(left, null);
  }

  public static <LEFT, RIGHT> Either<LEFT, RIGHT> right(final RIGHT right) {
    return new Either<>(null, right);
  }

  private Either(final LEFT left, final RIGHT right) {
    this.left = left;
    this.right = right;
  }

  public LEFT left() {
    return Objects.requireNonNull(left, "Either is not Left");
  }

  public RIGHT right() {
    return Objects.requireNonNull(right, "Either is not Right");
  }

  public boolean isLeft() {
    return left != null;
  }

  public boolean isRight() {
    return right != null;
  }
}
