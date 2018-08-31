package br.com.nathaliezago.exercicio_nathalie_01.api

import br.com.nathaliezago.exercicio_nathalie_01.model.UsuarioClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//criar interface com o serviço
interface GitHubService{
    @GET("/users/{username}")
    fun buscarUsuario(@Path("username") username:String):Call<UsuarioClass>

}