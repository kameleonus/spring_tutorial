package com.clockworkjava.kursspring.Services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repos.QuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;
@Service
public class QuestFormatter implements Formatter<Quest> {
    @Autowired
    QuestRepo questRepo;
    @Override
    public Quest parse(String text, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(text);
        return questRepo.getQuest(id);
    }

    @Override
    public String print(Quest object, Locale locale) {
        return object.toString();
    }
}
