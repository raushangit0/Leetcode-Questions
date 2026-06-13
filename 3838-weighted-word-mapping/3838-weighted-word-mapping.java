class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < words.length ; i++)
            {
                long sum = 0;
                String word = words[i];

                for(int j = 0 ; j < word.length() ; j++)
                    {
                        sum += weights[word.charAt(j) - 'a'];
                    }
                int rem = (int)(sum % 26);
                char mapChar = (char)('z' - rem);

                result.append(mapChar);
            }
        return result.toString();
    }
}