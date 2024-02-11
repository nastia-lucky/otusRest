package services;

import models.pets.PetDTO;
import utils.HttpMethods;
import java.util.Arrays;
import java.util.List;

public class PetService {

  private final String petPath = "pet/";

  public void createPet(PetDTO pet) {
    HttpMethods.post(pet, petPath, 200);
  }

  public boolean isPetExists(Integer petId) {
    return HttpMethods.getStatusCode(petPath + petId) == 200;
  }

  public void removePet(Integer petId) {
    HttpMethods.delete(petPath + petId, 200);
  }

  public int removeGetStatusCodePet(Integer petId) {
    return HttpMethods.deleteAndGetStatusCode(petPath + petId);
  }


  public boolean isPetRemoved(Integer petId) {
    return HttpMethods.getStatusCode(petPath + petId) == 404;
  }

  public PetDTO getPet(Integer petId) {
    return HttpMethods.getResponse(petPath + petId).getBody().as(PetDTO.class);
  }

  public List<PetDTO> getPetByStatus(String status) {
    return Arrays.asList(HttpMethods.getWithParam(petPath + "findByStatus", 200, "status", status).getBody().as(PetDTO[].class));
  }

  public void updatePet(PetDTO updatedValue) {
    HttpMethods.put(updatedValue, petPath, 200);
  }

}
