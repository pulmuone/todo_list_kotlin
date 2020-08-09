package com.example.todo_list_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.todo_list_kotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //val mainViewModel : MainViewModel by viewModels();
    val mainViewModel  by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //ActivityMainBinding 이 값은 xml화면에서  <data> 값을 입력하고 Make Project하면 생성된다.
        //생성이름 규칙은  xml화면 이름 뒤에 Binding이 붙는다.
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this //LiveData를 사용하기 위해선
        binding.viewModel = mainViewModel

        //Binding으로 변경
//        mainViewModel.getAll().observe(this, Observer {
//            result_text.text = it.toString()
//        })
        
        //Binding으로 변경
//        add_button.setOnClickListener {
//            //lifecycleScope은 Activity에서 비동기(코루틴)사용
//            //lifecycleScope.launch(Dispatchers.IO) {
//                mainViewModel.insert(Todo(todo_edit.text.toString()))
//            //}
//        }
    }
}