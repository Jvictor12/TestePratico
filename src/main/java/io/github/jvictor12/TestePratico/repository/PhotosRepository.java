package io.github.jvictor12.TestePratico.repository;

import io.github.jvictor12.TestePratico.entity.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotosRepository extends JpaRepository<Photos, String> {

}
