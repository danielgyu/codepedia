package com.hismayfly.orderexecution.application;

import com.hismayfly.orderexecution.domain.dto.RegisterShoeProductDTO;
import com.hismayfly.orderexecution.domain.dto.RegisterShoeRespDTO;
import com.hismayfly.orderexecution.domain.dto.RegisterShoeDTO;
import com.hismayfly.orderexecution.domain.entity.Brand;
import com.hismayfly.orderexecution.domain.entity.Shoe;
import com.hismayfly.orderexecution.domain.entity.ShoeProduct;
import com.hismayfly.orderexecution.infrastructure.BrandRepository;
import com.hismayfly.orderexecution.infrastructure.ShoeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegisterShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private BrandRepository brandRepository;

    public RegisterShoeRespDTO execute(RegisterShoeDTO dto) {
        Brand brand = brandRepository.getBrandByName(dto.brand());
        if (brand == null) {
            return new RegisterShoeRespDTO(false, "brand not found", 0L);
        }

        Shoe shoe = Shoe.builder()
                .brand(brand)
                .koreanName(dto.koreanName())
                .englishName(dto.englishName())
                .modelNumber(dto.modelNumber())
                .releasedAt(dto.releasedAt())
                .build();
        List<ShoeProduct> shoeProducts = new ArrayList<>();
        for (RegisterShoeProductDTO productDTO:dto.products()) {
            shoeProducts.add(ShoeProduct.builder()
                    .color(productDTO.color())
                    .size(productDTO.size())
                    .build());
        }
        shoeRepository.save(shoe, shoeProducts);

        return new RegisterShoeRespDTO(true, "", shoe.getId());
    }
}
