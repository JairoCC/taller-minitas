package com.keycode.TallerMinitas.services;

import com.keycode.TallerMinitas.models.ApplicationUser;
import com.keycode.TallerMinitas.models.DeminingType;
import com.keycode.TallerMinitas.repository.DeminingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeminingTypeService {

    @Autowired
    private DeminingTypeRepository deminingTypeRepository;
    @Autowired
    private ApplicationUser applicationUser;

    public List<DeminingType> listDeminingTypes(){
        return deminingTypeRepository.findByRegion(applicationUser.getCity());
    }

    public List<DeminingType> listAllDeminingTypes(){
        return deminingTypeRepository.findAll();
    }

    public DeminingType addDeminingService(String deminingName){
        return deminingTypeRepository.save(new DeminingType(0,applicationUser.getCity(),deminingName,applicationUser.getUsername()));
    }
    public DeminingType deleteDeminingService(Integer id){
        DeminingType registration = deminingTypeRepository.findById(id).get();
        deminingTypeRepository.delete(registration);
        return registration;
    }


    public DeminingType editDeminingService(Integer id, String deminingName){
        DeminingType registration = deminingTypeRepository.findById(id).get();
        registration.setRegion(applicationUser.getCity());
        registration.setDeminingName(deminingName);
        registration.setUser(applicationUser.getUsername());
        return  deminingTypeRepository.save(registration);
    }

    public DeminingType editDeminingRegion(Integer id, String region){
        DeminingType registration = deminingTypeRepository.findById(id).get();
        registration.setRegion(region);
        return  deminingTypeRepository.save(registration);
    }

    public DeminingType editDeminingUser(Integer id, String user){
        DeminingType registration = deminingTypeRepository.findById(id).get();
        registration.setUser(user);
        return  deminingTypeRepository.save(registration);
    }

}
