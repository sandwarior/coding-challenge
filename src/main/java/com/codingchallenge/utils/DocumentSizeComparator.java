package com.codingchallenge.utils;

import com.codingchallenge.models.Document;

import java.util.Comparator;

public class DocumentSizeComparator implements Comparator<Document> {
    @Override
    public int compare(Document doc1, Document doc2) {
        return doc1.getSize().compareTo(doc2.getSize());
    }
}
