package com.coutodev.marmiMvp.domain.Usuarios;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(UsuarioDto dto){
        Usuario usuario = new Usuario(dto);
    return usuarioRepository.save(usuario);

    }
}
