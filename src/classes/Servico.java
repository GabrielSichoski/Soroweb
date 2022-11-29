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
    
    
    private String Empresa;
    private String PrestadorServico;
    private int idPrestador;
    private String Servico;
    private String Horario;
    private String Data;
    private String Descricao;
    private String NumeroServico;
    private String NomeCliente;
    private String Endereco;
    private String Cidade;
    private String Estado;

    public Servico() {
        this.Empresa = "";
        this.PrestadorServico = "";
        this.Servico = "";
        this.Horario = "";
        this.Data = "";
        this.Descricao = "";
        this.NumeroServico = "";
        this.NomeCliente = "";
        this.Endereco = "";
        this.Cidade = "";
        this.Estado = "";
        this.idPrestador = 0;
        
    }

    public int getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(int idPrestador) {
        this.idPrestador = idPrestador;
    }

    
    
    public void limpaServico(){
        this.Empresa = "";
        this.PrestadorServico = "";
        this.Servico = "";
        this.Horario = "";
        this.Data = "";
        this.Descricao = "";
        this.NumeroServico = "";
        this.NomeCliente = "";
        this.Endereco = "";
        this.Cidade = "";
        this.Estado = "";
        this.idPrestador = 0;
    }
    
    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getPrestadorServico() {
        return PrestadorServico;
    }

    public void setPrestadorServico(String PrestadorServico) {
        this.PrestadorServico = PrestadorServico;
    }

    public String getServico() {
        return Servico;
    }

    public void setServico(String servico) {
        this.Servico = servico;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        this.Horario = horario;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        this.Data = data;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getNumeroServico() {
        return NumeroServico;
    }

    public void setNumeroServico(String NumeroServico) {
        this.NumeroServico = NumeroServico;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
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
    
    
    
    
}
