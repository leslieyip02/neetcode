class Solution {

    private static String divider = "x";
    private static Map<String, Integer> encodings = new HashMap<>();
    private static Map<Integer, String> decodings = new HashMap<>();
    private static int encoding = 0;

    public String encode(List<String> strs) {
        List<String> indices = new ArrayList<>();
        for (String str : strs) {
            if (!encodings.containsKey(str)) {
                encodings.put(str, encoding);
                decodings.put(encoding, str);
                encoding++;
            }
            indices.add(String.valueOf(encodings.get(str)));
        }
        return String.join(divider, indices);
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        if (str.length() == 0) {
            return decoded;
        }

        for (String section : str.split(divider)) {
            int index = Integer.parseInt(section);
            decoded.add(new String(decodings.get(index)));
        }
        return decoded;
    }
}

