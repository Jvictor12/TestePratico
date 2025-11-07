package io.github.jvictor12.TestePratico.dtos;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PhotosDTO implements Serializable {

        private String id;
        private String url;
        private Long width;
        private Long height;
}
