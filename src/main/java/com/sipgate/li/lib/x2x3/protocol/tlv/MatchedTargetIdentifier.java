/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.protocol.tlv;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public record MatchedTargetIdentifier(String encodedTargetIdentifier) implements TLV {

    @Override
    public int getType() {
        return 17;
    }

    @Override
    public void writeValueTo(final DataOutputStream outputStream) throws IOException {
        outputStream.write(encodedTargetIdentifier.getBytes(StandardCharsets.UTF_8));
    }

}
