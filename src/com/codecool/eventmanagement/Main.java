package com.codecool.eventmanagement;

public class Main {

    public static void main(String[] args) {

    	int numberOfHelpers = 25;
    	int numberOfManagers = 10;
    	int eventCount = 3;

	    Company bestCompany = new Company(numberOfHelpers, numberOfManagers);

	    bestCompany.electNewCeo();
	    bestCompany.organizeRandomEvents(eventCount);
	    bestCompany.startEvents();

		for (int i = 0; i < 100; i++) {
			System.out.println(Event.getRandomEventType());
		}
    }
}
