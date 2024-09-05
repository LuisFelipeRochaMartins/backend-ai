package com.github.luisfeliperochamartins.challenge.backend.domain.destinos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DestinoUpdateRecord(@NotNull Integer id,
                                  @NotBlank String foto,
                                  @NotBlank String nome,
                                  @NotNull BigDecimal preco) {
}
