package com.github.luisfeliperochamartins.challenge.backend.domain.destinos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DestinoRecord(@NotBlank String foto,
                            @NotBlank String nome,
                            @NotBlank String meta,
                            String descricao,
                            @NotNull BigDecimal preco) {

	public DestinoRecord(Destino destino) {
		this(destino.getFoto(), destino.getNome(), destino.getMeta(), destino.getDescricao(), destino.getPreco());
	}
}
