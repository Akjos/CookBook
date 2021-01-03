package pl.akjos.CookBook.plan.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Data
public class PlanToSaveDTO {

    private Long id;

    @NotEmpty
    @Max(80)
    private String name;

    @Max(500)
    private String description;

}
