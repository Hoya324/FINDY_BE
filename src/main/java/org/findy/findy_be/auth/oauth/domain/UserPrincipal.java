package org.findy.findy_be.auth.oauth.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.findy.findy_be.user.domain.RoleType;
import org.findy.findy_be.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserPrincipal implements OAuth2User, UserDetails, OidcUser {
	private final String userId;
	private final String password;
	private final SocialProviderType socialProviderType;
	private final RoleType roleType;
	private final Collection<GrantedAuthority> authorities;
	private Map<String, Object> attributes;

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getName() {
		return userId;
	}

	@Override
	public String getUsername() {
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Map<String, Object> getClaims() {
		return null;
	}

	@Override
	public OidcUserInfo getUserInfo() {
		return null;
	}

	@Override
	public OidcIdToken getIdToken() {
		return null;
	}

	public static UserPrincipal create(User user) {
		return new UserPrincipal(
			user.getUserId(),
			user.getPassword(),
			user.getSocialProviderType(),
			RoleType.USER,
			Collections.singletonList(new SimpleGrantedAuthority(RoleType.USER.getCode()))
		);
	}

	public static UserPrincipal create(User user, Map<String, Object> attributes) {
		UserPrincipal userPrincipal = create(user);
		userPrincipal.setAttributes(attributes);

		return userPrincipal;
	}
}

