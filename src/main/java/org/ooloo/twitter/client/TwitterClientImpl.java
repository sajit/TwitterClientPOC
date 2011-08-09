package org.ooloo.twitter.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ooloo.twitter.client.config.DefaultTwitterConfig;
import org.ooloo.twitter.client.config.TwitterClientConfig;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.Authorization;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterClientImpl implements TwitterClient {

	private static final Log log = LogFactory.getLog(TwitterClientImpl.class);
	private final String token;
	private final String tokenSecret;
	private boolean authenticated = false;
	private TwitterClientConfig clientConfig;
	private Twitter twitter;
	
	public ResponseList<Status> getHomeTimeline() throws TwitterException {
		if(!authenticated){
			throw new TwitterException("Hometime line can only be got for authenticated users");
			
		}
		
		return twitter.getHomeTimeline();
		
	}

	public boolean isAuthenticated() {
		
		return this.authenticated;
	}
	
	public TwitterClientImpl(final String token,final String tokenSecret){
		this.token = token;
		this.tokenSecret = tokenSecret;
		clientConfig = new DefaultTwitterConfig();
		init();
	}
	
	public TwitterClientImpl(final String token,final String tokenSecret,final TwitterClientConfig clientConfig){
		this.token = token;
		this.tokenSecret = tokenSecret;
		this.clientConfig = clientConfig;
		init();
	}
	
	private void init(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(clientConfig.getProperty(TwitterClientConfig.CONSUMER_KEY).toString())
		  .setOAuthConsumerSecret(clientConfig.getProperty(TwitterClientConfig.CONSUMER_SECRET).toString())
		  .setOAuthAccessToken(token)
		  .setOAuthAccessTokenSecret(tokenSecret);
		
		Authorization auth = new OAuthAuthorization(cb.build());
		twitter = new TwitterFactory().getInstance(auth);
		this.authenticated = true;
	}
	
}
