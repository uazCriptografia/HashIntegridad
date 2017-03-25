import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by porfirio on 3/24/17.
 */
public class StringUtils {
    public static String getHash(String string) {
        char[] chars = string.toCharArray();
        int hash = (int) chars[0];
        for (int i = 1; i < chars.length; i++) {
            hash = hash ^ (int) chars[i];
        }
        String binario = Integer.toBinaryString(hash);
        if (binario.length() < 8) {
            int faltantes = 8 - binario.length();
            for (int i = 0; i < faltantes; i++)
                binario = "0" + binario;
        }
        return binario;
    }

    public static String suffle(String string) {
        List<Character> characterList = new ArrayList<>();
        for (char c : string.toCharArray())
            characterList.add(c);
        Collections.shuffle(characterList);
        StringBuilder sb = new StringBuilder();
        for (char c : characterList)
            sb.append(c);
        return sb.toString();
    }
}
