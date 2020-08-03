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

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.Origem;
import com.algaworks.brewer.model.Sabor;
import com.algaworks.brewer.repository.Estilos;

@Controller
public class CervejasController {

	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);
	
	@Autowired
	private Estilos estilos;

	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
	   logger.trace("Cerveja - novo - Aprender usar o log.");

		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		
		return mv;
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model,
			RedirectAttributes attributes) {
		System.out.println("Passou pelo cadastrar");

		if (result.hasErrors()) {

			// model.addAttribute(cerveja);

			// return "cerveja/CadastroCerveja";
			return novo(cerveja);
		}

		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
         System.out.println("Cadastrar->Post-> SKU: " + cerveja.getSku() );
		 System.out.println("Cadastrar->Post-> Estilo: " + cerveja.getEstilo());
		 System.out.println("Cadastrar->Post-> Sabor: " + cerveja.getSabor() );
		 System.out.println("Cadastrar->Post-> Origem: " + cerveja.getOrigem() );
		
		return new ModelAndView("redirect:/cervejas/novo");
	}

}
