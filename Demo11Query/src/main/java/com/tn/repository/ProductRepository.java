package com.tn.repository;

import com.tn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//
//    List<Product> findByProductName(String productName);
//
//    List<Product> findByProductId(Integer productId);

//    List<Product> findByProductId(Integer id);

//    List<Product> findByProductId(Integer id);

//    List<Product> findByProductId(Integer id);

    @Query("from Product")
    List<Product> getAllData2();

//    GetDataByProductName
    @Query("FROM Product where productName = 'car'")
    List<Product> getAllByName2();

    @Query("FROM Product where productName = :pProductName")
    List<Product> getAllByName3(@Param("pProductName") String pProductName);

    @Query("FROM Product where productName = :pProductName and price = :pPrice")
    List<Product> getAllByName4(@Param("pProductName") String pProductName,
                                @Param("pPrice") Integer pPrice);

    @Query("DELETE from Product where id = :id")
    void deleteProductById(@Param("id") Integer id);

    @Modifying
    @Query("UPDATE Product SET price = 5000 WHERE id = :id")
    void updateProductById(@Param("id") Integer id);

    @Modifying
    @Query("UPDATE Product SET productName = :productName WHERE price = :price")
    void updateProductByPrice(@Param("product") String productName,
                              @Param("price") Integer price);
}
