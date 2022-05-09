package app.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("animalsCage")
public class Timer {

    private Long nanoTime = System.nanoTime();

    public Long getTime() {
        return nanoTime;
    }
}
