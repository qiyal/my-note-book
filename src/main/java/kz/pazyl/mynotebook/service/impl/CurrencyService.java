package kz.pazyl.mynotebook.service.impl;

import kz.pazyl.mynotebook.model.dto.CurrencyItem;
import kz.pazyl.mynotebook.repository.CurrencyRepository;
import kz.pazyl.mynotebook.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService implements ICurrencyService {
    @Autowired
    private CurrencyRepository repository;

    @Override
    public List<CurrencyItem> getCurrencyList() {
        return CurrencyItem.listOf(repository.findAll());
    }
}
