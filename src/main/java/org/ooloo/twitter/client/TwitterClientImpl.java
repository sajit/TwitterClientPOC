package org.ooloo.twitter.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;

public class TwitterClientImpl implements TwitterClient {

	private static final Log log = LogFactory.getLog(TwitterClientImpl.class);
	
	public ResponseList<Status> getHomeTimeline() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public TwitterClientImpl(){
		
	}
	
	public static TwitterClientImpl create(){
		TwitterClientImpl client = new TwitterClientImpl();
		return client;
	}

}
