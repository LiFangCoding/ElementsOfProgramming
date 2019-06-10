package _19_Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Let s and t be strings and D a dictionary, ie a set of strings.
 * Define s to produce t if there exits a sequence of strings from the dictionary P = {s0, s1,...,sn-1}
 * such that the first string is s, the last string is t. And adjacent strings have the same length and differ in
 * exactly one character. The sequence P is called a production sequence. For example,
 * if the dictionary is [bat,cot, dog, dag, dot, cat], then [cat, cot, dot, dog] is production sequence.
 * <p>
 * Given a dictionary D and two strings s and t, write a program to determine if s produces t. Assume that all characters
 * are lower alphabets. IF s does produce t, output the length of a shortest production sequence, otherwise, output -1.
 */
public class _7_TransformOneStringToAnother {
    // Hint: Treat strigns as vertices in an undirected graph, with an edge between u and v if and only if the corresponding strings
    // differ in one character.

    // Uses BFS to find the least steps of transformation
    public static int transformstring(Set<String> D, String s, String t) {
        Queue<StringWithDistance> q = new LinkedList<>();

        // Marks s as visited by erasing it in D
        D.remove(s);
        q.add(new StringWithDistance(s, 0));

        StringWithDistance f;
        while ((f = q.poll()) != null) {
            // returns if we find a match
            if (f.candidateString.equals(t)) {
                // Number of steps reaches it
                return f.distance;
            }

            // tries all possible transformations of f.first
            String str = f.candidateString;
            for (int i = 0; i < str.length(); i++) {
                String strStart = i == 0 ? "" : str.substring(0, i);
                String strEnd = i + 1 < str.length() ? str.substring(i + 1) : "";
                for (int j = 0; j < 26; j++) {
                    String modStr = strStart + (char) ('a' + j) + strEnd;
                    if (D.remove(modStr)) {
                        q.add(new StringWithDistance(modStr, f.distance + 1));
                    }
                }
            }
        }

        // cannot find a possible transformations.
        return -1;
    }

    /**
     * A brute-force approach may be to explore all strings that differ in one character from the starting string,
     * then two characters from starting string,etc. The problem with this approach is that it may explore lots of strings that
     * are outside he dictionary.
     * <p>
     * A better approach is to be more focused on dictionary words. In particular, it is natural to model this problem using graphs.
     * The vertices correspond to strings from th dictionary and the edge (u,v) indicates that strings corresponding to u and v differ
     * in exactly one character. Note tha the relation "differ in one character" is symmetric, so the graph is undirected.
     * <p>
     * For given example, the vertices would be [bat, cot, dog, dag, dot, cat].
     * Edges would be [(bat, cat),(cot, dot), (cot, cat), (dog, dag), (dog, dot)]
     * <p>
     * A production sequence is simply a path in G, so what we need is a shortest path from s to t in G.
     * Use BFS.
     * <p>
     * The number of vertices is the number d of words in the dictionary. The number of edges is, in  the worst-case, O(d^2).
     * The time complexity of BFS T= O(d + d ^ 2)
     * If the string length n is less than d, then the maximum number of edges out of a vertex is O(n), implying O(n *dd) bound.
     */

    private static class StringWithDistance {
        public String candidateString;
        public Integer distance;

        public StringWithDistance(String candidateString, Integer distance) {
            this.candidateString = candidateString;
            this.distance = distance;
        }
    }
}
