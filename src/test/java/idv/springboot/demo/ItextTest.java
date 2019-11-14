package idv.springboot.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.junit.jupiter.api.Test;

import com.itextpdf.awt.AsianFontMapper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextTest {

	private String path = "C:\\Users\\Min\\Desktop\\iTextHelloWorld.pdf";

	@Test
	void test() {

		try {

			// ==== 自行產生 ====

			// this.getBasicPdf();

			// this.getFontPdf();

			// this.getTablePdf();

			// this.getPwdPdf();

			// ==== 套版產生 ====

			// this.readPdfAndFix();

			this.setPosition();

		} catch (Exception e) {

			System.err.println(e.getMessage());
		}

	}

	/**
	 * getBasicPdf 產生基本的PDF(純文字)
	 * 
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	private void getBasicPdf() throws DocumentException, FileNotFoundException {

		Document document = new Document();

		PdfWriter.getInstance(document, new FileOutputStream(path));

		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Hello World", font);

		document.add(chunk);
		document.close();
	}

	/**
	 * getFontPdf 產生有字形的PDF
	 * 
	 * @throws DocumentException
	 * @throws IOException
	 */
	private void getFontPdf() throws DocumentException, IOException {

		// 建立一個文件
		Document document = new Document();

		// 設定輸出位置
		PdfWriter.getInstance(document, new FileOutputStream(path));

		// 開啟文件
		document.open();

		// 寫入內容
		Font font = FontFactory.getFont(AsianFontMapper.ChineseSimplifiedFont,
				AsianFontMapper.ChineseSimplifiedEncoding_H, 16, Font.NORMAL, BaseColor.BLACK);

		StringBuilder sb = new StringBuilder();

		sb.append("========== end ==========").append("\r\n");

		sb.append("english test ").append("\r\n");

		sb.append("中文測試 ").append("\r\n");

		sb.append("1234567890 test ").append("\r\n");

		sb.append("========== end ==========").append("\r\n");

		document.add(new Paragraph(sb.toString(), font));

		// 關閉文件
		document.close();
	}

	/**
	 * getTablePdf 產生有表格的PDF
	 * 
	 * @throws Exception
	 */
	private void getTablePdf() throws Exception {

		// 準備資料
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] { "月份", "去年銷量", "今年銷量" });
		list.add(new Object[] { "七月份", 1000, 1500 });
		list.add(new Object[] { "八月份", 1200, 1300 });
		list.add(new Object[] { "九月份", 900, 1100 });

		// 1 建立文件物件
		Document document = new Document();

		// 2 設定輸出位置
		PdfWriter.getInstance(document, new FileOutputStream(path));

		// 3 開啟文件
		document.open();

		// 4 輸出內容
		// 建立基礎字型支援中文
		BaseFont baseFont = BaseFont.createFont(AsianFontMapper.ChineseSimplifiedFont,
				AsianFontMapper.ChineseSimplifiedEncoding_H, false);

		/**** 大標題輸出 ******/
		Font titleFont = new Font(baseFont, 30, Font.BOLD, BaseColor.RED);
		// 居中
		Paragraph bigTitleParagraph = new Paragraph("出貨表", titleFont);
		bigTitleParagraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(bigTitleParagraph);

		/**** 作者輸出 ******/
		Font authorFont = new Font(baseFont, 15, Font.NORMAL, BaseColor.BLACK);
		Paragraph authorParagraph = new Paragraph("demoSite", authorFont);
		authorParagraph.setAlignment(Paragraph.ALIGN_RIGHT);
		document.add(authorParagraph);

		/**** 表格輸出 ******/
		Font contentFont = new Font(baseFont, 15, Font.NORMAL, BaseColor.BLUE);
		// 引數：列數
		PdfPTable table = new PdfPTable(3);
		// 迴圈資料
		for (Object[] values : list) {
			table.addCell(new PdfPCell(new Phrase(values[0].toString(), contentFont)));
			table.addCell(new PdfPCell(new Phrase(values[1].toString(), contentFont)));
			table.addCell(new PdfPCell(new Phrase(values[2].toString(), contentFont)));
		}

		// 設定元素距離上一個元素的距離
		table.setSpacingBefore(10);

		// 將表格新增到文件中
		document.add(table);

		// 5 關閉文件
		document.close();
	}

	/**
	 * getPwdPdf 產生密碼文件
	 * 
	 * @throws Exception
	 */
	public void getPwdPdf() throws Exception {

		// Loading an existing document
		File file = new File("C:\\Users\\Min\\Desktop\\itext.pdf");

		PDDocument document = PDDocument.load(file);

		// Creating access permission object
		AccessPermission ap = new AccessPermission();

		// Creating StandardProtectionPolicy object
		StandardProtectionPolicy spp = new StandardProtectionPolicy("1234", "1234", ap);

		// Setting the length of the encryption key
		spp.setEncryptionKeyLength(128);

		// Setting the access permissions
		spp.setPermissions(ap);

		// Protecting the document
		document.protect(spp);

		System.out.println("Document encrypted");

		// Saving the document
		document.save(path);
		// Closing the document
		document.close();
	}

	/**
	 * readPdfAndFix 讀檔並套版
	 * 
	 * @throws IOException
	 * @throws DocumentException
	 */
	private void readPdfAndFix() throws DocumentException, IOException {

		String templatePath = "C:\\Users\\Min\\Desktop\\itext.pdf";

		PDDocument doc = PDDocument.load(new File(templatePath));

		for (int idx = 0; idx < doc.getNumberOfPages(); idx++) {

			this.fillPDFContent(doc, idx);
		}
	}

	/**
	 * fillPDFContent 將內容填入PDF
	 * 
	 * @param doc
	 * @param pageNo
	 * @throws IOException
	 */
	private void fillPDFContent(PDDocument doc, int pageNo) throws IOException {

		PDPage page = doc.getPage(pageNo);

		// 內容
		PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND,
				true, true);

		// Begin the Content stream
		contentStream.beginText();

		// Setting the font to the Content stream
		InputStream in = new FileInputStream(
				"C:\\Users\\Min\\Desktop\\Min\\code\\BackEnd\\spring-boot-demo\\config\\sming.ttf");

		PDFont font = PDType0Font.load(doc, in, false);

		contentStream.setFont(font, 12);

		// Setting the position for the line
		contentStream.newLineAtOffset(152, 1000);

		// String text = "This is the sample document and we are adding content to it.";

		String text = "中文編碼終於通過!!!!!!!!!!!!!!!!chinese test";

		// Adding text in the form of string
		contentStream.showText(text);

		// Ending the content stream
		contentStream.endText();

		System.out.println("Content added");

		// Closing the content stream
		contentStream.close();

		// Saving the document
		doc.save(path);

		// Closing the document
		doc.close();
	}

	/**
	 * setPosition 文件座標
	 * 
	 * @throws Exception
	 */
	private void setPosition() throws Exception {

		// String templatePath = "C:\\Users\\Min\\Desktop\\test.pdf";

		String templatePath = "C:\\Users\\Min\\Desktop\\itext.pdf";

		PDDocument doc = PDDocument.load(new File(templatePath));

		for (int idx = 0; idx < doc.getNumberOfPages(); idx++) {

			this.setPositionMark(doc, idx, true);

			doc = PDDocument.load(new File(path));

			this.setPositionMark(doc, idx, false);
		}
	}

	/**
	 * setPositionMark 位置
	 * 
	 * @param doc
	 * @param pageNo
	 * @throws Exception
	 */
	private void setPositionMark(PDDocument doc, int pageNo, boolean isX) throws Exception {

		PDPage page = doc.getPage(pageNo);

		// 內容
		PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND,
				true, true);

		// Begin the Content stream
		contentStream.beginText();

		// Setting the font to the Content stream
		InputStream in = new FileInputStream(
				"C:\\Users\\Min\\Desktop\\Min\\code\\BackEnd\\spring-boot-demo\\config\\sming.ttf");

		PDFont font = PDType0Font.load(doc, in, false);

		contentStream.setFont(font, 5);

		if (isX) {

			int xnum = 10;

			for (int x = 0; x < 600; x += xnum) {

				// Setting the position for y
				contentStream.newLineAtOffset(xnum, 0);

				// Adding text in the form of string
				contentStream.showText(String.valueOf(x));
			}

		} else {

			int ynum = 5;

			for (int y = 0; y < 1000; y += ynum) {

				// Setting the position for x
				contentStream.newLineAtOffset(0, ynum);

				// Adding text in the form of string
				contentStream.showText(y + "-");
			}
		}

		// Ending the content stream
		contentStream.endText();

		// Closing the content stream
		contentStream.close();

		// Saving the document
		doc.save(path);

		// Closing the document
		doc.close();
	}
}
