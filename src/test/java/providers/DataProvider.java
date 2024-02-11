package providers;


import models.pets.PetCategory;
import models.pets.PetDTO;
import models.pets.PetTag;
import java.util.ArrayList;
import java.util.Arrays;

public class DataProvider {

  @org.testng.annotations.DataProvider(name = "petCreationData")
  public static Object[][] petCreationData() {
    PetDTO pet1 = new PetDTO(1, new PetCategory(1, "my category"), "dog name", Arrays.asList("url"), Arrays.asList(new PetTag(1, "tag 1")), "status");
    PetDTO pet2 = new PetDTO(2, null, "dog name", Arrays.asList("url"), Arrays.asList(new PetTag(1, "tag 1")), "status");
    PetDTO pet3 = new PetDTO(3, new PetCategory(5, "s"), null, Arrays.asList("url"), Arrays.asList(new PetTag(1, "tag 1")), "status");
    PetDTO pet4 = new PetDTO(4, new PetCategory(6, "category"), "m", new ArrayList<String>(), Arrays.asList(new PetTag(1, "tag 1")), "status");
    PetDTO pet5 = new PetDTO(5, new PetCategory(7, ""), "my cat", Arrays.asList("url", "another url"), Arrays.asList(new PetTag(1, null)), "status");
    PetDTO pet6 = new PetDTO(6, new PetCategory(8, "s"), "m", Arrays.asList("url", "another url"), new ArrayList<PetTag>(), "status");
    PetDTO pet7 = new PetDTO(7, new PetCategory(9, "llllllllooonf cooonf categortllllllllooonf categort"), "monkey", Arrays.asList("url", "another url"), Arrays.asList(new PetTag(1, "tag ")), null);
    PetDTO pet8 = new PetDTO(8, new PetCategory(3, null), " llllooooooong dog name llllooooooong dog name", Arrays.asList("url"), Arrays.asList(new PetTag(2, "tag 2")), "status");
    PetDTO pet9 = new PetDTO(9, new PetCategory(4, ""), "dog name", Arrays.asList("url"), Arrays.asList(new PetTag(1, "tag 1")), "status");
    PetDTO pet10 = new PetDTO(10, null, "", Arrays.asList("my url looooooooooong url"), Arrays.asList(new PetTag(1, "tag 5")), "status");
    PetDTO pet11 = new PetDTO(11, null, "", Arrays.asList(""), Arrays.asList(new PetTag(1, "tag 5")), "status");
    PetDTO pet12 = new PetDTO(11, null, null, null, null, null);
    return new Object[][]{{pet1}, {pet2}, {pet3}, {pet4}, {pet5}, {pet6}, {pet7}, {pet8}, {pet9}, {pet10}, {pet11}, {pet12}}
        ;
  }

  @org.testng.annotations.DataProvider(name = "petDataByStatus")
  public static Object[][] petDataByStatus() {
    PetDTO pet1 = new PetDTO(1, new PetCategory(1, "my category"), "dog name", Arrays.asList("url"), Arrays.asList(new PetTag(1, "tag 1")), "s");
    PetDTO pet2 = new PetDTO(2, null, "dog name", Arrays.asList("url"), Arrays.asList(new PetTag(1, "tag 1")), "looooooooong status  looooooooong status  looooooooong status  looooooooong status ");
    PetDTO pet3 = new PetDTO(3, new PetCategory(5, "s"), null, Arrays.asList("url"), Arrays.asList(new PetTag(1, "tag 1")), "");
    PetDTO pet4 = new PetDTO(4, new PetCategory(6, "category"), "m", new ArrayList<String>(), Arrays.asList(new PetTag(1, "tag 1")), "234");
    PetDTO pet5 = new PetDTO(5, new PetCategory(7, ""), "my cat", Arrays.asList("url", "another url"), Arrays.asList(new PetTag(1, null)), "normal status");
    PetDTO pet6 = new PetDTO(6, new PetCategory(8, "s"), "m", Arrays.asList("url", "another url"), new ArrayList<PetTag>(), "2");
    return new Object[][]{{pet1}, {pet2}, {pet3}, {pet4}, {pet5}, {pet6}}
        ;
  }

  @org.testng.annotations.DataProvider(name = "petUpdateData")
  public static Object[][] petUpdateData() {
    PetDTO pet1 = new PetDTO(1, new PetCategory(1, "my category"), "dog name", Arrays.asList("url"), Arrays.asList(new PetTag(1, "tag 1")), "status");
    PetDTO updatedPet1 = new PetDTO(2, null, null, null, Arrays.asList(new PetTag(2, "tag updated")), "status updated");
    PetDTO pet2 = new PetDTO(3, null, null, null, new ArrayList<PetTag>(), "null");
    PetDTO updatedPet2 = new PetDTO(4, new PetCategory(6, "category"), "m", Arrays.asList("updated url"), Arrays.asList(new PetTag(1, "tag 1 updated")), "status updated");
    return new Object[][]{{pet1, updatedPet1}, {pet2, updatedPet2}}
        ;
  }
}
