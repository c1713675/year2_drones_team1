//package com.asgdrones.drones.repositories.login.admin;
//
//
//import com.asgdrones.drones.domain.Login;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface AdminLoginJPA extends JpaRepository<Login, Long> {
//    @Query(value = "SELECT l FROM Login l WHERE l.username = :un AND l.password = :pw")
//    Login findByLoginDetails(@Param("un") String username, @Param("pw") String pw);
//
//    @Query(value = "SELECT l.isAdmin FROM login l JOIN admin a ON l.LoginID = a.Login_LoginID WHERE l.username = :un AND l.password = :pw")
//    boolean isLoginAdmin(@Param("un") String username, @Param("pw") String pw);
//}
