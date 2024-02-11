package tests;

import assertions.PetAssertions;
import providers.DataProvider;
import models.pets.PetDTO;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;
import java.util.List;

public class PetTests extends BaseTest {

  @Test(dataProvider = "petCreationData", dataProviderClass = DataProvider.class)
  public void createPetTest(PetDTO pet) {
    petService.createPet(pet);
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(petService.isPetExists(pet.getId()),
        PetAssertions.getPetNotCreatedAssert(pet.getId()));
    PetDTO actualPet = petService.getPet(pet.getId());
    softAssert.assertEquals(actualPet, pet,
        PetAssertions.getPetDataInconsistencyAssert(actualPet, pet));
    softAssert.assertAll();
  }

  @Test(dataProvider = "petDataByStatus", dataProviderClass = DataProvider.class)
  public void getCreatedPetByStatus(PetDTO pet) {
    petService.createPet(pet);
    SoftAssert softAssert = new SoftAssert();
    List<PetDTO> petsWithStatus = petService.getPetByStatus(pet.getStatus());
    softAssert.assertTrue(petsWithStatus.contains(pet),
        PetAssertions.getPetStatusNotExist(petsWithStatus, pet.getStatus(), pet));
    softAssert.assertAll();
  }

  @Test(dataProvider = "petCreationData", dataProviderClass = DataProvider.class)
  public void removePetTest(PetDTO pet) {
    petService.createPet(pet);
    SoftAssert softAssert = new SoftAssert();
    petService.removePet(pet.getId());
    softAssert.assertTrue(petService.isPetRemoved(pet.getId()),
        PetAssertions.getPetNotRemovedAssert(pet.getId()));
    softAssert.assertAll();
  }

  @Test(dataProvider = "petCreationData", dataProviderClass = DataProvider.class)
  public void removeAlreadyRemovedPetTest(PetDTO pet) {
    petService.createPet(pet);
    SoftAssert softAssert = new SoftAssert();
    petService.removePet(pet.getId());
    softAssert.assertEquals(petService.removeGetStatusCodePet(pet.getId()), 404,
        PetAssertions.getNotCorrectStatus(404));
    softAssert.assertAll();
  }

  @Test(dataProvider = "petUpdateData", dataProviderClass = DataProvider.class)
  public void updatedPetTest(PetDTO pet, PetDTO updatedPetData) {
    petService.createPet(pet);
    Integer createdPetId = pet.getId();
    updatedPetData.setId(createdPetId);
    petService.updatePet(updatedPetData);
    SoftAssert softAssert = new SoftAssert();
    PetDTO actualPet = petService.getPet(createdPetId);
    softAssert.assertEquals(actualPet, updatedPetData,
        PetAssertions.getPetDataInconsistencyAssert(actualPet, updatedPetData));
    softAssert.assertAll();
  }
}
