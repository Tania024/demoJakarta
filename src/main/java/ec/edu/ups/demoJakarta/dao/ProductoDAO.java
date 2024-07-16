package ec.edu.ups.demoJakarta.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demoJakarta.model.Cliente;
import ec.edu.ups.demoJakarta.model.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class ProductoDAO implements Serializable {
	@PersistenceContext
    private EntityManager em;

    public void insert(Producto producto) {
        try {
            em.persist(producto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Producto producto) {
        try {
            em.merge(producto);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    
    public void remove(int pro_id) {
        try {
        	Producto producto = em.find(Producto.class, pro_id);
            if (producto != null) {
                em.remove(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    public Producto read(int pro_id) {
        try {
            return em.find(Producto.class, pro_id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    
    public List<Producto> getAll(){
		
		String jpql = "SELECT p FROM Producto p"; // solo importa el nombre de la entidades/ de la clase. Si importa mayusculas y minusculas
		Query query = em.createQuery(jpql, Producto.class);  
		return query.getResultList();  //devuelve la lista de clientes
	}


}
