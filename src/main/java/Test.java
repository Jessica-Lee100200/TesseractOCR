
	import java.awt.Image;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStream;
	import java.nio.charset.Charset;
	import javax.imageio.ImageIO;
	import org.apache.http.HttpEntity;
	import org.apache.http.HttpResponse;
	import org.apache.http.client.HttpClient;
	import org.apache.http.client.methods.HttpGet;
	import org.apache.http.impl.client.DefaultHttpClient;
	import org.apache.pdfbox.pdmodel.PDDocument;
	import org.apache.pdfbox.pdmodel.PDPage;
	import org.apache.pdfbox.rendering.ImageType;
	import org.apache.pdfbox.rendering.PDFRenderer;
	import org.apache.pdfbox.tools.imageio.ImageIOUtil;
	import org.apache.tika.Tika;
	import org.apache.tika.exception.TikaException;
	import org.apache.tika.metadata.Metadata;
	import org.apache.tika.parser.AutoDetectParser;
	import org.apache.tika.parser.ParseContext;
	import org.apache.tika.parser.Parser;
	import org.apache.tika.parser.ocr.TesseractOCRConfig;
	import org.apache.tika.parser.ocr.TesseractOCRParser;
	import org.apache.tika.parser.pdf.PDFParserConfig;
	import org.apache.tika.sax.BodyContentHandler;
	import org.xml.sax.ContentHandler;
	import org.xml.sax.SAXException;




	import com.google.common.base.Stopwatch;
	//import com.itextpdf.text.pdf.PdfReader;

	import java.text.Normalizer;
	import java.util.concurrent.TimeUnit;
	import java.util.logging.Logger;




	public class Test {

		
		public static void main(String[] args) throws IOException, SAXException, TikaException {
//			Stopwatch s = Stopwatch.createUnstarted(); 
//		    s.start();
			Stopwatch s = Stopwatch.createUnstarted();
			
//			String filePath = "D:/Example.pdf";
//			String outputFilePath = "E:/IM";
//			File inputFile = new File(filePath);
//			File outputFolder = new File(outputFilePath);
//			String totalFileName = inputFile.getName();
//			String fileName = totalFileName.substring(0,totalFileName.lastIndexOf("."));
//			PDDocument doc = null;
//			try {
//				doc = PDDocument.load(inputFile);
//				PDFRenderer pdfRenderer = new PDFRenderer(doc);
//				
//				int pageCounter = 0;
//				//doc.getPage(pageCounter).setCropBox(pdfRenderer.);;
//				//doc.getPage(pageCounter).getCropBox().setLowerLeftY(600);
//				//doc.getPage(pageCounter).getCropBox().setUpperRightX(100);
//				//doc.getPage(pageCounter).getCropBox().setUpperRightY(100);
//				System.out.println(doc);
//				for(PDPage page : doc.getPages())
//					//doc.getPage(pageCounter).getCropBox().setLowerLeftX(200);
//					//doc.getPage(pageCounter).getCropBox().setLowerLeftY(200);
//					//doc.getPage(pageCounter).getCropBox().setUpperRightX(100);
//					//doc.getPage(pageCounter).getCropBox().setUpperRightY(100);
//				{
//					BufferedImage bim = pdfRenderer.renderImageWithDPI(pageCounter, 300, ImageType.RGB);
//					//BufferedImage bim = pdfRenderer.renderImage(pageCounter,2.0f);
//					
//					String imagename = outputFilePath + "\\" +fileName+ (pageCounter++) +".png";
//					System.out.println(imagename);
//					  ImageIOUtil.writeImage(bim,  imagename , 300);
//					
//					
//					System.out.println("Png image is created " +imagename );
//					ContentHandler handler = new BodyContentHandler();
//					TesseractOCRConfig config =new TesseractOCRConfig();
//					config.setTesseractPath("C:/Program Files (x86)/Tesseract-OCR");
//					ParseContext parseContext = new ParseContext();
//					parseContext.set(TesseractOCRConfig.class, config);
//					TesseractOCRParser parser = new TesseractOCRParser();
//					FileInputStream stream = new FileInputStream(imagename);
//					System.out.println("Image is parse for scraping......." );
//					Metadata metadata = new Metadata();
//			        parser.parse(stream, handler, metadata, parseContext);
//			        System.out.println(metadata);
//			        String content = handler.toString();
//			        
//			        System.out.println(content);
//			        System.out.println("scrapping successfully................................................!!");
//			        System.out.println("#########################");
//					
//				}
//				doc.close();
//			} finally {
//				if (doc != null) {
//					doc.close();
//				}
	//
//			}
			
			
			
			//Parser parser = new AutoDetectParser();
			//BodyContentHandler handler = new BodyContentHandler();
			//TesseractOCRParser parser = new TesseractOCRParser();
			Logger logger = Logger.getLogger(Test.class.getName());
			
//			Tika tika = new Tika(); 
//			  tika.setMaxStringLength(10*1024*1024);
			Parser parser = new AutoDetectParser();
			BodyContentHandler handler = new BodyContentHandler(-1);
			TesseractOCRConfig config =new TesseractOCRConfig();
			//String tessdataPath = "C:/Program Files (x86)/Tesseract-OCR";
			logger.info("pdf parsing");
			//System.out.println("pdf parse");
			config.setTesseractPath("C:/Program Files (x86)/Tesseract-OCR");
			config.setDensity(300);
			config.setDepth(8);
			config.setPageSegMode("12");
			PDFParserConfig pdfConfig = new PDFParserConfig();
			pdfConfig.setExtractInlineImages(true);
			pdfConfig.setExtractUniqueInlineImagesOnly(false);
			ParseContext parseContext = new ParseContext();
			parseContext.set(TesseractOCRConfig.class, config);	
			parseContext.set(PDFParserConfig.class, pdfConfig);
			parseContext.set(Parser.class, parser);
			//////////////////////////////////////////
//			HttpGet httpget = new HttpGet("http://health.mo.gov/information/publicnotices/invitations/rfq580410318000100.pdf"); 
//		    HttpEntity entity = null;
//		    HttpClient client = new DefaultHttpClient();
//		    HttpResponse response = client.execute(httpget);
//		    entity = response.getEntity();
//		    if (entity != null) {
//		    	InputStream instream = entity.getContent();
		    	
			FileInputStream stream = new FileInputStream("E:/New folder/21635_bid-file-17-01-furnishing-grounds-maintenance-for-williamson-cemetery.pdf");
			PDDocument doc = PDDocument.load(new File("E:/New folder/21635_bid-file-17-01-furnishing-grounds-maintenance-for-williamson-cemetery.pdf"));
			  // PdfReader reader =new PdfReader(stream);
			    int page = doc.getNumberOfPages();
		   System.out.println("Total no of pages "+page);
	        Metadata metadata = new Metadata();
	        
	     //   BufferedImage image = ImageIO.read(new File("D:/destanition/data1.png"));
	        s.start();
	        parser.parse(stream, handler, metadata, parseContext);
	      //  parser.parse(image, handler, metadata, parseContext);
	        logger.info("The metadata is : " +metadata  );
	       // System.out.println(metadata);
	        String content = handler.toString();
	      //  String value = content.replaceFirst("ï¬�", "fi");
	       // System.out.println("#########################");
	        String normalisedText = Normalizer.normalize(handler.toString(), Normalizer.Form.NFD).trim();
	        Charset UTF8_CHARSET = Charset.forName("UTF-8");
	        
	        byte[] b = content.getBytes();
	        
	        for (byte c: b) {
	            System.out.print("[" + c + "]");
	        }
	       String str = new String(b, UTF8_CHARSET);
	       String adjusted = str.replaceAll("(?m)^[ \t]*\r?\n", "");
	      String add= adjusted.replaceAll("[^\\p{ASCII}]", "");
	        System.out.println(add);
	      
	       // System.out.println(content);
	        System.out.println("Done");
	        s.stop();
	        System.out.println(s.elapsed(TimeUnit.SECONDS));
//			s.stop();
//		   logger.info("Total time in milliseconds: " + s.elapsed(TimeUnit.SECONDS));
	    
		}
		
	}


