package pl.akjos.CookBook.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {

    private Long id;

    @NotEmpty
    @Length(max = 80)
    private String name;

    @Length(max = 500)
    private String description;

}
