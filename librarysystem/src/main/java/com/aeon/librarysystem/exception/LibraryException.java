package com.aeon.librarysystem.exception;

import lombok.Getter;

@Getter
public abstract class LibraryException extends RuntimeException {
  private final int errorCode;

  protected LibraryException(int errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

}
