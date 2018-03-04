package com.simply.tp.sakilaflix.service;

/**
 * Created by shreeharshashet on 2/7/18.
 */


import com.simply.tp.sakilaflix.dao.MovieSeviceDAO;
import org.hibernate.cfg.Environment;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:testcontext.xml")
@TestPropertySource("classpath:test.properties")
public class MovieServiceTest {

    @Autowired
    MovieSeviceDAO mdao;

    @Test
    @Ignore
    public void movieServiceTest(){
        mdao.searchFilmsByTitle("GANDHI");
        fail("not yet done");
    }

    @Test
    public void redisTest(){
        System.out.println("**************  ****************");
        Config rConf = new Config();
        rConf.useSingleServer().setAddress("redis://192.168.1.3:6379");
        RedissonClient rc = Redisson.create(rConf);

        RList<Object> alist = rc.getList("alist");
        alist.add("Shree");

        //Environment.CACHE_PROVIDER_CONFIG

        System.out.println("**************** &&&&&&&&&&&&& * *********************");
    }
}
