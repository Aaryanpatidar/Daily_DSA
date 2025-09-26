import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;


    public MedianFinder() {
        left = new PriorityQueue<>((a,b) -> b-a);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.add(num);
        if(!right.isEmpty() && left.peek()>right.peek()){
            right.add(left.remove());
            left.add(right.remove());
        }
        if(left.size() > (right.size()+1)){
            right.add(left.remove());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (double)(left.peek()+right.peek())/2;
        }else{
            return (double)left.peek();
        }
    }
}
