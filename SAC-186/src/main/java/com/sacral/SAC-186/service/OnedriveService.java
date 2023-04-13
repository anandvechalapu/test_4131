package com.sacral.SAC-186.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacral.SAC-186.repository.OnedriveRepository;
import com.sacral.SAC-186.model.Onedrive;

@Service
public class OnedriveService {
    
    @Autowired
    private OnedriveRepository onedriveRepository;
    
    // Method to check if the ONEDRIVE credentials are valid
    public Boolean verifyOnedriveCredentials(String userName, String password, String url) {
        return onedriveRepository.verifyOnedriveCredentials(userName, password, url);
    }
    
    // Method to get a list of ONEDRIVE configurations
    public List<Onedrive> getOnedriveConfigurations() {
        return onedriveRepository.getOnedriveConfigurations();
    }
    
    // Method to add a new ONEDRIVE configuration
    public Onedrive addOnedriveConfiguration(String userName, String password, String url, String repositoryName) {
        return onedriveRepository.addOnedriveConfiguration(userName, password, url, repositoryName);
    }
    
    // Method to delete an existing ONEDRIVE configuration
    public void deleteOnedriveConfiguration(Long onedriveId) {
        onedriveRepository.deleteOnedriveConfiguration(onedriveId);
    }
    
    // Method to update an existing ONEDRIVE configuration
    public void updateOnedriveConfiguration(Long onedriveId, String userName, String password, String url, String repositoryName) {
        onedriveRepository.updateOnedriveConfiguration(onedriveId, userName, password, url, repositoryName);
    }
}