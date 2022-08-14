package com.codingchallenge.models;

import lombok.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocumentList {

    private List<Document> documentList;

    public long totalDocumentsCount(){
        return documentList.size();
    }
    public long deletedDocumentsCount(){
        return documentList.stream().filter(Document::getDeleted).count();
    }
    public long  totalSizeOfDocuments(){
        return documentList.stream().mapToLong(Document::getSize).sum();
    }
    public double avgSizeOfDocuments(){
        return documentList.stream().mapToLong(Document::getSize).average().orElse(0);
    }
    public void filterDocumentListOnCategory(String category){
        documentList =  documentList.stream().filter(document -> document.getCategories().contains(category)).collect(Collectors.toList());
    }
    public void sortDocumentListByName(Comparator<Document> comparator){
        documentList = documentList.stream().sorted(comparator).collect(Collectors.toList());
    }
}
