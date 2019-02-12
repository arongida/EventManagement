package com.codecool.eventmanagement;

import java.util.ArrayList;
import java.util.Random;

public class Company {

    private ArrayList<Manager> managers;
    private ArrayList<Helper> helpers;
    private ArrayList<Event> events;
    private boolean isThereALeader;

    public Company (int numberOfHelpersHired, int numberOfManagersHired) {
        helpers = new ArrayList<>();
        managers = new ArrayList<>();
        events = new ArrayList<>();
        isThereALeader = false;

        for (int i = 0; i < numberOfHelpersHired; i++) {
            helpers.add(new Helper());
        }

        for (int i = 0; i < numberOfManagersHired; i++) {
            managers.add(new Manager());
        }

    }

    public void electNewCeo() {
        Random random = new Random();
        if (isThereALeader) System.out.println("only one ceo is allowed as per written in the company policy wink wink");
        else {
            managers.get(random.nextInt(managers.size())).promote();
            isThereALeader = true;
        }
    }

    public void organizeRandomEvents(int eventCount) {
        Random random = new Random();
        for (int i = 0; i < eventCount; i++) {
            events.add(managers.get(random.nextInt(managers.size())).organizeEvent(Event.getRandomEventType(), helpers));
        }
    }

    public void startEvents() {
        Manager ceo = getCeo();
        for (Event event: events) {
            if (event.isReadyToStart()) ceo.startEvent(event);
        }
    }

    private Manager getCeo() {
        Manager ceo = null;
        for (Manager manager: managers) {
            if (manager.isChief()) ceo = manager;
        } return ceo;
    }

}
