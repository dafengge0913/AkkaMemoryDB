package com.github.dafengge0913.akkamemorydb.exception;

import java.io.Serializable;

public class KeyNotFoundException extends Exception implements Serializable {

    private final String key;

    public KeyNotFoundException(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "KeyNotFoundException{" +
                "key='" + key + '\'' +
                '}';
    }
}
