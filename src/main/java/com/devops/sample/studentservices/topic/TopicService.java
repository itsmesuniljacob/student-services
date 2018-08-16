package com.devops.sample.studentservices.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = Arrays.asList(
			new Topic("spring","spring framework","Spring framework Description"),
			new Topic("Go","Go Lang","Google language"),
			new Topic("Kotlin","Kotlin framework","Kotlin framework description"));
	
	public List<Topic> getAllTopics() {
		return topics;
		
	}
}
