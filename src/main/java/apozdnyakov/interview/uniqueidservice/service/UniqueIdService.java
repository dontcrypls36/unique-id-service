package apozdnyakov.interview.uniqueidservice.service;

import apozdnyakov.interview.uniqueidservice.model.Response;
import apozdnyakov.interview.uniqueidservice.repository.UniqueIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

@Service
public class UniqueIdService {

    @Value("${seed}")
    private long seed;

    private final Random random = new Random();

    @Autowired
    private UniqueIdRepository uniqueIdRepository;

    @PostConstruct
    private void init() {
        random.setSeed(seed);
    }

    public Response getUniqueIdentifier() {
        long num = random.nextLong() & Long.MAX_VALUE;
        while (!uniqueIdRepository.putIfAbsent(num)) {
            num = random.nextLong() & Long.MAX_VALUE;
        }
        return new Response(num);
    }
}
