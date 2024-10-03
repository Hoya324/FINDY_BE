package org.findy.findy_be.user.controller;

import org.findy.findy_be.common.meta.LoginUser;
import org.findy.findy_be.user.entity.User;
import org.findy.findy_be.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public User getUser(@LoginUser User user) {
		return user;
	}
}

