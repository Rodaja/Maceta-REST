package es.rodaja.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rodaja.model.entity.User;

public interface DaoUser extends JpaRepository<User, Integer> {

}
