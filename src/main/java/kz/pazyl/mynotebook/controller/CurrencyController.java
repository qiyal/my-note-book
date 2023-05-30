package kz.pazyl.mynotebook.controller;

import kz.pazyl.mynotebook.model.dto.CurrencyItem;
import kz.pazyl.mynotebook.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    private ICurrencyService currencyService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<CurrencyItem>> getCurrencyList() {
        return ResponseEntity.ok(currencyService.getCurrencyList());
    }
}
