package com.leetcode.stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/home//foo/"));
        System.out.println(simplifyPath.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath.simplifyPath("/../"));
        System.out.println(simplifyPath.simplifyPath("/.../a/../b/c/../d/./"));
    }

    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) return "";
        Stack<String> resultStack = new Stack<>();
        String[] pathArray = path.split("/");

        for (int i = 0; i < pathArray.length; i++) {
            String dir = pathArray[i];
            if (!dir.isEmpty() && !dir.equals(".") && !dir.equals("..")) {
                resultStack.push(dir);
            } else if (dir.equals("..")) {
                if (!resultStack.isEmpty())
                    resultStack.pop();
            }
        }

        return "/" + String.join("/", resultStack);
    }
}
