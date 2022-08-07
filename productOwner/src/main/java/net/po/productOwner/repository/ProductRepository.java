package net.po.productOwner.repository;

import net.po.productOwner.entity.productOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<productOwner, Integer> {
    // all CRUD database methods

}
