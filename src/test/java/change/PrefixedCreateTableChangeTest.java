package change;

import com.example.change.PrefixedCreateTableChange;
import liquibase.statement.core.CreateTableStatement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixedCreateTableChangeTest {

    private PrefixedCreateTableChange prefixedCreateTableChange;

    @BeforeEach
    void setUp() {
        prefixedCreateTableChange = new PrefixedCreateTableChange();
    }

    @Test
    void getPrefix_returnsNull_whenNotSet() {
        assertNull(prefixedCreateTableChange.getPrefix());
    }

    @Test
    void getPrefix_returnsPrefix_whenSet() {
        String expectedPrefix = "testPrefix";
        prefixedCreateTableChange.setPrefix(expectedPrefix);

        assertEquals(expectedPrefix, prefixedCreateTableChange.getPrefix());
    }

}
