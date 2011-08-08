package org.ooloo.twitter.client;


import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;


public interface TwitterClient {
	
	/**
	 * Get user's timeline
	 */
	public ResponseList<Status> getHomeTimeline() throws TwitterException;
	
	public boolean isAuthenticated();

}
