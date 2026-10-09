class Solution {

    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<String>();

        if (digits.isEmpty())
            return out;

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backtrack(digits, out, 0, new ArrayList<>());

        return out;
    }

    private void backtrack(String digits, List<String> out, int index, List<Character> current) {
        if (current.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for(char ch : current)
                sb.append(ch);
            out.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));

        for(char c : letters.toCharArray()) {
            current.add(c);
            backtrack(digits, out, index+1, current);
            current.remove(current.size()-1);
        }
    }
}
