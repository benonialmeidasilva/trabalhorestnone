package crud;

import br.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Benoni
 */
public class ListaCliente {
    
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    
    
    public static void addCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public static void removerCliente(Cliente c){
        listaClientes.remove(listaClientes.indexOf(c));
    }
    public static void editarCliente(Cliente c){
        listaClientes.set(listaClientes.indexOf(c), c);
    }
    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    public static void setListaClientes(ArrayList<Cliente> listaClientes) {
        ListaCliente.listaClientes = listaClientes;
    }
    
}
