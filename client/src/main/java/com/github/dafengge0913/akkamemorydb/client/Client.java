package com.github.dafengge0913.akkamemorydb.client;

import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.pattern.PatternsCS;
import com.github.dafengge0913.akkamemorydb.message.GetRequest;
import com.github.dafengge0913.akkamemorydb.message.SetRequest;
import com.typesafe.config.ConfigFactory;

import java.util.concurrent.CompletableFuture;

public class Client {
    private final ActorSystem actorSystem = ActorSystem.create("akkaMemoryDBClient", ConfigFactory.load("akka.conf"));
    private final ActorSelection remoteDB;

    public Client(String remoteAddress) {
        String path = "akka.tcp://akkaMemoryDB@" + remoteAddress + "/user/akkaMemoryDBActor";
        remoteDB = actorSystem.actorSelection(path);
    }

    public CompletableFuture<Object> set(String key, Object value) {
        return PatternsCS.ask(remoteDB, new SetRequest(key, value), 2000).toCompletableFuture();
    }

    public CompletableFuture<Object> get(String key) {
        return PatternsCS.ask(remoteDB, new GetRequest(key), 2000).toCompletableFuture();
    }

}
