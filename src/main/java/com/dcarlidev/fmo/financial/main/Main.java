/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.main;

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
            String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            File parent = new File(path).getParentFile();
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
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
