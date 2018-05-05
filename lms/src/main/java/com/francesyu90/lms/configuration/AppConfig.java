package com.francesyu90.lms.configuration;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class AppConfig {
	
	private MutablePicoContainer  pico;
	
	public AppConfig() {
		this.initializePico();
	}
	
	public void addPicoComponent(Object obj) {
		this.pico.addComponent(obj);
	}
	
	public Object getPicoComponent(Object obj) {
		return this.pico.getComponent(obj);
	}
	
	public void initializePico() {
		this.pico = new DefaultPicoContainer(); 
	}
	
	public MutablePicoContainer getPico() {
		return this.pico;
	}

}
