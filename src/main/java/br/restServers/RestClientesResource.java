package br.restServers;

import br.model.Cliente;
import crud.ListaCliente;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Benoni
 */
@Path("restClientes")
public class RestClientesResource implements Serializable{

    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> get() {
        return new ListaCliente().getListaClientes();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    @Path("/{id}")
    public Cliente getPorCodigo(@PathParam("id") int codigo) {
        Cliente c = new ListaCliente().getClientePorCodigo(codigo);
        return c;
    }

    @POST    
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(String xml) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Cliente cliente = objectMapper.readValue(xml, Cliente.class);
            new ListaCliente().addCliente(cliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @PUT    
    @Consumes(MediaType.APPLICATION_JSON)
    public void putXML(String xml) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Cliente cliente = objectMapper.readValue(xml, Cliente.class);
            new ListaCliente().editarCliente(cliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON) 
    @Path("/{id}")
    public void delete(@PathParam("id") int codigo) {
        ListaCliente clientes = new ListaCliente();
        clientes.removerCliente(clientes.getClientePorCodigo(codigo));
    }
}
