import com.delaney.closingbrackets.Application;;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AplicationTest {

    @BeforeEach
    public void initialise() {
        Application.openingBracket.put('}', '{');
        Application.openingBracket.put(']', '[');
        Application.openingBracket.put(')', '(');
    }

    @Test
    public void hasClosingBracketsTest_null() {
        assertFalse(Application.hasClosingBrackets(null));
    }

    @Test
    public void hasClosingBracketsTest_invalid() {
        assertFalse(Application.hasClosingBrackets("({}(".toCharArray()));
    }
    @Test
    public void hasClosingBracketsTest_valid() {
        assertTrue(Application.hasClosingBrackets("({})".toCharArray()));
    }
}
