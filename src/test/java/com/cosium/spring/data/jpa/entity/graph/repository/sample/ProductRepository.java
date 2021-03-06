package com.cosium.spring.data.jpa.entity.graph.repository.sample;

import java.util.List;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQueryDslPredicateExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created on 22/11/16.
 *
 * @author Reda.Housni-Alaoui
 */
public interface ProductRepository
		extends EntityGraphJpaRepository<Product, Long>,
		EntityGraphJpaSpecificationExecutor<Product>,
		EntityGraphQueryDslPredicateExecutor<Product>,
		ProductRepositoryCustom {

	List<Product> findByName(String name, EntityGraph entityGraph);

	List<Product> findByBrand(Brand brand);

	ProductName findProductNameByName(String name, EntityGraph entityGraph);

	@org.springframework.data.jpa.repository.EntityGraph(value = Product.BRAND_EG)
	Product findByBarcode(String barcode);

	long countByName(String name);

	@Query("select p.name from Product p")
	List<Object[]> findAllRaw();
}
