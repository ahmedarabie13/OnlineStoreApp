package gov.iti.jets.team5.utils.mappers;

import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.ProductDto;

public class ProductDtoMapper extends AbstractDtoMapper<ProductDto, Product> {
    @Override
    public ProductDto getDto(Product entity) {
        ProductDto productDto = new ProductDto();
        productDto.setProductID(entity.getId()+"");
        productDto.setProductPrice(entity.getPrice());
        productDto.setProductName(entity.getProductName());
        productDto.setProductImageURL(entity.getPhoto());
        productDto.setProductDesc(entity.getProductDescription());
        productDto.setQuantity(entity.getQuantity());
        return productDto;
    }
}
