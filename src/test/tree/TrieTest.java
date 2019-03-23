package tree;

import com.ytf.ds.tree.trie.Trie;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @Program: datastruct
 * @Description: trie 测试
 * @Author: yutianfang
 * @Date: 19/3/22星期五
 **/
public class TrieTest {

    @Test
    public void test(){
        Trie trie = new Trie(26);

        trie.insert("apple");
        boolean result = trie.search("apple");   // returns true
        Assert.assertTrue(result);

        result = trie.search("app");     // returns false
        Assert.assertTrue(!result);

        trie.insert("applel");
        trie.insert("appeal");

        List<String> list = trie.startsWith("apple"); // size == 2
        Assert.assertTrue(list.size() == 2);

        list = trie.startsWith("app");
        Assert.assertTrue(list.size() == 3);


        trie.insert("app");
        result = trie.search("app");     // returns true
        Assert.assertTrue(result);
    }
}
