package models.pets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PetDTO {

  @JsonProperty("id")
  protected Integer id;

  @JsonProperty("category")
  protected PetCategory category;

  @JsonProperty("name")
  protected String name;

  @JsonProperty("photoUrls")
  protected List<String> photoUrls;

  @JsonProperty("tags")
  protected List<PetTag> tags;

  @JsonProperty("status")
  protected String status;

}
