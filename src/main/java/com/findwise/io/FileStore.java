package com.findwise.io;

import java.io.IOException;
import java.util.Map;

public interface FileStore {
    Map<String, String> getDocumentsFromFile(String fileName) throws IOException;
}
