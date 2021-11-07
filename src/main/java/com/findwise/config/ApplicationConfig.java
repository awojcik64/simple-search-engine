package com.findwise.config;

import com.findwise.io.FileStore;
import com.findwise.io.JsonFileStore;

public class ApplicationConfig {

    private static ApplicationConfig instance;

    private FileStore fileStore;

    private ApplicationConfig() {
        this.fileStore = new JsonFileStore();
    }

    public static ApplicationConfig getInstance() {
        if(instance == null) {
            instance = new ApplicationConfig();
        }
        return instance;
    }

    public FileStore getFileStore() {
        return fileStore;
    }
}
