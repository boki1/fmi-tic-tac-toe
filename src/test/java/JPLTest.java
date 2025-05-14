import org.jpl7.Query;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JPLTest {
    @Test
    public void testPrologVersion() {
        Query q = new Query("current_prolog_flag(version, V)."); // term
        assertEquals("90324", q.oneSolution().get("V").toString());
    }
}
