package com.github.mpawlucz.connectionpool.test;

import com.github.mpawlucz.connectionpool.Connection;
import com.github.mpawlucz.connectionpool.impl.ConnectionImpl;
import com.github.mpawlucz.connectionpool.impl.PoolImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PoolImplTest {

    @Test
    void shouldReturnToPoolAfterClose() throws IOException {

        PoolImpl pool = new PoolImpl(Arrays.<Connection>asList(new ConnectionImpl()));

        Connection connection = pool.getConnection();
        assertNull(pool.getConnection());
        connection.close();

        Connection connection2 = pool.getConnection();
        assertNotNull(connection2);
        assertEquals(connection, connection2);

    }

    @Test
    void shouldPreserveInstance(){
        ConnectionImpl connectionFeed = new ConnectionImpl();
        PoolImpl pool = new PoolImpl(Arrays.<Connection>asList(connectionFeed));

        Connection connection = pool.getConnection();
        assertTrue(connection instanceof ConnectionImpl);
    }

}
