package ec.edu.ups.demoJakarta.business;

import java.util.List;

import ec.edu.ups.demoJakarta.dao.ClienteDAO;
import ec.edu.ups.demoJakarta.dao.DetalleFacturaDAO;
import ec.edu.ups.demoJakarta.dao.FacturaDAO;
import ec.edu.ups.demoJakarta.dao.ProductoDAO;
import ec.edu.ups.demoJakarta.model.Cliente;
import ec.edu.ups.demoJakarta.model.DetalleFactura;
import ec.edu.ups.demoJakarta.model.Factura;
import ec.edu.ups.demoJakarta.model.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	@Inject
	private ClienteDAO daoCliente;   //estoy trayendo del server, no tiene, me lo crea y devuelve y luego lo saca de la memoria por el Singleton
	
	@Inject
	private ProductoDAO daoProducto;
	
	@Inject
    private DetalleFacturaDAO daoDetalleFactura;
	
	@Inject
    private FacturaDAO daoFactura;
	
	@PostConstruct
	public void init() {
		
		System.out.println("Hola Mundo EJB");
		
		
		Cliente cliente  = new Cliente();
		cliente.setCedula("0106717671");
		cliente.setNombre("Tania Lojano");
		cliente.setDireccion("Cuenca");
		
		daoCliente.insert(cliente);
		
		
		List<Cliente> listado = daoCliente.getAll();
		for(Cliente cli: listado) {
			System.err.println(cli.getCedula() + " " + cli.getNombre()+ " " + cli.getDireccion());
		}
		
		
		Producto producto=new Producto();
		producto.setId(1);
		producto.setPrecio(23.4);
		producto.setStock(3);
		
		daoProducto.insert(producto);
		
		List<Producto> listado1 = daoProducto.getAll();
		for(Producto pro: listado1) {
			System.err.println(pro.getId() + " " + pro.getPrecio()+ " " + pro.getStock());
		}
		
		
		 Factura factura = new Factura();
	     factura.setId(1);
	     factura.setFecha(null);
	     factura.setCliente(cliente);
	        
	     daoFactura.insert(factura);
	     
	     
	     List<Factura> listado2 = daoFactura.getAll();
	     for(Factura fac: listado2) {
	         Cliente cli = fac.getCliente();
	         System.err.println(fac.getId() + " " + fac.getFecha() + " " + cli.getCedula() + " " + cli.getNombre());
	     }

	     DetalleFactura detalle = new DetalleFactura();
	     detalle.setId(1);
	     detalle.setCantidad(12);
	     detalle.setPrecio(65.7);
	        
	     daoDetalleFactura.insert(detalle);
	     
	     List<DetalleFactura> listado3 = daoDetalleFactura.getAll();
	     for(DetalleFactura det: listado3) {
	         System.err.println(det.getId() + " " + det.getCantidad() + " " + det.getPrecio());
	     }
	     
	}

}
