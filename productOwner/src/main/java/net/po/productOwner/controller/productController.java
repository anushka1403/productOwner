package net.po.productOwner.controller;

import net.po.productOwner.entity.productOwner;
import net.po.productOwner.exception.ResourceNotFoundException;
import net.po.productOwner.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productAPI/v1/owner")
public class productController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<productOwner> getAllProductOwner(){
        return productRepository.findAll();
    }

    @PostMapping
    public  productOwner createOwner(@RequestBody productOwner productowner){
        return productRepository.save(productowner);
    }
    @GetMapping("{po_id}")
    public ResponseEntity<productOwner> getProductOwnerById(@PathVariable("po_id") Integer poId){
        productOwner productowner = productRepository.findById(poId)
                .orElseThrow(() -> new ResourceNotFoundException("Product owner not Exist with id:"+poId));
        return ResponseEntity.ok(productowner);
    }

    @PutMapping("{po_id}")
    public ResponseEntity<productOwner> updateProductOwner(@PathVariable("po_id") Integer poId,@RequestBody productOwner productownerdetail){
        productOwner updateProductOwner = productRepository.findById(poId)
                .orElseThrow(() -> new ResourceNotFoundException("Product owner not found with this id:"+poId));
        updateProductOwner.setPoName(productownerdetail.getPoName());
        updateProductOwner.setProductId(productownerdetail.getProductId());
        updateProductOwner.setProductName(productownerdetail.getProductName());

        productRepository.save(updateProductOwner);

        return ResponseEntity.ok(updateProductOwner);
    }
    @DeleteMapping("{po_id}")
    public ResponseEntity<HttpStatus> deleteProductOwner(@PathVariable("po_id") Integer poId){
        productOwner productowner = productRepository.findById(poId)
                .orElseThrow(() -> new ResourceNotFoundException("Product owner not found with this id:"+poId));
        productRepository.delete(productowner);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

