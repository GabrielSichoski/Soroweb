
package classes;


public class Empresa{
    
    private String nome;
    private String CNPJ;
    private String endereco;
    private String cidade;
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empresa(String nome, String CNPJ,String endereco, String cidade, String estado) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    
    public void limpaEmpresa(){
    this.setNome("");
    this.setCNPJ("");
    this.setEndereco("");
    this.setCidade("");
    this.setEstado("");
    }

    public Empresa() {
    }
    
    
}
