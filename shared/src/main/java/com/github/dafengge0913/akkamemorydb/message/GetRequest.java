package com.github.dafengge0913.akkamemorydb.message;

import java.io.Serializable;

public class GetRequest implements Serializable {

    private final String key;

    public GetRequest(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "GetRequest{" +
                "key='" + key + '\'' +
                '}';
    }
}
