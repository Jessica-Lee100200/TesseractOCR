import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ocr.TesseractOCRConfig;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import java.util.logging.Logger;

public class TesseractOcr {

	public static void main(String[] args) throws IOException, SAXException, TikaException  {

		Logger logger = Logger.getLogger(TesseractOcr.class.getName());
		Parser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler(-1);
		String str = "E:/New folder/Bid.Number.01.pdf";
		//FileInputStream stream = new FileInputStream("D:/ocr_project/Invitation-to-Bid-Advertisement.pdf");	
		FileInputStream stream = new FileInputStream(str);
		Metadata metadata = new Metadata();
		parser.parse(stream, handler, metadata, new ParseContext());
		logger.info("The metadata is : " +metadata  );
		String content = handler.toString();
		System.out.println(content);
		if(content.length()>100){
			System.out.println("else condition");
			System.out.println(content);

		}else{
			try{
				FileInputStream stream1 = new FileInputStream(str);
				//Parser parser1 = new AutoDetectParser();
				BodyContentHandler handler1 = new BodyContentHandler(-1);
				TesseractOCRConfig config =new TesseractOCRConfig();
				config.setTesseractPath("C:/Program Files (x86)/Tesseract-OCR");
				config.setDensity(300);
				config.setDepth(8);
				config.setPageSegMode("12");
				//Metadata metadata1 = new Metadata();
				PDFParserConfig pdfConfig = new PDFParserConfig();
				pdfConfig.setExtractInlineImages(true);
				pdfConfig.setExtractUniqueInlineImagesOnly(false);
				ParseContext parseContext = new ParseContext();
				parseContext.set(TesseractOCRConfig.class, config);	
				parseContext.set(PDFParserConfig.class, pdfConfig);
				parseContext.set(Parser.class, parser);
				parser.parse(stream1, handler1, metadata, parseContext);
				String content1 = handler1.toString();
				System.out.println(content1);
			}catch(Exception e){
				e.printStackTrace();
			}
		}


	}
}