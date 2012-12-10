package mongodb;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

public class Main {
	private static final Log log = LogFactory.getLog(Main.class);

	public static void main(String[] args) throws Exception {

		MongoOperations mongoOps = new MongoTemplate(new Mongo("172.16.6.191"), "gaojice");
		log.info("insert start");
		for (int i = 0; i < 100000; i++) {
			mongoOps.insert(new Person("Joe" + RandomUtils.nextInt(100000000), 34));

		}

		log.info("insert end");

		// mongoOps.dropCollection("person");
	}
}
