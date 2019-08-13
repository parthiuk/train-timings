package com.tfl.gpss;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TrainTimingService {
	
	private static String URLPATH = "https://api.tfl.gov.uk/StopPoint/940GZZLUGPS/Arrivals?mode=tube";
	
	public TrainScheduleVO[] retrieveTrainSchedules() {
		RestTemplate restTemplate = new RestTemplate();
		TrainScheduleVO[] all_schedules = restTemplate.getForObject(URLPATH , TrainScheduleVO[].class);
		return all_schedules;
	}
}
