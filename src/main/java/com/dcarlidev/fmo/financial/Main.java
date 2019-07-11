/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial;

import java.time.LocalDate;
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

    @Override
    public void run(String... args) throws Exception {
        //Main.execute();
        System.out.println("dateeee: " +  LocalDate.now().toString());
    }

    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
}
