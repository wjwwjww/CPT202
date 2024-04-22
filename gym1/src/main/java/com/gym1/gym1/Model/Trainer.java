package com.gym1.gym1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Trainer {
    @Id
    private int trainerId;
    private String trainerPassword;
    private String trainerName;
    private int trainerRanking;
    private String trainerIntroduction;







    
    public Trainer(int trainerId, String trainerPassword, String trainerName, int trainerRanking, String trainerIntroduction) {
        this.trainerId = trainerId;
        this.trainerPassword =  trainerPassword;
        this.trainerName = trainerName;
        this.trainerRanking = trainerRanking;
        this.trainerIntroduction = trainerIntroduction;


    }
    public Trainer() {
    }

    
    public int gettrainerId() {
        return trainerId;
    }
    public void settrainerId(int trainerId) {
        this.trainerId = trainerId;
    }
    public String gettrainerPassword() {
        return trainerPassword;
    }
    public void settrainerPassword(String trainerPassword) {
        this.trainerPassword = trainerPassword;
    }
    public String gettrainerName() {
        return trainerName;
    }
    public void settrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    public int gettrainerRanking() {
        return trainerRanking;
    }
    public void settrainerRanking(int trainerRanking) {
        this.trainerRanking = trainerRanking;
    }
    public String gettrainerIntroduction() {
        return trainerIntroduction;
    }
    public void settrainerIntroduction(String trainerIntroduction) {
        this.trainerIntroduction = trainerIntroduction;
    }


    
}
