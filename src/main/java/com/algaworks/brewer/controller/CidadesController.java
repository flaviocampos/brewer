package com.algaworks.brewer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CidadesController {
	
	private static final Logger logger = LoggerFactory.getLogger(CidadesController.class);
	
	@RequestMapping("/cidades/novo")
	public String novo() {
		
		logger.error("Nivel erro CidadesController: " + CidadesController.logger.getName());
		logger.info ("Nivel info CidadesController");
		logger.debug("Nivel debug CidadesController");
		logger.trace("Nivel debug CidadesController");
		
		return "cidade/CadastroCidade";
	}

}
