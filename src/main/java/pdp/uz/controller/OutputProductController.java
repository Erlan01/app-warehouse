package pdp.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.entity.OutputProduct;
import pdp.uz.model.InputProductAddDto;
import pdp.uz.model.InputProductDto;
import pdp.uz.model.OutputProductAddDto;
import pdp.uz.model.OutputProductDto;
import pdp.uz.model.resp.OutputProductReport;
import pdp.uz.model.resp.ProductReport;
import pdp.uz.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping("/api/output/product")
public class OutputProductController {
    private final OutputProductService outputProductService;

    @Autowired
    public OutputProductController(OutputProductService outputProductService) {
        this.outputProductService = outputProductService;
    }

    @PostMapping("/add")
    public OutputProductDto add(@RequestBody OutputProductAddDto dto){
        return outputProductService.add(dto);
    }

    @PostMapping("/add/all")
    public List<OutputProductDto> addAll(@RequestBody List<OutputProductAddDto> dto){
        return outputProductService.addAll(dto);
    }

    @GetMapping("/get/all")
    public List<OutputProduct> getAll(){
        return outputProductService.getAll();
    }

    /**
     * Kunlik eng ko’p chiqim qilingan mahsulotlar
     *
     */
    @GetMapping("/get/today")
    public OutputProductReport get(){
        return outputProductService.get();
    }

    @GetMapping("/get/date")
    public OutputProductReport get(@RequestParam String date){
        return outputProductService.get(date);
    }
}
