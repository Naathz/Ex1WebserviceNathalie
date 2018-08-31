package br.com.nathaliezago.exercicio_nathalie_01.model

import com.google.gson.annotations.SerializedName

//indicar a representação de dados
data class UsuarioClass(
        @SerializedName("name") val nome:String,
        @SerializedName("avatar_url") val avatarUrl:String
)