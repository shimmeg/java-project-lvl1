package hexlet.code.mindgames.io;

public interface InputOutputStrategy {

    String readNext();
    int readNextInt();
    void print(String text);
    void println(String text);
}
