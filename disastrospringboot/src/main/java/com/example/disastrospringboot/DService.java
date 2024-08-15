package com.example.disastrospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DService {

    @Autowired
    private DRepository dRepository;

    public DModel findByEmail(String email) {
        return dRepository.findByEmail(email);
    }

    public List<DModel> findAll() {
        return dRepository.findAll();
    }

    public DModel save(DModel dModel) {
        return dRepository.save(dModel);
    }

    public DModel updateUser(String firstname, DModel updatedModel) {
        DModel existingUser = dRepository.findByFirstname(firstname);
        if (existingUser != null) {
            existingUser.setLastname(updatedModel.getLastname());
            existingUser.setEmail(updatedModel.getEmail());
            existingUser.setPassword(updatedModel.getPassword());
            return dRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void deleteByFirstname(String firstname) {
        DModel existingUser = dRepository.findByFirstname(firstname);
        if (existingUser != null) {
            dRepository.delete(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
