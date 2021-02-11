package Models;

import java.io.Serializable;
import java.util.Date;

import Models.Usuario;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String senha;
    private Date data_nascimento;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String senha, Date data_nascimento) {
        this.email = email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
    }

    public UsuarioDTO(Usuario entity) {
        email = entity.getEmail();
        senha = entity.getSenha();
        data_nascimento = entity.getData_nascimento();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

}