import redis.clients.jedis.Jedis;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2021/2/27
 * Description:
 */
public class test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("r-bp1250fe867e5934pd.redis.rds.aliyuncs.com",6379);
        System.out.println(jedis.ping());
    }
}
