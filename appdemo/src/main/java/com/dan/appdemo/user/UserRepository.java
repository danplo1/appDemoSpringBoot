package com.dan.appdemo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository ("userRepository")
public interface UserRepository extends JpaRepository <User, Integer> {
	
	public User findByEmail (String email);
	
	@Modifying//oznacza, że w bazie bedziemy coś modyfikować
	@Query("UPDATE User u SET u.password = :newPassword WHERE u.email= :email") //nameQuery, update, który przyjmuje parametry na jednym konkretnym polu
	public void updateUserPassword(@Param ("newPassword") String password, @Param("email") String email);
	

}
