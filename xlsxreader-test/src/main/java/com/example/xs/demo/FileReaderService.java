package com.example.xs.demo;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

public interface FileReaderService {
    public abstract Workbook openFile(String file) throws IOException;
}
