package com.manjeetpati.doc_converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.manjeetpati.doc_converter.service.DocConverterService;

@RestController
@RequestMapping("/converter")
public class DocConverterController {

    @Autowired
    private DocConverterService docConverterService;
    
    @PostMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Object converter(@RequestParam("file") MultipartFile file) {
        try {
            return docConverterService.convert(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.internalServerError();
    }
}
