package com.example.rest.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dao.CampaignDao;
import com.example.rest.model.Campaign;

import jakarta.websocket.server.PathParam;

@RestController
public class CampaignController {

    @Autowired
    private CampaignDao campaignDao;
    
    @GetMapping("/campaign")
    public List<Campaign> getAllCampaign() throws ClassNotFoundException, SQLException {
        return campaignDao.findAll();
    }

    @GetMapping("/campaign/{id}")
    public Campaign getCampaignById(@PathVariable int id) throws ClassNotFoundException, SQLException {
        return campaignDao.findById(id);
    }

    @DeleteMapping("/campaign/{id}")
    public Campaign deleteCampaignById(@PathVariable int id) throws ClassNotFoundException, SQLException {
        return campaignDao.deleteCampaignById(id);
    }
        
    @PostMapping("/campaign")
    public Campaign create(@RequestBody Campaign campaign) throws ClassNotFoundException, SQLException {
        return campaignDao.create(campaign);
    }
}
