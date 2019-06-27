/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.main;

import com.dcarlidev.fmo.financial.beans.Agency;
import com.dcarlidev.fmo.financial.etl.ETL_Executor;
import com.dcarlidev.fmo.financial.repositories.AgencyRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    AgencyRepository agencyRepo;

    public Main(@Value("${spring.application.name}") String name) {
        Main.name = name;
    }

    @Override
    public void run(String... args) throws Exception {
        //Main.execute();
        agencyRepo.save(new Agency("Agencia Modelo", "Orlando Florida"));
    }

    public static void execute() {
        try {
            String main_path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            File parent = new File(main_path).getParentFile();
            String separator = System.getProperty("file.separator");

            HashMap<String, String> job_parameters = new HashMap<>();
            HashMap<String, String> job_variables = new HashMap<>();

            System.out.println("File----" + name);
            Properties properties = new Properties();
            InputStream fileProperties = new FileInputStream(parent.getPath() + separator + "config" + separator + "config.properties");
            System.out.println("FilePropeties: " + fileProperties.toString());
            try {
                properties.load(fileProperties);
                properties.stringPropertyNames().forEach(prop -> {
                    if (prop.startsWith("parameter")) {
                        String parameter;
                        String value;
                        if (prop.contains("encrypt")) {
                            parameter = prop.replaceFirst("parameter.encrypt.", "");
                            //value = SecurityUtil.decrypt(properties.getProperty(prop));
                            value = properties.getProperty(prop);
                        } else {
                            parameter = prop.replaceFirst("parameter.", "");
                            value = properties.getProperty(prop);
                        }
                        job_parameters.put(parameter, value);
                    }
                    if (prop.startsWith("variable")) {
                        String variable;
                        String value;
                        if (prop.contains("encrypt")) {
                            variable = prop.replaceFirst("variable.encrypt.", "");
                            //value = SecurityUtil.decrypt(properties.getProperty(prop));
                            value = properties.getProperty(prop);
                        } else {
                            variable = prop.replaceFirst("variable.", "");
                            value = properties.getProperty(prop);
                        }
                        job_variables.put(variable, value);
                    }
                });
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String fecha = dateFormat.format(date);
            job_parameters.put("actual_date", fecha);

            String job_path = "";

            ETL_Executor etl_executor = new ETL_Executor();
            etl_executor.executeKettleJob(job_path, job_parameters, job_variables);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
}
