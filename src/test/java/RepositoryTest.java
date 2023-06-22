import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {


    Product item1 = new Product(78, "Хинкаль", 600);
    Product item2 = new Product(1, "Вареник", 1000);
    Product item3 = new Product(99, "Пельмень", 300);


    @Test

    public void generationOfExeption() {

        ShopRepository catchOne = new ShopRepository();
        catchOne.add(item1);
        catchOne.add(item2);
        catchOne.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            catchOne.removeById(80);
        });

    }

    @Test

    public void succesfulDeleteById() {

        ShopRepository deleteSuccesful = new ShopRepository();
        deleteSuccesful.add(item1);
        deleteSuccesful.add(item2);
        deleteSuccesful.add(item3);

        Product[] expected = {item1, item2};
        Product[] actual = deleteSuccesful.removeById(99);
        Assertions.assertArrayEquals(expected, actual);


    }

}
