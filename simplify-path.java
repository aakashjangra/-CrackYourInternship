//Problem link - https://leetcode.com/problems/simplify-path/

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");
        
        for(String dir: directories){
            if(dir.equals(".") || dir.length() == 0){
                continue;
            } else if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }

        return "/" + String.join("/", stack);
    }
}