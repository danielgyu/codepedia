package com.mayfly.interview.graphs;

import java.util.HashSet;
import java.util.Set;

public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree one,
            AncestralTree two
    ) {
        Set<AncestralTree> setOne = new HashSet<>();

        while (one != topAncestor) {
            setOne.add(one);
            one = one.ancestor;
        }

        while (two != topAncestor) {
            if (setOne.contains(two)) {
                return two;
            }
        }

        return null;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }
    }

}
