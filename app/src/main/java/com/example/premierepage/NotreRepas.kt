package com.example.premierepage

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.premierepage.model.RecetteX
import com.example.premierepage.model.Repa
import com.example.premierepage.view.NotreRepasAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotreRepas : Fragment(R.layout.activity_notre_repas) {
    private var retrofitInterface: RetrofitInterface? = null
    var myshared: SharedPreferences?=null
    private lateinit var recv: RecyclerView
    @SuppressLint("UseRequireInsteadOfGet", "NotifyDataSetChanged")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recv = view!!.findViewById(R.id.repasRecycler)

        val retrofit = RetrofitClient.getInstance()
        retrofitInterface = retrofit.create(RetrofitInterface::class.java)
        val map = HashMap<String?, String?>()
        map["typeRepas"] ="1"
        getRepas(map)

    }
    fun getRepas(map: java.util.HashMap<String?, String?>?){
        //5edmet l affichage mte3 les aliments
        val call = retrofitInterface!!.executeAllRepas(map)
        call.enqueue(object : Callback<MutableList<RecetteX>> {
            override fun onResponse(call: Call<MutableList<RecetteX>>, response: Response<MutableList<RecetteX>>) {
                if (response.code()==200){
                    var listRepas=response.body()!!
                    recv.apply {
                        recv.layoutManager = LinearLayoutManager(activity)
                        adapter= NotreRepasAdapter(context,listRepas,object: NotreRepasAdapter.onItemClickListener{
                            override fun onItemClick(position: Int) {
                                val i = Intent(context,Breakfast1::class.java)
                                i.putExtra("nomRepas",listRepas.get(position).nomRecette)
                                i.putExtra("idRepas",listRepas.get(position)._id)
                                i.putExtra("calories",listRepas.get(position).calories)
                                startActivity(i)
                            }
                        })
                    }
                }else if (response.code()==400){

                }
            }
            override fun onFailure(call: Call<MutableList<RecetteX>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        return inflater.inflate(R.layout.activity_notre_repas,container,false)
    }


}