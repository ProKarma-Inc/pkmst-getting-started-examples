/**
 * 
 */
package com.prokarma.pkmst.pkmst.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prokarma.pkmst.pkmst.dto.User;

/**
 * @author prokarma
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
