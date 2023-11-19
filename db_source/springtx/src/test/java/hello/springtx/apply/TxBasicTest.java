package hello.springtx.apply;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
public class TxBasicTest {

    @Autowired
    BasicService basicService;

    @Test
    void proxyCheck() {
        log.info("aop class ={}", basicService.getClass());
        Assertions.assertThat(AopUtils.isAopProxy(basicService)).isTrue();

    }

    @Test
    void txTest() {
        basicService.tx();
        basicService.noneTx();
    }

    @TestConfiguration
    static class TxApplyConfiguration {

        @Bean
        BasicService basicService() {
            return new BasicService();
        }
    }

    @Slf4j
    static class BasicService {

        @Transactional
        public void tx() {
            log.info("call tx");
            // 트랜잭션이 실행이 되는 지 검토 가능
            boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("tx active ={}", txActive);

        }


        public void noneTx() {
            log.info("call noneTx");
            // 트랜잭션이 실행이 되는 지 검토 가능
            boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("tx active ={}", txActive);
        }
    }

}
