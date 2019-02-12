package com.codecool.eventmanagement;

import java.util.Random;

public class Helper extends Employee {

    private Preference preference;
    private boolean isWorking;

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public Helper() {
        super("ExampleHelperNumber " + ++counter);
        preference = getRandomPreference();
        isWorking = false;
    }

    public void work(int elapsedTime, Event.EventType eventType) {
        if ((elapsedTime % 120) == 0 && elapsedTime != 0)  {
            goOnBreak();
        } else {
            switch (eventType) {
                case COCKTAILPARTY:
                    if ((elapsedTime % 5) == 0) {
                        System.out.println(name + ": MORE COCKTAILSS HERE!!<3");
                    } else {
                      //  System.out.println("refilling cocktails...");
                    } break;
                case CONFERENCE:
                    if ((elapsedTime == 0)) {
                        System.out.println(name + ": THE SNACKS ARE HERE BYENOW:)");
                    } else {
                        //System.out.println("no more snackies hihi timetogethigh...");
                    } break;
                case WEDDING:
                    if ((elapsedTime % 10) == 0) {
                        System.out.println(name + ": PLEASE ACCEPT THIS CAKE, ITS GOOOOOOD!");
                    } else {
                       // System.out.println("the cake is a lieee");
                    } break;
                default:
                    System.out.println("im just chillin");
                    break;
            }
        }
    }

    private void goOnBreak() {
        switch (preference) {
            case COFFEE:
                System.out.println(name + ": IM JUST SIPPING MY COFFEE!!");
                break;
            case SMOKING:
                System.out.println(name + ": inhale.. NEEDED THIS SOMKE MANNN!! exhale..");
                break;
            default: break;
        }
    }

    public enum Preference {
        COFFEE,
        SMOKING
    }

    private static Preference getRandomPreference() {
        Random random = new Random();
        Preference preference;
        if (random.nextDouble() <= 0.5) {
            preference = Preference.COFFEE;
        } else {
            preference = Preference.SMOKING;
        } return preference;
    }
}
