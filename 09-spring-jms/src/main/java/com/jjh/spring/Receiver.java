package com.jjh.spring;

import org.springframework.jms.annotation.JmsListener;

public class Receiver {

	@JmsListener(destination = "BookQueue")
	public void receive(Book message) {
		System.out.println("received message: " + message);
	}

}
