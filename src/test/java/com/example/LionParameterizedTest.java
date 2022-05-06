package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class LionParameterizedTest {
        private final String sex;
        private final boolean expectedHasMane;

        public LionParameterizedTest(String sex, boolean expectedHasMane) {
            this.sex = sex;
            this.expectedHasMane = expectedHasMane;
        }

        @Parameterized.Parameters
        public static Object[][] getLionData() {
            return new Object[][] {
                    {"Самец", true},
                    {"Самка", false},
            };
        }

        @Test
        public void doesReturnCorrectHasMane() throws Exception {
            Lion lion = new Lion(sex);
            boolean actualHasMane = lion.doesHaveMane();
            Assert.assertEquals(expectedHasMane, actualHasMane);
        }
    }