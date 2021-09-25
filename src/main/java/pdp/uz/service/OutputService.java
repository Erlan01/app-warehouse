package pdp.uz.service;

import pdp.uz.entity.Output;
import pdp.uz.model.OutputAddDto;
import pdp.uz.model.OutputDto;

import java.util.List;

public interface OutputService {
    OutputDto add(OutputAddDto dto);

    List<Output> get();
}
