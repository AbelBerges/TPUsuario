package com.desarrollo.appusuarios;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioViewModel extends ViewModel {
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public void setUsuarios(Usuario user){
        usuarios.add(user);
    }
}
