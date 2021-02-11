package Controllers;

import java.util.List;

import Models.Usuario;
import Models.UsuarioDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Urls {

    @GET("/users")
    Call<List<Usuario>> getUsers();

    @POST("/insert")
    Call<Boolean> inserirUsuario(@Body UsuarioDTO user);

}