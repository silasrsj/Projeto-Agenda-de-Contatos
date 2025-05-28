package org.example.model;

public class Contato {
    private String telefone;
    private String email;
    private Pessoa pessoa;

    public Contato(String telefone, String email, Pessoa pessoa) {
        this.telefone = telefone;
        this.email = email;
        this.pessoa = pessoa;
    }

    public Contato() {

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Nome: " + getPessoa().getNome() + "\n" +
                "Idade: " + getPessoa().getIdade() + "\n" +
                "Sexo: " + getPessoa().getSexo() + "\n" +
                "Data de Nascimento: " + getPessoa().getDataNascimento() + "\n" +

                "Telefone: " + getTelefone() + "\n" +
                "Email: " + getEmail() + "\n" +

                "Bairro: " + getPessoa().getEndereco().getBairro() + "\n" +
                "Rua: " + getPessoa().getEndereco().getRua() + "\n" +
                "Número: " + getPessoa().getEndereco().getNumero() + "\n" +
                "Cidade: " + getPessoa().getEndereco().getCidade() + "\n" +
                "Estado: " + getPessoa().getEndereco().getEstado() + "\n" +
                "Complemento: " + getPessoa().getEndereco().getCoplemento() + "\n";
    }
}
