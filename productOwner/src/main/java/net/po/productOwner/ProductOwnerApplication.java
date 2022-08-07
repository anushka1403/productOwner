package net.po.productOwner;

import net.po.productOwner.entity.productOwner;
import net.po.productOwner.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductOwnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductOwnerApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		productOwner productowner = new productOwner();
		productowner.setPoName("neha");
		productowner.setProductId(11);
		productowner.setProductName("car");
		productRepository.save(productowner);

		productOwner productowner1 = new productOwner();
		productowner1.setPoName("sneha");
		productowner1.setProductId(22);
		productowner1.setProductName("bike");
		productRepository.save(productowner1);


	}
}
