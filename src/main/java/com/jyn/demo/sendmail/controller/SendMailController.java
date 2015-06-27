package com.jyn.demo.sendmail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value="prototype")
@RequestMapping("/sendmail")
public class SendMailController {
	@Value("fromAddr")
	private String fromAddr;
	
	@Value("server")
	private String server;
	
	@Value("port")
	private String port;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage simpleMailMessage;
	
	@RequestMapping(value="", method={RequestMethod.GET})
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("sendmail/index");
		return mav;
	}
	
	@RequestMapping(value="send", method={RequestMethod.POST})
	public ModelAndView sendMail(HttpServletRequest request, HttpServletResponse response){
		simpleMailMessage.setSubject(request.getParameter("mailSubject"));
		simpleMailMessage.setTo(request.getParameter("mailTo"));
		simpleMailMessage.setText(request.getParameter("content"));
		ModelAndView mav = new ModelAndView("common/result");
		try{
			mailSender.send(simpleMailMessage);
			mav.addObject("result", "SUCCESS!");
			return mav;
		}catch(MailException e){
			mav.addObject("result", "FAILED:" + e.getMessage());
			return mav;
		}
	}
	
}
