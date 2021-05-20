package com.nssp.token.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    private final String host;
    private final int port;
    private final String password;
    private final int database;
    private LettuceConnectionFactory connection;

    public RedisConfig(@Value("${spring.redis.port}") int port,
                       @Value("${spring.redis.host}") String host,
                       @Value("${spring.redis.password}") String password,
                       @Value("${spring.redis.database}") int database) {
        this.port = port;
        this.host = host;
        this.password = password;
        this.database = database;
    }

    @Bean
    public void getConn() {
        var conn = new RedisStandaloneConfiguration();
        conn.setDatabase(this.database);
        conn.setPort(this.port);
        conn.setHostName(this.host);
        conn.setPassword(this.password);
        connection = new LettuceConnectionFactory(conn);
    }

    @Bean
    public RedisTemplate<String, String> getTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connection);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        template.setEnableDefaultSerializer(false);
        template.setEnableTransactionSupport(true);
        return template;
    }
}
