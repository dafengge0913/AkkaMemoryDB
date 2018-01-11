package com.github.dafengge0913.akkamemorydb.server;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.github.dafengge0913.akkamemorydb.message.SetRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AkkaMemoryDBTest {

    private ActorSystem system = ActorSystem.create();

    @Test
    public void setRequestTest() {
        TestActorRef<AkkaMemoryDB> actorRef = TestActorRef.create(system, Props.create(AkkaMemoryDB.class));
        actorRef.tell(new SetRequest("key", "value"), ActorRef.noSender());
        AkkaMemoryDB db = actorRef.underlyingActor();
        assertEquals(db.map.get("key"), "value");
    }

}
