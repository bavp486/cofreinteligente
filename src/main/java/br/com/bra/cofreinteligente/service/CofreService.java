package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.CofreDto;

import br.com.bra.cofreinteligente.repository.CofreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CofreService {

    @Autowired
    public CofreRepository cofreRepository;

    @Autowired
    public ClienteFilialService clienteFilialService;


