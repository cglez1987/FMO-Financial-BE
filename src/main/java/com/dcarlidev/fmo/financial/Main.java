/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial;

import com.dcarlidev.fmo.financial.beans.Agency;
import com.dcarlidev.fmo.financial.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author carlos
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.dcarlidev.fmo.financial.repositories")
@EntityScan(basePackages = "com.dcarlidev.fmo.financial.beans")
public class Main implements CommandLineRunner {

    private static String name;
    @Autowired
    AgencyService agencyService;

    public Main(@Value("${spring.application.name}") String name) {
        Main.name = name;
    }

    @Override
    public void run(String... args) throws Exception {
        //Main.execute();
        agencyService.saveAgency(new Agency("Universal Internacional Agency", "New York"));
    }

    

    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
}
