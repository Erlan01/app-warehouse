package pdp.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.entity.Output;
import pdp.uz.model.OutputAddDto;
import pdp.uz.model.OutputDto;
import pdp.uz.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/api/output")
public class OutputController {
    private final OutputService outputService;

    @Autowired
    public OutputController(OutputService outputService) {
        this.outputService = outputService;
    }

    @GetMapping("/get/all")
    public List<Output> getAll(){
        return outputService.get();
    }

    @PostMapping("/add")
    public OutputDto add(@RequestBody OutputAddDto dto){
        return outputService.add(dto);
    }
}
