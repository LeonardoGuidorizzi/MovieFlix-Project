package br.com.movieflix.movieflix.repository;

import br.com.movieflix.movieflix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
