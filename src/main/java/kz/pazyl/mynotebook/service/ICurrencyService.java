package kz.pazyl.mynotebook.service;

import kz.pazyl.mynotebook.model.dto.CurrencyItem;

import java.util.List;

public interface ICurrencyService {

    List<CurrencyItem> getCurrencyList();
}
