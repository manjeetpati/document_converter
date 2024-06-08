package com.manjeetpati.doc_converter.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface DocConverterService {
    public byte[] convert(MultipartFile file) throws Exception;
}
