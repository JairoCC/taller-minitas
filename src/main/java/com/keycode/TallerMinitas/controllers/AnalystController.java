package com.keycode.TallerMinitas.controllers;

import com.keycode.TallerMinitas.dto.DeminingTypeDTO;
import com.keycode.TallerMinitas.models.DeminingType;
import com.keycode.TallerMinitas.services.DeminingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demining")
@CrossOrigin("*")
public class AnalystController {
    @Autowired
    private DeminingTypeService deminingTypeService;

    @GetMapping("/list")
    public List<DeminingType> listDeminigType() throws ChangeSetPersister.NotFoundException {
        return deminingTypeService.listDeminingTypes();
    }

    @PostMapping("/add")
    public DeminingType addDeminigService(@RequestBody DeminingTypeDTO body) throws ChangeSetPersister.NotFoundException {
        return deminingTypeService.addDeminingService(body.getType());
    }

    @PutMapping("/edit")
    public DeminingType editDeminigService(@RequestBody DeminingTypeDTO body) throws ChangeSetPersister.NotFoundException {
        return deminingTypeService.editDeminingService(body.getId(), body.getType());
    }

    @DeleteMapping("/delete")
    public DeminingType deletesDeminigService(@RequestBody DeminingTypeDTO body) throws ChangeSetPersister.NotFoundException {
        return deminingTypeService.deleteDeminingService(body.getId());
    }

}
