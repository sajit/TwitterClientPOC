package org.ooloo.twitter.client;

import junit.framework.Assert;

import org.junit.Test;

import twitter4j.TwitterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Test cases for twitter client
 * @author Sajit Mathew Kunnumkal
 *
 */
public class TwitterClientTests {
	private static final Log log = LogFactory.getLog(TwitterClientTests.class);
	
	@Test
	public void testAuthenticatedClient(){
		log.info("In main test case");
		TwitterClientImpl client = new TwitterClientImpl();
		Assert.assertTrue(client.isAuthenticated());
		
	}
	
	@Test
	public void testGetHometimeLine() throws TwitterException{
		TwitterClientImpl client = new TwitterClientImpl();
		Assert.assertNotNull(client.getHomeTimeline());
	}

}
