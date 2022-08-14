package com.codingchallenge.clients;

import com.codingchallenge.exception.ClientConnectionRefusedException;
import com.codingchallenge.models.Document;
import com.codingchallenge.models.DocumentList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DocumentClient {
    public static final String DOCUMENT_API_IS_NOT_AVAILABLE = "DocumentAPI is not available. Please try again after some time";
    RestTemplate documentTemplate;
    String url;
    public DocumentList getDocuments(){
        try {
            return new DocumentList(Arrays.asList(documentTemplate.getForObject(url, Document[].class)));
        }catch(Exception ex){
            if(ex.getMessage().contains("Connection refused"))
            throw new ClientConnectionRefusedException(DOCUMENT_API_IS_NOT_AVAILABLE);
            else
                throw new ClientConnectionRefusedException(ex.getMessage());
        }
    }
}

