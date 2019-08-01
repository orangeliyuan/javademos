package per.example.java8.lambda;

/**
 * 1.
 * 函数式接口就是之定义一个抽象方法的接口，
 * lamdba 表达式允许你直接以内敛的形式为函数式接口的抽象方法
 * 提供实现，并把整个表达式作为函数式接口的实例。就是之前需要传Predicate<T>的位置传了一个lamdba
 *
 * 2.
 * @FunctionalInterface 注解用于编译级错误检查，加上该注解，当你写的接口不符合函数式接口定义的时候，编译器会报错
 * https://www.cnblogs.com/chenpi/p/5890144.html
 * 函数式接口里允许定义默认方法
 * 函数式接口里允许定义静态方法
 *
 * 3. 函数描述符
 * 函数式接口的抽象方法的签名（参数列表和返回值）基本上就是Lamdba表达式的签名，
 * 我们将这种抽象方法叫做函数描述符
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * lamdba 使用步骤：
 * 1. 行为参数化
 * 2. 使用函数式接口传递行为
 * 3. 执行一个行为
 * 4. 传递lamdba
 */
public class demo4 {

    public static void main(String[] args) throws IOException {
        System.out.println(processFileLimited());
        System.out.println(processFile((BufferedReader br) -> br.readLine() + br.readLine()));
        System.out.println(processFile(BufferedReader::readLine));
    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/liyuan/Desktop/temp1.txt"))) {
            return reader.readLine();
        }
    }

    // 函数式接口传递lamdba
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/liyuan/Desktop/temp1.txt"))) {
            return p.process(reader);
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor{
        String process(BufferedReader b) throws IOException;
    }
}
