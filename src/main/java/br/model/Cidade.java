package br.model;

import br.alerario.ICidade;
import java.io.Serializable;

/**
 *
 * @author Benoni
 */
public class Cidade implements Serializable {
    
    private int codigo;
    private String nome;
    
    
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
