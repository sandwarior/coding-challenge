package com.codingchallenge.utils;

import com.codingchallenge.models.Document;

import java.util.Comparator;

public class DocumentDeletedComparator implements Comparator<Document> {

    @Override
    public int compare(Document doc1, Document doc2) {
        return doc1.getDeleted().compareTo(doc2.getDeleted());
    }
}
