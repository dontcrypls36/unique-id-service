package apozdnyakov.interview.uniqueidservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class UniqueIdRepository {

    public static final String HASH_NAME = "UNIQUE_IDS";

    @Autowired
    private RedisTemplate redisTemplate;

    private HashOperations hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public boolean putIfAbsent(Long num) {
        return hashOperations.putIfAbsent(HASH_NAME, num, num);
    }
}
