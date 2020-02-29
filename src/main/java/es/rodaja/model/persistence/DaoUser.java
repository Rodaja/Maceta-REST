package es.rodaja.model.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rodaja.model.entity.User;

public interface DaoUser extends JpaRepository<User, Integer> {

	public Optional<User> findByEmail(String email);
}
