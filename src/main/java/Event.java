import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by pooh on 02.02.2016.
 */
public class Event {
    public int id = new Random().nextInt(100)+1;;
    public String msg;
    public Date date;
    public DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg + id + date + df.format(date);
    }


}
