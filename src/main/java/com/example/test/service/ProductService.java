package com.example.test.service;

import com.example.test.entity.Attachment;
import com.example.test.entity.Category;
import com.example.test.entity.Product;
import com.example.test.payload.ApiResponse;
import com.example.test.payload.ProductDto;
import com.example.test.repository.AttachmentRepository;
import com.example.test.repository.CategoryRepository;
import com.example.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    public ApiResponse add(ProductDto productDto) {
        boolean exists = productRepository.existsByName(productDto.getName());
        if (exists) {
            return new ApiResponse("Bunday Maxsulot Mavjud", false);
        } else {
            Product product = new Product();
            product.setName(productDto.getName());
            Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
            if (!optionalCategory.isPresent()) return new ApiResponse("Bunday Categorya mavjud emas", false);
            product.setCategory(optionalCategory.get());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
//            Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
//            if (!optionalAttachment.isPresent())return new ApiResponse("Bunday rasm yoq",false);
//            product.setPhoto(optionalAttachment.get());
            productRepository.save(product);
            return new ApiResponse("Saved", true);
        }
    }

    public ApiResponse editProduct(int id, ProductDto productDTO) {
//        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDTO.getPhotoId());
//        if (!optionalAttachment.isPresent()) return new ApiResponse("Bunday rasm yo'q", false);
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) return new ApiResponse("Bunday Maxsulot mavjud emas", false);
        Product product = optionalProduct.get();
        product.setName(productDTO.getName());
//        product.setPhoto(optionalAttachment.get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
        if (!optionalCategory.isPresent()) return new ApiResponse("Bunday Kategoriya mavjud emas", false);
        Category category = optionalCategory.get();
        product.setCategory(category);
        productRepository.save(product);
        return new ApiResponse("Edited", true);
    }


    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public ApiResponse getOne(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) return new ApiResponse("Bunday Maxsulot mavjud emas", false);
        return new ApiResponse("ok", true, optionalProduct.get());
    }

    public ApiResponse deleteProduct(int id) {
        boolean exists = productRepository.existsById(id);
        if (!exists) return new ApiResponse("Bunday Maxsulot mavjud emas", false);
        productRepository.deleteById(id);
        return new ApiResponse("Deleted", true);
    }

    public ApiResponse moreTen() {
        List<?> productMoreThanTen = productRepository.getProductMoreThanTen();
        return new ApiResponse("Success", true, productMoreThanTen);
    }

    public ApiResponse getProductQuantityEight() {
        List<?> allByQuantityEight = productRepository.getAllByQuantityEight();
        return new ApiResponse("Success", true, allByQuantityEight);
    }

    public ApiResponse infoProductCustomerId(int id) {
        List<?> allInfo = productRepository.getAllInfo(id);
        return new ApiResponse("Success", true, allInfo);
    }
}
