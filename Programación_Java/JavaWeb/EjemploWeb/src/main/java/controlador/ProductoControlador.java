package controlador;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dao.ProductoDAO;
import modelo.Departamento;
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
		ProductoDAO productoDAO = new ProductoDAO();
		if(opcion == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/index.jsp");
	        requestDispatcher.forward(request, response);
		}
		if(opcion.equalsIgnoreCase("inicio")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/index.jsp");
	        requestDispatcher.forward(request, response);
		}
		if(opcion.equalsIgnoreCase("crearTabla")) {
			if(productoDAO.createTable()) {
				System.out.println("Tabla PRODUCTO creada correctamente");
				request.setAttribute("mensaje", "producto INSERTADO correctamente");
			}
			// Despues vuelve al indice gracias a esto
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/index.jsp");
	        requestDispatcher.forward(request, response);
		} else if(opcion.equalsIgnoreCase("consultar")) {
			ArrayList<Producto> productos = productoDAO.consultarProducto();
			for(Producto p : productos) {
				System.out.println(p);
			}
			request.setAttribute("productos", productos);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/consultar2.jsp");
	        requestDispatcher.forward(request, response);
		} else if(opcion.equalsIgnoreCase("editar")) {
			int idProducto = Integer.parseInt(request.getParameter("idProducto"));
			Producto p = productoDAO.consultarProducto(idProducto);
			System.out.println(p);
			if(p != null) {
				request.setAttribute("producto", p);
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/editar.jsp");
	        requestDispatcher.forward(request, response);
		} else if(opcion.equalsIgnoreCase("eliminar")) {
			int idProducto = Integer.parseInt(request.getParameter("idProducto"));
			productoDAO.eliminarProducto(idProducto);
			System.out.println("Producto con ID "+ idProducto +" correctamente");
			request.setAttribute("mensaje", "Producto con ID "+ idProducto +" correctamente");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/index.jsp");
	        requestDispatcher.forward(request, response);
		} else if(opcion.equalsIgnoreCase("peticionWeb")) {
			HttpClient cliente = HttpClient.newHttpClient();
			HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create("http://info.empresa.dam.es:8055/items/departamentos")).GET().build();
			try {
				HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
				String respuestaString = respuesta.body();
				System.out.println(respuestaString);
				ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
				Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
				JsonObject jsonParser = JsonParser.parseString(respuestaString).getAsJsonObject();
				JsonArray jsonArray = jsonParser.getAsJsonArray("data");
				int id;
				String nombre, descripcion;
				for(JsonElement json : jsonArray) {
					JsonObject jsonObject = json.getAsJsonObject();
					id = jsonObject.get("id").getAsInt();
					nombre = jsonObject.get("nombre").getAsString();
					descripcion = jsonObject.get("descripcion").getAsString();
					departamentos.add(new Departamento(id, nombre, descripcion));
				}
				System.out.println(departamentos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		productoDAO.getConexion().cerrarConexion();
		
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
		} else if(opcion.equalsIgnoreCase("editar")) {
			ProductoDAO productoDAO = new ProductoDAO();
			Producto producto = new Producto();
			
			producto.setIdProducto(Integer.valueOf(request.getParameter("idProducto")));
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Integer.valueOf(request.getParameter("cantidad")));
			producto.setPrecio(Double.valueOf(request.getParameter("precio")));
			producto.setFechaActualizacion(new java.sql.Date(fechaActual.getTime()));
			
			if(productoDAO.editarProducto(producto)) {
				System.out.println("Producto con ID "+ producto.getIdProducto() +" Actualizado con éxito");
				request.setAttribute("mensaje", "Producto con ID "+ producto.getIdProducto() +" Actualizado con éxito");
			} else {
				System.out.println("ERROR al actualizar el producto " + producto.getIdProducto());
				request.setAttribute("mensaje", "ERROR al actualizar el producto " + producto.getIdProducto());
			}
			
			productoDAO.getConexion().cerrarConexion();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/index.jsp");
            requestDispatcher.forward(request, response);
		}
	}

}
