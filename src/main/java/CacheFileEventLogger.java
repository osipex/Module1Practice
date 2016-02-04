import java.util.ArrayList;
import java.util.List;

/**
 * Created by pooh on 03.02.2016.
 */
public class CacheFileEventLogger extends FileEventLogger {

    public int cacheSize;
    public List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }

    private void destroy(){
        if(!cache.isEmpty())
            writeEventsFromCache();
    }
}
