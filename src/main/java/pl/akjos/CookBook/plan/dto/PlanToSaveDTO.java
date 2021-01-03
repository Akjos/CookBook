package pl.akjos.CookBook.plan.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class PlanToSaveDTO {

    private Long id;

    @NotEmpty
    @Length(max = 80)
    private String name;

    @Length(max = 500)
    private String description;

}
