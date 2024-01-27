package com.cis.itilab2


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cis.itilab2.databinding.ActivityMainBinding
import com.cis.itilab2.model.AnswerData
import com.cis.itilab2.model.RetrofitConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnsave=binding.btnsave
        btnsave.setOnClickListener {
            val teacheranswer=binding.teacheranswer.text.toString()
            val studentanswer=binding.studentanswer.text.toString()
            val answerdata=AnswerData(teacheranswer,studentanswer)
            val coroutinScope=CoroutineScope(Dispatchers.Main)
            coroutinScope.launch {
                val response=RetrofitConfig.getServiceInstance().getAnswerLabel(answerdata)
                if (response.isSuccessful){
                    val bodyresponse=response.body()
                    binding.textview2.text=answerdata.model_answer
                    binding.textview.text=bodyresponse?.label
                }

            }
//            if (response!!.isSuccessful){
//                val responsedata = response?.body()
//                val data=responsedata?.data
//                Toast.makeText(this, "${data?.get(0)}",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(this,"there are a problem",Toast.LENGTH_LONG).show()
//            }
       }

    }


}

