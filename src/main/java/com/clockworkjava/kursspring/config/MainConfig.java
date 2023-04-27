package com.clockworkjava.kursspring.config;


import com.clockworkjava.kursspring.domain.repos.DBKnightRepo;
import com.clockworkjava.kursspring.domain.repos.InMemoryKnightRepo;
import com.clockworkjava.kursspring.domain.repos.KnightRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig {

@Bean(name="InMemoryKnightRepo")
@Profile("dev")
    public KnightRepo createInMemoryRepo(){
    KnightRepo repo = new InMemoryKnightRepo();
    return repo;
}
    @Bean(name="DBKnightRepo")
    @Profile("prod")
    public KnightRepo createDBRepo(){
        KnightRepo repo = new DBKnightRepo();
        return repo;
    }




}
