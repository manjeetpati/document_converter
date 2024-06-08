package com.manjeetpati.doc_converter.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.manjeetpati.doc_converter.service.DocConverterService;

import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping("/converter")
public class DocConverterController {

    @Autowired
    private DocConverterService docConverterService;
    
    @PostMapping()
    public ResponseEntity<InputStreamResource> converter(@RequestParam("file") MultipartFile file) throws Exception {
            InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(docConverterService.convert(file)));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);    
    }
}
