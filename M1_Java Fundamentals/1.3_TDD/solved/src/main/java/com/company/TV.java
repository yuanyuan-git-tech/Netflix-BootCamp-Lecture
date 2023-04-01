package com.company;

public class TV {

    private int channel;
    private boolean on;

    public TV(int channel) {
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public int increaseChannel() {
        return channel++;
    }

}
