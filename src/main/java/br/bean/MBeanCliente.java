package br.bean;

import br.model.Cidade;
import br.model.Cliente;
import br.restClientes.RestCidade;
import crud.ListaCliente;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Benoni
 */
@Named(value = "mBeanCliente")
@ViewScoped
public class MBeanCliente implements Serializable{
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Cidade> cidades;
    
    
    public MBeanCliente() {
        //clientes = new ListaCliente().getListaClientes() ;
        //cidades = new RestCidade().get(responseType, id);
    }
    
}
