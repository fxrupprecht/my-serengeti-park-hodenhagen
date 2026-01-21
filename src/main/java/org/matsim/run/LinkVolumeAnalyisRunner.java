package org.matsim.run;

import java.util.Map;

import org.matsim.core.events.EventsUtils;

public class LinkVolumeAnalyisRunner {
	
	public static void main (String[] args) {
		
	var handler = new LinkEventHandler();
	var manager = EventsUtils.createEventsManager();
	manager.addHandler(handler);

	EventsUtils.readEvents(manager, "C:\\Users\\frupprecht\\git\\my-serengeti-park-hodenhagen\\scenarios\\serengeti-park-v1.0\\"
			+ "output\\output-serengeti-park-v1.0-run1\\serengeti-park-v1.0-run1.output_events.xml.gz");
	
	
	Map<String, Integer> volumes = handler.getVolumes();
	System.out.println(volumes);
	
	
	}

}
