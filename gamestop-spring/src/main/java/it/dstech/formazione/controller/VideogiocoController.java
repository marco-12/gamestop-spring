package it.dstech.formazione.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.formazione.model.Videogioco;
import it.dstech.formazione.service.VideogiocoService;

@Controller
public class VideogiocoController {
	
	@Autowired
	private VideogiocoService videogiocoService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Videogioco> listaVideogiochi = videogiocoService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listaVideogiochi", listaVideogiochi);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		Videogioco videogioco = new Videogioco();
		model.put("videogioco", videogioco);
		return "new_videogioco";
	}
	
	@RequestMapping(value = "/saveVideogioco", method = RequestMethod.POST)
	public String saveAllenatore(@ModelAttribute("videogioco") Videogioco videogioco) {
		videogiocoService.save(videogioco);
		return "redirect:/";
	}
	
	@RequestMapping("/modificaVideogioco")
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_videogioco");
		Videogioco videogioco = videogiocoService.get(id);
		mav.addObject("videogioco", videogioco);
		return mav;
	}
	
	@RequestMapping("/cancellaVideogioco")
	public String deleteDigimonForm(@RequestParam long id) {
		videogiocoService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Videogioco> result = videogiocoService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		return mav;		
	}	
	
	
	@RequestMapping(value = "/ordina", method = RequestMethod.POST)
	public ModelAndView sort(@RequestParam("ordina") String command, Map<String, Object> model) {
		switch (Integer.parseInt(command)) {
		case 1: {
			ModelAndView view = new ModelAndView("visualizza_lista_ordinata");
			Videogioco videogioco = new Videogioco();
			model.put("videogioco", videogioco);
			view.addObject("listaVideogiochi", videogiocoService.orderByNome());
			return view;
		}
		case 2: {
			ModelAndView view = new ModelAndView("visualizza_lista_ordinata");
			Videogioco videogioco = new Videogioco();
			model.put("videogioco", videogioco);
			view.addObject("listaVideogiochi", videogiocoService.orderByPrezzo());
			return view;
		}
		case 3: {
			ModelAndView view = new ModelAndView("visualizza_lista_ordinata");
			Videogioco videogioco = new Videogioco();
			model.put("videogioco", videogioco);
			view.addObject("listaVideogiochi", videogiocoService.orderByCategoria());
			return view;
		}
		case 4: {
			ModelAndView view = new ModelAndView("visualizza_lista_ordinata");
			Videogioco videogioco = new Videogioco();
			model.put("videogioco", videogioco);
			view.addObject("listaVideogiochi", videogiocoService.orderByClassificazione());
			return view;
		}
		}
		return null;
	}

}
