package per.example.java8.program;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

public class demo29 {

    @Test
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        Assert.assertEquals(5, readDuration(props, "a"));
        Assert.assertEquals(0, readDuration(props, "b"));
        Assert.assertEquals(0, readDuration(props, "c"));
        Assert.assertEquals(0, readDuration(props, "d"));

        Assert.assertEquals(5, readDurationWithOptional(props, "a"));
        Assert.assertEquals(0, readDurationWithOptional(props, "b"));
        Assert.assertEquals(0, readDurationWithOptional(props, "c"));
        Assert.assertEquals(0, readDurationWithOptional(props, "d"));
    }

    // 非Optional 方法
    public static int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {}
        }
        return 0;
    }

    // Optional 方法
    public static int readDurationWithOptional(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(demo29::string2int)
                .filter(i -> i > 0).orElse(0);
    }

    public static Optional<Integer> string2int(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}