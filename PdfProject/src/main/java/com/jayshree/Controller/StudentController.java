package com.jayshree.Controller;

    import java.io.ByteArrayInputStream;
	import java.io.ByteArrayOutputStream;
	import java.io.IOException;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.core.io.InputStreamResource;
	import org.springframework.core.io.Resource;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
    import com.jayshree.Entity.Student;
	import com.jayshree.Repository.StudentRepository;
	import com.itextpdf.text.BaseColor;
	import com.itextpdf.text.Document;
	import com.itextpdf.text.DocumentException;
	import com.itextpdf.text.Font;
	import com.itextpdf.text.FontFactory;
	import com.itextpdf.text.PageSize;
	import com.itextpdf.text.Paragraph;
	import com.itextpdf.text.Phrase;
	import com.itextpdf.text.pdf.PdfPCell;
	import com.itextpdf.text.pdf.PdfPTable;
	import com.itextpdf.text.pdf.PdfWriter;
	
	@RestController
	@RequestMapping("/jay")
	public class StudentController {
		@Autowired
		private StudentRepository repository;
		@GetMapping("/pdf")
		public ResponseEntity<Resource> generatePdf() throws IOException, DocumentException {
			List<Student> student = repository.findAll();
			
			Document document = new Document(PageSize.A4, 25, 25, 25, 25);

			ByteArrayOutputStream os = new ByteArrayOutputStream();

			PdfWriter.getInstance(document, os);

			document.open();

			Paragraph title = new Paragraph("       List of Student of velocity",
					FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 40, Font.BOLD, new BaseColor(5, 255, 255)));
			

			document.add(title);
			PdfPTable table = new PdfPTable(5);
			table.setSpacingBefore(25);
		table.setSpacingAfter(25);

			PdfPCell c1 = new PdfPCell(new Phrase("Id"));
			table.addCell(c1);

			PdfPCell c2 = new PdfPCell(new Phrase("Name"));
			table.addCell(c2);

			PdfPCell c3 = new PdfPCell(new Phrase("surname"));
			table.addCell(c3);

			PdfPCell c4 = new PdfPCell(new Phrase("address"));
			table.addCell(c4);

			PdfPCell c5 = new PdfPCell(new Phrase("fees"));
			table.addCell(c5);

		

			for (Student std : student) {
				table.addCell(String.valueOf(std.getId()));
				table.addCell(String.valueOf(std.getName()));
				table.addCell(String.valueOf(std.getSurname()));
				table.addCell(String.valueOf(std.getAddress()));
				table.addCell(String.valueOf(std.getFees()));
				
			}

			document.add(table);
			Paragraph title1 = new Paragraph("Thank u  ",
					FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 40, Font.BOLD, new BaseColor(100, 100, 100)));
			document.add(title1);
			
			document.close();

			ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.parseMediaType("application/pdf"));
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=studentDetails.pdf");

			ResponseEntity<Resource> response = new ResponseEntity<Resource>(new InputStreamResource(is), headers,
					HttpStatus.OK);

			return response;
		}

	}


