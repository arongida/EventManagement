package com.codecool.eventmanagement;

import java.util.ArrayList;
import java.util.Random;

public class Event {

    private int length;
    private EventType eventType;
    private int elapsedTime;
    private ArrayList<Helper> helpers;
    private boolean readyToStart;

    public boolean isReadyToStart() {
        return readyToStart;
    }

    public void setReadyToStart(boolean readyToStart) {
        this.readyToStart = readyToStart;
    }

    public Event(EventType eventType) {
        this.helpers = new ArrayList<>();
        this.elapsedTime = 0;
        this.eventType = eventType;
        this.readyToStart = false;
        switch (eventType) {
            case WEDDING:
                this.length = 8;
                break;
            case CONFERENCE:
                this.length = 10;
                break;
            case COCKTAILPARTY:
                this.length = 5;
                break;
            default:
                this.length = 0;
                break;
        }
    }

    public enum EventType {
        COCKTAILPARTY,
        WEDDING,
        CONFERENCE
    }

    public int getLengthInMinutes() {
        return length * 60;
    }

    public void simulateEvent() {
        while (elapsedTime <= getLengthInMinutes()) {
            System.out.println(elapsedTime + " minute(s) into this amazing event: ");
            for (Helper helper: helpers) {
                helper.work(elapsedTime, eventType);
            }
            elapsedTime++;
        }
    }

    public void allocateHelper(Helper helper) {
        helpers.add(helper);
    }

    public int getHelperCount() {
        return helpers.size();
    }

    public static EventType getRandomEventType() {
        Random random = new Random();
        EventType eventType;
        int randomInt = random.nextInt(3);
        switch (randomInt) {
            case 0: eventType = EventType.COCKTAILPARTY; break;
            case 1: eventType = EventType.WEDDING; break;
            case 2: eventType = EventType.CONFERENCE; break;
            default: eventType = EventType.WEDDING; break;
        } return eventType;
    }
}
