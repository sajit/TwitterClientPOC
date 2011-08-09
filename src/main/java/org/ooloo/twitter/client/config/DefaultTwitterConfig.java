package org.ooloo.twitter.client.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class DefaultTwitterConfig implements TwitterClientConfig {
	
	private final Map<String, Boolean> features = new HashMap<String, Boolean>();

	private final Map<String, Object> properties = new HashMap<String, Object>();
	
	public DefaultTwitterConfig(){
		init();
	}

	private void init() {
		final Properties PROPERTIES = new Properties();
		FileInputStream st = null;
		try {
			
			st = new FileInputStream(this.getClass().getResource("/twitter.properties").getFile());
			PROPERTIES.load(st);
		} catch (IOException e) {
			// ignore
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (IOException ex) {
					// ignore
				}
			}
		}

		for (final String name : new String[]{CONSUMER_KEY, CONSUMER_SECRET}) {
			final String value = System.getProperty(name);
			if (value != null) {
				PROPERTIES.setProperty(name, value);
			}
		}

		if (PROPERTIES.getProperty(CONSUMER_KEY) == null ||
				PROPERTIES.getProperty(CONSUMER_SECRET) == null) {
			throw new IllegalArgumentException(String.format("No consumerKey and/or consumerSecret found in twitter.properties file. " +
					"You have to provide these as system properties."));
		}

		for (final Map.Entry<Object, Object> entry : PROPERTIES.entrySet()) {
			properties.put((String) entry.getKey(), entry.getValue());

		}
		
	}

	public boolean getFeature(String featureName) {
		return features.get(featureName);
	}

	public Map<String, Boolean> getFeatures() {
		return features;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}

	public boolean getPropertyAsFeature(String propertyName) {
		final Boolean v = (Boolean) getProperties().get(propertyName);
		return (v != null) ? v : false;
	}

}
