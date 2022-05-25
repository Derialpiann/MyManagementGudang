package com.saturnus.mymanagementgudang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailTransaksiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_transaksi)
        title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}