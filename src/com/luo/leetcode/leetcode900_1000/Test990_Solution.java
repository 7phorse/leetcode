package com.luo.leetcode.leetcode900_1000;

import com.luo.leetcode.data.UnionFind;

/**
 * @author luoxusheng 2021/1/6 22:51
 * @version 1.0.0
 */
public class Test990_Solution {

    public boolean equationsPossible(String[] equations) {

        UnionFind unionFind = new UnionFind(26);

        for (int i = 0; i < equations.length; i++) {
            if(equations[i].contains("==")){
                int a = equations[i].charAt(0) - 'a';
                int b = equations[i].charAt(equations[i].length()-1) - 'a';
                unionFind.union(a, b);
            }
        }
        for (int i = 0; i < equations.length; i++) {
            if(equations[i].contains("!=")){
                int a = equations[i].charAt(0) - 'a';
                int b = equations[i].charAt(equations[i].length()-1) - 'a';
                if(unionFind.connected(a, b)){
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "a==c";
        int i = s.charAt(0) - 'a';
        int j = s.charAt(s.length()-1) - 'a';
        System.out.println(i);
        System.out.println(j);
    }



    class UnionFind {
        private int count;

        private int[] parent;

        private int[] size;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];

            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }
}
