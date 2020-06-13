package com.ibm.mdm.api;

import com.ibm.mdm.model.Service;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class MongoDbTest {

    @Test
    public void insertTest() {
        PanacheMock.mock(Service.class);

        // Mocked classes always return a default value
        Assertions.assertEquals(0, Service.count());

        // Now let's specify the return value
        Mockito.when(Service.count()).thenReturn(23l);
        Assertions.assertEquals(23, Service.count());
    }

}
