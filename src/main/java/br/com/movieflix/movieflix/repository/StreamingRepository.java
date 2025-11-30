package br.com.movieflix.movieflix.repository;

import br.com.movieflix.movieflix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
