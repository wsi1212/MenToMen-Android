package kr.hs.b1nd.intern.mentomen.viewmodel

<<<<<<< HEAD:app/src/main/java/kr/hs/b1nd/intern/mentomen/viewmodel/MainViewModel.kt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.b1nd.intern.mentomen.util.SingleLiveEvent

class MainViewModel : ViewModel() {
=======
import android.content.Intent
import android.util.Log
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.b1nd.intern.mentomen.network.RetrofitClient
import kr.hs.b1nd.intern.mentomen.network.base.BaseResponse
import kr.hs.b1nd.intern.mentomen.network.model.Post
import kr.hs.b1nd.intern.mentomen.network.model.PostSubmitDto
import retrofit2.Call
import retrofit2.Response
>>>>>>> #10_post_network:app/src/main/java/kr/hs/b1nd/intern/mentomen/viewmodel/AddViewModel.kt


class AddViewModel(callBack: AddCallBack) : ViewModel() {
    val callBack = callBack
    val content = MutableLiveData<String>()
    interface AddCallBack{
        fun onClickImage()
    }
    fun onClickPost() {
        /*val call = RetrofitClient.postService.submitPost( PostSubmitDto(content.value ?: ""))

        call.enqueue(object : retrofit2.Callback<BaseResponse<List<Post>>> {
            override fun onResponse(call: Call<BaseResponse<List<Post>>>, response: Response<BaseResponse<List<Post>>>) {
                if (response.isSuccessful) {
                    itemList.value = response.body()?.data ?: emptyList()
                }
            }

            override fun onFailure(call: Call<BaseResponse<List<Post>>>, t: Throwable) {

            }

        })*/
    }
    fun onClickImage(){
        callBack.onClickImage()

    }
}