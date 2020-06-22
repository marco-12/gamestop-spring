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
	
	@RequestMapping(value= {"/", "/home"})
	public ModelAndView home() {
		List<Videogioco> listaVideogiochi = videogiocoService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listaVideogiochi", listaVideogiochi);
		return mav;
	}
	
	@RequestMapping("/nuovoVideogioco")
	public String nuovoVideogioco(Map<String, Object> model) {
		Videogioco videogioco = new Videogioco();
		model.put("videogioco", videogioco);
		return "new_videogioco";
	}
	
	@RequestMapping(value = "/saveVideogioco", method = RequestMethod.POST)
	public String salvaVideogioco(@ModelAttribute("videogioco") Videogioco videogioco) {
		videogiocoService.save(videogioco);
		return "redirect:/home";
	}
	
	@RequestMapping("/modificaVideogioco")
	public ModelAndView modificaVideogioco(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_videogioco");
		Videogioco videogioco = videogiocoService.get(id);
		mav.addObject("videogioco", videogioco);
		return mav;
	}
	
	@RequestMapping("/cancellaVideogioco")
	public String cancellaVideogioco(@RequestParam long id) {
		videogiocoService.delete(id);
		return "redirect:/home";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Videogioco> result = videogiocoService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		return mav;		
	}	
	
	
	@RequestMapping(value = "/ordina", method = RequestMethod.POST)
	public ModelAndView ordina(@RequestParam("command") String command, Map<String, Object> model) {
		ModelAndView view = new ModelAndView("visualizza_lista_ordinata");
		Videogioco videogioco = new Videogioco();
		model.put("videogioco", videogioco);
		switch (Integer.parseInt(command)) {
		case 1: {
			view.addObject("listaVideogiochi", videogiocoService.orderByTitolo());
			view.addObject("messaggio", "Videogiochi ordinati per titolo");
			return view;
		}
		case 2: {
			model.put("videogioco", videogioco);
			view.addObject("listaVideogiochi", videogiocoService.orderByPrezzo());
			view.addObject("messaggio", "Videogiochi ordinati per prezzo");
			return view;
		}
		case 3: {
			model.put("videogioco", videogioco);
			view.addObject("listaVideogiochi", videogiocoService.orderByCategoria());
			view.addObject("messaggio", "Videogiochi ordinati per categoria");
			return view;
		}
		case 4: {
			model.put("videogioco", videogioco);
			view.addObject("listaVideogiochi", videogiocoService.orderByClassificazione());
			view.addObject("messaggio", "Videogiochi ordinati per Classificazione");
			return view;
		}
		}
		return null;
	}

}
