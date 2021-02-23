package com.phorse.monkey.leetcode.data;

/**
 * @author luoxusheng 2021/1/6 22:15
 * @version 1.0.0
 */
public class UnionFind {
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
        if(size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];

        }
        count--;
    }

    public boolean connected(int p, int q){
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

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(20);
        unionFind.union(1,2);
        unionFind.union(2,3);
        int i = unionFind.find(2);
        System.out.println(i);
        System.out.println(unionFind.connected(1, 3));
    }
}
