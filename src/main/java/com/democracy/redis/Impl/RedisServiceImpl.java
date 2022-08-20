package com.democracy.redis.Impl;

import com.democracy.redis.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void setValues(String key, String data) {
        redisTemplate.opsForValue().set(key, data);
    }

    @Override
    public void setValues(String key, String data, Duration duration) {
        redisTemplate.opsForValue().set(key, data, duration);
    }

    @Override
    public String getValues(String key) {
        return (String) redisTemplate.opsForValue().get(key);

    }

    @Override
    public void deleteValues(String key) {
        redisTemplate.delete(key);
    }
}
