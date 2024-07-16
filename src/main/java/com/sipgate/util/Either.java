package com.sipgate.util;

import java.util.Objects;

public record Either<LEFT, RIGHT>(LEFT left, RIGHT right) {
    public Either {
        if (left == null && right == null) {
            throw new IllegalArgumentException("Either.left or Either.right must be non-null");
        }

        if (left != null && right != null) {
            throw new IllegalArgumentException("Either.left and Either.right must not be non-null at the same time");
        }
    }

    @Override
    public LEFT left() {
        return Objects.requireNonNull(left, "Either is not Left");
    }

    @Override
    public RIGHT right() {
        return Objects.requireNonNull(right, "Either is not Right");
    }
}
