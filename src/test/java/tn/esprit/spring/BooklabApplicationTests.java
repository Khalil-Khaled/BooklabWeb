package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.services.IForumServices;

@RunWith (SpringRunner.class)
@SpringBootTest
class BooklabApplicationTests {

	@Autowired
	IForumServices iForumServices;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetValidatedForums () {
		iForumServices.getValidatedForums();
	}

}
