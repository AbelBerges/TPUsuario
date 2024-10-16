package com.desarrollo.appusuarios;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.desarrollo.appusuarios.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private UsuarioViewModel uvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        uvm = new ViewModelProvider(this).get(UsuarioViewModel.class);
        tarea();
    }
    public void tarea(){
        binding.btnGuadar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(!binding.ingresoNombre.getText().toString().isEmpty() && !binding.ingresoEdad.getText().toString().isEmpty()){
                        String tomoNombre = binding.ingresoNombre.getText().toString();
                        int tomoEdad = Integer.parseInt(binding.ingresoEdad.getText().toString());
                        Usuario temp = new Usuario(tomoNombre,tomoEdad);
                        uvm.setUsuarios(temp);
                        binding.ingresoNombre.setText("");
                        binding.ingresoEdad.setText("");
                    } else {
                        binding.mensajeError.setText("No puede haber campos vacíos");
                        binding.ingresoNombre.setText("");
                        binding.ingresoEdad.setText("");
                    }
                } catch(NumberFormatException e){
                    binding.mensajeError.setText("Error en el formato de la entrada de edad");
                }
            }
        });
        binding.btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Usuario> verUsuarios = uvm.getUsuarios();
                String msg = "";
                for (Usuario user : verUsuarios) {
                    msg += "Nombre: " + user.getNombre() + ". Edad: " + user.getEdad() +"\n";
                }
                binding.mensajeError.setText(msg);
            }
        });
    }
}