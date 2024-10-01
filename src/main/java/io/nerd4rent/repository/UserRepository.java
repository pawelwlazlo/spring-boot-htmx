package io.nerd4rent.repository;

import io.nerd4rent.model.AppUser;
import io.nerd4rent.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    @Query("SELECT new io.nerd4rent.dto.UserDto(u.id, u.name, u.email) FROM AppUser u")
    List<UserDto> findAllProjectedBy();
}
