package task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeadlineTest {

    @Test
    public void constructor_invalidDate_throwsException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Deadline("homework", "2019-12-02"));
        assertEquals("date must be in format D/M/YYYY HHmm", e.getMessage());
    }

    @Test
    public void constructor_valid_success() {
        Deadline d = new Deadline("homework", "2/12/2019 1800");
        String result = d.toString();
        assertTrue(result.contains("homework"));
        assertTrue(result.contains("Dec"));
    }
}
