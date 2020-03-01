package es.rodaja.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rodaja.model.entity.User;

public interface DaoUser extends JpaRepository<User, Integer> {

	public List<User> findAllByEmail(String email);
}
