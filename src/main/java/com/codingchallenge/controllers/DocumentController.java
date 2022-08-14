package com.codingchallenge.controllers;

import com.codingchallenge.models.DocumentList;
import com.codingchallenge.models.DocumentsMetaInfo;
import com.codingchallenge.utils.SortBy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codingchallenge.services.DocumentService;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class DocumentController extends BaseController{
    DocumentService documentService;
    @GetMapping("/documents")
    public ResponseEntity<DocumentList> getDocuments(@RequestParam(required = false) String category,@RequestParam(required = false) SortBy sortBy){
        return  ResponseEntity.ok().body(documentService.getDocuments(category,sortBy));
    }

    @GetMapping("/documents/metaInfo")
    public ResponseEntity<DocumentsMetaInfo> getDocumentsMetaInfo(@RequestParam(required = false) String category){
        return  ResponseEntity.ok().body(documentService.getDocumentsMetaInfo(category));
    }

}
