package com.sacral.SAC-186.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OnedriveRepository extends JpaRepository<Onedrive, Long> {
    
    // Method to check if the ONEDRIVE credentials are valid
    Boolean verifyOnedriveCredentials(String userName, String password, String url);
    
    // Method to get a list of ONEDRIVE configurations
    List<Onedrive> getOnedriveConfigurations();
    
    // Method to add a new ONEDRIVE configuration
    Onedrive addOnedriveConfiguration(String userName, String password, String url, String repositoryName);
    
    // Method to delete an existing ONEDRIVE configuration
    void deleteOnedriveConfiguration(Long onedriveId);
    
    // Method to update an existing ONEDRIVE configuration
    void updateOnedriveConfiguration(Long onedriveId, String userName, String password, String url, String repositoryName);
}