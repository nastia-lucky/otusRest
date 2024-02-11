package assertions;

import models.pets.PetDTO;
import java.util.List;

public class PetAssertions {


  public static String getPetNotCreatedAssert(Integer petId) {
    return String.format("Pet with id [%s] is not created", petId);
  }

  public static String getPetDataInconsistencyAssert(PetDTO actualData, PetDTO expectedDTO) {
    return String.format("Data of actual added pet [%s] doesn't coincide with initial data [%s]", actualData, expectedDTO);
  }

  public static String getPetNotRemovedAssert(Integer petId) {
    return String.format("Pet with id [%s] is not removed ", petId);
  }

  public static String getPetStatusNotExist(List<PetDTO> pets, String status, PetDTO pet) {
    return String.format("Got pets [%s] by status [%s] doesn't contain created pet [%s] ", pets, status, pet);
  }

  public static String getNotCorrectStatus(int status) {
    return String.format("User doesn't get status code [%s] upon action", status);
  }
}
