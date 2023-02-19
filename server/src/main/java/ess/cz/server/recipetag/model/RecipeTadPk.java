package ess.cz.server.recipetag.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class RecipeTadPk implements Serializable {

    @Column(name = "recipe_id")
    private String recipeId;

    @Column(name = "tag_id")
    private String tagId;
}
