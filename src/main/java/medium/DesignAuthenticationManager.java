package medium;

import  java.util.*;

public class DesignAuthenticationManager {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            AuthenticationManager authenticationManager = new AuthenticationManager(5); // Constructs the AuthenticationManager with timeToLive = 5 seconds.
            authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
            authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
            authenticationManager.countUnexpiredTokens(6); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
            authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
            authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
            authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
            authenticationManager.countUnexpiredTokens(15); // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.
        }

        class AuthenticationManager {

            private int timeToLive;
            private Map<String, Integer> tokenToExpiry;
            private TreeMap<Integer, String> expiryToToken;

            public AuthenticationManager(int timeToLive) {
                this.timeToLive = timeToLive;
                this.tokenToExpiry = new HashMap<>();
                this.expiryToToken = new TreeMap<>();
            }

            public void generate(String tokenId, int currentTime) {
                tokenToExpiry.put(tokenId, currentTime+timeToLive);
                expiryToToken.put(currentTime+timeToLive, tokenId);
            }

            public void renew(String tokenId, int currentTime) {
                if(!tokenToExpiry.containsKey(tokenId)){
                    return;
                }

                final int tokenTime = tokenToExpiry.get(tokenId);
                if(!isExpired(tokenTime, currentTime)){
                    expiryToToken.remove(tokenTime);
                    generate(tokenId,currentTime);
                }
            }

            public int countUnexpiredTokens(int currentTime) {
                while (!expiryToToken.isEmpty() && isExpired(expiryToToken.firstKey(), currentTime)){
                    tokenToExpiry.remove(expiryToToken.get(expiryToToken.lastKey()));
                    expiryToToken.remove(expiryToToken.lastKey());
                }

                return tokenToExpiry.size();
            }

            private boolean isExpired(int tokenTime, int currentTime) {
                return tokenTime <= currentTime;
            }
        }
    }
}
