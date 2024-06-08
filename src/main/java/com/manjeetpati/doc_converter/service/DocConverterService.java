package com.manjeetpati.doc_converter.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocConverterService {
    public Object convert(MultipartFile file) throws Exception;
}
