/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author fekwa
 */
public class Funcionario {
    
    
    String nome;
    String rg;
    String email;
    String telefone;
    String endereco;
    String cargo;
    String senha;
    String sexo;
    String cpf;
    String salario;
    String estado_civil;

    public Funcionario() {
        this.nome = "";
        this.rg = "";
        this.email = "";
        this.telefone = "";
        this.endereco = "";
        this.cargo = "";
        this.senha = "";
        this.sexo = "";
        this.cpf = "";
        this.salario ="";
        this.estado_civil = "";
    }
    
    
    /*idFuncionario int primary key auto_increment,
    nome varchar(90) unique,
    rg int,
    email varchar(90),
    telefone int,
    endereco varchar(90),
    cargo varchar(90),
    senha varchar(60),
    sexo varchar(10),
    cpf int,
    salario float,
    estado_civil varchar(90)*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
}
