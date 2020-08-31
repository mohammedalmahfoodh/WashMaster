package com.kockumation.backEnd.engine.model;

public class TimePeriod {

    private long milliseconds;
    private String timeName;
    private long seconds;
    private int minutes;
    private int hours;

    public TimePeriod(String timeName) {
        this.timeName = timeName;
    }

    public int getTimeInMinutes()
    {

        return (int) ((milliseconds / 1000) / 60);

    }


    public void convertMilliToSMH()
    {

        if (milliseconds >= 0)
        {
            seconds = milliseconds / 1000;
            //     Milliseconds = Milliseconds % 1000;
        }
        if (seconds >= 60)
        {
            minutes = (int) (seconds / 60);
            seconds = seconds % 60;
        }
        if (minutes >= 60)
        {
            hours = minutes / 60;
            minutes = minutes % 60;

        }

    }

    public String getTimePeriod()
    {
        String hourString = hours > 9 ? String.valueOf(hours) : "0" + hours;
        String minuteString = minutes > 9 ? String.valueOf(minutes) : "0" + minutes;
        String secondString = seconds > 9 ? String.valueOf(seconds) : "0" + seconds;

        return  hourString + ":" + minuteString + ":" + secondString;

    }


    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        if (milliseconds >= 0){
            this.milliseconds = milliseconds;
            convertMilliToSMH();
        }

    }

    public String getTimeName() {
        return timeName;
    }

    public void setTimeName(String timeName) {
        this.timeName = timeName;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return (int) ((double)(milliseconds / 1000) / (double)60);
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
