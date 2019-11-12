package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import database.AppDataException;
import negocio.*;
import entidades.*;

/**
 * Servlet implementation class reporteCurso
 */
@WebServlet("/reporteCurso")
public class reporteCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reporteCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");	
		if(op.equals("reporte"))
		{
			if(Integer.parseInt(request.getParameter("sel1"))!=0)
			{
				CtrlCurso ctrlc=new CtrlCurso();	
				CtrlDocente cp= new CtrlDocente();
				CtrlInscripcionCurso cc=new CtrlInscripcionCurso();
				ArrayList<InscripcionCurso> listInsCurso=cc.getInscriptos(Integer.parseInt(request.getParameter("sel1")));
				response.setContentType("application/pdf");
				OutputStream out=response.getOutputStream();
				try
		        {
					Docente p=cp.getDocente(Integer.parseInt(request.getParameter("sel1")));
					Curso cur=ctrlc.getOne(Integer.parseInt(request.getParameter("sel1")));
					Document document = new Document(PageSize.A4, 50, 30, 50, 50);
		            PdfWriter.getInstance(document, out);
		            document.open();
		            Paragraph titulo=new Paragraph("Reporte del curso: "+cur.getNombre()+"");
		            titulo.getFont().setStyle(Font.BOLD);
		            titulo.getFont().setSize(16);
		            document.add(titulo);
		            document.add( Chunk.NEWLINE );
		            Paragraph titulo2=new Paragraph("Docente: "+p.getPersona().getNombre()+" "+p.getPersona().getApellido());
			        titulo2.getFont().setStyle(Font.BOLD);
			        titulo2.getFont().setSize(14);
			        document.add(titulo2);
			        document.add( Chunk.NEWLINE );
			        PdfPTable tabla = new PdfPTable(2);
			        if(listInsCurso.isEmpty()==false)
		    		{
			        	Paragraph columna1 = new Paragraph("Alumno");
			            columna1.getFont().setStyle(Font.BOLD);
			            columna1.getFont().setSize(10);
			            tabla.addCell(columna1);
		
			            Paragraph columna3 = new Paragraph("Fecha de inscripcion");
			            columna3.getFont().setStyle(Font.BOLD);
			            columna3.getFont().setSize(10);
				        tabla.addCell(columna3);
		
				        for(InscripcionCurso i:listInsCurso)
		    			{
			    				  tabla.addCell( i.getAlumno().getPersona().getNombre()+" "+i.getAlumno().getPersona().getApellido());
			    				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			    				  String fechaComoCadena = sdf.format(i.getFechainscripcion());
			    				  tabla.addCell(fechaComoCadena);
			    		}
		    		}
		            else
		            {
			            Paragraph sin=new Paragraph("El curso no posee ninguna inscripcion actual");
			            document.add(sin);
		            }
			            document.add(tabla);
			          
			            document.close();
			        }
			         catch (DocumentException exc){
			               throw new IOException(exc.getMessage());
			         } catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (AppDataException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        finally {            
			            out.close();
			        }
			}
			else
			{
				request.getRequestDispatcher("/reportesCurso.jsp").forward(request, response);	
			}	
		}
		if(op.equals("volver"))
		{
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

}
