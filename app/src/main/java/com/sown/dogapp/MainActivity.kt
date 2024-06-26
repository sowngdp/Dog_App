package com.sown.dogapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.ui.tooling.preview.Preview
import com.sown.dogapp.models.DogBreed
import com.sown.dogapp.viewModels.DogsApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lấy danh sách chó
        DogsApiService.getDogs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ dogsList ->
                // Duyệt qua danh sách và in ra tên của mỗi con chó
                for (dog in dogsList) {
                    Log.d(TAG, "Tên chó: ${dog.name}")
                }
            }, { error ->
                Log.e(TAG, "Lỗi khi tải dữ liệu: ", error)
            })

    }
}



