package com.saturnus.mymanagementgudang.tabs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saturnus.mymanagementgudang.DetailTransaksiActivity
import com.saturnus.mymanagementgudang.R
import com.saturnus.mymanagementgudang.adapter.ListJenisTransaksiAdapter
import com.saturnus.mymanagementgudang.models.Transaksi

class TabHome : Fragment(){
    private lateinit var rvTransaksi: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_tab_home, container, false)
        rvTransaksi = view.findViewById(R.id.list_transaksi)

        var itemsJenisTransaksi: ArrayList<Transaksi> = arrayListOf<Transaksi>(
            Transaksi(image = R.drawable.personal, jenisTransaksi = "Barang Elektronik", namaTransaksi = "Laptop", harga = "20000000"),
            Transaksi(image = R.drawable.electronik, jenisTransaksi = "Barang Alat Rumah Tangga", namaTransaksi = "Kulkas", harga = "1500000"),
            Transaksi(image = R.drawable.food, jenisTransaksi = "Makanan dan Minuman", namaTransaksi = "Kopi Kapal Api Special 380gram", harga = "30000")
        )

        rvTransaksi.setHasFixedSize(true)
        rvTransaksi.layoutManager = LinearLayoutManager( view.context)
        val listBuahAdapter = ListJenisTransaksiAdapter(itemsJenisTransaksi)
        rvTransaksi.adapter = listBuahAdapter

        listBuahAdapter.setOnItemClickCallback(object: ListJenisTransaksiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Transaksi, index: Int) {
                val detailIntent = Intent(view.context, DetailTransaksiActivity::class.java)
                detailIntent.putExtra("jenis_transaksi", itemsJenisTransaksi[index].jenisTransaksi)
                detailIntent.putExtra("nama_transaksi", itemsJenisTransaksi[index].namaTransaksi)
                detailIntent.putExtra("harga", itemsJenisTransaksi[index].harga)
                detailIntent.putExtra("image", itemsJenisTransaksi[index].image)
                startActivity(detailIntent)
            }
        } )

        return view
    }
}