package com.algaworks.brewer.controller;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.service.CadastroEstiloService;
import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradoException;

@Controller
public class EstilosController {
	
	private static final Logger logger = LoggerFactory.getLogger(EstilosController.class);
	
	@Autowired
	private CadastroEstiloService cadastroEstiloService;

	@RequestMapping("/estilos/novo")
	public ModelAndView novo(Estilo estilo) {
		
		logger.info("Estilo novo...");
		ModelAndView mv = new ModelAndView("estilo/CadastroEstilo");
		return mv;
	}
	
	@RequestMapping(value = "/estilos/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, Model model, RedirectAttributes attributes) {
		logger.info("Estilo cadastrar...");
		
		if (result.hasErrors()){
			return novo(estilo);
		}
		
		try {
			cadastroEstiloService.salvar(estilo);			
		} catch (NomeEstiloJaCadastradoException e) {
			result.rejectValue("nome",e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		
		return new ModelAndView("redirect:/estilos/novo");
	}
}
