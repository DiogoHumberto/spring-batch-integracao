package br.com.apibachintegracao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apibachintegracao.dto.PedCompDto;
import br.com.apibachintegracao.service.PedCompService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController("/api/pedido")
@RequiredArgsConstructor
public class PedCompController {
	
	
	private final PedCompService pedCompService;
	
	
	@PostMapping
	public ResponseEntity<PedCompDto> novoPedido(@Valid  @RequestBody PedCompDto pedCompDto ){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pedCompService.savarNovoPed(pedCompDto));
				
	}
	
	@PutMapping
	public ResponseEntity<PedCompDto> alterarPedido(@Valid  @RequestBody PedCompDto pedCompDto ){
		
		return ResponseEntity.status(HttpStatus.OK).body(pedCompService.alterarPed(pedCompDto));
				
	}
	

}
