package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    HashMap<String, Object> datos;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){

        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {

        Optional<Product> res = productRepository.findProductByName(product.getName());
        datos = new  HashMap<>();
        if (res.isPresent() && product.getId() == null){
            //throw new IllegalStateException("Producto ya existe");
            datos.put("error", 402);
            datos.put("message", "El producto ya existe!");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message", "Producto creato exitosamente!");
        if (product.getId() != null){
            datos.put("message", "Producto actualizado exitosamente!");
        }

        productRepository.save(product);
        datos.put("data", product);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }

    public ResponseEntity<Object> deleteProduct(Long id){
        datos = new  HashMap<>();
        boolean existe = this.productRepository.existsById(id);
        if (!existe){
            datos.put("error", 404);
            datos.put("message", "No se pudo eliminar el producto!");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.NOT_FOUND
            );
        }
        this.productRepository.deleteById(id);
        datos.put("message", "El producto fue elimnado exitosamente!");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
