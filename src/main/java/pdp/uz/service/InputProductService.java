package pdp.uz.service;

import pdp.uz.model.InputProductAddDto;
import pdp.uz.model.InputProductDto;
import pdp.uz.model.resp.ExpiredProducts;
import pdp.uz.model.resp.ExpiredProductsFullInfo;
import pdp.uz.model.resp.ProductReport;
import java.util.List;

public interface InputProductService {
    InputProductDto add(InputProductAddDto dto);

    List<InputProductDto> addAll(List<InputProductAddDto> dto);

    List<ProductReport> get();

    List<ProductReport> get(String date);

    ExpiredProducts getExpiredProducts();

    List<ExpiredProductsFullInfo> getExpiredProductsFullInfo(String date);
}
