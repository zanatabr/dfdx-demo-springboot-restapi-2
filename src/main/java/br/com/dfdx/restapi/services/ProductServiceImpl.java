package br.com.dfdx.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dfdx.restapi.models.Product;
import br.com.dfdx.restapi.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product find(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}

	@Override
	public Product create(Product product) {
		this.productRepository.save(product);
		return product;
	}

	@Override
	public Product update(Long id, Product product) {
		Product productExists = this.productRepository.findById(id).orElse(null);
		if (productExists != null) {
			productExists.setId(productExists.getId());
			this.productRepository.save(product);
			return product;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		this.productRepository.deleteById(id);
	}

}
