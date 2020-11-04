//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mycompany.app;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class EnvSettings {
    private String apiKey;
    private String apiUsername;
    private String dbName;
    private String dbUsername;
    private String dbPassword;
    private int dbPort;

    private EnvSettings() {
        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + System.getProperty("file.separator") + "config.conf");
            Properties props = new Properties();
            props.load(new FileReader(file));
            String _apiKey = props.getProperty("api-key");
            String _apiUseranme = props.getProperty("api-username");
            String _dbName = props.getProperty("db-name");
            String _dbUsername = props.getProperty("db-username");
            String _dbPassword = props.getProperty("db-password");
            String _dbPort = props.getProperty("db-port");
            if (_apiKey == null || _apiKey.isEmpty()) {
                throw new Exception("API Key is required");
            } else {
                this.setApiKey(_apiKey);
                if (_apiUseranme != null && !_apiUseranme.isEmpty()) {
                    this.setApiUsername(_apiUseranme);
                    if (_dbName != null && !_dbName.isEmpty()) {
                        this.setDbName(_dbName);
                        if (_dbPassword != null && !_dbPassword.isEmpty()) {
                            this.setDbPassword(_dbPassword);
                            if (_dbUsername == null || _dbUsername.isEmpty()) {
                                throw new Exception("DB username is required");
                            } else {
                                this.setDbUsername(_dbUsername);
                                if (_dbPort == null || _dbPort.isEmpty()) {
                                    throw new Exception("DB port is required");
                                } else {
                                    this.setDbPort(Integer.parseInt(_dbPort));
                                }
                            }
                        } else {
                            throw new Exception("DB password is required");
                        }
                    } else {
                        throw new Exception("DB name is required");
                    }
                } else {
                    throw new Exception("API Username is required");
                }
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        }
    }

    public static EnvSettings getInstance() {
        return EnvSettings.LazyHolder.instance;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiUsername() {
        return this.apiUsername;
    }

    public void setApiUsername(String apiUsername) {
        this.apiUsername = apiUsername;
    }

    public String getDbName() {
        return this.dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUsername() {
        return this.dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return this.dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public int getDbPort() {
        return this.dbPort;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    private static class LazyHolder {
        private static final EnvSettings instance = new EnvSettings();

        private LazyHolder() {
        }
    }
}
