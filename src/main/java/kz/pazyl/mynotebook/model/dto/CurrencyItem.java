package kz.pazyl.mynotebook.model.dto;

import kz.pazyl.mynotebook.model.entity.CurrencyEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
}
