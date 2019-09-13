package br.bean;

import br.model.Cidade;
import br.model.Cliente;
import br.restClientes.RestCidade;
import crud.ListaCliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;

/**
 *
 * @author Benoni
 */
@Named(value = "mBeanCliente")
@SessionScoped
public class MBeanCliente implements Serializable{
    
    private List<Cliente> clientes;
    private List<Cidade> cidades;
    private Cliente clienteSelecionado;
    private int codCli;
    private String nomeCli;
    private int codCidade;
    private int opcao;
    
    
    
    public MBeanCliente() {
        try{
            RestCidade rc = new RestCidade();
            cidades = rc.getAll();
            rc.close();
        }
        catch(ClientErrorException e){
            cidades = new ArrayList<Cidade>();
            System.out.println("Pode ser que o web service das cidades está fora do ar!");
        }
        clientes = ListaCliente.listaClientes;
        clienteSelecionado = new Cliente();
        opcao = 0; //cadastrndo novo
    }
    
    
    
    public void salvar(){
        if(opcao == 0){ //cadastrando novo
            clienteSelecionado = new Cliente();
        }
        for(Cidade cid: cidades){
            if(cid.getCodigo() == codCidade){
                clienteSelecionado.setCidade(cid);
                break;
            }
        }
        clienteSelecionado.setCodigo(codCli);
        clienteSelecionado.setNome(nomeCli);
        if(opcao == 0){ //cadastrando novo
            new ListaCliente().addCliente(clienteSelecionado);
        }
        else{ //editando um existente
            new ListaCliente().editarCliente(clienteSelecionado);
        }
        clientes = ListaCliente.listaClientes;
        opcao = 0; //cadastrar novo
        codCli = 0;
        nomeCli = "";
        codCidade = 0;
    }
    
    public void alterarCliente(int codCli){
        for(Cliente cli: clientes){
            if(cli.getCodigo() == codCli){
                clienteSelecionado = cli;
                opcao = 1; //editar um cliente existente
                this.codCli = clienteSelecionado.getCodigo();
                nomeCli = clienteSelecionado.getNome();
                codCidade = clienteSelecionado.getCidade().getCodigo();
                break;
            }
        }
    }
    
    public void excluirCliente(int codCli){
        for(Cliente cli: clientes){
            if(cli.getCodigo() == codCli){
                clientes.remove(cli);
                new ListaCliente().removerCliente(codCli);
                break;
            }
        }
    }
    
    
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    public List<Cidade> getCidades() {
        return cidades;
    }
    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }
    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }
    public int getCodCidade() {
        return codCidade;
    }
    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }
    public int getCodCli() {
        return codCli;
    }
    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }
    public String getNomeCli() {
        return nomeCli;
    }
    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }
    
}
