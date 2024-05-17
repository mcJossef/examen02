package com.munoz.jossef.examen02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.munoz.jossef.examen02.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeComponents()
    }
    fun observeComponents() {
        binding.btnRegistrar.setOnClickListener {
            if (isEmptyInputs()) {
                Toast.makeText(this, "Hay algún campo vacío", Toast.LENGTH_SHORT).show()
            } else {
                goDetallesActivity()
            }
        }
    }
    private fun goDetallesActivity() {
        val Nombre = binding.FullName.text.toString()
        val Codigo= binding.IdNumero.text.toString()
        val Productos = binding.IdProductos.text.toString()
        val Ciudad = binding.IdCiudad.text.toString()
        val Direccion = binding.IdDireccion.text.toString()

        val intent = Intent(this, DetallesActivity::class.java)
        intent.putExtra(Nombre_key, Nombre)
        intent.putExtra(Celular_key, Codigo)
        intent.putExtra(Productos_key, Productos)
        intent.putExtra(Ciudad_key, Ciudad)
        intent.putExtra(Direccion_key, Direccion)
        startActivity(intent)

    }

    private fun isEmptyInputs(): Boolean {
        return binding.FullName.text.isEmpty() ||
                binding.IdNumero.text.isEmpty() ||
                binding.IdProductos.text.isEmpty() ||
                binding.IdCiudad.text.isEmpty() ||
                binding.IdDireccion.text.isEmpty()

    }
}