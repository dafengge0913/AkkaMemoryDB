package com.github.dafengge0913.akkamemorydb.server;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.github.dafengge0913.akkamemorydb.exception.KeyNotFoundException;
import com.github.dafengge0913.akkamemorydb.message.GetRequest;
import com.github.dafengge0913.akkamemorydb.message.SetRequest;

import java.util.HashMap;
import java.util.Map;

public class AkkaMemoryDB extends AbstractActor {

    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<>();

    @Override
    public Receive createReceive() {

        return receiveBuilder()
                .match(SetRequest.class, message -> {
                    log.info("Received Set request: {}", message);
                    map.put(message.getKey(), message.getValue());
                })
                .match(GetRequest.class, message -> {
                    log.info("Received Get request: {}", message);
                    Object value = map.get(message.getKey());
                    Object response = (value != null) ? value : new Status.Failure(new KeyNotFoundException(message.getKey()));
                    sender().tell(response, self());
                })
                .matchAny(o -> log.info("Received unknown message: {}", o))
                .build();
    }
}
