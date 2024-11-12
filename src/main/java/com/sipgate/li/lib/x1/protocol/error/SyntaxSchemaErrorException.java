package com.sipgate.li.lib.x1.protocol.error;

public class SyntaxSchemaErrorException extends X1ErrorException {

  public SyntaxSchemaErrorException(final String error) {
    super(SYNTAX_SCHEMA_ERROR, error);
  }
}
