package com.github.luisfeliperochamartins.challenge.backend.domain.depoimento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DepoimentoUpdateRecord(@NotNull Integer id,
                                     @NotBlank String fotoUrl,
                                     @NotBlank String depoimento,
                                     @NotBlank String nomePessoa) {
}
