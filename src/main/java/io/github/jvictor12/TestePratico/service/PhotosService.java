package io.github.jvictor12.TestePratico.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jvictor12.TestePratico.dtos.PhotosDTO;
import io.github.jvictor12.TestePratico.entity.Photos;
import io.github.jvictor12.TestePratico.exception.ObjectNotFoundException;
import io.github.jvictor12.TestePratico.repository.PhotosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PhotosService {

    private final WebClient webClient;
    private final PhotosRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    //Pegando limite como parametro para definir o numero de fotos no retorno
    public List<Photos> fetchAndSave(int limit) {
        //Fazendo requisição get e buildando o corpo da url
        WebClient.RequestHeadersSpec<?> req = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/images/search")
                        .queryParam("limit", limit)
                        .build());

        //Simplificando retorno
        Mono<PhotosDTO[]> mono = req.retrieve()
                .bodyToMono(PhotosDTO[].class);
        PhotosDTO[] dtos = mono.block();
        if (dtos == null) return List.of();

        //Buildando retorno e salvando no banco de dados
        List<Photos> saves = new ArrayList<>();
        for (PhotosDTO dto : dtos) {
            try {
                Photos r = new Photos();
                r.setId(dto.getId());
                r.setUrl(dto.getUrl());
                r.setWidth(dto.getWidth());
                r.setHeight(dto.getHeight());
                repository.save(r);
                saves.add(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return saves;
    }

    //Listando todos os dados salvos no banco
    public List<Photos> findAll() {
        return repository.findAll();
    }

    //Listando a entidade pelo ID
    public Photos findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Foto não encontrada"));
    }
}
