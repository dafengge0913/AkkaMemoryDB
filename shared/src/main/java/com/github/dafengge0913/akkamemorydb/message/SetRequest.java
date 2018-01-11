package com.github.dafengge0913.akkamemorydb.message;

public class SetRequest {

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
