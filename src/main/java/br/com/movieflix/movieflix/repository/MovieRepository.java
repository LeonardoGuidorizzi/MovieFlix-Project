package br.com.movieflix.movieflix.repository;

import br.com.movieflix.movieflix.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    boolean existsByNameIgnoreCase(String name);
    List<Movie> findMovieByCategories_Id(Long categoriesId);
    List<Movie> findMovieByStreamings_Id(Long streamingsId);
}
