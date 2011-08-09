package org.ooloo.twitter.client.config;

import junit.framework.Assert;

import org.junit.Test;

public class ClientConfigTests {
	
	@Test
	public void testLoadProperties(){
		DefaultTwitterConfig config = new DefaultTwitterConfig();
		String consumerkey = config.getProperty(TwitterClientConfig.CONSUMER_KEY).toString();
		Assert.assertNotNull(consumerkey);
		Assert.assertEquals("9W0QG3wGMQpEW52NVXNlw", consumerkey);
		String consumerSecret = config.getProperty(TwitterClientConfig.CONSUMER_SECRET).toString();
		Assert.assertEquals("t40PapBOqeQjW3VhqNc0Sziua71vRo2lYxox0MGo8", consumerSecret);
	}
	

}
