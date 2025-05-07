package vistasCliente;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class TestPDF {
    
	public static void main(String[] args) throws DocumentException {
		
		try {
            Document document = new Document();
            String dest = "C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\testpdf2.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
            
            Phrase header = new Phrase("Hello world");
            document.add(header);
            
            document.close();
            
            System.out.println("PDF creado");
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
		
	}
	
}
