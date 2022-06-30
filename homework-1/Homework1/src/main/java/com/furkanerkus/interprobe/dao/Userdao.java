package com.furkanerkus.interprobe.dao;

import com.furkanerkus.interprobe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userdao extends JpaRepository<User, Long> {
}
