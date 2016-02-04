import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by pooh on 02.02.2016.
 *
 */
public class App {

    public Client client;
    public EventLogger eventLogger;
    private Event event;
    private Map<EventType, EventLogger> loggers;
    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    public App(Client client, ConsoleEventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event = (Event) ctx.getBean("event");
        event.setMsg(message);
        EventLogger logger = loggers.get(type);
        if (logger == null){
            logger = this.eventLogger;
        }
        logger.logEvent(event);
    }


    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        app.logEvent(EventType.ERROR, "Log item for user 1");
        app.logEvent(EventType.INFO, "Log item for user 1");
        app.logEvent(null, "Log item witout type for user 1");

        ctx.close();



    }
}
