package pdp.uz.service;

import pdp.uz.model.OutputProductAddDto;
import pdp.uz.model.OutputProductDto;
import pdp.uz.model.resp.OutputProductReport;
import pdp.uz.model.resp.ProductReport;

import java.util.List;

public interface OutputProductService {
    OutputProductDto add(OutputProductAddDto dto);

    List<OutputProductDto> addAll(List<OutputProductAddDto> dto);

    OutputProductReport get();

    OutputProductReport get(String date);
}
