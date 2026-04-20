package controlador;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductoDAO;
import modelo.Producto;

/**
 * Servlet implementation class ProductoControlador
 */
@WebServlet("/ProductoControlador")
public class ProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String opcion = request.getParameter("opcion");
		if(opcion.equalsIgnoreCase("crearTabla")) {
			ProductoDAO productoDAO = new ProductoDAO();
			if(productoDAO.createTable()) {
				System.out.println("Tabla PRODUCTO creada correctamente");
				request.setAttribute("mensaje", "producto INSERTADO correctamente");
			}
			productoDAO.getConexion().cerrarConexion();
			// Despues vuelve al indice gracias a esto
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/index.jsp");
            requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String opcion = request.getParameter("opcion");
		Date fechaActual = new Date();
		
		if(opcion.equalsIgnoreCase("insertar")) {
			ProductoDAO productoDAO = new ProductoDAO();
			Producto producto = new Producto();
			
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Integer.valueOf(request.getParameter("cantidad")));
			producto.setPrecio(Double.valueOf(request.getParameter("precio")));
			producto.setFechaCreacion(new java.sql.Date(fechaActual.getTime()));
			
			if(productoDAO.insertProducto(producto)) {
				System.out.println("Producto INSERTADO CORRECTAMENTE");
				request.setAttribute("mensaje", "producto INSERTADO correctamente");
			} else {
				System.out.println("ERROR al insertar producto");
				request.setAttribute("mensaje", "ERROR al insertar producto");
			}
			productoDAO.getConexion().cerrarConexion();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/index.jsp");
            requestDispatcher.forward(request, response);
		}
	}

}
