package com.sec.game.monitoring.service;

import java.util.ArrayList;
import java.util.List;

import com.sec.game.monitoring.model.User;

import org.springframework.stereotype.Service;

@Service
public interface SampleService {

	List<User> getSampleData() ;

}