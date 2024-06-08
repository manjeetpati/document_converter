package com.manjeetpati.doc_converter.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manjeetpati.doc_converter.service.DocConverterService;
import com.manjeetpati.doc_converter.util.POIUtil;

@Service
public class DocConverterServiceImpl implements DocConverterService {

    @Override
    public byte[] convert(MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.'));
        return POIUtil.INSTANCE.wordToPDF(file.getInputStream(), filename);
    }
    
}
