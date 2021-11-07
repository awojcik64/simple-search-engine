package com.findwise.search;

import com.findwise.model.IndexEntryImpl;
import com.findwise.IndexEntry;
import com.findwise.SearchEngine;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngineImpl implements SearchEngine {

    public Map<String, String> documents = new HashMap<>();

    public Map<String, List<IndexEntry>> wordIndexEntries = new HashMap<>();

    @Override
    public void indexDocument(String id, String content) {
        this.documents.put(id, content);
        String[] words = tokenizeDocument(content.toLowerCase());
        var wordCountMap = getCountedWordsMap(words);

        for (String word : new ArrayList<>(wordCountMap.keySet())) {
            IndexEntry entry = new IndexEntryImpl(id, (double)wordCountMap.get(word)/words.length);
            if(wordIndexEntries.containsKey(word)) {
                wordIndexEntries.get(word).add(entry);
            }
            else {
                wordIndexEntries.put(word, new ArrayList<>(List.of(entry)));
            }
        }

    }

    @Override
    public List<IndexEntry> search(String term) {
        String rawSearchTerm = term.replace(" ", "").toLowerCase();
        var indexEntries = this.wordIndexEntries.getOrDefault(rawSearchTerm, Collections.emptyList());
        double inverseDocumentFrequency = getInverseDocumentFrequency(rawSearchTerm);
        return indexEntries
                .stream()
                .map(IndexEntryImpl::new)
                .peek(entry -> entry.setScore(entry.getScore()*inverseDocumentFrequency))
                .sorted(Comparator.comparing(IndexEntry::getScore).reversed())
                .collect(Collectors.toList());
    }

    private String[] tokenizeDocument(String document) {
        return document.split("\\s+");
    }

    private Map<String, Integer> getCountedWordsMap(String[] words) {
        var wordCountMap = new HashMap<String, Integer>();
        for (String word : words) {
            if(!wordCountMap.containsKey(word)) {
                wordCountMap.put(word, 1);
            }
            else {
                wordCountMap.put(word, wordCountMap.get(word)+1);
            }
        }
        return wordCountMap;
    }

    private double getInverseDocumentFrequency(String term) {
        int documentOccurencesCount = wordIndexEntries.getOrDefault(term, Collections.emptyList()).size();
        int allDocumentsCount = documents.size();
        return Math.log((double)allDocumentsCount/(documentOccurencesCount));
    }
}
