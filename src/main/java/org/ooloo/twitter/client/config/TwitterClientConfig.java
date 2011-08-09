package org.ooloo.twitter.client.config;

import com.sun.jersey.core.util.FeaturesAndProperties;

public interface TwitterClientConfig extends FeaturesAndProperties{
	
	public boolean getPropertyAsFeature(String featureName);
	public static final String CONSUMER_KEY = "consumer.key";
	public static final String CONSUMER_SECRET = "consumer.secret";

}
