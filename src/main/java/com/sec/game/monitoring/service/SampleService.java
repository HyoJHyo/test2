package com.sec.game.monitoring.service;

import java.util.ArrayList;
import java.util.List;

import com.sec.game.monitoring.model.User;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

	public List<User> getSampleData() {

        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setUserId("123");
        users.add(user);

		return users;
	}

}