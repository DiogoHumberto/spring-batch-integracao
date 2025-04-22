package br.com.apibachintegracao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpresaDto {

    private UUID uuid;

    @CNPJ
    @Pattern(regexp = "\\d+", message = "O campo deve conter apenas números")
    private String cnpj;

    @NotBlank
    private String fantasia;

    @NotBlank
    private String razsoc;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "O campo deve conter exatamente 11 dígitos numéricos")
    private String telefone;

    @Email
    private String email;


}
