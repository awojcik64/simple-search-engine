package com.findwise.io;

import com.findwise.model.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonFileStore implements FileStore{

    private ObjectMapper mapper = new ObjectMapper();

    public JsonFileStore() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public Map<String, String> getDocumentsFromFile(String fileName) throws IOException {
        var documentsList = Arrays.asList(mapper.readValue(Paths.get(fileName).toFile(), Document[].class));
        return documentsList
                .stream()
                .collect(Collectors.toMap(Document::getId, Document::getContent));
    }
}
