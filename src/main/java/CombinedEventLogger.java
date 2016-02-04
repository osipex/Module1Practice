import java.util.Collection;

/**
 * Created by pooh on 04.02.2016.
 *
 */
public class CombinedEventLogger implements EventLogger {

    Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for (EventLogger logger : loggers){
            logger.logEvent(event);
        }
    }
}
