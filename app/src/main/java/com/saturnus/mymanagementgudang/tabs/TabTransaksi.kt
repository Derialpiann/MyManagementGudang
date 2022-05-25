package com.saturnus.mymanagementgudang.tabs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.saturnus.mymanagementgudang.FormActivity
import com.saturnus.mymanagementgudang.R

class TabTransaksi : Fragment(){
    private lateinit var btnTambah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_tab_transaksi, container, false)
        btnTambah = view.findViewById(R.id.btnTambah)
        btnTambah.setOnClickListener {
            val formIntent = Intent(view.context, FormActivity::class.java)
            startActivity(formIntent)
        }

        return view
    }
}