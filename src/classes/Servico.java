/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author fekwa
 */
public class Servico {
    
    private int idServico;
    private int idEmpresa;
    private String PrestadorServico;
    private int idPrestador;
    private String Horario;
    private String Data;
    private String Descricao;
    private int CpfCliente;
    private String Endereco;
    private String Cidade;
    private String Estado;
    private String nomeEmpresa;
    private String trabalho;
    private String nomePrestador;

    public Servico() {
        this.idEmpresa = 0;
        this.PrestadorServico = "";
        this.idServico = 0;
        this.Horario = "";
        this.Data = "";
        this.Descricao = "";
        this.idServico = 0;
        this.CpfCliente = 0 ;
        this.Endereco = "";
        this.Cidade = "";
        this.Estado = "";
        this.idPrestador = 0;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getPrestadorServico() {
        return PrestadorServico;
    }

    public void setPrestadorServico(String PrestadorServico) {
        this.PrestadorServico = PrestadorServico;
    }

    public int getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(int idPrestador) {
        this.idPrestador = idPrestador;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getCpfCliente() {
        return CpfCliente;
    }

    public void setCpfCliente(int CpfCliente) {
        this.CpfCliente = CpfCliente;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(String trabalho) {
        this.trabalho = trabalho;
    }

    public String getNomePrestador() {
        return nomePrestador;
    }

    public void setNomePrestador(String nomePrestador) {
        this.nomePrestador = nomePrestador;
    }

    
    
    
    
    
    
    
}
