package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * class of transaction
 */
public class Transaction {
    // tutorial for how to use timestamp: https://mkyong.com/java/how-to-get-current-timestamps-in-java/
    private final long timestamp;    // timestamp that create this transaction
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String desc;    // description of this transaction

    public Transaction(String desc) {
        this.timestamp = System.currentTimeMillis();
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public long getTimestampLong() {
        return timestamp;
    }

    public String getTimestampFormat(SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(this.timestamp));
    }

    public String getTimestampFormat() {
        return getTimestampFormat(this.dateFormat);
    }
}
