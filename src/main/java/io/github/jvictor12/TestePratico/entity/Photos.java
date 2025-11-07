package io.github.jvictor12.TestePratico.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "tb_photos")
public class Photos {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String url;

    private Long width;

    private Long height;

}
