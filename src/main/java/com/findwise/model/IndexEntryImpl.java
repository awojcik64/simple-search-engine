package com.findwise.model;

import com.findwise.IndexEntry;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IndexEntryImpl implements IndexEntry {

    private String id;

    private double score;

    public IndexEntryImpl(IndexEntry indexEntry) {
        this.id = indexEntry.getId();
        this.score = indexEntry.getScore();
    }
}
