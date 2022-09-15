package actors;
import org.junit.Test;
import static org.junit.Assert.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import org.junit.Test;
import org.mockito.Mockito;
import actors.SearchSupervisor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


public class SearchSupervisorTest {
	private final ActorRef ws = null;
	@Test
	public void supervisorTest()
	{
        final ActorSystem actorSystem = ActorSystem.create();
        try {
        	new TestKit(actorSystem) {{
        		 System.out.println(actorSystem);
                 final Props props = SearchSupervisor.props(ws);
                 final ActorRef searchRef = actorSystem.actorOf(props);
                 searchRef.tell(new SearchSupervisor.RegisterMsg(), getRef());
                 searchRef.tell("data",getRef());
        	}};
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            TestKit.shutdownActorSystem(actorSystem);
        }
	}
}