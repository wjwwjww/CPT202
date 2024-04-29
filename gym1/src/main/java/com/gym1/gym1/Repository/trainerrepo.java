package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.Trainer;


@Repository
public interface trainerrepo extends JpaRepository<Trainer, Integer>{
    Trainer findByTrainerEmail(String trainerEmail);
    boolean existsByTrainerEmail(String trainerEmail);

}
