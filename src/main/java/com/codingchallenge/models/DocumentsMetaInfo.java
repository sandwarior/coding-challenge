package com.codingchallenge.models;

import lombok.Data;

@Data
public class DocumentsMetaInfo {
    private long totalDocumentCount;
    private long deletedDocumentCount;
    private long totalSize;
    private double avgSize;
}
