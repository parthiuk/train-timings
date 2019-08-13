package com.tfl.gpss;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainTimingController {

	@Autowired
	TrainTimingService timingsService;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashBoard() {
		ModelAndView model = new ModelAndView();

		TrainScheduleVO schedules[] = timingsService.retrieveTrainSchedules();
    	Predicate<TrainScheduleVO> predicate = x-> x.getPlatformName().contains("Platform 1");
    	
    	model.addObject("p1schedules", getPlatformSchedules(schedules, predicate))
    	.addObject("p2schedules", getPlatformSchedules(schedules, predicate.negate()))
    	.setViewName("dashboard");

    	return model;
	}
	
	private List<TrainScheduleVO> getPlatformSchedules(TrainScheduleVO schedules[], Predicate<TrainScheduleVO> predicate) {
		Comparator<TrainScheduleVO> comparator = (o1, o2) -> o1.getExpectedArrivalTime().compareTo(o2.getExpectedArrivalTime());
		List<TrainScheduleVO> filteredSchedules = Stream.of(schedules).filter(predicate).collect(Collectors.toList());

		Collections.sort(filteredSchedules, comparator);
    	return filteredSchedules;
	}
	
}
