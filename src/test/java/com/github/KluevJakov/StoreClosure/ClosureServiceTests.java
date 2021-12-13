package com.github.KluevJakov.StoreClosure;

import com.github.KluevJakov.StoreClosure.entity.Closure;
import com.github.KluevJakov.StoreClosure.repository.ChangelogRepository;
import com.github.KluevJakov.StoreClosure.repository.ClosureRepository;
import com.github.KluevJakov.StoreClosure.repository.StoreRepository;
import com.github.KluevJakov.StoreClosure.service.ClosureService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@SpringBootTest
public class ClosureServiceTests {

    @Mock
    private static ClosureRepository closureRepository;
    @Mock
    private StoreRepository storeRepository;
    @Mock
    private ChangelogRepository changelogRepository;
    @InjectMocks
    private static ClosureService closureService = new ClosureService();
    private List<Closure> clList;

    @BeforeEach
    void setUp() {
        clList = new ArrayList<>();
        clList.add(new Closure(1L, new Date(2020, 1, 1), new Date(2020, 2, 1), Closure.closureTypeEnum.EMERGENCY));
        clList.add(new Closure(1L, new Date(2021, 1, 1), new Date(2021, 2, 1), Closure.closureTypeEnum.WEATHER));
        closureRepository.saveAll(clList);
    }

    @Test
    public void findAllByStoreId() {
        Mockito.when(closureService.findAllByStoreId(1L)).thenReturn(clList);
        List<Closure> closuresRetrivedList = closureService.findAllByStoreId(1L);
        Assert.assertEquals(clList, closuresRetrivedList);
    }

    @Test
    public void createClosureIfPossibleCorrect() {
        Mockito.when(closureService.createClosureIfPossible(1L, "testText", new Date(2000, 1, 1), new Date(2000, 1, 2), Closure.closureTypeEnum.WEATHER.toString())).thenReturn(true);
        Boolean check = closureService.createClosureIfPossible(1L, "testText", new Date(2000, 1, 1), new Date(2000, 1, 2), Closure.closureTypeEnum.WEATHER.toString());
        Assert.assertTrue(check);
    }

    @Test
    public void createClosureIfPossibleIntersection() {
        Mockito.when(closureService.createClosureIfPossible(1L, "testText", new Date(2000, 1, 1), new Date(2000, 1, 2), Closure.closureTypeEnum.WEATHER.toString())).thenReturn(true);
        Mockito.when(closureService.createClosureIfPossible(1L, "testText", new Date(2000, 1, 1), new Date(2001, 1, 2), Closure.closureTypeEnum.EMERGENCY.toString())).thenReturn(true);

        List<Closure> closureList = new ArrayList<>();
        closureList.add(new Closure(1L, new Date(2021, 1, 1), new Date(2021, 1, 2), Closure.closureTypeEnum.WEATHER));
        Mockito.when(closureService.findAllByStoreId(1L)).thenReturn(closureList);

        Boolean check = closureService.createClosureIfPossible(1L, "testText", new Date(2000, 1, 1), new Date(2000, 1, 2), Closure.closureTypeEnum.EMERGENCY.toString());
        Assert.assertFalse(check);
    }

    @Test
    public void createClosureIfPossibleStoreIdDoesNotExists() {
        Mockito.when(closureService.createClosureIfPossible(9999L, "testText", new Date(2000, 1, 1), new Date(2000, 1, 2), Closure.closureTypeEnum.WEATHER.toString())).thenReturn(true);

        List<Closure> closureList = new ArrayList<>();
        closureList.add(new Closure(9999L, new Date(2021, 1, 1), new Date(2021, 1, 2), Closure.closureTypeEnum.WEATHER));
        Mockito.when(closureService.findAllByStoreId(9999L)).thenReturn(closureList);

        Boolean check = closureService.createClosureIfPossible(9999L, "testText", new Date(2000, 1, 1), new Date(2000, 1, 2), Closure.closureTypeEnum.WEATHER.toString());
        Assert.assertFalse(check);
    }
}
