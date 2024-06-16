package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import main.Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GraphTest {

    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
        // 根据test.txt文件内容构建图，这里假设test.txt文件中的每个单词都是图中的一个节点
        String content = "wish you goodmorning, goodafternoon, and goodnight.";
        String[] words = content.split("\\s+|,\\s*|\\.");
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (String word : wordSet) {
            graph.addVertex(word);
        }
        // 假设图中的每个单词都与其他所有单词相连，权重为1
        for (String word1 : wordSet) {
            for (String word2 : wordSet) {
                if (!word1.equals(word2)) {
                    graph.addEdge(word1, word2, 1);
                }
            }
        }
    }

    @Test
    public void testRandomWalk() {
        String path = graph.randomWalk();
        assertTrue(path.length() > 0); // 确保路径不为空

        // 验证路径中的每个节点是否在图中
        String[] pathNodes = path.split(" -> ");
        for (String node : pathNodes) {
            assertTrue(graph.adjList.containsKey(node));
        }

        // 验证路径是否保存到文件中
        File walkFile = new File("randomWalk.txt");
        assertTrue(walkFile.exists());
        assertEquals(path, readAllText(walkFile));
        walkFile.delete(); // 测试后删除文件
    }

    private String readAllText(File file) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}