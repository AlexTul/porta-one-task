import com.tuleninov.portaone.task.AppReturn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppReturnTest {

    @Test
    void testReturnFirstUniqueCharNull() {
        var ch = new AppReturn();

        assertThrows(IllegalStateException.class, () -> ch.returnFirstUniqueChar(null));
    }

    @Test
    void testReturnAppEmpty() {
        String text = "";
        var ch = new AppReturn();

        assertThrows(IllegalStateException.class, () -> ch.returnFirstUniqueChar(text));
    }

    @Test
    void testReturnAppBlank() {
        String text = " ";
        var ch = new AppReturn();

        assertThrows(IllegalStateException.class, () -> ch.returnFirstUniqueChar(text));
    }

    @Test
    void testAppReturnText1() {
        String text = """
                The Tao gave birth to machine language. Machine language gave birth to the assembler.
                The assembler gave birth to the compiler. Now there are ten thousand languages.
                Each language has its purpose, however humble. Each language expresses the Yin and Yang of software.Each language has its place within the Tao.
                But do not program in COBOL if you can avoid it. -- Geoffrey James, "The Tao of Programming"
                """;
        var ch = new AppReturn();

        assertEquals('m', ch.returnFirstUniqueChar(text));
    }

    @Test
    void testAppReturnText2() {
        String text2 = """
                C makes it easy for you to shoot yourself in the foot.
                C++ makes that harder, but when you do, it blows away your whole leg. (с) Bjarne Stroustrup
                """;
        var ch = new AppReturn();

        assertEquals('e', ch.returnFirstUniqueChar(text2));
    }
}
