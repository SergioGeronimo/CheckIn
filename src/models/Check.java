package models;
//Check by Sergio Geronimo on 29/04/2019

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class Check {
    private int id;
    private Date date;
    private Time time;
    private String workerID;
    private boolean attendance;

    public Check(int id, Date date, Time time, String workerID, boolean attendance) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.workerID = workerID;
        this.attendance = attendance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public int isAttendanceSQL(){
        return (this.attendance? 1:0 );
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return  "Check ID:\t\t" + this.id + "\n" +
                "Date:\t\t" + this.date.toString() + "\n" +
                "Time:\t\t" + this.time.toString() + "\n" +
                "Worker ID:\t" + this.workerID + "\n" +
                "Status:\t\t" + (this.attendance? "punctual" : "retardment");
    }
}
