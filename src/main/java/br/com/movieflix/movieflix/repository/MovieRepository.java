package br.com.movieflix.movieflix.repository;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories_Id(Long categoriesId);
    List<Movie> findMovieByStreamings_Id(Long streamingsId);
}
