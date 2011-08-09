package org.ooloo.twitter.client;

import junit.framework.Assert;

import org.junit.Test;

import twitter4j.ResponseList;
import twitter4j.Status;
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
	private final String token="53721250-ueUpQpirevHzsy4QuX9ngIWQ01ZMUjHt0JHPjP4Y";
	private final String tokenSecret = "5s5C8xR2pbDcji3uVxS6giv7OoNfRZIjkGsT8Mwaao";
	@Test
	public void testAuthenticatedClient(){
		log.info("In main test case");
		TwitterClientImpl client = new TwitterClientImpl(token,tokenSecret);
		Assert.assertTrue(client.isAuthenticated());
		
	}
	
	@Test
	public void testGetHometimeLine() throws TwitterException{
		TwitterClientImpl client = new TwitterClientImpl(token,tokenSecret);
		ResponseList<Status> stati = client.getHomeTimeline();
		Assert.assertNotNull(stati);
		
		log.info("# of statuses " + stati.size());
		for(int i=0;i<stati.size();i++){
			log.info(stati.get(i).getText());
		}
	}

}
