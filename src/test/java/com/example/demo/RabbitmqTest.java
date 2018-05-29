package com.example.demo;

import com.example.demo.pojo.User;
import com.example.demo.receiver.Receiver;
import com.example.demo.sender.Sender;
import com.example.demo.sender.Sender2;
import com.example.demo.sender.Sender3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTest {

    @Autowired
    private Sender sender;
    @Autowired
    private Sender2 sender2;
    @Autowired
    private Sender3 sender3;
    @Autowired
    private Receiver receiver;

    /**
     * 一对一发送
     *
     * @throws InterruptedException
     */
    @Test
    public void oneToOne() throws InterruptedException {
        sender.send("test");
    }

    /**
     * 一对多发送
     *
     * @throws Exception
     */
    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            sender.send(i + "");
        }
        Thread.sleep(10000l);
    }

    /**
     * 多对多发送
     *
     * @throws Exception
     */
    @Test
    public void manyToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            sender.send(i + "");
            sender2.send(i + "");
        }
        Thread.sleep(10000l);
    }

    /**
     * 发送对象
     */
    @Test
    public void testSendObject() throws InterruptedException {
        User user = new User("test", 11);
        sender3.send(user);
        Thread.sleep(10000l);
    }

}
