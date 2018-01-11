package com.github.dafengge0913.akkamemorydb.message;

import java.io.Serializable;

public class SetRequest implements Serializable {

    private final String key;
    private final Object value;

    public SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SetRequest{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
