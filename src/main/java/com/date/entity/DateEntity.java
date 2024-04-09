package com.date.entity;
import java.sql.Date;
public class DateEntity {
    private Date date;
    private Long d;
    public DateEntity() {
        d = System.currentTimeMillis();
        date = new Date(0);
        date.setTime(d);

    }
    public Date getDate() {
        return this.date;
    }

}
