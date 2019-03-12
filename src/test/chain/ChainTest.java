package chain;

import com.ytf.ds.chain.Chain;
import com.ytf.ds.chain.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yutianfang
 * DATE: 17/12/5星期二.
 */
public class ChainTest {

    @Test
    public void insert() {
        Chain<Integer> chain = new Chain<>();
        for (int i = 1; i < 10; i++) {
            chain.insert(i - 1, i);
        }

        System.out.print(chain);
        Assert.assertTrue(chain.length() == 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertOutOfBound() {
        Chain<Integer> chain = new Chain<>();
        chain.insert(1, 1);
    }

    @Test
    public void delete(){
        Chain<Integer> chain = buildChain();
        Assert.assertTrue(chain.delete(1).getValue() == 1);
        System.out.println(chain);
        Assert.assertTrue(chain.length() == 8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteOutOfBound(){
        Chain<Integer> chain = buildChain();
        chain.delete(0);
    }

    @Test
    public void find(){
        Chain<Integer> chain = buildChain();
        Assert.assertTrue(chain.find(2).getValue() == 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findOutOfBound(){
        Chain<Integer> chain = buildChain();
        chain.find(10);
    }

    @Test
    public void append(){
        Chain<Integer> chain = new Chain<>();
        Assert.assertTrue(chain.append(1).length() == 1);

        chain = buildChain();
        Assert.assertTrue(chain.append(1).length() == 10);
    }

    @Test
    public void reverse(){
        Chain<Integer> chain = new Chain<>();
        for (int i = 1; i <= 3; i++) {
            chain.insert(i - 1, i);
        }

        System.out.println(chain);


        Node newHead = reverse(chain.find(1));
        Node node = newHead;
        while (node != null){
            System.out.print(node.getValue());
            node = node.getNext();
        }
    }

    private Node reverse(Node node){
        // 找到最后一一个
        if(node == null || node.getNext() == null){
            return node;
        }

        Node newHead = reverse(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);

        return newHead;
    }
    private Chain<Integer> buildChain() {
        Chain<Integer> chain = new Chain<>();
        for (int i = 1; i < 10; i++) {
            chain.insert(i - 1, i);
        }
        return chain;
    }
}
