package com.keycode.TallerMinitas.controllers;

import com.keycode.TallerMinitas.models.DeminingType;
import com.keycode.TallerMinitas.services.DeminingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private DeminingTypeService deminingTypeService;

    @GetMapping("/")
    public String hellowAdminController(){
        return "admin level access";
    }

    @GetMapping("/deminingType")
    public List<DeminingType> listDeminigType() throws ChangeSetPersister.NotFoundException {
        return deminingTypeService.listAllDeminingTypes();
    }
}
