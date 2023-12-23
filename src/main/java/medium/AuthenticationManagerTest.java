package medium;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManagerTest {
    public static void main(String[] args) {
        /*AuthenticationManager authenticationManager = new AuthenticationManager(6); // Constructs the AuthenticationManager with timeToLive = 5 seconds.
        authenticationManager.generate("kxlq", 9); // No token exists with tokenId "aaa" at time 1, so nothing happens.
        authenticationManager.renew("avem", 10); // Generates a new token with tokenId "aaa" at time 2.
        System.out.println(authenticationManager.countUnexpiredTokens(15));
*/
        AuthenticationManager authenticationManager = new AuthenticationManager(13); // Constructs the AuthenticationManager with timeToLive = 5 seconds.
        authenticationManager.generate("ybiqb", 13); // No token exists with tokenId "aaa" at time 1, so nothing happens.
        authenticationManager.renew("ybiqb", 21); // Generates a new token with tokenId "aaa" at time 2.
        System.out.println(authenticationManager.countUnexpiredTokens(29)); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
    }

    static
    class AuthenticationManager {

        int timeToLive;
        Map<String, Integer> tokenMap;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.tokenMap = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            tokenMap.put(tokenId, currentTime+timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if(!tokenMap.containsKey(tokenId)){
                return;
            }

            int tokenTime = tokenMap.get(tokenId);
            if(isBetween(tokenTime, currentTime)){
                generate(tokenId,currentTime);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            return (int)tokenMap.entrySet().stream()
                    .map(m->m.getValue())
                    .filter(t -> isBetween(t, currentTime))
                    .count();
        }

        private boolean isBetween(int tokenTime, int timeToValid){
            return timeToValid < tokenTime && timeToValid >= tokenTime - timeToLive;
        }
    }
}
