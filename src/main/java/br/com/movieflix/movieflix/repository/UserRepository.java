package br.com.movieflix.movieflix.repository;

import br.com.movieflix.movieflix.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String userRegister);
}
