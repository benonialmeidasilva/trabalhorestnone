package crud;

import br.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Benoni
 */
public class ListaCliente {
    
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    
    
    public void addCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public void removerCliente(Cliente c){
        listaClientes.remove(listaClientes.indexOf(c));
    }
    public void editarCliente(Cliente c){
        listaClientes.set(listaClientes.indexOf(c), c);
    }
    public Cliente getClientePorCodigo(int codigo) {
        for(Cliente c: listaClientes){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        ListaCliente.listaClientes = listaClientes;
    }
    
}
