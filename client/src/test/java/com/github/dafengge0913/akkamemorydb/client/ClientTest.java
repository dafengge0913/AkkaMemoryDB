package com.github.dafengge0913.akkamemorydb.client;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class ClientTest {

    Client client = new Client("127.0.0.1:6666");

    @Test
    public void setGetTest() throws ExecutionException, InterruptedException {
        client.set("key123", 123);
        Integer result = (Integer) client.get("key123").get();
        assert (result == 123);
    }

}
