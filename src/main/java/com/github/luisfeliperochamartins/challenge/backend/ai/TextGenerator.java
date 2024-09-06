package com.github.luisfeliperochamartins.challenge.backend.ai;

import com.cohere.api.Cohere;
import com.cohere.api.requests.ChatRequest;
import com.cohere.api.types.NonStreamedChatResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TextGenerator {

	@Value("${cohere_api_key}")
	private String API_KEY;

	public String createText(String cidade) {
		Cohere cohere = Cohere.builder().token(API_KEY).clientName("snippet").build();

		NonStreamedChatResponse response = cohere
				.chat(ChatRequest.builder()
						.message("Faça um resumo sobre " +  cidade + " enfatizando o porque este lugar é incrível. " +
								"Utilize uma linguagem informal e até 50 caracteres no máximo em cada parágrafo. " +
								"Crie 2 parágrafos neste resumo.")
						.build());

		return response.getText();
	}
}
