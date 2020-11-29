package pl.akjos.CookBook.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "days")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder;
}
