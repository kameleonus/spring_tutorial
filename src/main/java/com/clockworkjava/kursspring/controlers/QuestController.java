package com.clockworkjava.kursspring.controlers;

import com.clockworkjava.kursspring.Services.KnightService;
import com.clockworkjava.kursspring.Services.QuestService;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInfo;
import com.clockworkjava.kursspring.domain.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    QuestService questService;
    @Autowired
    KnightService knightService;
    @Autowired
    PlayerInfo playerInfo;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model){
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight",knight);
        model.addAttribute("notStartedQuests",notStartedQuests);
        return "assignQuest";
    }
    @RequestMapping(value = "/assignQuest",method = RequestMethod.POST)
    public String assignQuest(Knight knight, BindingResult result){
        System.out.println(result);
        knightService.updateKnight(knight);
        knight.getQuest().setStarted(true);
        return "redirect:/knights";
    }
    @RequestMapping(value = "/checkQuests",method = RequestMethod.GET)
    public String checkQuests(){

        knightService.getMyGold();
        return "redirect:/knights";
    }

}
