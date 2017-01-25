public class QuickSort {

    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        if (values == null || values.length == 0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number);

    }

    private int getMedian(int a, int b, int c) {
        if (numbers[a] > numbers[b]) {
            if (numbers[a] > numbers[c]) {
                if (numbers[c] > numbers[b]) {
                    return c;
                } else {
                    return b;
                }
            } else {
                return a;
            }
        } else if (numbers[a] > numbers[c]) {
            return a;
        } else if (numbers[b] > numbers[c]) {
            return c;
        } else {
            return b;
        }
    }

    private void quicksort(int low, int high) {
        if (high - low <= 1) return;
        if (high - low == 2) {
            if (numbers[low] > numbers[high - 1])
                exchange(low, high - 1);
            return;
        }

        int i = low + 1;
        int pivot = medianOfThreeAsPivot(low, (high + low - 1)/2, high - 1);

        for (int j = low + 1; j < high; j++) {
            if (numbers[j] < pivot) {
                exchange(i, j);
                i++;
            }
        }

        exchange(low, i - 1);

        quicksort(low, i - 1);
        quicksort(i, high);
    }

    private int firstElementAsPivot(int index) {
        return numbers[index];
    }

    private int lastElementAsPivot(int first, int last) {
        exchange(first, last);
        return numbers[first];
    }

    private int medianOfThreeAsPivot(int first, int second, int third) {
        exchange(first, getMedian(first, second, third));
        return numbers[first];
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
