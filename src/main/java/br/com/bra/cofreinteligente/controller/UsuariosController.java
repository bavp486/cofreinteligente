package br.com.bra.cofreinteligente.controller;


import br.com.bra.cofreinteligente.dto.UsuariosDto;
import br.com.bra.cofreinteligente.entity.Usuarios;
import br.com.bra.cofreinteligente.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuarios")
public class UsuariosController {

    @Autowired
    public UsuariosService usuariosService;

    @PostMapping
    public ResponseEntity<Object> addUsuario(@RequestBody UsuariosDto dto) throws Exception {
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body("Usuario " +
                        usuariosService.addUsuarios(dto).getNome()
                + " cadastrado com sucesso");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<UsuariosDto> getAllUsuarios (){
        return usuariosService.getAllUsuarios();
    }

    @PatchMapping
    public ResponseEntity<Object> alteraAcessoUsuario (@RequestParam Long funcional, String acesso) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Acesso do usuario "
                + usuariosService.alteraAcessoByUsuarios(funcional,acesso).getNome() +
                        " alterado para " + acesso);
    }

    @DeleteMapping("/{funcional}")
    public ResponseEntity<Object> deletaUsuario(@PathVariable(value = "funcional")Long funcional) throws Exception {
        usuariosService.deletaUsuario(funcional);
        return ResponseEntity.noContent().build();
    }

}
