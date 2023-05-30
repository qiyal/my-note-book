package kz.pazyl.mynotebook.model.dto;

import kz.pazyl.mynotebook.model.entity.CurrencyEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CurrencyItem {
    private Long id;
    private String name;
    private String code;

    public static CurrencyItem of(CurrencyEntity entity) {
        if (entity == null) return null;

        return CurrencyItem.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .build();
    }

    public static List<CurrencyItem> listOf(List<CurrencyEntity> entityList) {
        if (entityList == null) return null;

        return entityList.stream()
                .map(CurrencyItem::of)
                .collect(Collectors.toList());
    }
}
