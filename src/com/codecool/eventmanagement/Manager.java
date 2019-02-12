package com.codecool.eventmanagement;

import java.util.ArrayList;

public class Manager extends Employee {

    private boolean isChief;

    public Manager() {
        super("ExampleManagerNumber " + ++counter);
        this.isChief = false;
    }

    public void promote() {
        isChief = true;
        System.out.println(name + ": I AM YOUR NEW CEO BOW TO ME:)");
    }

    public Event organizeEvent(Event.EventType eventType, ArrayList<Helper> helpers) {
        Event event = new Event(eventType);
        int counter = 0;
        while (event.getHelperCount() < 10 && counter < helpers.size()) {
            Helper helper = helpers.get(counter);
            if (!helper.isWorking()) {
                event.allocateHelper(helper);
                helper.setWorking(true);
            }
            counter++;
        }
        if (event.getHelperCount() < 10) System.out.println("HEY CEO HIRE MORE HELPERS PLEASE");
        else event.setReadyToStart(true);
        return event;
    }

    public void startEvent(Event event) {
        if (this.isChief) {
            event.simulateEvent();
        } else {
            System.out.println("ask the ceo plis!");
        }
    }

    public boolean isChief() {
        return isChief;
    }
}
