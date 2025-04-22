package br.com.apibachintegracao.controller;

import br.com.apibachintegracao.dto.EmpresaDto;
import br.com.apibachintegracao.dto.PedCompDto;
import br.com.apibachintegracao.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/empresa")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<EmpresaDto> novaEmpresa(@Valid @RequestBody EmpresaDto empresaDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.criar(empresaDto));

    }

}
