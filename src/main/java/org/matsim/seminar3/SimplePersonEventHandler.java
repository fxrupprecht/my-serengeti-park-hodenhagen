package org.matsim.seminar3;


import java.util.HashMap;
import java.util.Map;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.population.Person;


public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {

	private Map<Id<Person>, Double> persond2departureTime = new HashMap<>();
	
	@Override
	public void handleEvent(PersonDepartureEvent personDepartureEvent) {
		var departureTime = personDepartureEvent.getTime();
		var personID = personDepartureEvent.getPersonId();
		persond2departureTime.put(personID, departureTime);
		System.out.println("Departure: " + personDepartureEvent.getTime() + ": " + personDepartureEvent.getPersonId());
	}
	
	@Override
	public void handleEvent(PersonArrivalEvent personArrivalEvent) {
		var arriveTime = personArrivalEvent.getTime();
		var departureTime = persond2departureTime.get(personArrivalEvent.getPersonId());
		var travelTime = arriveTime - departureTime;
		System. out.println("Person: " + personArrivalEvent.getPersonId() + " travelled: " + travelTime + " sec");
	}
	
}