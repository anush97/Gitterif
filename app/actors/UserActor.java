package actors;
import com.fasterxml.jackson.databind.node.ObjectNode;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import play.Logger;	
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
	*User Actor to fetch the user details
	* @author Ujjawal Aggarwal
	*/
public final class UserActor extends AbstractActor {
    private final ActorRef ws;

    static public class TimeMessage {
        public final JsonNode obj;
        public TimeMessage(JsonNode obj) {
            this.obj = obj;
        }
    }
    /**
* get the user details creating instance of Service class
*
*/
    public UserActor(final ActorRef wsOut) {
    	ws =  wsOut;
       Logger.debug("New UserActor {} forWebSocket {} ; timeActor : {}",self(),wsOut);
    }

    public static Props props(final ActorRef wsout) {
        return Props.create(UserActor.class, wsout);
    }

    @Override
    public Receive createReceive(){
        return receiveBuilder()
                .match(TimeMessage.class, this::sendTime)
                .build();
    }

    @Override
    public void preStart() {
        context().actorSelection("/user/topicActor/")
        .tell(new TopicActor.RegisterMsg(),self());
        
    }
    private void sendTime(TimeMessage msg){
        //final ObjectNode response =Json.newObject();
    	//final ObjectNode response =msg.obj;
        //response.put("time",msg.obj);
        ws.tell(msg.obj,self());
    }

}