package com.codingchallenge.utils;

import com.codingchallenge.models.Document;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class DocumentComparatorFactory {
    public Comparator<Document> getDocumentComparator(SortBy sortBy) {
        if(sortBy.equals(SortBy.NAME))
            return new DocumentNameComparator();
        else if(sortBy.equals(SortBy.TYPE))
            return new DocumentTypeComparator();
        else if(sortBy.equals(SortBy.DELETED))
            return new DocumentDeletedComparator();
        else if(sortBy.equals(SortBy.SIZE))
            return new DocumentSizeComparator();
        else
            return new DocumentSizeComparator();
    }
}
