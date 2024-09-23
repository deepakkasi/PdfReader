package org.example.readerapp;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static List<Integer> readPdf(File file,String keyvalue) throws IOException {

        //File file = new File("D://PdfReader//Lorem Ipsum.pdf");
        List<Integer> TotalPageNumu = new ArrayList<>();
        System.out.println(keyvalue);
        try {
            PDDocument document = Loader.loadPDF(file);
            System.out.println(document.getNumberOfPages());
            for (int pageNumber = 1; pageNumber <= document.getNumberOfPages(); pageNumber++) {

                PDFTextStripper s = new PDFTextStripper();
                String contents = s.getText(document);
                //String contents = s.getText(document);
                if (contents.contains(keyvalue)) {
                    TotalPageNumu.add(pageNumber);
                    System.out.println("Page number is " + pageNumber);
                }
            }
            document.close();
            return TotalPageNumu;
        } catch (FileNotFoundException fil) {
            System.out.println("File not found");
            TotalPageNumu.add(-1);
            return TotalPageNumu;
        }
    }


}
