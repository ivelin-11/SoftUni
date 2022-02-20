package stackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;
private int index;

    public StackOfStrings(){
        this.data=new ArrayList<>();
        this.index=-1;
    }

    public void push(String item){
        this.data.add(item);
        this.index++;
    }

    public String peek(){
        return this.data.get(this.index);
    }

    public String  pop(){
        return this.data.remove(this.index--);
    }
public boolean isEmpty(){
        return this.data.isEmpty();
}
}
