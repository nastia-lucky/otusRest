package services;

import io.qameta.allure.Step;
import models.pets.PetDTO;
import utils.HttpMethods;

import java.util.Arrays;
import java.util.List;

public class PetService {

  private final String petPath = "pet/";

  @Step("Create pet")
  public void createPet(PetDTO pet) {
    HttpMethods.post(pet, petPath, 200);
  }

  @Step("Check whether pet exists")
  public boolean isPetExists(Integer petId) {
    return HttpMethods.getStatusCode(petPath + petId) == 200;
  }

  @Step("Remove pet")
  public void removePet(Integer petId) {
    HttpMethods.delete(petPath + petId, 200);
  }

  @Step("Remove pe and get status code")
  public int removeGetStatusCodePet(Integer petId) {
    return HttpMethods.deleteAndGetStatusCode(petPath + petId);
  }


  @Step("Check whether pet removed")
  public boolean isPetRemoved(Integer petId) {
    return HttpMethods.getStatusCode(petPath + petId) == 404;
  }

  @Step("Check whether pet exists")
  public PetDTO getPet(Integer petId) {
    return HttpMethods.getResponse(petPath + petId).getBody().as(PetDTO.class);
  }

  @Step("Get pet by status")
  public List<PetDTO> getPetByStatus(String status) {
    return Arrays.asList(HttpMethods.getWithParam(petPath + "findByStatus", 200, "status", status).getBody().as(PetDTO[].class));
  }

  @Step("Update pet")
  public void updatePet(PetDTO updatedValue) {
    HttpMethods.put(updatedValue, petPath, 200);
  }

}
