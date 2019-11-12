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

import entidades.*;
import negocio.*;

/**
 * Servlet implementation class reporteEstado
 */
@WebServlet("/reporteEstado")
public class reporteEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reporteEstado() {
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

		    	int id=Integer.parseInt(request.getParameter("sel1"));
		    	CtrlAlumno ca=new CtrlAlumno();
		    	Alumno al;
				al = ca.getOne(id);
				CtrlInscripcionCurso cic=new CtrlInscripcionCurso();
				ArrayList<InscripcionCurso> listInsCurso=cic.getAllInscripcionesCurso(al);
				CtrlInscripcionCarrera cica=new CtrlInscripcionCarrera();
				ArrayList<InscripcionCarrera> listInsCar=cica.getAllInscripcionesCarrera(al);
				ArrayList<InscripcionCurso> listaEstado=cic.getEstadoCursoAnterior(al);
				response.setContentType("application/pdf");
				OutputStream out=response.getOutputStream();
				try
		        {
		            Document document = new Document(PageSize.A4, 50, 30, 50, 50);
		            PdfWriter.getInstance(document, out);
		            document.open();
		            Paragraph titulo=new Paragraph("Estado academico de "+ al.getPersona().getNombre()+" "+al.getPersona().getApellido()+"");
		            titulo.getFont().setStyle(Font.BOLD);
		            titulo.getFont().setSize(16);
		            document.add(titulo);
		            document.add( Chunk.NEWLINE );
		            Paragraph titulo2=new Paragraph("Inscripciones actuales a cursos");
		            titulo2.getFont().setStyle(Font.BOLD);
		            titulo2.getFont().setSize(14);
		            document.add(titulo2);
		            document.add( Chunk.NEWLINE );
		            PdfPTable tabla = new PdfPTable(5);
		            if(listInsCurso.isEmpty()==false)
		    		{
		            	Paragraph columna1 = new Paragraph("Curso");
				        columna1.getFont().setStyle(Font.BOLD);
				        columna1.getFont().setSize(10);
				        tabla.addCell(columna1);

				        Paragraph columna2 = new Paragraph("Descripcion");
				        columna2.getFont().setStyle(Font.BOLD);
				        columna2.getFont().setSize(10);
				        tabla.addCell(columna2);

				        Paragraph columna3 = new Paragraph("Fecha de inscripcion");
				        columna3.getFont().setStyle(Font.BOLD);
				        columna3.getFont().setSize(10);
				        tabla.addCell(columna3);

				        Paragraph columna4 = new Paragraph("Estado");
				        columna4.getFont().setStyle(Font.BOLD);
				        columna4.getFont().setSize(10);
				        tabla.addCell(columna4);

				        Paragraph columna5 = new Paragraph("Nota");
				        columna5.getFont().setStyle(Font.BOLD);
				        columna5.getFont().setSize(10);
				        tabla.addCell(columna5);
			    		for(InscripcionCurso ic:listInsCurso)
			    		{
			    			tabla.addCell( ic.getCurso().getNombre());
			    			tabla.addCell(ic.getCurso().getDescripcion());
			    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			    			String fechaComoCadena = sdf.format( ic.getFechainscripcion());
			    			tabla.addCell(fechaComoCadena);
			    			tabla.addCell(ic.getEstado());
			    			tabla.addCell(String.valueOf(ic.getNota()));
			    		}
			    	}
			        else
			        {
				         Paragraph sin=new Paragraph("No posee ninguna inscripcion actual");
				         document.add(sin);
			        }
			        document.add(tabla);
			        document.add( Chunk.NEWLINE );
			        Paragraph titulo3=new Paragraph("Inscripciones actuales a carrera");
			        titulo3.getFont().setStyle(Font.BOLD);
			        titulo3.getFont().setSize(14);
			        document.add(titulo3);
			        document.add( Chunk.NEWLINE );
			        PdfPTable tabla2 = new PdfPTable(3);
			        if(listInsCar.isEmpty()==false)
			        {
			           	Paragraph col1 = new Paragraph("Carrera");
			          	col1.getFont().setStyle(Font.BOLD);
			           	col1.getFont().setSize(10);
					    tabla2.addCell(col1);
					        
					    Paragraph col2 = new Paragraph("Fecha de inscripcion");
					    col2.getFont().setStyle(Font.BOLD);
					    col2.getFont().setSize(10);
					    tabla2.addCell(col2);
					      
					      
					    Paragraph coll22 = new Paragraph("Promedio de cursos aprobados");
					    coll22.getFont().setStyle(Font.BOLD);
					    coll22.getFont().setSize(10);
					    tabla2.addCell(coll22);
					       
					        
			          	for(InscripcionCarrera icc:listInsCar)
			           	{
			           		 tabla2.addCell( icc.getCarrera().getNombre());
			    			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			    			 String fechaComoCadena = sdf.format(icc.getFechainscripcion());
			    			 tabla2.addCell(fechaComoCadena);
			    			 int prom= cica.getProm(al, icc.getCarrera());
			    			 tabla2.addCell(String.valueOf(prom));
			           	}	       	
			    	}
			        else
			        {
				         Paragraph sin=new Paragraph("No posee ninguna inscripcion actual");
				         document.add(sin);
			        }
			        document.add(tabla2);
			        document.add( Chunk.NEWLINE );
			        Paragraph titulo4=new Paragraph("Cursos anteriores");
			        titulo4.getFont().setStyle(Font.BOLD);
			        titulo4.getFont().setSize(14);
			        document.add(titulo4);
			        document.add( Chunk.NEWLINE );
			        PdfPTable tabla3 = new PdfPTable(3);
			        if(listaEstado.isEmpty()==false)
			        {
			          	Paragraph colu1 = new Paragraph("Curso");
			           	colu1.getFont().setStyle(Font.BOLD);
			           	colu1.getFont().setSize(10);
					    tabla3.addCell(colu1);
					        
					    Paragraph colu2 = new Paragraph("Fecha de inscripcion");
					    colu2.getFont().setStyle(Font.BOLD);
					    colu2.getFont().setSize(10);
					    tabla3.addCell(colu2);
					        
					          
					     Paragraph colu3 = new Paragraph("Estado");
					     colu3.getFont().setStyle(Font.BOLD);
					     colu3.getFont().setSize(10);
					     tabla3.addCell(colu3);
					   	for(InscripcionCurso insc:listaEstado)
					   	{
					 		 tabla3.addCell( insc.getCurso().getNombre());
			    			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			    			 String fechaComoCadena1 = sdf.format(insc.getFechainscripcion());
			    			 tabla3.addCell(fechaComoCadena1);
			    			 tabla3.addCell(insc.getEstado());
					   	}
			         }
			         else
			         {
			           	  Paragraph sin=new Paragraph("No posee ninguna inscripcion actual");
					      document.add(sin);
			         }
			         document.add(tabla3);
			         document.close();
		        }
			    catch (DocumentException exc)
				{
			         throw new IOException(exc.getMessage());
			    }
			    finally 
			    {            
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
