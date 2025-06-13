package org.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        GestorCuentasTest.class,
        GestorCuentasTestMock.class,
})

public class SuiteTests {
}

