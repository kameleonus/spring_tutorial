package com.clockworkjava.kursspring.controlers;


import com.clockworkjava.kursspring.Services.KnightService;
import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KnightControler {
    @Autowired
    KnightService knightService;
    @RequestMapping("/knights")
    public String getKnights(Model model){
      List<Knight> allKnights =  knightService.getAllKnights();
      model.addAttribute("knights",allKnights);
        return "knights";
    }
    @RequestMapping("/newknight")
    public String createKnight(Model model){
        model.addAttribute("knight",new Knight());
        return "knightform";
    }
    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id,Model model){
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight",knight);
        return "knight";
    }
    @RequestMapping(value = "/knights",method = RequestMethod.POST)
    public String saveKnights(Knight knight){
        knightService.saveKnight(knight);
        return "redirect:/knights";
    }
}
