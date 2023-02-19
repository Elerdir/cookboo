package ess.cz.server.recipetag.repository;

import ess.cz.server.recipetag.model.RecipeTadPk;
import ess.cz.server.recipetag.model.RecipeTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeTagRepository extends JpaRepository<RecipeTagEntity, RecipeTadPk> {
}
