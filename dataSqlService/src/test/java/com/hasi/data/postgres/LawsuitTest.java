package com.hasi.data.postgres;

import com.hasi.data.postgres.config.TestConfig;
import com.hasi.data.postgres.entity.Lawsuit;
import com.hasi.data.postgres.service.LawsuitService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class LawsuitTest {

    private static Lawsuit lawsuit;
    @Autowired
    LawsuitService lawsuitService;

    @BeforeClass
    public static void init() {
        lawsuit = prepareLawsuit(1);
    }

    private static Lawsuit prepareLawsuit(int id) {
        return Lawsuit.builder()
                .lawyerId("lawyer-" + id)
                .clientId("client-" + id)
                .build();
    }

    @Test
    public void testPersistence() {
        Lawsuit lawsuit2 = prepareLawsuit(2);
        lawsuitService.addNewLawsuit(lawsuit);
        lawsuitService.addNewLawsuit(lawsuit2);
        List<Lawsuit> retrievedLawsuits = lawsuitService.getAllLawsuit();
//        Assert.assertEquals(retrievedLawsuits.size(), 2);
//        Assert.assertEquals(lawsuitService.countLawsuitByClientId("client-1"), new Long(1));
//        Assert.assertEquals(lawsuitService.countLawsuitByLawyerId("lawyer-1"), new Long(1));
//        lawsuitService.deleteLawsuit(lawsuit.getLawsuitId());
//        lawsuitService.deleteLawsuit(lawsuit2.getLawsuitId());
//        retrievedLawsuits = lawsuitService.getAllLawsuit();
//        Assert.assertTrue(retrievedLawsuits.isEmpty());
    }
}
