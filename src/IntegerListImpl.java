import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private final Integer[] arrayInteger;
    private int size;

    public IntegerListImpl() {

        arrayInteger = new Integer[10];
    }

    public IntegerListImpl(int initSize) {

        arrayInteger = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        arrayInteger[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            arrayInteger[size++] = item;
            return item;
        }
        System.arraycopy(arrayInteger, index, arrayInteger, index + 1, size - index);
        arrayInteger[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        arrayInteger[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundExeption();
        }
        if (index != size) {
            System.arraycopy(arrayInteger, index + 1, arrayInteger, index, size - index -1);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer item = arrayInteger[index];

        if (index != size) {
            System.arraycopy(arrayInteger, index + 1, arrayInteger, index, size - index - 1);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {

        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (arrayInteger[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayInteger[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return arrayInteger[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(arrayInteger, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemExeption();
        }
    }

    private void validateSize() {
        if (size == arrayInteger.length) {
            throw new StorageIsFullExeption();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexExeption();
        }
    }
}
