package com.saturnus.mymanagementgudang.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.saturnus.mymanagementgudang.R
import com.saturnus.mymanagementgudang.models.Transaksi

class ListJenisTransaksiAdapter (private val items: List<Transaksi>)
    : RecyclerView.Adapter<ListJenisTransaksiAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var namaTransaksi: TextView = itemView.findViewById(R.id.namaTransaksi)
        var jenisTransaksi: TextView = itemView.findViewById(R.id.jenisTransaksi)
        var gambarJenisTransasksi: ImageView = itemView.findViewById(R.id.gambarJenisTransaksi)
        var btnHapus: Button = itemView.findViewById(R.id.btnHapus)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListJenisTransaksiAdapter.ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_transaksi, parent, false)
        return ListViewHolder(view)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Transaksi, index: Int)
    }

    override fun onBindViewHolder(holder: ListJenisTransaksiAdapter.ListViewHolder, position: Int) {
        val buah = items[position]

        holder.gambarJenisTransasksi.setImageResource(buah.image)
        holder.namaTransaksi.text = buah.namaTransaksi + " (RP." + buah.harga + ")"
        holder.jenisTransaksi.text = buah.jenisTransaksi.toString()

        holder.btnHapus.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(holder.itemView.context)
            alertDialogBuilder.setTitle("Perhatian")
            alertDialogBuilder.setMessage("Apakah anda yakin ingin menghapus data ini ? ")

            alertDialogBuilder.setPositiveButton("Ya") {
                    dialog, which ->
                Toast.makeText(holder.itemView.context, "Maaf fitur belum jadi", Toast.LENGTH_SHORT).show()
            }
            alertDialogBuilder.setNegativeButton("Tidak") {
                    dialog, which ->
                Toast.makeText(holder.itemView.context, "Maaf fitur belum jadi", Toast.LENGTH_SHORT).show()
            }
            alertDialogBuilder.show()
        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(items[holder.adapterPosition], position)
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount(): Int {
        return items.size
    }
}