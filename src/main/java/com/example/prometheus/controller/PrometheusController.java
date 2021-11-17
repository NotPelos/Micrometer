package com.example.prometheus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class PrometheusController {

	private Counter c;
	
	public PrometheusController (MeterRegistry registry) {
		this.c = Counter.builder("invocaciones.hello").description("Invocaciones totales").register(registry);
	}
	
	
	@GetMapping(path="/helloworld")
	public String helloworld() {
		c.increment();
		return "Hellow World";
	}
}
