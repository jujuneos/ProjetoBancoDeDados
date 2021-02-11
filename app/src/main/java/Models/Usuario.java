package Models;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    private String email;
    private String senha;
    private Date data_nascimento;

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

    @Override
    public String toString() {
        return "\nEmail: "
                + email
                + "\n";
    }
}
