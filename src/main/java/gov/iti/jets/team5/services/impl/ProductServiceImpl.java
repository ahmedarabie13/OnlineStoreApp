package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.dao.ProductDao;
import gov.iti.jets.team5.dao.daoImpl.ProductDaoImpl;
import gov.iti.jets.team5.models.dto.OrderDto;
import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.services.ProductService;

public class ProductServiceImpl implements ProductService {

    @Override
    public Boolean updateProductsAfterCheckout(OrderDto orderDto) {
        //todo: subtract the order products amounts from the db products amounts
        var products = orderDto.getProducts().keySet();
        products.stream().forEach((productDto) -> {
            Integer productQuantityInOrder = orderDto.getProducts().get(productDto);
            ProductDao productDao= ProductDaoImpl.getInstance();

            Integer storedQuantity = 12;
//                    productDao.getProductQuantity(productDto);
            Integer newAmount= storedQuantity - productQuantityInOrder;
            //todo : update the db with the product new quantity
        });

        return true;
    }
}
