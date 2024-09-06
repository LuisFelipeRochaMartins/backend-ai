package com.github.luisfeliperochamartins.challenge.backend.domain.destinos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DestinoUpdateRecord(@NotNull Integer id,
                                  String foto,
                                  String nome,
								  String descricao,
								  String meta,
                                  BigDecimal preco) {
}
