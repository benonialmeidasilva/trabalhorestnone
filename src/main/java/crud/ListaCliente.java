package crud;

import br.model.Cliente;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Benoni
 */
public class ListaCliente implements Serializable{
    
    public static ArrayList<Cliente> listaClientes;
    
    static{
        listaClientes = new ArrayList<Cliente>();
    }
    
    public void addCliente(Cliente c){
        ListaCliente.listaClientes.add(c);
    }
    
    public void removerCliente(int cod){
        //ListaCliente.listaClientes.remove(ListaCliente.listaClientes.indexOf(c));
        Cliente c;
        for(int i = 0; i < ListaCliente.listaClientes.size(); i++){
            c = ListaCliente.listaClientes.get(i);
            if(c != null){
                if(c.getCodigo() == cod){
                    ListaCliente.listaClientes.remove(i);
                    break;
                }
            }
        }
    }
    
    public void editarCliente(Cliente c){
        //ListaCliente.listaClientes.set(ListaCliente.listaClientes.indexOf(c), c);
        Cliente cli;
        for(int i = 0; i < ListaCliente.listaClientes.size(); i++){
            cli = ListaCliente.listaClientes.get(i);
            if(cli != null){
                if(cli.getCodigo() == c.getCodigo()){
                    ListaCliente.listaClientes.set(i, c);
                    break;
                }
            }
        }
    }
    
    public Cliente getClientePorCodigo(int codigo) {
        for(Cliente c: ListaCliente.listaClientes){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }
    
    public ArrayList<Cliente> getListaClientes() {
        return ListaCliente.listaClientes;
    }
    
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        ListaCliente.listaClientes = listaClientes;
    }
    
}
