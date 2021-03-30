# Redis Apps using Jedis


### Start Redis Server
  Install redis from redis.io OR by Docker compose

    Start redis server:
        ` redis-server `
   
    Start redis-cli and execute below commands:
        ` redis-cli `
   
    OR

  Launch Redis and Redis-Commander from docker

   ` cd redis-pub-sub`
   ` docker-compose up redis redis-commander `

  Access redis-commander from http://localhost:8081

### Run Publisher and Consumer
   
  Launch Producer

    From IDE, start running file RedisPublisher

  Launch Consumer

    From IDE, start running file RedisConsumer

### Run Setter and Getter from Redis Cache

  Launch Setter

    From IDE, start running file RedisCacheSetter

  Launch Getter

    From IDE, start running file RedisCacheGetter