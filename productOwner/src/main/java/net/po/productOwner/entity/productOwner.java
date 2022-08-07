package net.po.productOwner.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_owner")

public class productOwner
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "po_id")
    private Integer poId;

    @Column(name = "po_name")
    private String poName;

    @Column(name="product_id")
    private Integer productId;

    @Column(name="product_name")
    private String productName;


}
