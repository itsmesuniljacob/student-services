package com.devops.sample.studentservices.studenttests;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.devops.sample.studentservices.hello.TopicController;
import com.devops.sample.studentservices.topic.Topic;
import com.devops.sample.studentservices.topic.TopicService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServicesTests {
	
	
	private List<Topic> topics = Arrays.asList(
			new Topic("spring","spring framework","Spring framework Description"),
			new Topic("Go","Go Lang","Google language"),
			new Topic("Kotlin","Kotlin framework","Kotlin framework description"));
	
	@Mock
	TopicService topicService;

	private MockMvc mockMvc;
	
	@InjectMocks
	private TopicController topicController;
	
	@InjectMocks
	private Topic topic;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(topicController).build();
	}
	
//	@Test
//	public void testGetAllTopicsUsingMockito() {
//		when(topicService.getAllTopics()).thenReturn(topics);
//	}
	
	@Test
	public void testGetAllTopics() throws Exception {
		when(topicController.getAllTopics()).thenReturn(topics);
		mockMvc.perform(get("/topics"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$[0].id",Matchers.is("spring")));
	}

	@Test
	public void getTopicByIdTest()  {

		Topic topic = new Topic("Go","Go lang","Go hand book");
		when(topicService.getTopic("Go")).thenReturn(topic);
		try {
			mockMvc.perform(get("/topics/{id}","Go"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.id").exists())
					.andExpect(jsonPath("$.id", Matchers.is("Go")));
			verify(topicService,times(1)).getTopic("Go");
			verifyNoMoreInteractions(topicService);
		}

		catch (Exception e) {
			fail("Failure in test" + e.getMessage());
		}
	}

	@Test
	public void getTopicMethodTest() {
		when(topicService.getAllTopics()).thenReturn(topics);
	}
 
}
