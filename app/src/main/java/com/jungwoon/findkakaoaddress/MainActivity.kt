package com.jungwoon.findkakaoaddress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.jungwoon.findkakaoaddress.AddressActivity.Companion.ADDRESS_REQUEST_CODE

class MainActivity : AppCompatActivity() {

    private val button: Button by lazy {
        findViewById(R.id.button)
    }

    private val address: TextView by lazy {
        findViewById(R.id.address)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 버튼을 누르면 AddressActivity를 띄워주는 부분
        button.setOnClickListener {
            Intent(this, AddressActivity::class.java).apply {
                startActivityForResult(this, ADDRESS_REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            ADDRESS_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    // 주소를 가져와서 보여주는 부분
                    val addressData = data?.extras?.getString("address")
                    address.text = addressData
                }
            }
        }
    }
}