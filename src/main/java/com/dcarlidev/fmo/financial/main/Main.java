/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.main;

import com.dcarlidev.fmo.financial.etl.ETL_Executor;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            String main_path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            File parent = new File(main_path).getParentFile();
            String separator = System.getProperty("file.separator");
            
            Properties properties = new Properties();
            InputStream fileProperties = new FileInputStream(parent.getPath() + separator + "config" + separator + "config.properties");
            properties.load(fileProperties);
            
            HashMap<String, String> job_parameters = new HashMap<>();
            HashMap<String, String> job_variables = new HashMap<>();
            
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
            
            String job_path = properties.getProperty("job_path");
            
            ETL_Executor etl_executor = new ETL_Executor();
            etl_executor.executeKettleJob(job_path, job_parameters, job_variables);
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
