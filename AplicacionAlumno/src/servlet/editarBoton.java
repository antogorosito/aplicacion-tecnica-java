package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editarBoton
 */
@WebServlet("/editarBoton")
public class editarBoton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editarBoton() {
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
		if(op.equals("editar"))
		{

			if(Integer.parseInt(request.getParameter("sel1"))!=0)
			{
				request.getRequestDispatcher("/editarAlumno.jsp").forward(request, response);	
			}
			else
			{
				request.getRequestDispatcher("/editar.jsp").forward(request, response);	
			}	
			
		}
		if(op.equals("volver"))
		{
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		
		
	}

}
