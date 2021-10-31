class Solution {
    public static Map<String, Integer> monthMap = new HashMap<String, Integer>() {{
        put("Jan", 1);
        put("Feb", 2);
        put("Mar", 3);
        put("Apr", 4);
        put("May", 5);
        put("Jun", 6);
        put("Jul", 7);
        put("Aug", 8);
        put("Sep", 9);
        put("Oct", 10);
        put("Nov", 11);
        put("Dec", 12);
    }};
    public String reformatDate(String date) {
        String[] dmy = date.split(" ");
        String d = dmy[0].substring(0, dmy[0].length() - 2);
        if (d.length() == 1)
            d = "0" + d;
        String m = String.valueOf(monthMap.get(dmy[1]));
        if (m.length() == 1)
            m = "0" + m;
        String y = dmy[2];
        
        return y + "-" + m + "-" + d;
    }
}