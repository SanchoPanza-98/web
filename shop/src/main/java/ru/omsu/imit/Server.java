package ru.omsu.imit;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.omsu.imit.utils.MyBatisUtils;
import ru.omsu.imit.utils.spring.ConfigUtils;

class Parameters{
    @Parameter(names = { "-f" }, arity = 1,
            description = "name of file with configuration properties")
    String fileName = "config.properties";
}

@SpringBootApplication
public class Server {

    public static void main(String[] args) {
        MyBatisUtils.initSqlSessionFactory();
        Parameters parameters = new Parameters();
        JCommander jc = new JCommander(parameters);
        jc.parse(args);

        new ConfigUtils(parameters.fileName);
        SpringApplication.run(Server.class, args);

    }
}