package br.com.apibachintegracao.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apibachintegracao.dto.PedCompDto;
import br.com.apibachintegracao.service.PedCompService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/pedido")
@RequiredArgsConstructor
public class PedCompController {

	private final PedCompService pedCompService;

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job integraPedidoNovoJob;

	@PostMapping
	public ResponseEntity<PedCompDto> novoPedido(@Valid @RequestBody PedCompDto pedCompDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(pedCompService.savarNovoPed(pedCompDto));

	}

	@PutMapping
	public ResponseEntity<PedCompDto> alterarPedido(@Valid @RequestBody PedCompDto pedCompDto) {

		return ResponseEntity.status(HttpStatus.OK).body(pedCompService.alterarPed(pedCompDto));

	}

	@GetMapping("/job/integra-pedido-novo")
	public String invokeBatchJob() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(integraPedidoNovoJob, jobParameters);
		return "Job integração pedido novo iniciado com sucesso!";
	}

}
