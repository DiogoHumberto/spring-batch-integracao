package br.com.apibachintegracao.service;

import br.com.apibachintegracao.domain.EmpresaModel;
import br.com.apibachintegracao.dto.EmpresaDto;
import br.com.apibachintegracao.exception.BadRequestException;
import br.com.apibachintegracao.mapper.EmpresaMapper;
import br.com.apibachintegracao.repository.EmpresaModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaModelRepository empresaRepository;

    public EmpresaDto criar(EmpresaDto reqDto){

        if(empresaRepository.existsByCnpj(reqDto.getCnpj())){
            throw new BadRequestException("Empresa já existente!");
        }

        EmpresaModel empresa =  empresaRepository.save(EmpresaMapper.toEntity(reqDto));

        return EmpresaMapper.toDto(empresa);

    }
}
