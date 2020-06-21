import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> heap;

    public Heap(int capacity) {
        heap = new ArrayList<>(capacity);
    }

    void insert(int element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);

    }

    boolean delete(int element) {
        int index = heap.indexOf(element);
        if (index == -1) {
            return false;
        }

        int lastHeapIndex = heap.size() - 1;
        heap.set(index, heap.get(lastHeapIndex));
        heap.remove(lastHeapIndex);
        lastHeapIndex--;

        if (lastHeapIndex == 0 || lastHeapIndex == -1 || index > lastHeapIndex) {
            return true;
        }

        int parentIndex = getParentIndex(index);

        if (heap.get(parentIndex) < heap.get(index)) {
            heapifyUp(index);
        } else {

            heapifyDown(index, lastHeapIndex);

        }
        return true;
    }

    void heapifyDown(int index, int lastHeapIndex) {
        int data = heap.get(index);

        while (index < lastHeapIndex) {
            int leftChildIndex = getChildIndex(index, true);
            int rightChildIndex = getChildIndex(index, false);

            int childToSwap;
            if (leftChildIndex <= lastHeapIndex) {
                childToSwap = leftChildIndex;
                if (rightChildIndex <= lastHeapIndex) {
                    childToSwap = heap.get(leftChildIndex) > heap.get(rightChildIndex) ? leftChildIndex
                            : rightChildIndex;

                }
            } else {
                break;
            }

            if (data < heap.get(childToSwap)) {
                heap.set(index, heap.get(childToSwap));
            } else {
                break;
            }
            index = childToSwap;
        }

        heap.set(index, data);

    }

    void heapifyUp(int index) {
        int element = heap.get(index);
        int parentIndex = getParentIndex(index);

        while (index > 0 && heap.get(parentIndex) < element) {
            heap.set(index, heap.get(parentIndex));
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }

        heap.set(index, element);
    }

    int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    int getChildIndex(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public static void main(String[] args) {
        Heap heap = new Heap(20);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.heap.forEach(element -> System.out.print(element + " "));
        System.out.println();
        heap.delete(80);
        heap.heap.forEach(element -> System.out.print(element + " "));
        System.out.println();

    }
}