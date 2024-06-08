package com.manjeetpati.doc_converter.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

@Component
public class POIUtil {

    public static POIUtil INSTANCE;

    static {
        INSTANCE = new POIUtil();
    }

    public POIUtil getInstance() {
        return INSTANCE;
    }

    public byte[]  wordToPDF(InputStream in,String fileName) throws IOException {
        String filepath = "./staging/"+fileName+".pdf";
        XWPFDocument document = new XWPFDocument(in);
        document.createStyles();
        PdfOptions options = PdfOptions.create();
        OutputStream out = new FileOutputStream(new File(filepath));
        PdfConverter.getInstance().convert(document, out, options);
        FileInputStream fin = new FileInputStream(new File(filepath));
        byte[] response = IOUtils.toByteArray(fin);
        document.close();
        out.close();
        fin.close();
        clearStaging(filepath);
        return response;
    }

    private void clearStaging(String filepath) {
        File file = new File(filepath); 
        if(file.delete()) {
            System.out.println("cleared the file");
        }
        else {
            System.out.println("could not clear the file");
        }
    }
}