

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/create")
public class PDFCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		String usuario = request.getParameter("usuario");
		String date = request.getParameter("date");
		String escolaridade = request.getParameter("escolaridade");
		

		
		
		if (usuario!="ativo")
			usuario="inativo";
		
		try {
			 Document document = new Document();
		     
		        PdfWriter.getInstance(document, response.getOutputStream());
		        document.open();
		        Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
		        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
		        Chunk chunk = new Chunk("Dados", chapterFont);
		        Chapter chapter = new Chapter(new Paragraph(chunk), 1);
		        chapter.setNumberDepth(0);
		        chapter.add(new Paragraph ("Login:"+login, paragraphFont));
		        chapter.add(new Paragraph ("Nome:"+nome, paragraphFont));
		        chapter.add(new Paragraph ("Tipo:"+tipo, paragraphFont));
		        chapter.add(new Paragraph ("Usuario:"+usuario, paragraphFont));
		        chapter.add(new Paragraph ("date:"+date, paragraphFont));
		        chapter.add(new Paragraph ("escolaridade:"+escolaridade, paragraphFont));
		        document.add(chapter);
		        document.close();
			createPdf(response.getOutputStream());
		} catch (DocumentException e) {
			response.sendError(404, "PDF não gerado.");
		}
	}


	private void createPdf(ServletOutputStream outputStream) {
		// TODO Auto-generated method stub
		
	}
	
	

}
