package Participants;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.net.URL;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class APIControllerTest {

	private static final Logger LOG = LoggerFactory.getLogger(APIController.class);

    @Value("${local.server.port}")
    private int port;

    private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();
	}
	
	@Test
	public void getParticipant() throws Exception {
		String userURI = base.toString() + "/user";
		Credentials credentials=new Credentials("pepe@pepe.com","pepe");
		Participant expected = new Participant("pepe", "pepe", "pepe@pepe.com", new Date(123),
				"pepe", "pepe", "pepe", "pepe");
		Participant actual=template.postForObject(userURI,credentials,Participant.class,"");
		assertEquals(expected,actual);
	}

	@Test
	public void getNonexistantParticipant() throws Exception {
		String userURI = base.toString() + "/user";
		Credentials credentials=new Credentials("kek@kek.com","kek");
		Participant actual=template.postForObject(userURI,credentials,Participant.class,"");
		assertNull(actual);
	}

}