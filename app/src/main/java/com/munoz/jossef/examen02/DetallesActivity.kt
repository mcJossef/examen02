package com.munoz.jossef.examen02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.munoz.jossef.examen02.databinding.ActivityDetallesBinding

class DetallesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetallesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)
        binding = ActivityDetallesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerComponentUi()

        intent.extras?.let {
            showData(it)
        }
    }
    private fun listenerComponentUi() {
        binding.btnWSP.setOnClickListener {
            WSP()
        }
        binding.btnTelefono.setOnClickListener {
            Llamar()
        }
        binding.btnGPS.setOnClickListener {
            openGoogleMaps()
        }
    }
    private fun showData(paraExtras:Bundle){
        val FullName = paraExtras.getString(Nombre_key)
        val Celular = paraExtras.getString(Celular_key)
        val Productos = paraExtras.getString(Productos_key)
        val Ciudad = paraExtras.getString(Ciudad_key)
        val Direccion = paraExtras.getString(Direccion_key)

        val ubicacion = "$Ciudad, $Direccion"
        binding.tvIdDireccion.text = ubicacion

        binding.tvFullName.text = FullName
        binding.tvIdCodigo.text = Celular
        binding.tvIdProductos.text = Productos
    }
    private fun WSP() {
        val phoneNumber = binding.btnWSP.toString().trim()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$phoneNumber")
        startActivity(intent)
    }
    private fun Llamar() {
        val phoneNumber = binding.btnTelefono.toString().trim()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+51$phoneNumber")
        startActivity(intent)}

    private fun openGoogleMaps() {
        val address = "${binding.tvIdDireccion.text}"
        val geoUri = "http://maps.google.com/maps?q=$address"
        val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
        startActivity(mapIntent)
    }

}