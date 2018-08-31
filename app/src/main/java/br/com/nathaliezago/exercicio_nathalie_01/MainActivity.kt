package br.com.nathaliezago.exercicio_nathalie_01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.nathaliezago.exercicio_nathalie_01.api.GitHubService
import br.com.nathaliezago.exercicio_nathalie_01.model.UsuarioClass
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //chamar o serviço pelo botão
        btPesquisar.setOnClickListener{
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            //indicar quem é o botao
            val service = retrofit.create(GitHubService::class.java)
            service.buscarUsuario(etUsuario.text.toString())
                    //quando digitar object, dê alt+enter
                    .enqueue(object :Callback<UsuarioClass>{
                        override fun onFailure(call: Call<UsuarioClass>?, t: Throwable?) {
                            Toast.makeText(this@MainActivity, "NÃO DEU", Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(call: Call<UsuarioClass>?, response: Response<UsuarioClass>?) {
                            val usuario = response?.body()
                            Picasso.get()
                                    .load(usuario?.avatarUrl)
                                    .into(ivBonecoAndroid)
                            tvUsuario.text = usuario?.nome
                        }

                    })
        }
    }
}
