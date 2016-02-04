/**
 * Created by pooh on 02.02.2016.
 *
 */
public class ConsoleEventLogger implements EventLogger{

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
