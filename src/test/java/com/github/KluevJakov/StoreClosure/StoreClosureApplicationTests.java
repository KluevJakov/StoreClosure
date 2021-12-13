package com.github.KluevJakov.StoreClosure;

import com.github.KluevJakov.StoreClosure.controller.ClosureController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StoreClosureApplicationTests {

    @Autowired
    private ClosureController closureController;

    @Test
    void contextLoads() {
        assertThat(closureController).isNotNull();
    }

}
