package com.sipgate.util;

public record Either<LEFT, RIGHT>(LEFT left, RIGHT right) {
    public Either {
        if (left == null && right == null) {
            throw new IllegalArgumentException("Either.left or Either.right must be non-null");
        }

        if (left != null && right != null) {
            throw new IllegalArgumentException("Either.left and Either.right must not be non-null at the same time");
        }
    }
}
