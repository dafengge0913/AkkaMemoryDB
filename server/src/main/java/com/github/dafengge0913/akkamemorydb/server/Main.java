package com.github.dafengge0913.akkamemorydb.server;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

public class Main {

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("akkaMemoryDB", ConfigFactory.load("akka.conf"));
        actorSystem.actorOf(Props.create(AkkaMemoryDB.class), "akkaMemoryDBActor");
    }
}
