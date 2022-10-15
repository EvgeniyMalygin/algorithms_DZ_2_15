import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerListImplTest {

    private static IntegerListImpl arrayListTemp;

    @BeforeEach
    public void setArrayListTemp() {
        arrayListTemp = new IntegerListImpl(10);
    }

    private void completionArray() {
        arrayListTemp.add(1);
        arrayListTemp.add(2);
        arrayListTemp.add(3);
        arrayListTemp.add(4);
        arrayListTemp.add(5);
        arrayListTemp.add(6);
        arrayListTemp.add(7);
        arrayListTemp.add(8);
        arrayListTemp.add(9);
        arrayListTemp.add(10);
    }
    @Test
    void addCorrectData() {
        arrayListTemp.add(123);
        Assertions.assertEquals(arrayListTemp.get(0), 123);
    }

    @Test
    void addSizeNotCorrect() {
        completionArray();
        Assertions.assertThrows(StorageIsFullExeption.class, () -> arrayListTemp.add(11));
    }

    @Test
    void addItemIsNull() {
        Assertions.assertThrows(NullItemExeption.class, () -> arrayListTemp.add(null));
    }

    @Test
    void setCorrectData() {
        completionArray();
        Assertions.assertEquals(12, arrayListTemp.set(5, 12));
    }

    @Test
    void setErrorIndex() {
        Assertions.assertThrows(InvalidIndexExeption.class, () -> arrayListTemp.set(11, 12));
    }

    @Test
    void setErrorItem() {
        completionArray();
        Assertions.assertThrows(NullItemExeption.class, () -> arrayListTemp.set(9, null));
    }

    @Test
    void removeForIndexCorrectData() {
        completionArray();
        Assertions.assertEquals(arrayListTemp.get(5), arrayListTemp.remove(5));
    }

    @Test
    void removeForItemCorrectData() {
        completionArray();
        Assertions.assertEquals(6, arrayListTemp.remove((Integer) 6));
    }
    @Test
    void containsCorrectItem() {
        completionArray();
        Assertions.assertEquals(true, arrayListTemp.contains((Integer) 6));
    }
    @Test
    void containsItemNotFound() {
        completionArray();
        Assertions.assertEquals(false, arrayListTemp.contains((Integer) 66));
    }

    @Test
    void indexOfCorrectItem() {
        completionArray();
        Assertions.assertEquals(5, arrayListTemp.indexOf((Integer) 6));
    }
    @Test
    void indexOfItemNotFound() {
        completionArray();
        Assertions.assertEquals(-1, arrayListTemp.indexOf((Integer) 66));
    }

    @Test
    void lastIndexOfCorrectIt() {
        completionArray();
        Assertions.assertEquals(5, arrayListTemp.indexOf((Integer) 6));
    }
    @Test
    void lastIndexOfItemNotFound() {
        completionArray();
        Assertions.assertEquals(-1, arrayListTemp.indexOf((Integer) 66));
    }

    @Test
    void getCorrectIndex() {
        completionArray();
        Assertions.assertEquals(6, arrayListTemp.get(5));
    }

    @Test
    void equalsCorrectData() {
        completionArray();
        IntegerListImpl temp = new IntegerListImpl();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        temp.add(7);
        temp.add(8);
        temp.add(9);
        temp.add(10);
        Assertions.assertEquals(true, arrayListTemp.equals(temp));

    }
    @Test
    void equalsErrorData() {
        completionArray();
        IntegerListImpl temp = new IntegerListImpl();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        temp.add(7);
        temp.add(8);
        temp.add(9);
        temp.add(10);
        Assertions.assertEquals(false, arrayListTemp.equals(temp));

    }

    @Test
    void sizeTest() {
        completionArray();
        Assertions.assertEquals(10, arrayListTemp.size());
    }

    @Test
    void isEmptyTrue() {
        Assertions.assertEquals(true, arrayListTemp.isEmpty());
    }
    @Test
    void isEmptyFalse() {
        completionArray();
        Assertions.assertEquals(false, arrayListTemp.isEmpty());
    }

    @Test
    void toArray() {
        completionArray();
        Integer[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assertions.assertArrayEquals(temp, arrayListTemp.toArray());
    }

    @Test
    void sortInsertion(){
        completionArray();
        IntegerListImpl temp = new IntegerListImpl();
        temp.add(10);
        temp.add(9);
        temp.add(8);
        temp.add(7);
        temp.add(6);
        temp.add(5);
        temp.add(4);
        temp.add(3);
        temp.add(2);
        temp.add(1);

        Assertions.assertArrayEquals(arrayListTemp.toArray(), temp.sortInsertion());
    }

}