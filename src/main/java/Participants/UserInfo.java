package Participants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfo {
	
	// Log
	private static final Logger LOG = LoggerFactory.getLogger(UserInfo.class);

    private final String firstName;
    private final Integer age;

    protected UserInfo() {
        firstName = "";
        age = 0;
    }

    public UserInfo(String name, Integer age) {
    	LOG.info("Creating getParticipantInfo " + name + ". age: " + age);
        this.firstName = name;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }
}