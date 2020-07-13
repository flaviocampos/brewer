package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;

@Controller
public class CervejasController {
	
	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);

	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		
		logger.error("Nivel erro CervejaController: " + CervejasController.logger.getName());
		logger.info("Nivel info CervejaController");
		logger.debug("Nivel debug CervejaController");
		logger.trace("Nivel trace CervejaController");
		//model.addAttribute(new Cerveja());
		return "cerveja/CadastroCerveja";
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model , RedirectAttributes attributes) {
		System.out.println("Passou pelo cadastrar");
		
		if (result.hasErrors()) {
			
			//model.addAttribute(cerveja);
			
			//return "cerveja/CadastroCerveja";	
			return novo(cerveja);	
		}
		
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
	//	System.out.println("Cadastrar /Post: " + cerveja.getSku() + " - " + cerveja.getNome());			
		return "redirect:/cervejas/novo";
	}
	
}
