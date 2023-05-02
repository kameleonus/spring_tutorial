package com.clockworkjava.kursspring.controlers;


import com.clockworkjava.kursspring.Services.KnightService;
import com.clockworkjava.kursspring.components.TimeComponent;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInfo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KnightControler {
    @Autowired
    TimeComponent timeComponent;
    @Autowired
    PlayerInfo playerInfo;
    @Autowired
    KnightService knightService;
    @RequestMapping("/knights")
    public String getKnights(Model model){
      List<Knight> allKnights =  knightService.getAllKnights();
      model.addAttribute("knights",allKnights);
      model.addAttribute("timeComponent",timeComponent);
      model.addAttribute("playerInfo",playerInfo);
        return "knights";
    }
    @RequestMapping("/newknight")
    public String createKnight(Model model){
        model.addAttribute("knight",new Knight());
        model.addAttribute("timeComponent",timeComponent);
        model.addAttribute("playerInfo",playerInfo);
        return "knightform";
    }
    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id,Model model){
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight",knight);
        model.addAttribute("timeComponent",timeComponent);
        model.addAttribute("playerInfo",playerInfo);
        return "knight";
    }
    @RequestMapping(value = "/knights",method = RequestMethod.POST)
    public String saveKnights(@Valid Knight knight, BindingResult bindResult){
        if(bindResult.hasErrors()){
            System.out.println("erors");
            bindResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getObjectName()));
            return "knightform";
        }else{
        knightService.saveKnight(knight);
        return "redirect:/knights";}
    }
    @RequestMapping(value = "/knight/delete/{id}",method = RequestMethod.GET)
    public String deleteKnight(@PathVariable("id") Integer id){
        knightService.deleteKnight(id);
        return "redirect:/knights";
    }
}
