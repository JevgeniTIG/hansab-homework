package ee.hansab.homework.security;

import java.util.Arrays;
import java.util.List;

public class SecurityConstants {

    public static final List<String> allowed = Arrays.asList(
            "/users",
            "/users/**",
            "/cars",
            "/cars/**");
}
