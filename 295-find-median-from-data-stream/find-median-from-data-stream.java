import java.util.*;

class MedianFinder {
    // Left side (Max Heap) stores the smaller half
    private PriorityQueue<Integer> leftHeap;
    // Right side (Min Heap) stores the larger half
    private PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        // Init heaps
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Optimization: Decide strictly where to put it first
        if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
            leftHeap.add(num);
        } else {
            rightHeap.add(num);
        }

        // Rebalance Step: Ensure size difference is never > 1
        
        // If Left is too heavy (more than 1 element bigger than Right)
        if (leftHeap.size() > rightHeap.size() + 1) {
            rightHeap.add(leftHeap.poll());
        }
        // If Right is too heavy (Right should never be bigger than Left in my design)
        else if (rightHeap.size() > leftHeap.size()) {
            leftHeap.add(rightHeap.poll());
        }
    }
    
    public double findMedian() {
        // If Left has more elements, it holds the median
        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peek();
        }
        // Otherwise, it's the average of the two peaks
        return (leftHeap.peek() + rightHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */