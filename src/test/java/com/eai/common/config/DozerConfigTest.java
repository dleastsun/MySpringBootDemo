package com.eai.common.config;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.eai.common.config.model.Destination;
import com.eai.common.config.model.Source;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DomainTestApplication.class)
@ContextConfiguration(classes = { DozerConfig.class })
//@Import({DozerConfig.class})
public class DozerConfigTest {
    
//    private static Mapper dozerMapper;
    
    @Autowired
    private Mapper dozerMapper;
    
//    @Before
//    public void setUp() throws Exception {
//        dozerMapper = new DozerBeanMapper();
//    }

    
    @Test
    public void test1() throws Exception {
        Source source = new Source();
        source.setId(1);
        source.setName("SourceName");
        Destination destination = dozerMapper.map(source, Destination.class); 
//        System.out.println(destination.getId());
//        System.out.println(destination.getName());
//        assertThat(1, is(destination.getId()));
        
        System.out.println(destination.getDestinationId());
        System.out.println(destination.getDestinationName());
        
    }
    
}
