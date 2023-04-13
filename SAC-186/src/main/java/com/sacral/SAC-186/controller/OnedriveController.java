package com.sacral.SAC-186.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacral.SAC-186.model.Onedrive;
import com.sacral.SAC-186.service.OnedriveService;

@RestController
@RequestMapping("/onedrive")
public class OnedriveController {
    
    @Autowired
    private OnedriveService onedriveService;
    
    // Endpoint to check if the ONEDRIVE credentials are valid
    @PostMapping("/verify")
    public ResponseEntity<Boolean> verifyOnedriveCredentials(@RequestBody Onedrive onedrive) {
        Boolean isVerified = onedriveService.verifyOnedriveCredentials(onedrive.getUserName(), onedrive.getPassword(), onedrive.getUrl());
        return new ResponseEntity<>(isVerified, HttpStatus.OK);
    }
    
    // Endpoint to get a list of ONEDRIVE configurations
    @GetMapping("/list")
    public ResponseEntity<List<Onedrive>> getOnedriveConfigurations() {
        List<Onedrive> onedriveList = onedriveService.getOnedriveConfigurations();
        return new ResponseEntity<>(onedriveList, HttpStatus.OK);
    }
    
    // Endpoint to add a new ONEDRIVE configuration
    @PostMapping("/add")
    public ResponseEntity<Onedrive> addOnedriveConfiguration(@RequestBody Onedrive onedrive) {
        Onedrive newOnedrive = onedriveService.addOnedriveConfiguration(onedrive.getUserName(), onedrive.getPassword(), onedrive.getUrl(), onedrive.getRepositoryName());
        return new ResponseEntity<>(newOnedrive, HttpStatus.OK);
    }
    
    // Endpoint to delete an existing ONEDRIVE configuration
    @DeleteMapping("/delete/{onedriveId}")
    public ResponseEntity<Void> deleteOnedriveConfiguration(@PathVariable Long onedriveId) {
        onedriveService.deleteOnedriveConfiguration(onedriveId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    // Endpoint to update an existing ONEDRIVE configuration
    @PutMapping("/update/{onedriveId}")
    public ResponseEntity<Void> updateOnedriveConfiguration(@PathVariable Long onedriveId, @RequestBody Onedrive onedrive) {
        onedriveService.updateOnedriveConfiguration(onedriveId, onedrive.getUserName(), onedrive.getPassword(), onedrive.getUrl(), onedrive.getRepositoryName());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}