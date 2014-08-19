package br.com.evertontrindade;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main( String[] args ) {
        PDFMergerUtility util = new PDFMergerUtility();

        File folder = new File("/home/everton/quandomelembro");

        File[] files = folder.listFiles();
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (File file : files) {
            util.addSource(file);
        }

        util.setDestinationFileName("/home/everton/quandomelembro.pdf");
        try {
            util.mergeDocuments();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }
    }
}
