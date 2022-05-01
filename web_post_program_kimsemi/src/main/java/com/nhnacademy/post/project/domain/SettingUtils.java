package com.nhnacademy.post.project.domain;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SettingUtils {
    private SettingUtils() {
    }
    public static void settingCounter(ServletContext context) {
        String counterFileName = context.getInitParameter("counterFileName");
        Integer counter = null;

        try (DataInputStream dis = new DataInputStream(
            Objects.requireNonNull(
                SettingUtils.class.getResourceAsStream("/" + counterFileName)))) {
            counter = dis.readInt();
        } catch (IOException e) {
            log.error("", e);
        }
        counter = Optional.ofNullable(counter).orElse(0);
        context.setAttribute("counter", counter);
    }
}
