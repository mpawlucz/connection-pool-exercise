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
        connection.close();

        assertNull(pool.getConnection());

        Connection connection2 = pool.getConnection();
        assertNotNull(connection2);
        assertEquals(connection, connection2);

    }
}
