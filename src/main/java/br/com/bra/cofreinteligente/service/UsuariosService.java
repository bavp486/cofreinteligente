package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.UsuariosDto;
import br.com.bra.cofreinteligente.entity.Usuarios;
import br.com.bra.cofreinteligente.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    public UsuariosRepository usuariosRepository;


    public UsuariosDto addUsuarios (UsuariosDto dto) throws Exception {
        var usuarios = usuariosRepository.findById(dto.getFuncional());
        if (usuarios.isPresent()){
            throw new Exception("Usuário já cadastrado");
        }
        var usuario = Usuarios.builder()
                .funcional(dto.getFuncional())
                .nome(dto.getNome())
                .acesso(dto.getAcesso())
                .build();
        usuariosRepository.save(usuario);
        return new UsuariosDto(usuario);
    }

    public List<UsuariosDto> getAllUsuarios (){
        return usuariosRepository.findAll().stream()
                .map(UsuariosDto::new)
                .toList();
    }

    public UsuariosDto alteraAcessoByUsuarios(Long funcional, String acesso) throws Exception {
        var usuarios = usuariosRepository.findById(funcional);
        if (usuarios.isEmpty()){
            throw new Exception("Usuário não localizado");
        }
        var usuario = Usuarios.builder()
                .funcional(usuarios.get().getFuncional())
                .nome(usuarios.get().getNome())
                .acesso(acesso)
                .build();
        usuariosRepository.save(usuario);
        return new UsuariosDto(usuario);
    }

    public void deletaUsuario(Long funcional) throws Exception {
        var usuarios = usuariosRepository.findById(funcional);
        if (usuarios.isEmpty()){
            throw new Exception("Usuário não localizado");
        }
        usuariosRepository.deleteById(funcional);
    }

}
