import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {


    Product item1 = new Product(78, "Хинкаль", 600);
    Product item2 = new Product(1, "Вареник", 1000);
    Product item3 = new Product(99, "Пельмень", 300);
    Product item4 = new Product(99, "Плесень", 0);


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

    public void successfulDeleteById() {

        ShopRepository deleteSuccessful = new ShopRepository();
        deleteSuccessful.add(item1);
        deleteSuccessful.add(item2);
        deleteSuccessful.add(item3);

        Product[] expected = {item1, item2};
        Product[] actual = deleteSuccessful.removeById(99);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void alreadyExist() {

        ShopRepository addOne = new ShopRepository();
        addOne.add(item3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            addOne.add(item4);
        });

    }

    @Test

    public void successfulAdd() {

        ShopRepository addSuccessful = new ShopRepository();
        addSuccessful.add(item1);
        addSuccessful.add(item2);

        Product[] expected = {item1, item2, item3};
        Product[] actual = addSuccessful.add(item3);
        Assertions.assertArrayEquals(expected, actual);
    }

}
