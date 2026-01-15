/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.protocol.tlv;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;

public record DestinationIpv4TLV(Inet4Address ipAddress) implements TLV {

    @Override
    public int getType() {
        return 11;
    }

    @Override
    public void writeValueTo(final DataOutputStream outputStream) throws IOException {
        outputStream.write(ipAddress.getAddress());
    }
}
