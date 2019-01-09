package com.sec.game.monitoring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sec.game.monitoring.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

    @RequestMapping(value="/sample")
    public ModelAndView sampleView ( HttpSession session, HttpServletRequest request)  {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sample");
        return mv;
    }

    @RequestMapping(value="/sample/user/get", produces="application/json; charset=UTF-8")
	@ResponseBody
	public User addProc (HttpSession session) throws JsonProcessingException  {
        User user = new User();
        user.setUserId("abc");
        user.setUserAddr("경기도 용인시 기흥구 언남동");
        user.setUserAge("45");
        user.setUserName("홍길동");

        return user;
    }
}