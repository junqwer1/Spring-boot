package org.koreait.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class TestJob {

//    @Scheduled(fixedRate = 3L, timeUnit = TimeUnit.SECONDS)
    public void testScheduling() {
        log.info("3초 마다 실행!");
    }
}
