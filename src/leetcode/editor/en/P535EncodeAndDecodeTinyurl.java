//Note: This is a companion problem to the System Design problem: Design 
//TinyURL. 
//
// TinyURL is a URL shortening service where you enter a URL such as https://
//leetcode.com/problems/design-tinyurl and it returns a short URL such as http://
//tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL. 
//
// There is no restriction on how your encode/decode algorithm should work. You 
//just need to ensure that a URL can be encoded to a tiny URL and the tiny URL 
//can be decoded to the original URL. 
//
// Implement the Solution class: 
//
// 
// Solution() Initializes the object of the system. 
// String encode(String longUrl) Returns a tiny URL for the given longUrl. 
// String decode(String shortUrl) Returns the original long URL for the given 
//shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
// 
// 
//
// 
// Example 1: 
//
// 
//Input: url = "https://leetcode.com/problems/design-tinyurl"
//Output: "https://leetcode.com/problems/design-tinyurl"
//
//Explanation:
//Solution obj = new Solution();
//string tiny = obj.encode(url); // returns the encoded tiny url.
//string ans = obj.decode(tiny); // returns the original url after deconding it.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= url.length <= 10⁴ 
// url is guranteed to be a valid URL. 
// 
// Related Topics Hash Table String Design Hash Function 👍 1440 👎 2783


package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Encode and Decode TinyURL
 * 
 * @author: eumes
 * @date: 2022-04-23 22:37:07
 */
 public class P535EncodeAndDecodeTinyurl {
    public static void main(String[] args) {
//        Solution_P535 solution = new Solution_P535();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Codec_Solution_P535 {

    Map<String, String> codeMap = new HashMap<>();
    Map<String, String> urlMap = new HashMap<>();
    int len = 6;
    static final char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    String prefix = "http://prefix/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlMap.containsKey(longUrl)) {
            return urlMap.get(longUrl);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int idx = (int) (Math.random() * chars.length);
            builder.append(chars[idx]);
        }
        String code = builder.toString();
        if (codeMap.containsKey(code)) {
            return encode(longUrl);
        }

        codeMap.put(code, longUrl);
        urlMap.put(longUrl, code);

        return prefix + code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeMap.get(shortUrl.substring(shortUrl.length() - len));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)
