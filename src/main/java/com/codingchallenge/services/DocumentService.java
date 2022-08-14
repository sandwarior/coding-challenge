package com.codingchallenge.services;

import com.codingchallenge.clients.DocumentClient;
import com.codingchallenge.models.Document;
import com.codingchallenge.models.DocumentList;
import com.codingchallenge.models.DocumentsMetaInfo;
import com.codingchallenge.utils.DocumentComparatorFactory;
import com.codingchallenge.utils.SortBy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@AllArgsConstructor
public class DocumentService {

    DocumentClient documentClient;
    DocumentComparatorFactory documentComparatorFactory;
    public DocumentList getDocuments(String category, SortBy sortBy){
        DocumentList documentList = documentClient.getDocuments();
        if (category != null) {
            documentList.filterDocumentListOnCategory(category);
        }
        if(sortBy!=null) {
            getSortedList(documentList, sortBy);
        }
        return documentList;
    }

    public DocumentsMetaInfo getDocumentsMetaInfo(String category){
        DocumentsMetaInfo documentsMetaInfo = new DocumentsMetaInfo();
        DocumentList documentList = documentClient.getDocuments();
        if(category!=null)
            documentList.filterDocumentListOnCategory(category);
        documentsMetaInfo.setDeletedDocumentCount(documentList.deletedDocumentsCount());
        documentsMetaInfo.setTotalDocumentCount(documentList.totalDocumentsCount());
        documentsMetaInfo.setAvgSize(documentList.avgSizeOfDocuments());
        documentsMetaInfo.setTotalSize(documentList.totalSizeOfDocuments());
        return documentsMetaInfo;
    }

    public DocumentList getSortedList(DocumentList documentList, SortBy sortBy){
        Comparator<Document> documentComparator;
        documentComparator = documentComparatorFactory.getDocumentComparator(sortBy);
        documentList.sortDocumentListByName(documentComparator);
        return documentList;
    }
}
