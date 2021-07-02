package be.vdab.frida.controllers;

import be.vdab.frida.forms.SausRadenForm;
import be.vdab.frida.services.SausService;
import be.vdab.frida.sessions.SausRaden;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("sauzen")
class SausController {
    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final SausService sausService; // constructor met parameter
    private final SausRaden sausRaden;

    private String randomSaus() {
        var sauzen = sausService.findAll();
        return sauzen.get(ThreadLocalRandom.current().nextInt(sauzen.size())).getNaam();
    }

    SausController(SausService sausService, SausRaden sausRaden) {
        this.sausService = sausService;
        this.sausRaden = sausRaden;
    }

    @GetMapping
    public ModelAndView sauzen() {
        return new ModelAndView("sauzen", "sauzen", sausService.findAll());
    }

    @GetMapping("{id}")
    public ModelAndView saus(@PathVariable long id) {
        var modelAndView = new ModelAndView("saus");
        sausService.findById(id).ifPresent(saus -> modelAndView.addObject(saus));
        return modelAndView;
    }

    @GetMapping("alfabet")
    public ModelAndView alfabet() {
        return new ModelAndView("sausAlfabet", "alfabet", alfabet);
    }

    @GetMapping("alfabet/{letter}")
    public ModelAndView sauzenBeginnendMet(@PathVariable char letter) {
        return new ModelAndView("sausAlfabet", "alfabet", alfabet).addObject("sauzen", sausService.findByNaamBegintMet(letter));
    }

    @GetMapping("raden")
    public ModelAndView radenForm() {
        sausRaden.reset(randomSaus());
        return new ModelAndView("sausRaden").addObject(sausRaden).addObject(new SausRadenForm(null));
    }

    @PostMapping("raden/nieuwspel")
    public String radenNieuwSpel() {
        return "redirect:/sauzen/raden";
    }

    @PostMapping("raden")
    public ModelAndView raden(@Valid SausRadenForm form, Errors errors) {
        if (errors.hasErrors()) {
            return new ModelAndView("sausRaden").addObject(sausRaden);
        }
        sausRaden.gok(form.getLetter());
        return new ModelAndView("redirect:/sauzen/raden/volgendegok");
    }

    @GetMapping("raden/volgendegok")
    public ModelAndView volgendeGok() {
        return new ModelAndView("sausRaden").addObject(sausRaden).addObject(new SausRadenForm(null));
    }

}

