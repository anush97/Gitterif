package actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Models.GithubResult;
import play.Logger;
import play.libs.Json;
import akka.japi.pf.DeciderBuilder;
import akka.actor.SupervisorStrategy;

import java.time.Duration;
import java.util.*;

public class SupervisorActor extends AbstractActor {

	public SupervisorActor() {
		System.out.println("*********Supervisor Actor STARTED *******************!");
		
	}

	static public Props getProps() {
		return Props.create(SupervisorActor.class);
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(Props.class,
			              props -> {
			                getSender().tell(getContext().actorOf(props, "searchActor"), getSelf());
			              }).build();
	}
	
	
    private static SupervisorStrategy strategy =
        new OneForOneStrategy(
            10,
            Duration.ofMinutes(1),
            DeciderBuilder.match(ArithmeticException.class, e -> SupervisorStrategy.resume())
                .match(NullPointerException.class, e -> SupervisorStrategy.restart())
                .match(IllegalArgumentException.class, e -> SupervisorStrategy.restart())
                .matchAny(o -> SupervisorStrategy.escalate())
                .build());

    @Override
    public SupervisorStrategy supervisorStrategy() {
      return strategy;
    }
    
    @Override
    public void preRestart(Throwable cause, Optional<Object> msg) {
      // do not kill all children, which is the default here
    }
  }
	
