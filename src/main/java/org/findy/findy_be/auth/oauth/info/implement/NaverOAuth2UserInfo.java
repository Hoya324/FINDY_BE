package org.findy.findy_be.auth.oauth.info.implement;

import java.util.Map;

import org.findy.findy_be.auth.oauth.info.OAuth2UserInfo;

public class NaverOAuth2UserInfo extends OAuth2UserInfo {

	public NaverOAuth2UserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		Map<String, Object> response = (Map<String, Object>)attributes.get("response");

		if (response == null) {
			return null;
		}

		return (String)response.get("id");
	}

	@Override
	public String getName() {
		Map<String, Object> response = (Map<String, Object>)attributes.get("response");

		if (response == null) {
			return null;
		}

		return (String)response.get("name");
	}

	@Override
	public String getEmail() {
		Map<String, Object> response = (Map<String, Object>)attributes.get("response");

		if (response == null) {
			return null;
		}

		return (String)response.get("email");
	}

	@Override
	public String getImageUrl() {
		Map<String, Object> response = (Map<String, Object>)attributes.get("response");

		if (response == null) {
			return null;
		}

		return (String)response.get("profile_image");
	}
}

