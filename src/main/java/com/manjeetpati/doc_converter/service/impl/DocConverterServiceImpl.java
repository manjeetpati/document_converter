package com.manjeetpati.doc_converter.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manjeetpati.doc_converter.service.DocConverterService;

@Service
public class DocConverterServiceImpl implements DocConverterService {

    @Override
    public Object convert(MultipartFile file) throws Exception {
        System.out.println("file: " + file.getOriginalFilename());
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convert'");
    }
    
}
