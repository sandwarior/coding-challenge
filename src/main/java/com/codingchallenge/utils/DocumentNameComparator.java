package com.codingchallenge.utils;

import com.codingchallenge.models.Document;

import java.util.Comparator;


public class DocumentNameComparator implements Comparator<Document> {
    @Override
    public int compare(Document doc1, Document doc2) {
        return doc1.getName().compareTo(doc2.getName());
    }
}
