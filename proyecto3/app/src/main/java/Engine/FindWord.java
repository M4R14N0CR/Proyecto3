package Engine;

public class FindWord {

	public boolean findWord(String pBaseWord, String pWordTofind) {
		
		
        if (pBaseWord == null || pWordTofind.length() > pBaseWord.length()) {
            return false;
        }
        
        if (pWordTofind == null || pWordTofind.length() == 0) {
            return false;
        }
 
        for (int i = 0; i <= pBaseWord.length() - pWordTofind.length(); i++)
        {
            int j;
            for (j = 0; j < pWordTofind.length(); j++) {
                if (pWordTofind.charAt(j) != pBaseWord.charAt(i + j)) {
                    break;
                }
            }
 
            if (j == pWordTofind.length()) {
                return true;
            }
        }
 
        return false;
	}
}
